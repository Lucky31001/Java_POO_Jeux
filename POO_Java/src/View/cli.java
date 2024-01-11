package View;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import Controller.Combat;
import Controller.Generate;
import Models.Characters.Characters;

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
        String name = " ";
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    System.out.println("Rentrer votre pseudo : \r\n");
                    name = scanner1.next();
                    Combat.fight(name,Generate.easy());
                    break;
                case 2:
                    System.out.println("Rentrer votre pseudo : \r\n");
                    name = scanner1.next();
                    Combat.fight(name,Generate.normal());
                    break;
                case 3:
                    System.out.println("Rentrer votre pseudo : \r\n");
                    name = scanner1.next();
                    Combat.fight(name,Generate.hard());
                    break;
                case 4:
                    startMenu();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + response);
            }
        }finally {

        }
    }

    public static void station(Characters Player){
        System.out.flush();
        System.out.println("Bienvenue dans la Station :\r\n");
        System.out.println("Solde :"+ Player.getCoins() + " SD \r\n");
        System.out.println("1 - Réparation de 100 HP (300 SD)\r\n2 - Réparation de 300 HP (500 SD) \r\n3 - Retour");
        Scanner scanner = new Scanner(System.in);
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    if (Player.getCoins() >= 300){
                        Player.setHp(Player.getHp() + 100);
                        Player.setCoins(Player.getCoins() - 300);
                    }else {
                        System.out.println("Vous n'avez pas assez de StarDust");
                    }
                    break;
                case 2:
                    if (Player.getCoins() >= 500){
                        Player.setHp(Player.getHp() + 300);
                        Player.setCoins(Player.getCoins() - 500);
                    }else {
                        System.out.println("Vous n'avez pas assez de StarDust");
                    }
                    break;
                case 3:
                    startMenu();
                    break;
            }
        }catch(InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        }
    }

    public static void garage(Characters Player){
        System.out.flush();
        System.out.println("Bienvenue au garage :\r\n");
        System.out.println("Solde : "+ Player.getCoins() + " SD \r\n");
        System.out.println("1 - Heal \r\n2 - Shield \r\n3 - Weapons \r\n4 - Ammo \r\n5 - ??? \r\n6 - Retour");
        Scanner scanner = new Scanner(System.in);
        try {
            int response = scanner.nextInt();
            scanner.nextLine();
            switch (response) {
                case 1:
                    System.out.flush();
                    System.out.println("Heal :\r\n");
                    System.out.println("Solde :" + Player.getCoins() + " SD \r\n");
                    System.out.println("1 - Booster mineur +5% HP (300 SD) \r\n2 - Booster majeur +15% HP (750 SD)\r\n3 - Retour");
                    int response1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response1) {
                        case 1:
                            if (Player.getCoins() >= 300) {
                                Player.setInitialHP(Player.getInitialHP() + ((Player.getInitialHP() * 5) / 100));
                                Player.setCoins(Player.getCoins() - 300);
                                System.out.println("Achat bien effectué");

                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 2:
                            if (Player.getCoins() >= 750) {
                                Player.setInitialHP(Player.getInitialHP() + ((Player.getInitialHP() * 15) / 100));
                                Player.setCoins(Player.getCoins() - 750);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 3:
                            garage(Player);
                            break;
                    }
                    break;
                case 2:
                    System.out.flush();
                    System.out.println("Shield :\r\n");
                    System.out.println("Solde :" + Player.getCoins() + " SD \r\n");
                    System.out.println("1 - Booster mineur +5% Shield (300 SD) \r\n2 - Booster majeur +15% Shield (750 SD)\r\n3 - Retour");
                    int response2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response2) {
                        case 1:
                            if (Player.getCoins() >= 300) {
                                Player.setInitialShield(Player.getInitialShield() + ((Player.getInitialShield() * 5) / 100));
                                Player.setCoins(Player.getCoins() - 300);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 2:
                            if (Player.getCoins() >= 750) {
                                Player.setInitialShield(Player.getInitialShield() + ((Player.getInitialShield() * 15) / 100));
                                Player.setCoins(Player.getCoins() - 750);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 3:
                            garage(Player);
                            break;
                    }
                    break;
                case 3:
                    System.out.flush();
                    System.out.println("Weapons :\r\n");
                    System.out.println("Solde :" + Player.getCoins() + " SD \r\n");
                    System.out.println("1 - Canon Laser 450 Damage (500 SD) \r\n2 - Electro Canon 600 Damage (800 SD)\r\n3 - Canon Plasma 800 Damage (1300 SD)\r\n4 - Retour");
                    int response3 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response3) {
                        case 1:
                            if (Player.getCoins() >= 500) {
                                Player.setDamage(450);
                                Player.setCoins(Player.getCoins() - 500);
                                Player.setWeight(Player.getWeight() + 75);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 2:
                            if (Player.getCoins() >= 800) {
                                Player.setDamage(600);
                                Player.setCoins(Player.getCoins() - 800);
                                Player.setWeight(Player.getWeight() + 188);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 3:
                            if (Player.getCoins() >= 1300) {
                                Player.setDamage(800);
                                Player.setCoins(Player.getCoins() - 1300);
                                Player.setWeight(Player.getWeight() + 250);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 4:
                            garage(Player);
                            break;
                    }
                    break;
                case 4:
                    System.out.flush();
                    System.out.println("Ammo :\r\n");
                    System.out.println("Solde :" + Player.getCoins() + " SD \r\n");
                    System.out.println("1 - Charges Ionique +5% Damage (300 SD) \r\n2 - EXO Roquette +15% Damage (750 SD)\r\n3 - Retour");
                    int response4 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response4) {
                        case 1:
                            if (Player.getCoins() >= 300) {
                                Player.setDamage(Player.getDamage() + ((Player.getDamage() * 5) / 100));
                                Player.setCoins(Player.getCoins() - 300);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 2:
                            if (Player.getCoins() >= 750) {
                                Player.setDamage(Player.getDamage() + ((Player.getDamage() * 15) / 100));
                                Player.setCoins(Player.getCoins() - 750);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 3:
                            garage(Player);
                            break;
                    }
                    break;
                case 5:
                    System.out.flush();
                    System.out.println("M̷͎̏a̶̭̔r̷͚̚c̷̼̽h̶̹͒é̴̞͗ ̴̬͒N̸̰̂o̶͙̅i̷͈̇r̴͕̉ :\r\n");
                    System.out.println("Solde :" + Player.getCoins() + " SD \r\n");
                    System.out.println("1 - Booster Interstellaire +200% HP/Shield(2500 SD) \r\n2 - Starlight Quantum Annihilator 1500 Damage (3000 SD)\r\n3 - Retour");
                    int response5 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response5) {
                        case 1:
                            if (Player.getCoins() >= 2500) {
                                Player.setInitialHP(Player.getInitialHP() + ((Player.getInitialHP() * 200) / 100));
                                Player.setInitialShield(Player.getInitialShield() + ((Player.getInitialShield() * 200) / 100));
                                Player.setCoins(Player.getCoins() - 2000);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 2:
                            if (Player.getCoins() >= 3000) {
                                Player.setDamage(1500);
                                Player.setWeight(Player.getWeight() + 1000);
                                Player.setCoins(Player.getCoins() - 3000);
                                System.out.println("Achat bien effectué");
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                            }
                            break;
                        case 3:
                            garage(Player);
                            break;
                    }
                    break;
                case 6:
                    break;
                    }

        }catch(InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        }
    }


}