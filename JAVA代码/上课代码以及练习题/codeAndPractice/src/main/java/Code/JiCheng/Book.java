package Code.JiCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiCheng
 * @文件名称：Book
 * @时间：2023/08/17/15:34
 */
public class Book {
    private String name;
    private String author;
    protected int a = 33;
    public static int b =2;
    public Book(){

    }
    public Book(String name,String author){
        this.name = name;
        this.author = author;
    }
    public void info(){
//        System.out.println(name + "\t" + author + "\t");
        System.out.println("父类方法");
    }
    void printInfo() {
        System.out.println("name:" + name);
        System.out.println("author:" + author);
    }

    public static void xie(){
        System.out.println("父类的静态方法");
    }
}

