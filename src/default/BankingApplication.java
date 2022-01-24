import java.util.Scanner;

public class BankingApplication {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj swoje imie");
        String customerName = scan.nextLine();
        System.out.println("Podaj swoje nazwisko");
        String customerId = scan.nextLine();

        BankAccount Name = new BankAccount(customerName, customerId);
        Name.showMenu();

    }
}

class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String cname, String cid) {
        customerName = cname;
        customerId = cid;

    }

    void deposit(int amount) {
        if (amount != 0) {
            balance = balance + amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Wpłacono: " + previousTransaction + "zł");
        } else if (previousTransaction < 0) {
            System.out.println("Wypłacono: " + Math.abs(previousTransaction) + "zł");
        } else {
            System.out.println("Nie dokonano żadnej transakcji");
        }
    }

        void showMenu() {

            char option = '\0';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Witaj " + customerName + " " + customerId);
            System.out.println("\n");
            System.out.println("A: Sprawdź swój stan konta");
            System.out.println("B: Wpłać pieniądze");
            System.out.println("C: Wypłać pieniądze");
            System.out.println("D: Ostatnia Transakcja");
            System.out.println("E: Wyjdź z Systemu");
            System.out.println("F: Przelicz na dolary");

            do {
                System.out.println("\n");
                System.out.println("Wybierz swoją opcję: ");
                option = scanner.next().charAt(0);
                System.out.println("\n");

                switch (option) {
                    case 'A':
                        System.out.println("------");
                        System.out.println("Kwota na koncie: = " + balance + " zł");
                        System.out.println("------");
                        break;

                    case 'B':
                        System.out.println("------");
                        System.out.println("Wybierz kwote jaką chcesz wpłacić na konto: " + balance + " zł");
                        System.out.println("------");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println("\n");
                        break;

                    case 'C':
                        System.out.println("------");
                        System.out.println("Wybierz kwote jaką chcesz wypłacić z konta: " + balance + " zł");
                        System.out.println("------");
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println("\n");
                        break;

                    case 'D':
                        System.out.println("------");
                        getPreviousTransaction();
                        System.out.println("------");
                        break;

                    case 'E':
                        System.out.println("-----------");
                        break;

                    case 'F':
                        System.out.println("Kwota w dolarach na twoim koncie to: " + balance * 4.01 + " USD");
                        break;

                    case 'G':
                        System.out.println("Największa transakcja w systemie: ");
                }
            }
            while (option != 'E');
            System.out.println("Dziekuje za skorzystanie z naszych usług!");

        }
    }