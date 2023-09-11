package Practice.LX0908;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class Account {
    private long id;
    private double balance;
    private String password;

    private static int count = 0; // 类
    public Account(double balance, String password) {
//        id = count ++; 先赋值
        id = ++count; // 先自增
        this.balance = balance;
        this.password = password;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return id == account.id && Double.compare(balance, account.balance) == 0 && Objects.equals(password, account.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, password);
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", balance=" + balance +
                ", password='" + password + '\'' +
                '}';
    }
}

class Test04 {
    public static void main(String[] args) {
        List<Account> list = new ArrayList<>();
        list.add(new Account(10.00, "1234"));
        list.add(new Account(15.00, "5678"));
        list.add(new Account(0, "1010"));
        // 该 Map 的键为id，值为相应的Account 对象。
        HashMap<Long, Account> hashMap = new HashMap<>();
        for (int i = 0; i < list.size(); i ++) {
            Account account = list.get(i);
            hashMap.put(account.getId(), account);
        }
        System.out.println(hashMap); // key=value
        // List forEach()  迭代器  for循环（支持随机访问） 增强for  Set 没有for循环
        hashMap.forEach((k, v) -> {
            System.out.println(k + ":" + v.getBalance());
        });
    }
}
