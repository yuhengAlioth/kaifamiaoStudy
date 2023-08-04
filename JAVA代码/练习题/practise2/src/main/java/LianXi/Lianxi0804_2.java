package LianXi;

public class Lianxi0804_2 {
    public static void main(String[] args) {
//        打印100以内除了尾数为3,5,7的所有数
        boolean s = true;
        for ( int i = 1;i <= 100; i ++){
            if (i % 10 != 3 && i % 10 != 5 && i % 10 != 7){
                System.out.println(i);
            }
        }
    }
}
