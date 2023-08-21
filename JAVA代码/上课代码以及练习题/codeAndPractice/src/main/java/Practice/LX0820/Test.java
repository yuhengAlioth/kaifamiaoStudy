package Practice.LX0820;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0820
 * @文件名称：Test
 * @时间：2023/08/20/23:46
 */
public class Test {
    private static final Scanner input = new Scanner(System.in); // 初始化，不可修改
    private static final MovieTheater mt = new MovieTheater(); // 初始化电影院，不可修改
    private static User loginUser; // 初始化当前登录用户

    public static void main(String[] args) {
        menu();
    }

    /**
     * 每次进入系统显示的功能菜单
     */
    public static void menu() {
        System.out.println("===============================");
        System.out.println("***欢迎来到开发喵影院***");
        System.out.println("1. 查询电影");
        System.out.println("2. 查询所有电影");
        System.out.println("3. 管理员登录");
        System.out.println("4. 用户登录");
        System.out.println("5. 用户注册");
        System.out.println("0. 退出系统");
        System.out.println("===============================");
        System.out.println("请输入操作选项：");
        int type = input.nextInt();
        // 根据输入的数字进行对应的操作
        switch (type) {
            case 1 -> selectMovie();
            case 2 -> showMovies(0);
            case 3 -> login(1);
            case 4 -> login(2);
            case 5 -> register();
            case 0 -> {
                return;
            }
        }
    }

    /**
     * 查询电影的方法
     */
    public static void selectMovie() {
        System.out.println("请输入电影名称");
        String name = input.next();
        Movie movie = mt.selectMovieByName(name); // 将输入的电影名称传入电影院类中
        if (movie == null) {
            System.out.println("暂时没有该电影信息");
        } else {
            System.out.println(movie);
        }
        menu();
    }

    /**
     * 查询所有电影信息的方法
     */
    public static void showMovies(int type) {
        mt.showAllMovies();
        // 根据角色不同返回不同菜单
        if (type == 0) {
            menu();
        } else {
            managerMenu();
        }
    }

    /**
     * 登录的方法
     */
    public static void login(int role) {
        System.out.println("请输入电话号码");
        String phone = input.next();
        System.out.println("请输入密码");
        String password = input.next();
        loginUser = mt.selectUser(phone, password, role); // 将当前输入的信息进行登录验证
        if (loginUser == null) {
            System.out.println("登录失败");
            menu();
        } else {
            System.out.println("登录成功！");
            System.out.println(loginUser.getUsername() + ", 欢迎您！");
            // 根据角色显示菜单
            if (role == 1) {
                managerMenu();
            } else {
                userMenu();
            }
        }
    }

    /**
     * 普通用户注册的方法
     */
    public static void register() {
        System.out.println("请输入用户名：");
        String username = input.next();
        System.out.println("请输入密码：");
        String password = input.next();
        System.out.println("请再次输入密码：");
        String rePass = input.next();
        // 检验两次输入的密码一样
        password = checkPassword(password, rePass);
        System.out.println("请输入电话：");
        String phone = input.next();
        // TODO 验证电话号码是否被注册了 电话号码长度在11位  length() 可以获取字符串的长度  数组中是 length 属性
        // 电话号码是11位，并且没有被注册
        phone = checkPhone(phone);
        User user = new User(username, password, phone, 2);
        // 将信息储存到用户数组中
        mt.addUser(user);
        System.out.println("注册成功，你可以去登录了！");
        menu();
    }

    /**
     * 管理员登录后的功能菜单显示的方法
     */
    public static void managerMenu() {
        System.out.println("***********************");
        System.out.println("1. 新增电影");
        System.out.println("2. 删除电影");
        System.out.println("3. 修改电影");
        System.out.println("4. 查看所有电影");
        System.out.println("5. 查看所有用户");
        System.out.println("0. 退出登录");
        System.out.println("***********************");
        System.out.println("请输入操作选项：");
        int type = input.nextInt();
        switch (type) {
            case 1 -> addMovie();
            case 2 -> deleteMovie();
            case 3 -> updateMovie();
            case 4 -> showMovies(1);
            case 5 -> showUsers();
            case 0 -> {
                loginUser = null;
                menu();
            }
        }
    }

    /**
     * 添加电影的方法
     */
    public static void addMovie() {
        System.out.println("输入电影名称：");
        String name = input.next();
        System.out.println("输入电影导演：");
        String director = input.next();
        System.out.println("输入电影价格：");
        double price = input.nextDouble();
        System.out.println("输入电影上映时间：");
        int date = input.nextInt();
        Movie movie = new Movie(name, director, date, price);
        // 将电影储存在电影数组中
        mt.addMovie(movie);
        System.out.println("添加成功！" + movie);
        managerMenu();
    }

    /**
     * 删除电影
     */
    public static void deleteMovie() {
        System.out.println("输入电影名称：");
        String name = input.next();
        if (mt.deleteMovie(name)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败，你删除的电影可能不存在！");
        }
        managerMenu();
    }

    /**
     * 修改电影信息
     */
    public static void updateMovie() {
        System.out.println("请输入电影名称：");
        String name = input.next();
        Movie movie = mt.selectMovieByName(name);
        if (movie != null) {
            System.out.println(movie);
            System.out.println("请输入要修改的内容：");
            System.out.println("1. 价格");
            System.out.println("2. 上映日期");
            System.out.println("0. 取消");
            int op = input.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("请输入新的价格：");
                    double price = input.nextDouble();
                    movie.setPrice(price);
                    System.out.println("修改完成！");
                }
                case 2 -> {
                    System.out.println("请输入新的上映时间：");
                    int date = input.nextInt();
                    movie.setDate(date);
                    System.out.println("修改完成！");
                }
                case 0 -> {
                    managerMenu();
                }
            }
        } else {
            System.out.println("暂时没有该电影，你可以先上映！");
        }
        managerMenu();
    }

    /**
     * 查询所有用户的方法
     */
    public static void showUsers() {
        mt.showAllUsers();
        managerMenu();
    }

    /**
     * 用户登录后显示的功能菜单的方法
     */
    public static void userMenu() {
        System.out.println("===================");
        System.out.println("1. 修改用户信息");
        System.out.println("2. 查询用户信息");
        System.out.println("0. 退出登录");
        System.out.println("===================");
        int type = input.nextInt();
        switch (type) {
            case 1 -> updateUser();
            case 2 -> showUser();
            case 0 -> menu();
        }
    }

    /**
     * 显示用户信息的方法
     */
    private static void showUser() {
        // 显示当前登录的用户信息
        System.out.println(loginUser);
        userMenu();
    }

    /**
     * 修改用户信息的方法
     */
    private static void updateUser() {
        System.out.println("===================================");
        System.out.println("你要修改哪些信息？");
        System.out.println("1. 用户名");
        System.out.println("2. 密码");
        System.out.println("3. 电话");
        System.out.println("0. 取消");
        System.out.println("===================================");
        // loginUser 存储的是登录的用户信息
        User user = new User();
        int op = input.nextInt();
        switch (op) {
            case 1 -> {
                System.out.println("请输入用户名：");
                String name = input.next();
                loginUser.setUsername(name);
            }
            case 2 -> {
                System.out.println("请输入密码：");
                String password = input.next();
                System.out.println("请再次输入密码：");
                String rePass = input.next();
                // 让两次输入的密码一致
                password = checkPassword(password, rePass);
                loginUser.setPassword(password);
            }
            case 3 -> {
                System.out.println("请输入电话号码：");
                String phone = input.next();
                // 电话号码是11位, 并且没有被注册
                phone = checkPhone(phone);
                loginUser.setPhone(phone);
            }
            case 0 -> {
                userMenu();
            }
        }
        userMenu();
    }

    /**
     * 检验电话是否在11位，以及是否被注册过
     * @param phone 要检验的号码
     * @return 合理的号码
     */
    private static String checkPhone(String phone) {
        while (phone.length() != 11) {
            System.out.println("电话号码输入有误，请重新输入：");
            phone = input.next();
        }
        // 验证电话号码是否已经被注册
        while (mt.selectUserByPhone(phone) != null) {
            System.out.println("电话号码已经被注册，请重新输入：");
            phone = input.next();
        }
        return phone;
    }

    /**
     * 检验两次输入的密码一致
     * @param password 第一个输入的密码
     * @param rePass   重复输入的密码
     * @return 返回两次输入一致的密码
     */
    private static String checkPassword(String password, String rePass) {
        // 让两次输入的密码一致
        while (password == null || !password.equals(rePass)) {
            System.out.println("两次密码不一致，请重新输入！");
            System.out.println("请输入密码：");
            password = input.next();
            System.out.println("请再次输入密码：");
            rePass = input.next();
        }
        return password;
    }
}

