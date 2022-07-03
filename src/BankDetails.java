import java.util.Scanner;

public class BankDetails {
    private String accid;
    private String name;
    private String acc_type;
    private long balance;
    Scanner sc = new Scanner(System.in);
    public void openAccount(){
        System.out.println("==================================================");
        System.out.println("=================Account Creation=================");
        System.out.print("Enter Account ID: ");
        accid = sc.next();
        System.out.print("Enter Account Type: ");
        acc_type = sc.next();
        System.out.print("Enter Name: ");
        name = sc.next();
        System.out.print("Enter Balance: ");
        balance = sc.nextLong();
    }
//Displaying account details
    public void showAccount() {
        System.out.println("==================================================");
        System.out.println("=================Account Details==================");
        System.out.println("Account holder: " + name);
        System.out.println("Account ID: " + accid);
        System.out.println("Account type: " + acc_type);
        System.out.println("Balance: " + balance);
    }
    //Depositing funds
    public void deposit(){
        long amt;
        System.out.println("==================================================");
        System.out.println("=================Account Deposit==================");
        System.out.println("Enter the amount you want to deposit: ");
        amt = sc.nextLong();
        balance = balance + amt;

    }

    public void withdraw(){
        long amt;
        System.out.println("==================================================");
        System.out.println("=================Account Withdraw=================");
        System.out.println("Enter the amount to withdraw: ");
        amt = sc.nextLong();
        if(balance >= amt){
            balance = balance - amt;
            System.out.println(("Balance after withdraw: " + balance));
        }
        else {
        System.out.println("Your balance is less than " + amt + "\tTransaction failed!");
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
