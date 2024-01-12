package Controller;

import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Patrouilleur;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import View.cli;

import java.util.Random;
import java.util.ArrayList;

import static View.cli.garage;

/**
 * The Generate class provides methods for generating characters and enemies.
 */
public class Generate {

    /**
     * Generates a random integer based on the given base value.
     *
     * @param random The Random object used to generate random values.
     * @param base   The base value for generating the random integer.
     * @return A random integer within the specified range.
     */
    private static int getRandomInt(Random random, int base) {
        return random.nextInt(51) + base;
    }

    /**
     * Generates a list of easy-level enemy characters.
     *
     * @return An ArrayList containing instances of different enemy characters.
     */
    public static ArrayList<Characters> easy() {
        ArrayList<Characters> Enemies = new ArrayList<>();

        Characters cargo = new Cargo(getRandomInt(new Random(), 1500), getRandomInt(new Random(), 500), 750, 1000, "Cargo", 1000);
        Characters patrouilleur = new Patrouilleur(getRandomInt(new Random(), 700), getRandomInt(new Random(), 300), 500, 800, "Patrouilleur", 500);
        Characters chasseur = new Chasseur(getRandomInt(new Random(), 400), getRandomInt(new Random(), 200), 350, 700, "Chasseur", 200);
        Characters chasseur2 = new Chasseur(getRandomInt(new Random(), 400), getRandomInt(new Random(), 200), 350, 700, "Chasseur", 200);

        Enemies.add(chasseur);
        Enemies.add(patrouilleur);
        Enemies.add(chasseur2);
        Enemies.add(cargo);
        return Enemies;
    }

    /**
     * Generates a list of normal-level enemy characters.
     *
     * @return An ArrayList containing instances of different enemy characters.
     */
    public static ArrayList<Characters> normal() {
        ArrayList<Characters> Enemies = new ArrayList<>();

        Characters cargo = new Cargo(getRandomInt(new Random(), 1750), getRandomInt(new Random(), 500), 750, 900, "Cargo", 1000);
        Characters patrouilleur = new Patrouilleur(getRandomInt(new Random(), 1050), getRandomInt(new Random(), 300), 500, 700, "Patrouilleur", 500);
        Characters chasseur = new Chasseur(getRandomInt(new Random(), 600), getRandomInt(new Random(), 200), 350, 600, "Chasseur", 200);
        Characters chasseur2 = new Chasseur(getRandomInt(new Random(), 600), getRandomInt(new Random(), 200), 350, 600, "Chasseur", 200);

        Enemies.add(chasseur);
        Enemies.add(patrouilleur);
        Enemies.add(chasseur2);
        Enemies.add(cargo);

        return Enemies;
    }

    /**
     * Generates a list of hard-level enemy characters.
     *
     * @return An ArrayList containing instances of different enemy characters.
     */
    public static ArrayList<Characters> hard() {
        ArrayList<Characters> Enemies = new ArrayList<>();

        Characters cargo = new Cargo(getRandomInt(new Random(), 2000), getRandomInt(new Random(), 500), 750, 800, "Cargo", 1000);
        Characters patrouilleur = new Patrouilleur(getRandomInt(new Random(), 1400), getRandomInt(new Random(), 300), 500, 600, "Patrouilleur", 500);
        Characters chasseur = new Chasseur(getRandomInt(new Random(), 800), getRandomInt(new Random(), 200), 350, 500, "Chasseur", 200);
        Characters chasseur2 = new Chasseur(getRandomInt(new Random(), 800), getRandomInt(new Random(), 200), 350, 500, "Chasseur", 200);

        Enemies.add(chasseur);
        Enemies.add(patrouilleur);
        Enemies.add(chasseur2);
        Enemies.add(cargo);

        return Enemies;
    }

    /**
     * Generates a player character with the given name and default stats.
     *
     * @param name The name of the player character.
     * @return An instance of the player character.
     */
    public static Characters generateplayer(String name) {
        int hp = 1000;
        int damage = 350;
        int shield = 500;
        int weight = 550;
        String nom = name;
        int coins = 0;

        Characters player = new Player(hp, damage, shield, weight, nom, coins);
        cli.sauvegardeplayer(hp, damage, shield, weight, nom, coins);
        System.out.println("Player created");
        return player;
    }

    /**
     * Displays the statistics of the given character.
     *
     * @param Player The character whose statistics are to be displayed.
     */
    public static void afficherStats(Characters Player){
        System.out.println("Name   : " + Player.getName());
        System.out.println("HP     : " + Player.getHp());
        System.out.println("Shield : " + Player.getShield());
        System.out.println("Damage : " + Player.getDamage());
        System.out.println("Weight : " + Player.getWeight());
    }
}
