package Practice.LX0818.Bank;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0818.Bank
 * @文件名称：BankAccount
 * @时间：2023/08/18/16:53
 */
public class BankAccount {
    private int accountNumber;
    private double balance;

    public int getAccountNumber(){
        return accountNumber;
    }
    public void setAccountNumber(int accountNumber){
        this.accountNumber = accountNumber;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }

    public void deposit(){
        System.out.println("存款：" + balance);
    }
    public void withdraw(double balance){
        System.out.println("取款：" + balance);
    }

}

