package Code.NeiBuLei;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.NeiBuLei
 * @文件名称：Test
 * @代码功能：测试内部类
 * @时间：2023/08/29/14:45
 */
public class Test {
    public static void main(String[] args) {
        China china = new China();
        China.GanSu ganSu = china.new GanSu("兰州");
        china.fw();
        System.out.println("===================");
        ganSu.fw();
    }
}

