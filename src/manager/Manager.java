package manager;

import checker.Checker;

import java.util.Scanner;

public class Manager {
    Scanner scanner = new Scanner(System.in);
    private final Checker checker;

    public Manager() {
        checker = new Checker();
    }

    public void start() {
        while (true) {

            printMenu();

            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    String cardNum = getCardNum();
                    System.out.println(checker.check(cardNum));
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Такой комманды не существует. Попробуйте еще раз.");
            }
        }
    }

    private String getCardNum() {
        System.out.println("Введите номер карты: ");
        return scanner.next();
    }

    private void printMenu() {
        System.out.println("1. Проверить новую карту.");
        System.out.println("0. Выход.");
    }
}
