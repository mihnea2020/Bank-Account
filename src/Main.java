import java.util.Scanner;

class BankDetails {
    private String accNo;
    private String name;
    private long  balance;
    Scanner in = new Scanner(System.in);

    public void openAccount() {
        System.out.print("Enter account number: ");
        accNo = in.next();
        System.out.print("Enter name: ");
        name = in.next();
        System.out.print("Enter balance: ");
        balance = in.nextLong();
    }

    public void showAccount() {
        System.out.println("Name of the account holder: " + name);
        System.out.println("Account number: " + accNo);
        System.out.println("Balance: " + balance + "\n");
    }

    public void deposit() {
        long dep;
        System.out.println("Enter the amount you want to deposit: ");
        dep = in.nextLong();
        balance = balance + dep;
    }

    public void withdraw() {
        long wit;
        System.out.println("Enter the amount wou want to withdraw: ");
        wit = in.nextLong();
        if(balance >= wit) {
            balance = balance - wit;
            System.out.println("Balance after withdrawal: " + balance);
        }else {
            System.out.println("Your balance is less than " + wit + "\tTransaction failed!");
        }
    }

    public boolean search(String acNum) {
        if(accNo.equals(acNum)) {
            showAccount();
            return (true);
        } else {
            return (false);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many numbers of customers do you want to input? ");
        int n = in.nextInt();
        BankDetails C[] = new BankDetails[n];
        for(int i = 0; i < C.length;i++) {
            C[i] = new BankDetails();
            C[i].openAccount();
        }

        int ch;
        do {
            System.out.println("\nBanking system application");
            System.out.println("1. Display all accounts details \n2. Search by account number \n3. Deposit the amount \n4. Withdraw the amount \n5. Exit");
            System.out.println("Enter your choice: ");
            ch = in.nextInt();
            String accNum;
            Boolean found;
            switch (ch) {
                case 1:
                    for(int i = 0; i< C.length; i++) {
                        C[i].showAccount();
                    }
                    break;

                case 2:
                    System.out.println("Enter the account number: ");
                    accNum = in.next();
                    found = false;
                    for(int i = 0; i < C.length; i++) {
                        found = C[i].search(accNum);
                        if(found)
                            break;
                    }
                    if(!found)
                        System.out.println("The account does not exist!");
                    break;

                case 3:
                    System.out.println("Enter the account number: ");
                    accNum = in.next();
                    found = false;
                    for(int i = 0; i < C.length; i++) {
                        found = C[i].search(accNum);
                        if(found) {
                            C[i].deposit();
                            break;
                        }
                    }
                    if(!found)
                        System.out.println("The account does not exist!");
                    break;

                case 4:
                    System.out.println("Enter the account number: ");
                    accNum = in.next();
                    found = false;
                    for(int i = 0; i < C.length; i++) {
                        found = C[i].search(accNum);
                        if(found) {
                            C[i].withdraw();
                            break;
                        }
                    }
                    if(!found)
                        System.out.println("The account does not exist!");
                    break;

                case 5:
                    System.out.println("Have a nice day!");
                    break;
            }
        }while(ch != 5);
    }
}