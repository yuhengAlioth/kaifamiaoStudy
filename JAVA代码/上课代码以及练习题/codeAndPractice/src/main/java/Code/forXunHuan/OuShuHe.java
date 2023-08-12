package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.forXunHuan
 * @文件名称：OuShuHe
 * @时间：2023/08/12/17:05
 */
public class OuShuHe {
    public static void main(String[] args) {
        // 计算并且输出从1到100之间所有偶数的和
        int sum = 0;
        for (int i = 1;i <= 100; i ++){
            if (i % 2 == 0){
                sum +=  i;
            }
        }
        System.out.println(sum);
    }
}

