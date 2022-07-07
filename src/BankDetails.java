import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.Scanner;
import static java.lang.Runtime.getRuntime;

public class BankDetails {
    String url="jdbc:mysql://localhost:3306/bankapp";
    String user="root";
    String pass="1234";
    Scanner sc = new Scanner(System.in);
    //Creating account
    public void openAccount(){
        System.out.println("==================================================");
        System.out.println("=================Account Creation=================");
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            System.out.println("Enter Username");
            String username=sc.next();
            System.out.println("Enter balance");
            int balance=sc.nextInt();
            statement.executeUpdate("insert into users(name, balance) value('"+username+"','"+balance+"')");
            System.out.println("Values inserted successfully!");
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
                DecimalFormat f = new DecimalFormat("##.00");
                System.out.println("==================================================");
                System.out.print("User ID: " + resultSet.getString("id"));
                System.out.print("\n Username: " + resultSet.getString("name"));
                System.out.print("\n Balance: " + resultSet.getString("balance"));
                System.out.print("\n Balance (Euro): €" + f.format((resultSet.getDouble("balance")*0.51)));
                System.out.print("\n Balance (Dollars): $" + f.format((resultSet.getDouble("balance")*0.53)));
                System.out.print("\n Balance (Yen): ¥" + f.format((resultSet.getDouble("balance")*70.68)));
                System.out.println("\n==================================================");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Depositing funds
    public void deposit(){
        System.out.println("==================================================");
        System.out.println("=================Account Deposit==================");
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            if(resultSet.next()){
            System.out.println("Enter ID");
            int userId=sc.nextInt();
            System.out.println("Deposit amount: ");
            double deposit=sc.nextInt();
            double balance = resultSet.getInt("balance");
            double newBalance = deposit + balance;
                String updateQuery="update users set balance="+newBalance+" where id="+userId+"";
                statement.executeUpdate(updateQuery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Withdrawing funds
    public void withdraw(){
        double amount;
        System.out.println("==================================================");
        System.out.println("=================Account Withdraw=================");
        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from users");
            if(resultSet.next()){
                System.out.println("Enter ID");
                int userId=sc.nextInt();
                System.out.println("Withdraw amount: ");
                double withdraw=sc.nextInt();
                double balance = resultSet.getInt("balance");
                double newBalance = balance - withdraw;
                if(withdraw > balance)
                {
                    System.out.println("You don't have sufficient funds!");
                    Runtime.getRuntime().exit(1);
                }
                String updateQuery="update users set balance="+newBalance+" where id="+userId+"";
                statement.executeUpdate(updateQuery);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
