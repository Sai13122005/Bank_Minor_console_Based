import java.util.*;
public class UseBank
{
    public static void main(String[] args)
    {
        while(true)
        {
            System.out.println("1.Open a New Account\n2. Deposit Funds\n3. Withdraw Funds\n4. View Transaction History\n5. View All Bank Accounts\n6. Close an Account\n7. Exit");
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a Option:");
            int op = sc.nextInt();
            switch(op)
            {
                case 1:
                    System.out.println("Enter CustomerName and InitialDeposit");
                    Scanner s1 = new Scanner(System.in);
                    String name = s1.nextLine();
                    double amount = sc.nextDouble();
                    Account a = Bank.openAccount(name,amount);
                    break;
                case 2:
                    System.out.println("Enter AccountID");
                    int id = sc.nextInt();
                    if(Bank.getActiveList().length <= id || Bank.getActiveList()[id] == false)
                    {
                        System.out.println("ID not Found");
                    }
                    else
                    {
                        System.out.print("Enter Amount to Deposit: ");
                        double amount1 = sc.nextDouble();
                        Bank.getAccounts()[id].deposit(amount1);
                    }
                    break;
                case 3:
                    System.out.println("Enter AccountID");
                    int id1 = sc.nextInt();
                    if(Bank.getActiveList().length <= id1 || Bank.getActiveList()[id1] == false)
                    {
                        System.out.println("ID not Found");
                    }
                    else
                    {
                        System.out.print("Enter Amount to Withdraw: ");
                        double amount2 = sc.nextDouble();
                        Bank.getAccounts()[id1].withdraw(amount2);
                    }
                    break;
                case 4:
                    System.out.println("Enter AccountID");
                    int id2 = sc.nextInt();
                    if(Bank.getActiveList().length <= id2 || Bank.getActiveList()[id2] == false)
                    {
                        System.out.println("ID not Found");
                    }
                    else
                    {
                        Bank.getAccounts()[id2].getTransactionHistory();
                    }
                    break;
                case 5:
                    Bank.displayAllAccounts();
                    break;
                case 6:
                    System.out.println("Enter AccountID");
                    int id3 = sc.nextInt();
                    if(Bank.getActiveList().length <= id3 || Bank.getActiveList()[id3] == false)
                    {
                        System.out.println("ID not Found");
                    }
                    else
                    {
                        Bank.getAccounts()[id3].closeAccount();
                        System.out.println("Account Closed");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for visiting");
                    return;
                default:
                    System.out.println("Invalid Input,Try Again");
                sc.close();
            }
        }
    }
}