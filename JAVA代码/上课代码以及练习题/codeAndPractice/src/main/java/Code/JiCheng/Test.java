package Code.JiCheng;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.JiCheng
 * @文件名称：Test
 * @时间：2023/08/17/15:41
 */
public class Test {

    public static void main(String[] args) {
        Book book = new XuanHuan("小王子","kfm","566666");
        XuanHuan book1 = new XuanHuan("斗罗大陆","唐家三少","玄幻");

        book.info();
        book1.info();
        book.printInfo();
        book1.printInfo();
        System.out.println("=================");
        System.out.println(book.a);
        System.out.println(book1.a);
        System.out.println("====================");
        Book.xie();
        XuanHuan.xie();
        System.out.println("===================");
        System.out.println(Book.b);
        System.out.println(XuanHuan.b);
    }

}

