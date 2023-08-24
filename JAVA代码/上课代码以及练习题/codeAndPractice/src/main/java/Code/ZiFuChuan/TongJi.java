package Code.ZiFuChuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ZiFuChuan
 * @文件名称：TongJi
 * @时间：2023/08/23/14:13
 */
public class TongJi {
    public static void main(String[] args) {
        String str = "Java语言是面向对象的，Java语言是健壮的，Java语言是安全的，Java语言是高性能的，Java语言是跨平台的";
        String demo = "Java";
        int index = str.indexOf(demo);
        int count = 0;
        while ( index >= 0){
            count++;
            str = str.substring(index + demo.length());
            index = str.indexOf(demo);
        }
        System.out.println(count);
    }
}

