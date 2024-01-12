package Controller;
import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Patrouilleur;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;

import java.util.ArrayList;

import static View.cli.garage;

public class Generate {



    public static ArrayList<Characters> easy() {
        ArrayList<Characters> Enemies = new ArrayList<>();

        Characters cargo = new Cargo(1000, 500, 750, 800, "Cargo", 1111);
        Characters patrouilleur = new Patrouilleur(1000, 350, 500, 800, "Patrouilleur", 11111);
        Characters chasseur = new Chasseur(1000, 200, 350, 800, "Chasseur", 1111);
        Characters chasseur2 = new Chasseur(1000, 200, 350, 800, "Chasseur", 1111);

        Enemies.add(patrouilleur);
        Enemies.add(cargo);
        Enemies.add(chasseur);
        Enemies.add(chasseur2);
        return Enemies;

    }


    public static ArrayList<Characters> normal() {
        ArrayList<Characters> Enemies = new ArrayList<>();

        Characters cargo = new Cargo(1000, 500, 750, 800, "Cargo", 1111);
        Characters patrouilleur = new Patrouilleur(1000, 350, 500, 550, "Patrouilleur", 1111);
        Characters chasseur = new Chasseur(1000, 200, 350, 250, "Chasseur", 1111);

        Enemies.add(patrouilleur);
        Enemies.add(cargo);
        Enemies.add(chasseur);


        return Enemies;
    }

    public static ArrayList<Characters> hard() {
        ArrayList<Characters> Enemies = new ArrayList<>();

        Characters cargo = new Cargo(1000, 500, 750, 800, "Cargo", 1111);
        Characters patrouilleur = new Patrouilleur(1000, 350, 500, 550, "Patrouilleur", 1111);
        Characters chasseur = new Chasseur(1000, 200, 350, 250, "Chasseur", 111);

        Enemies.add(patrouilleur);
        Enemies.add(cargo);
        Enemies.add(chasseur);

        return Enemies;
    }

    public static Characters generatePlayer(String name) {
        Characters player = new Player(1000, 4000, 500, 550, name, 0);
        return player;
    }

    public static void afficherStats(Characters Player){
        System.out.println("Name   : " + Player.getName());
        System.out.println("HP     : " + Player.getHp());
        System.out.println("Shield : " + Player.getShield());
        System.out.println("Damage : " + Player.getDamage());
        System.out.println("Weight : " + Player.getWeight());
    }


}



