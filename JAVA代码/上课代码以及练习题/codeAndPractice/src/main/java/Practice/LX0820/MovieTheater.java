package Practice.LX0820;

import java.util.Objects;


/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0820
 * @文件名称：MovieTheater
 * @时间：2023/08/20/23:41
 */
public class MovieTheater {
    private User[] users;  // 存储用户信息
    private Movie[] movies;   // 存储电影信息
    private int userCount;  // 记录存放用户信息的数组下标
    private int movieCount;  // 记录存放电影信息的数组下标

    // 初始化
    public MovieTheater() {
        users = new User[10];
        movies = new Movie[10];
        users[0] = new User("admin", "admin", "15109481041", 1);
        users[1] = new User("test", "test", "15109481042", 2);
        userCount = 2;
        movies[0] = new Movie("你的名字", "新海诚", 20201001, 49.9);
        movies[1] = new Movie("孤注一掷", "申奥", 20230701, 39.9);
        movieCount = 2;
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
     * 按照输入的名称查询电影信息
     *
     * @param name 要查询的电影名称
     * @return 有的话返回电影对象 没有返回null
     */
    public Movie selectMovieByName(String name) {
        // 在电影的数组中查找是否存在传入的电影信息
        for (int i = 0; i < movieCount; i++) {
            if (movies[i].getName().equals(name)) {
                return movies[i];
            }
        }
        return null;
    }

    /**
     * 显示所有电影信息
     */
    public void showAllMovies() {
        for (int i = 0; i < movieCount; i++) {
            System.out.println(movies[i]);
        }
    }

    /**
     * 显示所有用户信息
     */
    public void showAllUsers() {
        for (int i = 0; i < userCount; i++) {
            System.out.println(users[i]);
        }
    }

    /**
     * 按照 user 对象查询用户
     *
     * @param user 要查询的用户信息
     * @return 如果存在返回用户对象，不存在返回null
     */
    public User selectUser(User user) {
        for (int i = 0; i < userCount; i++) {
            if (Objects.equals(users[i].getPhone(), user.getPhone())
                    && Objects.equals(users[i].getPassword(), user.getPassword())
                    && users[i].getRole() == user.getRole()) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * 登录验证
     * @param phone    手机号作为登录账号
     * @param password 密码
     * @param role     身份
     * @return 不满足返回null
     */
    public User selectUser(String phone, String password, int role) {
        // 在用户类中进行查找信息
        for (int i = 0; i < userCount; i++) {
            // 判断是否输入的信息与数组中一致
            if (Objects.equals(users[i].getPhone(), phone)
                    && Objects.equals(users[i].getPassword(), password)
                    && users[i].getRole() == role) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * 新增电影
     * @param movie 你要添加的电影对象
     */
    public void addMovie(Movie movie) {
        moviesGrow();
        movies[movieCount] = movie;
        movieCount++;

    }

    /**
     * 新增用户
     */
    public void addUser(User user) {
        usersGrow();
        users[userCount] = user;
        userCount++;
    }

    /**
     * 用户注册判断手机号是否被注册
     * @param phone 手机号
     * @return 返回值
     */
    public User selectUserByPhone(String phone) {
        for (int i = 0; i < userCount; i++) {
            if (Objects.equals(users[i].getPhone(), phone)) {
                return users[i];
            }
        }
        return null;
    }

    /**
     * 修改在users数组中存储的对象的值
     * @param u1 当前登录的用户信息
     * @param u2 用户输入的新的用户信息
     */
    public User updateUser(User u1, User u2) {
        for (int i = 0; i < userCount; i++) {
            if (users[i].equals(u1)) {  // 查询到你要修改的是哪一个对象 users[i]
                if (u2.getPassword() != null) { // u2 用户输入的修改内容
                    users[i].setPassword(u2.getPassword()); // 如果输入了密码
                } else if (u2.getUsername() != null) {
                    users[i].setUsername(u2.getUsername()); //  如果输入了用户名
                } else {
                    users[i].setPhone(u2.getPhone()); // 如果输入了电话
                }
                return users[i];
            }
        }
        return null;
    }

    /**
     * 根据电影名称删除电影数组中的电影信息
     * @param name 要删除的电影名称
     * @return 是否删除成功
     */
    public boolean deleteMovie(String name) {
        int index = -1;
        for (int i = 0; i < movieCount; i++) {
            if (Objects.equals(name, movies[i].getName())) { // 说明该电影存在 我 index = 1 10  3 你 我 孤  3 - (index + 1) 你， 孤， null
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
}

