package Practice.LX0818.Bank;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818.Bank
 * @文件名称：SavingsAccount
 * @时间：2023/08/18/17:05
 */
public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(double interestRate){
        this.interestRate = interestRate;
    }
    @Override
    public void withdraw(double balance) {
        System.out.println("取款：" + balance * interestRate);
    }
}

