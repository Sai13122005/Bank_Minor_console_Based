public class Account
{
    private int accountID;
    private String customerName;
    private double balance;
    private Transaction[] transactions;
    private int transactionCount;
    private Account(int id, String customerName, double initialDeposit)
    {
        accountID = id;
        this.customerName = customerName;
        balance += initialDeposit;
        transactions = new Transaction[100];
        transactions[transactionCount++] = new Transaction("Deposit",initialDeposit);
    }
    public static Account setter(int id, String customer, double initialDeposit)
    {
        Account a = new Account(id, customer, initialDeposit);
        return a;
    }
    public void deposit(double amount)
    {
        balance += amount;
        transactions[transactionCount++] = new Transaction("Deposit",amount);
        System.out.println("Deposit Sucessful");
    }
    public void withdraw(double amount) 
    {
        if(balance-amount > Bank.getMinBalance())
        {
            balance -= amount;
            transactions[transactionCount++] = new Transaction("Withdraw",amount);
            System.out.println("Withdrawl Sucessful");
        }
        else
        {
            System.out.println("No minimum Balance");
        }
    }
    public boolean closeAccount()
    {
        Bank.getActiveList()[accountID] = false;
        Bank.getAccounts()[accountID] = null;
        return Bank.getActiveList()[accountID] == false; 
    }
    public void getTransactionHistory()
    {
        System.out.println("Transaction Details:-");
        for(int i = 0; i< transactionCount; i++)
        {
            System.out.println(transactions[i].getTransactionDetails());
        }
    }
    public void printDetails()
    {
        System.out.println(accountID+"\t"+customerName+"\t"+balance);
    }
}