public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int numOfAccounts= 0;
    private static double totalAllAccounts=0;

    public BankAccount(){
        numOfAccounts ++;
        this.checkingBalance= 0;
        this.savingsBalance=0;
    }
    public static int bankCount(){
        return numOfAccounts;
    }
    public double getCheckingBalance(){
        return this.checkingBalance;
    }
    public double getSavingsBalance(){
        return this.savingsBalance;
    }
    public void depositMoney(double amount, String account){
        if(account.equals("Checking")){
            this.setChecking(this.getCheckingBalance() + amount);
        }else if(account.equals("Savings")){
            this.savingsBalance += amount;
        }
        totalAllAccounts += amount;
    }
    public void withdrawMoney(double amount, String account){
        if (account.equals("Checking")){
            if (this.getCheckingBalance()-amount<0){
                System.out.println("Insufficient funds. Please contact your bank.");
            }
            else {
                this.setChecking(this.getCheckingBalance()-amount);
                totalAllAccounts -= amount;
            }
        } else if (account.equals("Savings")){
            if (this.getSavingsBalance()-amount<0){
                System.out.println("Insufficient funds. Please contact your bank.");
            } else {
                this.setSavings(this.getSavingsBalance()-amount);
                totalAllAccounts-=amount;
            }
        }
    }
    public void accountBalance(){
        System.out.println("Total Checking:" + this.checkingBalance +"  " +"Total Savings:" + this.savingsBalance);
    }
    public static double getTotal(){
        return totalAllAccounts;
    }
    private void setChecking(double checkingBalance){
        this.checkingBalance= checkingBalance;
    }
    private void setSavings(double savingsBalance){
    this.savingsBalance = savingsBalance;
    }
}

