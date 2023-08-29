package Code.NeiBuLei;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.NeiBuLei
 * @文件名称：China
 * @代码功能：内部类
 * @时间：2023/08/29/11:41
 */
public class China {
    private String city = "中国";
    private static double area = 960.1;
    public void test(){
        System.out.println("中国类的test()方法");
    }
    public static void aVoid(){
        System.out.println("中国类的aVoid()方法");
    }
    // 内部类
    public class GanSu{
        private String city;
        private static double area = 62.3;
        public GanSu (String city){
            this.city = city;
        }
        public void test(){
            System.out.println("中国类里面的内部类--甘肃类的test()方法");
        }
        public static void aVoid(){
            System.out.println("中国类里面的内部类--甘肃类的aVoid()方法");
        }
        // 内部类访问外部类的方法
        public void fw(){
            test();
            China.this.test();
            aVoid();
            China.aVoid();
            System.out.println(city);
            System.out.println(China.this.city);
            System.out.println(area);
            System.out.println(China.area);
        }
    }
    public void fw(){
        test();
        aVoid();
        GanSu ganSu = new GanSu("兰州");
        ganSu.test();
        GanSu.aVoid();
        System.out.println(city);
        System.out.println(area);
        System.out.println(ganSu.city);
        System.out.println(GanSu.area);
    }

}
