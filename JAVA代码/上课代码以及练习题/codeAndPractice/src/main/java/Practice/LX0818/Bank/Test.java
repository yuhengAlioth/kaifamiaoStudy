package Practice.LX0818.Bank;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818.Bank
 * @文件名称：Test
 * @时间：2023/08/18/17:00
 */
public class Test {
    public static void main(String[] args) {
        BankAccount bankAccount = null;
        bankAccount = new SavingsAccount(0.5);
        bankAccount.setBalance(1000);
        bankAccount.deposit();
        bankAccount.withdraw(600);
    }
}

