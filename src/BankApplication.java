import java.util.Scanner;

public class BankApplication {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many customers do you want to create ?");
             BankDetails cA;
            cA = new BankDetails();
            cA.openAccount();

        int ch;
        do {
            System.out.println("==================================================");
            System.out.println("=======================BANK=======================");
            System.out.println("1. Display all registered accounts \n 2. Search By ID\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Exit");
            System.out.println("Input: ");
            ch = sc.nextInt();
            switch(ch) {

                case 1:
                    BankDetails sa;
                    sa = new BankDetails();
                    sa.showAccount();
                    break;
                case 2:
                    BankDetails dep;
                    dep = new BankDetails();
                    dep.deposit();
                    break;
                case 3:
                    System.out.print("Enter the account ID you searching for: ");
                    break;
                case 4:
                    System.out.print("Enter the account ID you searching for: ");
                    break;
                case 5:
                    System.out.println("Exiting application!");
                    break;
            }
        }
        while (ch != 5);

    }
}
