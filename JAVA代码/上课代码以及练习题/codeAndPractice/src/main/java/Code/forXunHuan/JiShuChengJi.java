package Code.forXunHuan;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.forXunHuan
 * @文件名称：JiShuChengJi
 * @时间：2023/08/12/17:06
 */
public class JiShuChengJi {
    public static void main(String[] args) {
        // 计算并且输出从10到1之间所有奇数的乘积
        int pro = 1;
        for (int i = 10; i >= 1; i --){
            if (i % 2 != 0){
                pro *= i;
            }
        }
        System.out.println(pro);
    }
}

