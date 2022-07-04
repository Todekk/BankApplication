import java.util.Scanner;

public class BankDetails {
    private String accid;
    private String name;
    private double balance;
    Scanner sc = new Scanner(System.in);
    public void openAccount(){
        System.out.println("==================================================");
        System.out.println("=================Account Creation=================");
        System.out.print("Enter Account ID: ");
        accid = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextDouble();
    }
//Displaying account details
    public void showAccount() {
        System.out.println("==================================================");
        System.out.println("=================Account Details==================");
        System.out.println("Account holder: " + name);
        System.out.println("Account ID: " + accid);
        System.out.println("Balance Levs: " + balance + "lv.");
        System.out.println("Balance Euros: €" + (double) Math.round((balance*0.51)*100)/100);
        System.out.println("Balance Dollars: $" + (double) Math.round((balance*0.531)*100)/100);
    }
    //Depositing funds
    public void deposit(){
        double amount;
        System.out.println("==================================================");
        System.out.println("=================Account Deposit==================");
        System.out.println("Enter the amount you want to deposit: ");
        amount = sc.nextDouble();
        balance = balance + amount;

    }

    public void withdraw(){
        double amount;
        System.out.println("==================================================");
        System.out.println("=================Account Withdraw=================");
        System.out.println("Enter the amount to withdraw: ");
        amount = sc.nextDouble();
        if(balance >= amount){
            balance = balance - amount;
            System.out.println(("Balance after withdraw: " + balance));
        }
        else {
        System.out.println("Your balance is less than " + amount + ".\tTransaction failed!");
        }

    }
    public boolean search(String ac_id){
        if(accid.equals(ac_id)){
            showAccount();
            return(true);
        }
        return (false);
    }
}
