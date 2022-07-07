import java.util.Scanner;

public class BankApplication {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        BankDetails bd;
        bd = new BankDetails();
        int ch;
        do {
            System.out.println("==================================================");
            System.out.println("=======================BANK=======================");
            System.out.println("1 Create Account \n 2. Display all registered accounts \n 3. Deposit money\n 4. Withdraw money \n 5. Exit");
            System.out.println("Input: ");
            ch = sc.nextInt();
            switch (ch) {
                case 1:
                    bd.openAccount();
                    break;
                case 2:
                    bd.showAccount();
                    break;
                case 3:
                    bd.deposit();
                    break;
                case 4:
                    bd.withdraw();
                    break;
                case 5:
                    System.out.println("Exiting application!");
                    break;
            }
        }
        while (ch != 5);

    }
}
