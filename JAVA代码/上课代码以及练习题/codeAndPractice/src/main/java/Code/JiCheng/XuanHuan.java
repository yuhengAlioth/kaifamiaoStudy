package Code.JiCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiCheng
 * @文件名称：XuanHuan
 * @时间：2023/08/17/15:37
 */
public class XuanHuan extends Book {
    // 子类可以继承父类的非私有属性，子类可以继承父类的非私有方法
    // 子类可以添加自己的属性和方法，从而达到对父类的扩展
    // 子类中调用父类的构造，使用super关键字。如果父类没有写构造，子类可以不用调用父类的构造。
    // 如果父类有构造，必须在子类的构造方法中调用。
    public String zl;
//    protected int a = 66;
    public static int b = 222;

    public XuanHuan(String name, String author, String zl) {
        // 调用父类构造参数
        super(name, author);
        this.zl = zl;
    }

    // 重写父类的方法
    @Override
    public void info(){
//        super.info();
//        System.out.println(zl + "\t");
        System.out.println("子类重写父类方法");
    }
    @Override
    void printInfo() {
        // super.方法名() 表示调用父类的方法  this.方法名() 调用本类中的方法
        super.printInfo();
        System.out.println("zl:" + zl);
    }

    public static void xie() {
        System.out.println("子类静态方法");
    }
}

