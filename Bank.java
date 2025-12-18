public class Bank
{
    private static final int MAX_ACCOUNTS = 10;
    private static Account[] accounts;
    private static boolean[] activeIDs;
    private static final double MIN_BALANCE = 500.00;
    
    static{
        System.out.println("Bank is Now Online");
        accounts = new Account[MAX_ACCOUNTS];
        activeIDs = new boolean[MAX_ACCOUNTS];
        
    }
    
    public static Account openAccount(String customerName, double initialDeposit){
        if(initialDeposit < MIN_BALANCE)
        {
            System.out.println("Minimum Balance Should be "+MIN_BALANCE);
            return null;
        }
        int i = 0;
        while(i < MAX_ACCOUNTS && activeIDs[i]!= false)
        {
            i++;
        }
        if(i >= MAX_ACCOUNTS)
        {
            System.out.println("Bank is Full...");
            return null;
        }
        activeIDs[i] = true;
        accounts[i] = Account.setter(i, customerName, initialDeposit);
        System.out.println("Congrats, Account opened");
        return accounts[i];
    }
    public static double getMinBalance()
    {
        return MIN_BALANCE;
    }
    public static boolean[] getActiveList()
    {
        return activeIDs;
    }
     public static Account[] getAccounts()
    {
        return accounts;
    }
    public static Account findAccount(int accountNumber)
    {
        if(MAX_ACCOUNTS <= accountNumber)
        {
            return null;
        }
        return accounts[accountNumber];
    }
    public static void displayAllAccounts(){
        System.out.println("BANK ACCOUNTS:-");
        System.out.println("ID\tName\t\tBalance");
        for(int i = 0; i< MAX_ACCOUNTS; i++)
        {
            if(accounts[i] != null)
            {
                accounts[i].printDetails();
            }
            else
            {
                System.out.println(i+" is Inactive");
            }
        }
    }
}