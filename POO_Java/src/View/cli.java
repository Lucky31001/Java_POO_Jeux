package View;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

import Controller.Combat;
import Controller.Generate;
import Models.Characters.Characters;
import Models.Characters.Player;
import Models.Characters.Player;


public class cli {

    /**
     * Displays the start menu for the Star Destroyer game.
     * Players can choose to begin a new game, continue an existing game, or exit the program.
     * If an invalid input is provided, the user is prompted again until a valid choice is made.
     */
    public static void startMenu() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n    WELCOME TO STAR DESTROYER\r\n\n");
        System.out.println("1 - Commencer       2 - Continuer     3 - Quitter\r\n");
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    setDifficulty(false);
                    break;
                case 2:
                    setDifficulty(true);
                    break;
                case 3:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Invalide");try {
                    Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    startMenu();
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        }
    }

    /**
     * Displays the game over message and options for restarting or quitting the game.
     * If an invalid input is provided, the user is prompted again until a valid choice is made.
     */
    public static void restartLoose() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        System.out.println("            GAME OVER !\r\n\n");
        System.out.println("1 - Rejouer            2 - Quitter\r\n");
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    setDifficulty(false);
                    break;
                case 2:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Invalide");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    startMenu();
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        }
    }

    /**
     * Displays the victory message and options for restarting or quitting the game.
     * If an invalid input is provided, the user is prompted again until a valid choice is made.
     */
    public static void restartWin() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        System.out.println("            YOU WON !\r\n\n");
        System.out.println("1 - Rejouer            2 - Quitter\r\n");
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    setDifficulty(false);
                    break;
                case 2:
                    System.out.println("Quitter");
                    break;
                default:
                    System.out.println("Invalide");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    startMenu();
                    break;

            }
        } catch (InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        }
    }

    /**
     * Sets the difficulty level for the game, either starting a new game or continuing an existing one.
     * Players can choose the difficulty (easy, normal, hard) and enter their username.
     * If an invalid input is provided, the user is prompted again until a valid choice is made.
     *
     * @param bool A boolean indicating whether to start a new game (false) or continue an existing one (true).
     *             If false, the method will guide the player through starting a new game.
     *             If true, the method will guide the player through continuing an existing game.
     */
    public static void setDifficulty(boolean bool) {
        if (!bool) { //Commencer
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Choisissez la difficultée de votre nouvelle partie :\r\n");
            System.out.println("1 - Easy \r\n2 - Normal \r\n3 - Hard \n\n4 - Menu ");
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            String name = " ";
            try {
                int response = scanner.nextInt();
                switch (response) {
                    case 1:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Rentrer votre pseudo : \r\n");
                        name = scanner1.next();
                        boolean victoire = Combat.fight(Generate.generateplayer(name), Generate.easy(), 0);
                        break;
                    case 2:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Rentrer votre pseudo : \r\n");
                        name = scanner1.next();
                        victoire = Combat.fight(Generate.generateplayer(name), Generate.normal(), 0);
                        break;
                    case 3:
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println("Rentrer votre pseudo : \r\n");
                        name = scanner1.next();
                        victoire = Combat.fight(Generate.generateplayer(name), Generate.hard(), 0);
                        break;
                    case 4:
                        startMenu();
                        break;
                    default:
                        System.out.println("Invalide");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        setDifficulty(bool);
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
            }
        } else { // Continuer
            System.out.flush();
            System.out.println("Choisissez la difficultée pour votre partie :\r\n");
            System.out.println("1 - Easy \r\n2 - Normal \r\n3 - Hard \n\n4 - Menu ");
            Scanner scanner = new Scanner(System.in);
            Scanner scanner1 = new Scanner(System.in);
            String name = " ";
            try {
                int response = scanner.nextInt();
                switch (response) {
                    case 1:
                        boolean victoire = Combat.fight(cli.LectureSauvegardeplayer(), Generate.easy(), 0);
                        break;
                    case 2:
                        victoire = Combat.fight(cli.LectureSauvegardeplayer(), Generate.normal(), 0);
                        break;
                    case 3:
                        victoire = Combat.fight(cli.LectureSauvegardeplayer(), Generate.hard(), 0);
                        break;
                    case 4:
                        startMenu();
                        break;
                    default:
                        System.out.println("Invalide");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        setDifficulty(bool);
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {

            }
        }
    }

    /**
     * Displays the Station menu where players can perform various actions.
     * Players can choose to repair their spaceship's HP by spending StarDust (SD),
     * or return to the main combat menu.
     *
     * @param player   The player character whose spaceship's HP and StarDust will be affected by the actions.
     * @param Enemies  An ArrayList of Characters representing the enemies in the current combat scenario.
     * @param n        An integer representing the current turn or round in the combat scenario.
     */
    public static void station(Characters player,ArrayList<Characters> Enemies,int n){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Bienvenue dans la Station :\r\n");
        System.out.println("Solde :" + player.getCoins() + " SD \r\n");
        System.out.println("1 - Réparation de 100 HP (300 SD)\r\n2 - Réparation de 300 HP (500 SD) \r\n3 - Retour");
        Scanner scanner = new Scanner(System.in);
        try {
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    if (player.getCoins() >= 300){
                        player.setHp(player.getHp() + 100);
                        player.setCoins(player.getCoins() - 300);
                        if (player.getHp() > player.getInitialHP()){
                            player.setHp(player.getInitialHP());
                        }
                        System.out.println("Achat bien effectué");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Combat.whatNext(player,Enemies,n);
                    }else {
                        System.out.println("Vous n'avez pas assez de StarDust");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Combat.whatNext(player,Enemies,n);
                    }
                    break;
                case 2:
                    if (player.getCoins() >= 500){
                        player.setHp(player.getHp() + 300);
                        player.setCoins(player.getCoins() - 500);
                        if (player.getHp() > player.getInitialHP()){
                            player.setHp(player.getInitialHP());
                        }
                        System.out.println("Achat bien effectué");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Combat.whatNext(player,Enemies,n);
                    }else {
                        System.out.println("Vous n'avez pas assez de StarDust");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        Combat.whatNext(player,Enemies,n);
                    }
                    break;
                case 3:
                    Combat.whatNext(player, Enemies, n);
                    break;
                default:
                    System.out.println("Invalide");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    station(player,Enemies, n);
                    break;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Displays the Garage menu where players can perform various actions related to their spaceship.
     * Players can choose to heal, boost shield, upgrade weapons, buy ammo, explore mysterious items,
     * or make special purchases.
     *
     * @param player   The player character whose spaceship's attributes and inventory will be affected by the actions.
     * @param Enemies  An ArrayList of Characters representing the enemies in the current combat scenario.
     * @param n        An integer representing the current turn or round in the combat scenario.
     */
    public static void garage(Characters player, ArrayList<Characters> Enemies, int n){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Bienvenue au garage :\r\n" +
                "Vos HP et Shield ont été restaurés");
        player.setShield(player.getInitialShield());
        player.setHp(player.getInitialHP());
        System.out.println("Solde : "+ player.getCoins() + " SD \r\n");
        System.out.println("1 - Heal \r\n2 - Shield \r\n3 - Weapons \r\n4 - Ammo \r\n5 - ??? \r\n6 - Retour");
        Scanner scanner = new Scanner(System.in);
        try {
            int response = scanner.nextInt();
            scanner.nextLine();
            switch (response) {
                case 1:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Heal :\r\n");
                    System.out.println("Solde :" + player.getCoins() + " SD \r\n");
                    System.out.println("1 - Booster mineur +5% HP (300 SD) \r\n2 - Booster majeur +15% HP (750 SD)\r\n3 - Retour");
                    int response1 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response1) {
                        case 1:
                            if (player.getCoins() >= 300) {
                                player.setInitialHP(player.getInitialHP() + ((player.getInitialHP() * 5) / 100));
                                player.setHp(player.getInitialHP());
                                player.setCoins(player.getCoins() - 300);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);

                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 2:
                            if (player.getCoins() >= 750) {
                                player.setInitialHP(player.getInitialHP() + ((player.getInitialHP() * 15) / 100));
                                player.setHp(player.getInitialHP());
                                player.setCoins(player.getCoins() - 750);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 3:
                            garage(player, Enemies, n);
                            break;
                        default:
                            System.out.println("Invalide");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            garage(player,Enemies, n);
                            break;
                    }
                    break;
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Shield :\r\n");
                    System.out.println("Solde :" + player.getCoins() + " SD \r\n");
                    System.out.println("1 - Booster mineur +5% Shield (300 SD) \r\n2 - Booster majeur +15% Shield (750 SD)\r\n3 - Retour");
                    int response2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response2) {
                        case 1:
                            if (player.getCoins() >= 300) {
                                player.setInitialShield(player.getInitialShield() + ((player.getInitialShield() * 5) / 100));
                                player.setShield(player.getInitialShield());
                                player.setCoins(player.getCoins() - 300);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 2:
                            if (player.getCoins() >= 750) {
                                player.setInitialShield(player.getInitialShield() + ((player.getInitialShield() * 15) / 100));
                                player.setShield(player.getInitialShield());
                                player.setCoins(player.getCoins() - 750);
                                System.out.println("Achat bien effectué");try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 3:
                            garage(player, Enemies, n);
                            break;
                        default:
                            System.out.println("Invalide");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            garage(player,Enemies, n);
                            break;
                    }
                    break;
                case 3:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Weapons :\r\n");
                    System.out.println("Solde :" + player.getCoins() + " SD \r\n");
                    System.out.println("1 - Canon Laser 450 Damage (500 SD) \r\n2 - Electro Canon 600 Damage (800 SD)\r\n3 - Canon Plasma 800 Damage (1300 SD)\r\n4 - Retour");
                    int response3 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response3) {
                        case 1:
                            if (player.getCoins() >= 500) {
                                player.setDamage(450);
                                player.setCoins(player.getCoins() - 500);
                                player.setWeight(player.getWeight() + 75);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 2:
                            if (player.getCoins() >= 800) {
                                player.setDamage(600);
                                player.setCoins(player.getCoins() - 800);
                                player.setWeight(player.getWeight() + 188);
                                System.out.println("Achat bien effectué");

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 3:
                            if (player.getCoins() >= 1300) {
                                player.setDamage(800);
                                player.setCoins(player.getCoins() - 1300);
                                player.setWeight(player.getWeight() + 250);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 4:
                            garage(player, Enemies, n);
                            break;
                        default:
                            System.out.println("Invalide");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            garage(player,Enemies, n);
                            break;
                    }
                    break;
                case 4:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("Ammo :\r\n");
                    System.out.println("Solde :" + player.getCoins() + " SD \r\n");
                    System.out.println("1 - Charges Ionique +5% Damage (300 SD) \r\n2 - EXO Roquette +15% Damage (750 SD)\r\n3 - Retour");
                    int response4 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response4) {
                        case 1:
                            if (player.getCoins() >= 300) {
                                player.setDamage(player.getDamage() + ((player.getDamage() * 5) / 100));
                                player.setCoins(player.getCoins() - 300);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 2:
                            if (player.getCoins() >= 750) {
                                player.setDamage(player.getDamage() + ((player.getDamage() * 15) / 100));
                                player.setCoins(player.getCoins() - 750);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);

                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 3:
                            garage(player, Enemies, n);
                            break;
                        default:
                            System.out.println("Invalide");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            garage(player,Enemies, n);
                            break;
                    }
                    break;
                case 5:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();
                    System.out.println("M̷͎̏a̶̭̔r̷͚̚c̷̼̽h̶̹͒é̴̞͗ ̴̬͒N̸̰̂o̶͙̅i̷͈̇r̴͕̉ :\r\n");
                    System.out.println("Solde :" + player.getCoins() + " SD \r\n");
                    System.out.println("1 - Booster Interstellaire +200% HP/Shield(2500 SD) \r\n2 - Starlight Quantum Annihilator 34500 Damage (55000 SD)\r\n3 - Retour");
                    int response5 = scanner.nextInt();
                    scanner.nextLine();
                    switch (response5) {
                        case 1:
                            if (player.getCoins() >= 2500) {
                                player.setInitialHP(player.getInitialHP() + ((player.getInitialHP() * 200) / 100));
                                player.setInitialShield(player.getInitialShield() + ((player.getInitialShield() * 200) / 100));
                                player.setHp(player.getInitialHP());
                                player.setShield(player.getInitialShield());
                                player.setCoins(player.getCoins() - 2000);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 2:
                            if (player.getCoins() >= 55000) {
                                player.setDamage(1500);
                                player.setWeight(player.getWeight() + 1000);
                                player.setCoins(player.getCoins() - 55000);
                                System.out.println("Achat bien effectué");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            } else {
                                System.out.println("Vous n'avez pas assez de StarDust");
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                                Combat.whatNext(player,Enemies,n);
                            }
                            break;
                        case 3:
                            garage(player, Enemies, n);
                            break;
                        default:
                            System.out.println("Invalide");
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            garage(player,Enemies, n);
                    }
                    break;
                case 6:
                    Combat.whatNext(player, Enemies, n);
                    break;
                default:
                    System.out.println("Invalide");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    garage(player,Enemies, n);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalide : " + e);
            startMenu();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        cli.sauvegardeplayer(player.getHp(), player.getDamage(), player.getShield(), player.getWeight(), player.getName(), player.getCoins());
        System.out.println("Sauvegarde automatique des stats du joueur... \r\n");

    }

    public static void sauvegardeplayer(int hp, int damage, int shield, int weight, String name, int coins) {
        File file = new File("Sauvegardeplayer.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            String hpText = String.valueOf(hp);
            String damageText = String.valueOf(damage);
            String shieldText = String.valueOf(shield);
            String weightText = String.valueOf(weight);
            String coinsText = String.valueOf(coins);

            bw.write(hpText);
            bw.newLine();
            bw.write(damageText);
            bw.newLine();
            bw.write(shieldText);
            bw.newLine();
            bw.write(weightText);
            bw.newLine();
            bw.write(name);
            bw.newLine();
            bw.write(coinsText);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Characters LectureSauvegardeplayer() throws IOException {
        File file = new File("Sauvegardeplayer.txt");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        ArrayList<String> sb = new ArrayList<String>();
        String line;
        while ((line = br.readLine()) != null) {
            sb.add(line);
        }
        fr.close();
        int hp = Integer.parseInt(sb.getFirst());
        int damage = Integer.parseInt(sb.get(1));
        int shield = Integer.parseInt(sb.get(2));
        int weight = Integer.parseInt(sb.get(3));
        int coins = Integer.parseInt(sb.getLast());
        Characters player = new Player(hp, damage, shield, weight, sb.get(4), coins);
        return player;
    }


}