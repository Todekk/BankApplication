import java.util.Scanner;

public class BankApplication {
    public static void main(String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("How many customers do you want to create ?");
        int n = sc.nextInt();
        BankDetails C[] = new BankDetails[n];
        for (int i = 0; i < C.length; i++)
        {
            C[i] = new BankDetails();
            C[i].openAccount();
        }
        int ch;
        do {
            System.out.println("==================================================");
            System.out.println("=======================BANK=======================");
            System.out.println("1. Display all registered accounts \n 2. Search By ID\n 3. Deposit the amount \n 4. Withdraw the amount \n 5. Exit");
            System.out.println("Input: ");
            ch = sc.nextInt();
            switch(ch) {

                case 1:
                    for (int i = 0; i < C.length; i++) {
                        C[i].showAccount();
                    }
                    break;
                case 2:
                    System.out.print("Enter the account ID you searching for: ");
                    String ac_id = sc.next();
                    boolean found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_id);
                        if (found) {
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist! Are you sure you entered the right ID?");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account ID: ");
                    ac_id = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_id);
                        if (found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist! Are you sure you entered the right ID?");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account ID : ");
                    ac_id = sc.next();
                    found = false;
                    for (int i = 0; i < C.length; i++) {
                        found = C[i].search(ac_id);
                        if (found) {
                            C[i].withdraw();
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Account doesn't exist! Are you sure you entered the right ID?");
                    }
                    break;
                case 5:
                    System.out.println("Exiting application!");
                    break;
            }
        }
        while (ch != 5);

    }
}
