package Practice.LX0816;

/**
 * @作者：玉蘅
 * @项目名称：codeAndPractice
 * @包名：Practice.LX0816
 * @文件名称：BankAccount
 * @时间：2023/08/16/19:19
 */
public class BankAccount {
    // 银行账户管理 创建一个名为 BankAccount 的类，用于管理银行账户。

    // 封装---属性：账户号码（accountNumber）、账户持有人姓名（accountHolder）、余额（balance）
    private String accountNumber;
    private String accountHolder;
    private double balance;

    // 无参构造
    public BankAccount() {
    }

    // 有参构造
    public BankAccount(String accountNumber, String accountHolder) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
    }

    // 获取账户号码的方法
    public String getAccountNumber() {
        return this.accountNumber;
    }
    // 设置账户号码的方法
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // 获取账户持有人姓名的方法
    public String getAccountHolder() {
        return this.accountHolder;
    }
    // 设置账户持有人姓名的方法
    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }
    // 获取余额的方法
    public double getBalance() {
        return balance;
    }
    // 设置余额的方法
    public void setBalance(double balance) {
        this.balance = balance;
    }

    // 输出查询信息的方法
    public String info() {
        return "账户名称：" + this.accountHolder + ", 账户编号：" + this.accountNumber + "，账户余额：" + this.balance;
    }

    // 存款方法
    public boolean saveMoney(double money) {
        if (money > 0) {
            this.balance += money;
            return true;
        } else {
            System.out.println("你输入的钱不对！");
            return false;
        }
    }

    // 取款方法
    public boolean drawMoney(double money) {
        if (money < 0) {
            System.out.println("你输入的钱不对！");
            return false;
        } else {
            if (balance < money) {
                System.out.println("余额不足，你心里没数嘛");
                return false;
            }
            balance -= money;
            return true;
        }
    }
}

