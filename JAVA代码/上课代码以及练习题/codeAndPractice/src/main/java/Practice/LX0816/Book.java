package Practice.LX0816;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：Book
 * @时间：2023/08/16/19:32
 */
public class Book {
    private String title;
    private String author;
    private int year;
    private double price;
    public Book(){

    }
    public Book(String title, String author,int year,double price){
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getAuthor(){
        return author;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public String info() {
        return "书名：" + this.title + ", 作者：" + this.author + ", 出版年份：" + this.year + ", 出售价格：" + this.price;
    }
}

