package View;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import Controller.Generate;

public class cli {
    public static void startMenu() {
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Jouer \r\n2 - Quitter");
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    setDifficulty();
                    break;
                case 2:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Invalide");
                    startMenu();
                    break;

            }
        }
        catch(InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        }
    }

    public static void setDifficulty(){
        System.out.flush();
        System.out.println("Choisissez votre difficultée :\r\n");
        System.out.println("1 - Easy \r\n2 - Normal \r\n3 - Hard \n\n4 - Menu ");
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1= new Scanner(System.in);
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    System.out.println("Rentrer votre pseudo : \r\n");
                    String name = scanner1.next();
                    Generate.easy(name);
                    break;
                case 2:
                    System.out.println("Rentrer votre pseudo : \r\n");
                    name = scanner1.next();
                    Generate.normal(name);
                    break;
                case 3:
                    System.out.println("Rentrer votre pseudo : \r\n");
                    name = scanner1.next();
                    Generate.hard(name);
                    break;
                case 4:
                    startMenu();
                    break;
            }
        }finally {

        }
    }
}