package Controller;
import Models.Characters.Characters;
import View.cli;

import java.util.ArrayList;
import java.util.Scanner;

public class Combat extends Generate {


    public static boolean fight(Characters player, ArrayList<Characters> Enemies,int n){
        int fight = 0;
        int tour = 0;
        boolean victoire = false;
        Characters actualEnemis = Enemies.getFirst();
        System.out.flush();
        System.out.println("    "+player.getName()+" VS "+actualEnemis.getName()+"\r\n\n");

        if (actualEnemis.getWeight() >= player.getWeight()) {
            tour = 1;
        }
        while ((player.getHp() > 0) && (actualEnemis.getHp() > 0)) {

            if (tour == 1) {
                System.out.println("Tour du joueur... \r\n");
                System.out.flush();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choisissez votre action : \r\n1 - Attack \r\n2 - Retrieve Shield\r\n");

                int response = scanner.nextInt();

                switch (response){
                    case 1 :
                        player.attack(actualEnemis);
                        break;
                    case 2 :
                        player.retrieveShield();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + response);
                }
                tour = 0;
            }else{
                System.out.println("Tour de l'ennemi... \r\n");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println();
                actualEnemis.choice(player);
                tour = 1;
            }

        }
        if (player.getHp() <=0){
            System.out.flush();
            cli.restartLoose();
        }else {
            victoire = true;
            Enemies.removeFirst();
            System.out.flush();
            System.out.println("SUCCESS !\n");
            Characters.addCoins(actualEnemis,player);
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (Enemies.isEmpty()){
                cli.restartWin();
            }else {
                whatNext(player,Enemies,n);
            }
        }
        return victoire;
    }


    public static void whatNext(Characters player, ArrayList<Characters> Enemies,int n){

        if (n/3 == 1){
            System.out.flush();
            System.out.println("\nChoisissez votre action : \n\n1 - Continuer          2 - Station Spatiale\n");
            System.out.println(
                    "\n |||||||||||||||||||| \n"+
                    "\n  " + player.getName() +
                    " : \n - HP : " + player.getHp() +
                    "\n - Damage : " + player.getDamage() +
                    "\n - Defence : " + player.getShield() +
                    "\n - Weight : " + player.getWeight() +
                    "\n\n |||||||||||||||||||| \n");

            Scanner scanner = new Scanner(System.in);
            int response = scanner.nextInt();
            n = -1;
            switch (response) {
                case 1:
                    fight(player, Enemies, n + 1);
                    break;
                case 2:
                    cli.garage(player,Enemies,n);
                    break;
            }
        }else {
            System.out.flush();
            System.out.println("\nChoisissez votre action : \n\n1 - Continuer          2 - Station Spatiale\n");
            System.out.println(
                    "\n |||||||||||||||||||| \n"+
                    "\n  " + player.getName() +
                    " : \n - HP : " + player.getHp() +
                    "\n - Damage : " + player.getDamage() +
                    "\n - Defence : " + player.getShield() +
                    "\n - Weight : " + player.getWeight() +
                    "\n\n |||||||||||||||||||| \n");

            Scanner scanner = new Scanner(System.in);
            int response = scanner.nextInt();
            switch (response) {
                case 1:
                    fight(player, Enemies, n + 1);
                    break;
                case 2:
                    cli.station(player,Enemies,n);
                    break;
            }
        }
    }
}
