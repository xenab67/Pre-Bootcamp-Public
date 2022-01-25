public class BankTest{
    public static void main(String[] args) {
    BankAccount b= new BankAccount();
    b.depositMoney(250.25, "Savings");
    b.depositMoney(2300.15, "Checking");
    b.accountBalance();
    b.withdrawMoney(200.00, "Savings");
    b.accountBalance();
    b.withdrawMoney(100.50, "Savings");
    b.withdrawMoney(650.18, "Checking");
    b.accountBalance();
    }
}