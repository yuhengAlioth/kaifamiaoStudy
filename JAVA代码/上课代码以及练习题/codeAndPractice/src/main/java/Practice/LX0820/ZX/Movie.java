package Practice.LX0820.ZX;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0820.ZX
 * @文件名称：Movie
 * @时间：2023/08/21/20:38
 */
public class Movie {
    // 先定义私有属性
    private String name;    //电影的名称
    private String director;    //电影的导演
    private double price;   //电影的价格
    private int date;   //上映时间
    private int tickets;    // 票数

    // 创建无参、有参构造函数
    public Movie() {
    }

    public Movie(Movie movie, int count) {
        this(movie.getName(), movie.getDirector(),movie.getPrice(), movie.getDate(), movie.getTickets());
        this.tickets = count;
    }

    public Movie(String name, String director, double price, int date,int tickets) {
        this.name = name;
        this.director = director;
        this.price = price;
        this.date = date;
        this.tickets = tickets;
    }

    // 创建get、set方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getTickets() {
        return tickets;
    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Movie{" +
                "电影名称：'" + name + '\'' +
                ", 导演：'" + director + '\'' +
                ", 售价：" + price +
                ", 上映时间：" + date +
                ", 票数：" + tickets +
                '}';
    }

    // 重写equals方法
    @Override
    public boolean equals(Object obj) {
        // 先比较地址
        if (this == obj) {
            return true;
        }
        // 16新增方法 ==> instanceof
        if (obj instanceof Practice.LX0820.Movie movie) { // 16新增的
            if (Objects.equals(this.name, movie.getName())
                    && Objects.equals(this.director, movie.getDirector())
                    && this.date == movie.getDate()
                    && this.price == movie.getPrice()) {
                return true;
            }
        }
        return false;
    }
}

