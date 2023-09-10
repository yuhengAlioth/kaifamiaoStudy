package exercise.september.Sept8th;

import java.util.Objects;

public class Account {
    private long id = 0;
    private double balance;
    private String password;

Exec04 exec04 = new Exec04();

    public Account( double balance, String password) {
        id=exec04.s++;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id && Double.compare(account.balance, balance) == 0 && Objects.equals(password, account.password);
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
