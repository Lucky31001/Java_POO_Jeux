package Controller;
import Controller.Generate;
import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Enemis.Patrouilleur;
import Models.Characters.Player;
import Models.Objects.Consumable;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Combat extends Generate {


    public static void fight(String name, ArrayList<Characters> Enemies) {
        int tour = 0;
        Characters actualEnemis = Enemies.getFirst();
        Characters player = Generate.generatePlayer(name);


        if (actualEnemis.getWeight() >= player.getWeight()) {
            tour = 1;
        }
        while ((player.getHp() > 0) && (actualEnemis.getHp() > 0)) {

            if (tour == 1) {
                System.out.println("Tour du player \r\n");
                System.out.flush();
                Scanner scanner = new Scanner(System.in);
                System.out.println("Choisissez votre action : \r\n1 - Attack \r\n2 - Retrieve Shield\r\n");

                int response = scanner.nextInt();

                switch (response){
                    case 1 :
                        System.out.println("attaque");
                        player.attack(actualEnemis);
                        break;
                    case 2 :
                        System.out.println("Je recharge");
                        player.retrieveShield();
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + response);
                }
                tour = 0;
            }else{
                System.out.println("Tour du ainemy \r\n");
                System.out.println();
                actualEnemis.choice(player);
                tour = 1;
            }
            System.out.println(actualEnemis.getHp());
            System.out.println(player.getHp());
        }
        if (player.getHp() <=0){
            boolean victoire = false;
            System.out.println("Perdu");
        }else {
            boolean victoire = true;
            System.out.println("Gagné");
        }
        Enemies.removeFirst();
    }
}
