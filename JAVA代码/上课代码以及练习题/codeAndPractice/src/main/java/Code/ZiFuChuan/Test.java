package Code.ZiFuChuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ZiFuChuan
 * @文件名称：Test
 * @时间：2023/08/22/19:30
 */
public class Test {
    public static void main(String[] args) {
        String cha = "app";
        String cha2 = "aoy";
        System.out.println(cha.charAt(1));
        System.out.println(cha.compareTo(cha2));

        String cha3 = "  ab  cd  ";
        System.out.println(cha3.trim());

        boolean b = false;
        Boolean obj = Boolean.valueOf(b);
        System.out.println(obj); // Output: true

        char c = 'A';
        Character obj1 = Character.valueOf(c);
        System.out.println(obj1); // Output: A

        char[] data = {'H', 'e', 'l', 'l', 'o'};
        String str = String.valueOf(data);
        System.out.println(str); // Output: Hello

    }
}

