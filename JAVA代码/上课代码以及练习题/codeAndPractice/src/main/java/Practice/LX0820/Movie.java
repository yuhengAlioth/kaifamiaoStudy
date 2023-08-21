package Practice.LX0820;

import java.util.Objects;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0820
 * @文件名称：Movie
 * @时间：2023/08/20/23:37
 */
public class Movie {
    private String name; //电影的名称
    private String director; // 电影的导演
    private int date; // 上映时间(2023年1月1日 写成20230101)
    private double price; // 电影的价格

    public Movie() {
    }

    public Movie(String name, String director, int date, double price) {
        this.name = name;
        this.director = director;
        this.date = date;
        this.price = price;
    }

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

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "电影名称：" + name + ",导演：" + director + ",上映时间：" + date + ",价格：" + price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        // 通用方法
/*        if (obj instanceof Movie) {
            Movie otherMovie = (Movie) obj;
            if (this.name.equals(otherMovie.getName()) &&
                    this.director.equals(otherMovie.getDirector()) &&
                    this.date == otherMovie.getDate() &&
                    this.price == otherMovie.getPrice()) {
                return true;
            }
        }*/
        // 16新增方法
        if (obj instanceof Movie movie) { // 16新增的
            if (Objects.equals(this.name, movie.getName()) &&
                    Objects.equals(this.director, movie.getDirector())
                    && this.date == movie.getDate()
                    && this.price == movie.getPrice()) {
                return true;
            }
        }
        return false;
    }
}

