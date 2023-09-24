package Test.Two;

import com.mysql.cj.jdbc.Driver;

import java.io.*;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Test.Two
 * @文件名称：BookManager
 * @代码功能：图书馆类
 * @时间：2023/09/23/9:09
 */
public class BookManager {

    public BookManager(){
        init(); // 初始化数据库
    }

    // TODO 数据库连接方法
    public Connection getConnection() throws SQLException{
        String url = "jdbc:mysql://localhost:3306/kfm";  // 数据库连接URL
        String user = "root";  // 数据库用户名
        String password = "root";  // 数据库密码
        return  DriverManager.getConnection(url,user,password);
    }

    // TODO 初始化图书馆
    public void init(){
        List<String> dbLists = new ArrayList<>(); // 储存数据库里面所有表的名称
        // 2. 获取连接
        try (Connection conn = getConnection();
             // 3. 获取执行sql的对象
             Statement stat = conn.createStatement();){
            // 4. 编写sql
            String selectSql = "show tables";
            // 5. 执行sql
            ResultSet set = stat.executeQuery(selectSql);
            // 获取列数
            ResultSetMetaData metaData = set.getMetaData();
            int columnCount = metaData.getColumnCount(); // 获取数据库中表的条数

            // 6. 解析结果
            while (set.next()) {
                String string = "";
                for (int i = 1; i <= columnCount; i++) {
                    Object value = set.getObject(i); // 获取表名称
                    string += value; // 将数据库的所有表名字全部遍历出来
                }
                dbLists.add(string); // 将表名字放入到集合中
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // 定义储存表的变量
        String book = null;
        String log = null;

        for (String s : dbLists) {
            if ("books".equals(s)){
                book = s;
            }
            if ("operation_log".equals(s)){
                log = s;
            }
        }

        // 判断是否存在两张表
        if (book == null && log == null){
            List<String> sqlLists = new ArrayList<>(); // 读取sql语句

            try(FileReader fileReader = new FileReader("io\\sql.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);) {
                String line = ""; // 读一行文本
                while ((line = bufferedReader.readLine()) != null) {
                    String[] oneLine = line.split(";");
                    for (String s : oneLine) {
                        sqlLists.add(s.trim());
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            // 定义创建表的sql语句
            String bookSql = "";
            String logSql = "";
            for (int i = 0; i < sqlLists.size(); i++) {
                // 0~7 第一句
                if (i<=7){
                    bookSql += sqlLists.get(i);
                }
                if (i>7){
                    logSql += sqlLists.get(i);
                }

            }
//            System.out.println(bookSql);
//            System.out.println(logSql);


            try (// 2. 获取连接
                 Connection conn = getConnection();
                 // 4. 获取执行sql的对象
                 Statement stat = conn.createStatement();) {

                // 5. 执行sql
                int i = stat.executeUpdate(bookSql); // 返回值是影响行数
                int j = stat.executeUpdate(logSql); // 返回值是影响行数
                // 6. 解析返回值
                if (i == 0 && j == 0) {
                    System.out.println("创建表成功");
                } else {
                    System.out.println("创建表失败");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }else {
//            System.out.println(book);
//            System.out.println(log);
//            System.out.println("图书馆初始化完毕");
        }



    }

    // TODO 添加图书功能
    public void addBookInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入图书的出版日期:");
        String publication_date = scanner.next();

        System.out.print("请输入图书的书名:");
        String book_title = scanner.next();

        System.out.print("请输入图书的作者:");
        String author = scanner.next();

        System.out.print("请输入图书的价格:");
        double price = scanner.nextDouble();

        System.out.print("请输入图书的数量:");
        int quantity = scanner.nextInt();
        // 获取连接
        try(Connection connection = getConnection();) {
            String sql = "insert into books (publication_date, book_title, author, price, quantity) VALUES ( ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, publication_date);
            statement.setString(2, book_title);
            statement.setString(3, author);
            statement.setDouble(4, price);
            statement.setInt(5, quantity);

            int rowsInserted = statement.executeUpdate(); // 返回影响行数

            if (rowsInserted > 0) {
//                System.out.println("添加《" + book_title + "》图书成功");
                System.out.printf("\033[36;1m添加《%s》图书成功\n\033[0m",book_title);
                String desc = "新增图书 - 书名：《" + book_title + "》";
                log(desc);
            }
        } catch (SQLException e) {
            System.out.println("添加失败: " + e.getMessage());
        }

    }

    // TODO  删除图书功能
    public void removeBook(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入要删除图书的书名:");
        String book_title = scanner.next();
        // 获取连接
        try(Connection connection = getConnection();) {
            String sql = "delete from books where book_title = (?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, book_title);

            int rowsDeleted = statement.executeUpdate(); // 影响行数
            if (rowsDeleted > 0) {
//                System.out.println("删除《" + book_title + "》图书成功");
                System.out.printf("\033[36;1m删除《%s》图书成功\n\033[0m",book_title);
                String desc = "删除图书记录 - 书名：《" + book_title + "》";
                log(desc);
            }
        } catch (SQLException e) {
            System.out.println("删除失败: " + e.getMessage());
        }
    }

    // TODO 修改图书数量功能
    public void modifyBookQuantity(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("请输入要修改数量的图书的书名:");
        String book_title = scanner.next();

        System.out.print("请输入修改的数量:");
        int quantity = scanner.nextInt();
        // 获取连接
        try (Connection connection = getConnection();){
            String showSql = "select quantity from books where book_title = ?";
            PreparedStatement showStatement = connection.prepareStatement(showSql);
            showStatement.setString(1, book_title);
            ResultSet resultSet = showStatement.executeQuery();

            if (resultSet.next()){
                int oldQuantity = resultSet.getInt("quantity");

                String sql = "update books set quantity = ? where book_title = ?";
                PreparedStatement statement = connection.prepareStatement(sql);

                statement.setInt(1, quantity);
                statement.setString(2, book_title);

                int rowsUpdate = statement.executeUpdate(); // 影响行数
                if (rowsUpdate > 0) {
//                    System.out.println("修改《" + book_title + "》图书数量成功");
                    System.out.printf("\033[36;1m修改《%s》图书数量成功\n\033[0m",book_title);
                    String desc = "修改图书信息 - 书名：《" + book_title + "》原数量：" + oldQuantity + " 修改后：" + quantity;
                    log(desc);
                }
            }else {
                System.out.println("图书《" + book_title + "》不存在");
            }
        } catch (SQLException e) {
            System.out.println("修改失败: " + e.getMessage());
        }
    }

    // TODO 查询所有图书
    public void showAllBooks(){

        try {
            // 获取连接
            Connection connection = getConnection();

            String sql = "select * from books";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                String publication_date = resultSet.getString("publication_date");
                String book_title = resultSet.getString("book_title");
                String author = resultSet.getString("author");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");

//                System.out.println("出版日期：" + publication_date + ",书名: " + book_title + ",作者：" + author + ",价格：" + price + ",数量: " + quantity);
                System.out.printf("\033[36;1m出版日期：%s，书名：《%s》，作者：%s，价格：%.2f，数量：%d\n\033[0m",publication_date,book_title,author,price,quantity);
            }
        } catch (SQLException e) {
            System.out.println("查询失败: " + e.getMessage());
        }
    }

    // TODO 将用户的每个操作都记录在日志表
    public void log(String desc) {
        String description = desc;
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String time = nowTime.format(formatter);
        // 获取连接
        try(Connection connection = getConnection();) {
            String sql = "insert into operation_log (description,operation_time) VALUES ( ? , ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, description);
            statement.setString(2, time);

            int rowsInserted = statement.executeUpdate(); // 返回影响行数
            if (rowsInserted > 0) {
//                System.out.println("日志记录成功");
                System.out.printf("\033[35;1m日志记录成功\n\033[0m");
            }
        } catch (SQLException e) {
            System.out.println("添加失败: " + e.getMessage());
        }
    }
}
class Test {
    static Scanner sc = new Scanner(System.in);
    static BookManager bookManager = new BookManager();
    public static void main(String[] args) {

        while (true) {
            menu();
            System.out.print("请进行的操作：");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> addBook();
                case 2 -> removeBook();
                case 3 -> modifyBookQuantity();
                case 4 -> showAllBooks();
                case 0 -> {
                    System.out.println("退出图书管理系统成功！");
                    return;
                }
            }
        }
    }

    /**
     * 菜单
     */
    public static void menu() {
        System.out.println("*******开发喵图书管理系统V1.0********");
        System.out.println("1. 添加图书");
        System.out.println("2. 删除图书");
        System.out.println("3. 修改图书数量");
        System.out.println("4. 查询所有图书信息");
        System.out.println("0. 退出");
        System.out.println("******************");
    }
    /**
     * 添加图书
     */
    public static void addBook() {
        bookManager.addBookInfo();
    }

    /**
     * 删除图书
     */
    public static void removeBook(){
        bookManager.removeBook();
    }

    /**
     * 修改图书数量
     */
    public static void modifyBookQuantity(){
        bookManager.modifyBookQuantity();
    }

    /**
     * 查询所有图书
     */
    public static void showAllBooks(){
        bookManager.showAllBooks();
    }
}
