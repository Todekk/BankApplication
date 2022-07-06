import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class BankDetails {
    String url="jdbc:mysql://localhost:3306/bankapp";
    String user="root";
    String pass="1234";
    private double balance;
    Scanner sc = new Scanner(System.in);
    public void openAccount(){
        System.out.println("==================================================");
        System.out.println("=================Account Creation=================");
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            Scanner scanner=new Scanner(System.in);
            System.out.println("Enter Username");
            String username=scanner.next();
            System.out.println("Enter balance");
            int balance=scanner.nextInt();

            statement.executeUpdate("insert into users(name, balance) value('"+username+"','"+balance+"')");
            System.out.println("Values inserted successfully!");


            /*ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
                System.out.println(resultSet.getString("balance"));
            }*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//Displaying account details
    public void showAccount() {
        System.out.println("==================================================");
        System.out.println("=================Account Details==================");
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();


            ResultSet resultSet = statement.executeQuery("select * from users");

            while (resultSet.next()) {
                System.out.println("==================================================");
                System.out.print("User ID: " + resultSet.getString("id"));
                System.out.print("\n Username: " + resultSet.getString("name"));
                System.out.print("\n Balance: " + resultSet.getString("balance"));
                System.out.println("\n==================================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Depositing funds
    public void deposit(){
        double amount;
        System.out.println("==================================================");
        System.out.println("=================Account Deposit==================");
        /*System.out.println("Enter the amount you want to deposit: ");
        amount = sc.nextDouble();*/
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);

            Statement statement = connection.createStatement();

            String updateQuery="update users set name = 'Todek', balance='5000' where id= 1";
            statement.executeUpdate(updateQuery);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /*public void withdraw(){
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
    }*/
}
