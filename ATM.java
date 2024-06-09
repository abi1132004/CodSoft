import java.util.Scanner;

class Account
{
    private double funds;
    public Account(double initialFunds)
    {
        this.funds = initialFunds;
    }
    public double getFunds()
    {
        return funds;
    }
    public void addFunds(double amount)
    {
        funds += amount;
        System.out.println("Deposit successful. Current balance: " + funds);
    }
    public void removeFunds(double amount)
    {
        if (funds >= amount) 
        {
            funds -= amount;
            System.out.println("Withdrawal successful. Current balance: " + funds);
        } 
        else
        {
            System.out.println("Insufficient funds. Withdrawal failed.");
        }
    }
}

class AutomatedTellerMachine
{
    private Account account;
    public AutomatedTellerMachine(Account account)
    {
        this.account = account;
    }
    public void showMenu()
    {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }
    public void executeOption(int option)
    {
        Scanner inputScanner = new Scanner(System.in);
        switch (option)
        {
            case 1:
                System.out.print("Enter amount to withdraw: ");
                double amountToWithdraw = inputScanner.nextDouble();
                account.removeFunds(amountToWithdraw);
                break;
            case 2:
                System.out.print("Enter amount to deposit: ");
                double amountToDeposit = inputScanner.nextDouble();
                account.addFunds(amountToDeposit);
                break;
            case 3:
                System.out.println("Current balance: " + account.getFunds());
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please choose again.");
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        Account userAccount = new Account(1000);
        AutomatedTellerMachine atm = new AutomatedTellerMachine(userAccount);
        Scanner inputScanner = new Scanner(System.in);
        while (true) 
        {
            atm.showMenu();
            System.out.print("Enter your choice: ");
            int userChoice = inputScanner.nextInt();
            atm.executeOption(userChoice);
        }
    }
}