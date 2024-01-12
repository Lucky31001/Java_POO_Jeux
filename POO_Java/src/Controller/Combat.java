package Controller;
import Models.Characters.Characters;
import View.cli;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Combat extends Generate {


    public static boolean fight(Characters player, ArrayList<Characters> Enemies,int n) throws IOException {
        int fight = 0;
        int tour = 0;
        boolean victoire = false;
        cli.sauvegardePlayer(player.getHp(), player.getDamage(), player.getShield(), player.getWeight(), player.getName(), player.getCoins());
        Characters actualEnemis = Enemies.getFirst();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("    "+player.getName()+" VS "+actualEnemis.getName()+"\n");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (actualEnemis.getWeight() >= player.getWeight()) {
            tour = 1;
        }

        while ((player.getHp() > 0) && (actualEnemis.getHp() > 0)) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                    "\n  " + player.getName() +
                    "\n----------------------"+
                    "\n - HP : " + player.getHp() + "/" + player.getInitialHP() +
                    "\n - Damage : " + player.getDamage() +
                    "\n - Shield : " + player.getShield() + "/" + player.getInitialShield() +
                    "\n - Weight : " + player.getWeight());
            System.out.println(
                    "\n  " + actualEnemis.getName() +
                    "\n----------------------"+
                    "\n - HP : " + actualEnemis.getHp() + "/" + actualEnemis.getInitialHP() +
                    "\n - Damage : " + actualEnemis.getDamage() +
                    "\n - Shield : " + actualEnemis.getShield() + "/" + actualEnemis.getInitialShield() +
                    "\n - Weight : " + actualEnemis.getWeight() +
                    "\n----------------------\n");
            if (tour == 1) {
                System.out.println("Tour du joueur... \r\n");
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choisissez votre action : \r\n1 - Attack \r\n2 - Retrieve Shield\r\n");
                int response = scanner.nextInt();

                switch (response){
                    case 1 :
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println(
                                "\n  " + player.getName() +
                                "\n----------------------"+
                                "\n - HP : " + player.getHp() + "/" + player.getInitialHP() +
                                "\n - Damage : " + player.getDamage() +
                                "\n - Shield : " + player.getShield() + "/" + player.getInitialShield() +
                                "\n - Weight : " + player.getWeight());
                        System.out.println(
                                "\n  " + actualEnemis.getName() +
                                "\n----------------------"+
                                "\n - HP : " + actualEnemis.getHp() + "/" + actualEnemis.getInitialHP() +
                                "\n - Damage : " + actualEnemis.getDamage() +
                                "\n - Shield : " + actualEnemis.getShield() + "/" + actualEnemis.getInitialShield() +
                                "\n - Weight : " + actualEnemis.getWeight() +
                                "\n----------------------\n");

                        player.attack(actualEnemis);

                        try {
                            Thread.sleep(1700);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    case 2 :
                        System.out.print("\033[H\033[2J");
                        System.out.flush();
                        System.out.println(
                                "\n  " + player.getName() +
                                "\n----------------------"+
                                "\n - HP : " + player.getHp() + "/" + player.getInitialHP() +
                                "\n - Damage : " + player.getDamage() +
                                "\n - Shield : " + player.getShield() + "/" + player.getInitialShield() +
                                "\n - Weight : " + player.getWeight());
                        System.out.println(
                                "\n  " + actualEnemis.getName() +
                                "\n----------------------"+
                                "\n - HP : " + actualEnemis.getHp() + "/" + actualEnemis.getInitialHP() +
                                "\n - Damage : " + actualEnemis.getDamage() +
                                "\n - Shield : " + actualEnemis.getShield() + "/" + actualEnemis.getInitialShield() +
                                "\n - Weight : " + actualEnemis.getWeight() +
                                "\n----------------------\n");
                        player.retrieveShield();
                        try {
                            Thread.sleep(1700);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + response);
                }
                tour = 0;
            }else{
                System.out.println("Tour de l'ennemi... \r\n");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                actualEnemis.choice(player);
                try {
                    Thread.sleep(2500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                tour = 1;
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }

        }
        if (player.getHp() <=0){
            cli.restartLoose();
        }else {
            victoire = true;
            Enemies.removeFirst();
            System.out.println("SUCCESS !\n");
            try {
                Thread.sleep(1200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Characters.addCoins(actualEnemis,player);
            try {
                Thread.sleep(1700);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Enemies.isEmpty()){
                cli.restartWin();
            }else {
                whatNext(player,Enemies,n+1);
            }
        }
        return victoire;
    }


    public static void whatNext(Characters player, ArrayList<Characters> Enemies,int n){
        player.setShield(player.getInitialShield());
        if (n == 3){
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                    "\n Vos statistiques :" +
                    "\n---------------------- \n"+
                    "\n - HP : " + player.getHp() + "/" + player.getInitialHP() +
                    "\n - Damage : " + player.getDamage() +
                    "\n - Shield : " + player.getShield() + "/" + player.getInitialShield() +
                    "\n - Weight : " + player.getWeight() +
                    "\n\n---------------------- \n");
            System.out.println("\nChoisissez votre action : \n\n1 - Continuer          2 - Garage\n");
            Scanner scanner = new Scanner(System.in);
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    n = 0;
                    fight(player, Enemies, n);
                    break;
                case 2:
                    cli.garage(player,Enemies,n);
                    break;
            }

        }else {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(
                    "\n Vos statistiques :" +
                    "\n---------------------- \n"+
                    "\n - HP : " + player.getHp() + "/" + player.getInitialHP() +
                    "\n - Damage : " + player.getDamage() +
                    "\n - Shield : " + player.getShield() + "/" + player.getInitialShield() +
                    "\n - Weight : " + player.getWeight() +
                    "\n\n---------------------- \n");
            System.out.println("\nChoisissez votre action : \n\n1 - Continuer          2 - Station Spatiale\n");
            Scanner scanner = new Scanner(System.in);
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    fight(player, Enemies, n);
                    break;
                case 2:
                    cli.station(player,Enemies,n);
                    break;
            }
        }
    }
}
