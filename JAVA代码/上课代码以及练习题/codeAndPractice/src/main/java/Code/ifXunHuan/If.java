package Code.ifXunHuan;

import java.util.Scanner;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Code.ifXunHuan
 * @文件名称：If
 * @时间：2023/08/12/17:07
 */
public class If {
    public static void main(String[] args) {
        // 需求：测量用户体温，发现体温高于37度就报警。
        double temp = 38;
        if (temp > 37) {
            System.out.println("这个人体温不正常，快把他抓走");
            System.out.println("这个人体温不正常，快把他抓走");
            System.out.println("这个人体温不正常，快把他抓走");
        }
        System.out.println("我是代码的剩余部分");

        System.out.println("-----------------------------------------------");
        // 需求2：发红包，你的钱包余额是99元，现在要发出90元
        // 如果钱够触发发红包的动作，如果钱不够，则提示：余额不足。
        System.out.println("我要开始发红包了");
        double balance = 89;
        if (balance > 90) {
            balance -= 90;
            System.out.println("你的余额是" + balance);
        } else {
            System.out.println("你的余额不足");
        }
        System.out.println("-----------------------------------------------");
        // 需求3：某个公司有一个绩效系统，根据员工的打分输出对应的绩效级别。[0,60) D [60,80) C [80,90) B [90,100] A
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入员工打分成绩");
        double score = sc.nextDouble();
        if (score >= 0 && score < 60) {
            System.out.println("员工绩效级别：D");
        } else if (score < 80) {
            System.out.println("员工绩效级别：C");
        } else if (score < 90) {
            System.out.println("员工绩效级别：B");
        } else if (score <= 100) {
            System.out.println("员工绩效级别：A");
        } else {
            System.out.println("你输入的成绩不合理");
        }
        System.out.println("绩效评定完毕");

    }
}

