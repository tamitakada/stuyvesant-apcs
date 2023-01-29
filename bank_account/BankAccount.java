public class BankAccount {

  private double balance;
  private int accountID;
  private String password;

  public static void main(String args[]) {

  }

  public BankAccount(int a, String p) {
    balance = 0;
    accountID = a;
    password = p;
  }

  public double getBalance() {
    return balance;
  }

  public int getAccountID() {
    return accountID;
  }

  public void setPassword(String newPass) {
    password = newPass;
  }

  public boolean deposit(double amount) {
    if (amount < 0) return false;
    else balance += amount;
    return true;
  }

  public boolean withdraw(double amount) {
    if ((amount < 0) || (balance < amount)) return false;
    else balance -= amount;
    return true;
  }

  private boolean authenticate(String password) {
    return this.password.equals(password);
  }

  public boolean tranferTo(BankAccount other, double amount, String password) {
    return (authenticate(password) && withdraw(amount) && other.deposit(amount));
  }

  public String toString() {
    return "" + '#' + accountID + "\t$" + balance;
  }

  public String getPassword() {
    return password;
  }

}
