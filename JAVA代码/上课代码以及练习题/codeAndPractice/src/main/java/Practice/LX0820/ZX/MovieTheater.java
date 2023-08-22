package Practice.LX0820.ZX;

import java.util.Objects;
import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0820.ZX
 * @文件名称：MovieTheater
 * @时间：2023/08/22/10:27
 */
public class MovieTheater {
    // 存储用户信息
    private User[] users;
    // 存储电影信息
    private Movie[] movies;

    private int userCount;  // 记录存放用户信息的数组下标
    private int movieCount;  // 记录存放电影信息的数组下标

    private Scanner sc = new Scanner(System.in);
    private User loginUser;

    /**
     * 初始化
     */
    public MovieTheater() {
        users = new User[10];
        movies = new Movie[10];
        users[0] = new User("admin", "admin", "15109481041", 1);
        users[1] = new User("test", "test", "15109481042", 2);
        userCount = 2;
        movies[0] = new Movie("你的名字", "新海诚", 49.9, 20201001, 20);
        movies[1] = new Movie("消失的她", "田宝臣", 39.9, 20230701, 40);
        movies[2] = new Movie("原神大电影", "飞碟社", 39.9, 20250812, 10);
        movies[3] = new Movie("奥特曼大战花园宝宝", "圆谷", 38.8, 20240812, 5);
        movies[4] = new Movie("孤注一掷", "申奥", 41.8, 20230812, 7);
        movieCount = 5;
    }

    public void open() {
        menu();
    }

    private void menu() {
        System.out.println("***************************");
        System.out.println("===欢迎来到开发喵影院===");
        System.out.println("1. 查询电影");
        System.out.println("2. 查询所有电影");
        System.out.println("3. 管理员登录");
        System.out.println("4. 用户登录");
        System.out.println("5. 用户注册");
        System.out.println("0. 退出系统");
        System.out.println("***************************");
        System.out.println("请输入操作选项：");
        int type = sc.nextInt();
        switch (type) {
            case 1 -> selectMovie();
            case 2 -> {
                showMovies();
                menu();
            }
            case 3 -> login(1); // 管理员登录
            case 4 -> login(2); // 用户登录
            case 5 -> register();
            case 0 -> {
                return;
            }
        }
    }


    /**
     * 扩容存储电影信息的数组
     */

    private void moviesGrow() {
        if (movieCount == movies.length) {
            Movie[] newMovies = new Movie[movies.length * 2];
            System.arraycopy(movies, 0, newMovies, 0, movies.length);
            movies = newMovies;
        }
    }

    /**
     * 扩容存储用户信息的数组
     */

    private void usersGrow() {
        if (userCount == users.length) {
            User[] newUsers = new User[users.length * 2];
            System.arraycopy(users, 0, newUsers, 0, users.length);
            users = newUsers;
        }
    }

    /**
     * 查询电影信息
     *
     * @param name
     * @return
     */
    public int selectMovieByName(String name) {
        for (int i = 0; i < movieCount; i++) {
            if (movies[i].getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询电影
     */
    private void selectMovie() {
        System.out.println("请输入电影名称");
        String name = sc.next();
        int index = selectMovieByName(name);
        if (index < 0) {
            System.out.println("暂无此电影");
        } else {
            System.out.println(movies[index]);
        }
        menu();
    }

    /**
     * 显示所有上映电影信息
     */
    private void showMovies() {
        sortMovieByDate();
        for (int i = 0; i < movieCount; i++) {
            System.out.println(movies[i]);
        }
    }

    /**
     * 按照上映日期排序 movies
     */
    private void sortMovieByDate() {
        // 排序 movies
        for (int i = 0; i < movieCount - 1; i++) {
            for (int j = 0; j < movieCount - 1 - i; j++) {
                if (movies[j].getDate() < movies[j + 1].getDate()) {
                    Movie temp = movies[j];
                    movies[j] = movies[j + 1];
                    movies[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 登录
     *
     * @param role
     */
    private void login(int role) {
        System.out.println("请输入电话号码");
        String phone = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        int index = selectUser(phone, password, role);
        if (index < 0) {
            System.out.println("登录失败");
            menu();
        } else {
            loginUser = users[index];
            System.out.println("登录成功！");
            System.out.println(loginUser.getUsername() + ", 欢迎您！");
            if (role == 1) {
                managerMenu();
            } else {
                userMenu();
            }
        }
    }

    /**
     * 用户登录之后显示的功能菜单
     */
    public void userMenu() {
        System.out.println("*********************");
        System.out.println("1. 修改用户信息");
        System.out.println("2. 查询用户信息");
        System.out.println("3. 买票");
        System.out.println("4. 显示已购买的票");
        System.out.println("0. 退出登录");
        System.out.println("*********************");
        int type = sc.nextInt();
        switch (type) {
            case 1 -> updateUser();
            case 2 -> showUser();
            case 3 -> buyTicket();
            case 4 -> showAllBuyTickets();
            case 0 -> {
                loginUser = null;
                menu();
            }
        }
    }

    /**
     * 显示用户所有已购买票信息
     */
    private void showAllBuyTickets() {
        Movie[] buyMovies = loginUser.getBuyMovies();
        for (int i = 0; i < buyMovies.length; i++) {
            if (buyMovies[i] != null) {
                System.out.println(buyMovies[i]);
            }
        }
        userMenu();
    }

    /**
     * 用户买票
     */
    private void buyTicket() {
        showMovies();
        System.out.println("请输入你要购买的电影名称：");
        String name = sc.next();
        Movie movie = movies[selectMovieByName(name)];
        System.out.println(movie);
        System.out.println("请输入购买的票数：");
        int count = sc.nextInt();
        int tickets = movie.getTickets(); // 当前电影所有票数
        while (count > tickets || count < 0) {
            System.out.println("输入的票数有问题，当前票总剩余：" + tickets);
            System.out.println("请重新输入：");
            count = sc.nextInt();
        }
        movie.setTickets(tickets - count);
        loginUser.addMovie(new Movie(movie, count));
        System.out.println("购买成功");
        userMenu();
    }


    /**
     * 显示用户信息
     */
    private void showUser() {
        System.out.println(loginUser);
        userMenu();
    }

    /**
     * 管理员菜单
     */
    private void managerMenu() {
        System.out.println("============*****=============");
        System.out.println("1. 新增电影");
        System.out.println("2. 删除电影");
        System.out.println("3. 修改电影");
        System.out.println("4. 查看所有电影");
        System.out.println("5. 查看所有用户");
        System.out.println("0. 退出登录");
        System.out.println("============*****=============");
        System.out.println("请输入操作选项：");
        int type = sc.nextInt();
        switch (type) {
            case 1 -> addMovie();
            case 2 -> {
                showMovies();
                deleteMovie();
            }
            case 3 -> updateMovie();
            case 4 -> {
                showMovies();
                managerMenu();
            }
            case 5 -> showUsers();
            case 0 -> {
                loginUser = null;
                menu();
            }
        }
    }

    /**
     * 查看所有用户信息
     */
    private void showUsers() {
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i]);
        }
        managerMenu();
    }

    /**
     * 添加电影
     */
    private void addMovie() {
        System.out.println("输入电影名称：");
        String name = sc.next();
        System.out.println("输入电影导演：");
        String director = sc.next();
        System.out.println("输入电影价格：");
        double price = sc.nextDouble();
        System.out.println("输入电影上映时间：");
        int date = sc.nextInt();
        System.out.println("输入电影票数：");
        int tickets = sc.nextInt();
        Movie movie = new Movie(name, director, price,date,tickets);
        // 将电影储存在电影数组中
        moviesGrow();
        movies[movieCount] = movie;
        movieCount++;
        System.out.println("添加成功！" + movie);
        managerMenu();
    }

    /**
     * 修改电影
     */
    private void updateMovie() {
        System.out.println("请输入电影名称：");
        String name = sc.next();
        int index = selectMovieByName(name);
        if (index != -1) {
            System.out.println(movies[index]);
            System.out.println("请输入要修改的内容：");
            System.out.println("1. 价格");
            System.out.println("2. 上映日期");
            System.out.println("0. 取消");
            int op = sc.nextInt();
            switch (op) {
                case 1 -> {
                    System.out.println("请输入新的价格：");
                    double price = sc.nextDouble();
                    movies[index].setPrice(price);
                    System.out.println("修改完成！");
                }
                case 2 -> {
                    System.out.println("请输入新的上映时间：");
                    int date = sc.nextInt();
                    movies[index].setDate(date);
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
     * 删除电影
     */
    private void deleteMovie() {
        System.out.println("输入电影名称：");
        String name = sc.next();
        if (deleteMovie(name)) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败，你删除的电影可能不存在！");
        }
        managerMenu();
    }
    private boolean deleteMovie(String name) {
        int index = -1;
        for (int i = 0; i < movieCount; i++) {
            if (Objects.equals(name, movies[i].getName())) { // 说明该电影存在
                index = i;
            }
        }
        if (index == -1) {
            return false;
        }
        System.arraycopy(movies, 0, movies, 0, index);
        System.arraycopy(movies, index + 1, movies, index, movieCount - index - 1);
        movieCount--;
        return true;
    }

    /**
     * 修改用户信息
     */
    private void updateUser() {
        System.out.println(loginUser);
        System.out.println("你要修改哪些信息？");
        System.out.println("1. 用户名");
        System.out.println("2. 密码");
        System.out.println("3. 电话");
        System.out.println("0. 取消");
        int op = sc.nextInt();
        switch (op) {
            case 1 -> {
                System.out.println("请输入用户名：");
                String name = sc.next();
                loginUser.setUsername(name);
            }
            case 2 -> {
                System.out.println("请输入密码：");
                String password = sc.next();
                System.out.println("请再次输入密码：");
                String rePass = sc.next();
                // 让两次输入的密码一致
                password = checkPassword(password, rePass);
                loginUser.setPassword(password);
            }
            case 3 -> {
                System.out.println("请输入电话号码：");
                String phone = sc.next();
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
     * 用户注册
     */
    private void register() {
        System.out.println("请输入电话：");
        String phone = sc.next();
        // TODO 验证电话号码是否被注册了 电话号码长度在11位  length() 可以获取字符串的长度  数组中是 length 属性
        // 电话号码是11位，并且没有被注册
        phone = checkPhone(phone);
        System.out.println("请输入用户名：");
        String username = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请再次输入密码：");
        String rePass = sc.next();
        // 检验两次输入的密码一样
        password = checkPassword(password, rePass);
        User user = new User(username, password, phone, 2);
        addUser(user);
        System.out.println("注册成功，你可以去登录了！");
        menu();
    }

    /**
     * 添加用户
     *
     * @param user 要添加的用户对象
     */
    private void addUser(User user) {
        usersGrow();
        users[userCount++] = user;
    }

    /**
     * 按照电话、密码、身份查询用户信息
     *
     * @param phone    查询的电话
     * @param password 查询的密码
     * @param role     查询的身份
     * @return 如果存在返回该对象的下标，不存在返回 -1
     */
    private int selectUser(String phone, String password, int role) {
        for (int i = 0; i < userCount; i++) {
            if (Objects.equals(users[i].getPhone(), phone)
                    && Objects.equals(users[i].getPassword(), password)
                    && users[i].getRole() == role) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 检验电话是否在11位，以及是否被注册过
     *
     * @param phone 要检验的号码
     * @return 合理的号码
     */
    private String checkPhone(String phone) {
        while (phone.length() != 11) {
            System.out.println("电话号码输入有误，请重新输入：");
            phone = sc.next();
        }
        // 验证电话号码是否已经被注册
        while (selectUserByPhone(phone) > 0) {
            System.out.println("电话号码已经被注册，请重新输入：");
            phone = sc.next();
        }
        return phone;
    }

    /**
     * 按照电话查询用户信息
     *
     * @param phone 要查询的电话
     * @return 如果存在返回下标，不存在返回 -1
     */
    private int selectUserByPhone(String phone) {
        for (int i = 0; i < userCount; i++) {
            if (Objects.equals(users[i].getPhone(), phone)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 检验两次输入的密码一致
     *
     * @param password 第一个输入的密码
     * @param rePass   重复输入的密码
     * @return 返回两次输入一致的密码
     */
    private String checkPassword(String password, String rePass) {
        // 让两次输入的密码一致
        while (password == null || !password.equals(rePass)) {
            System.out.println("两次密码不一致，请重新输入！");
            System.out.println("请输入密码：");
            password = sc.next();
            System.out.println("请再次输入密码：");
            rePass = sc.next();
        }
        return password;
    }

}

