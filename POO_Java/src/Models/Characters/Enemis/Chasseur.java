package Models.Characters.Enemis;

import Models.Characters.Characters;

/**
 * The Chasseur class represents an enemy character type - Chasseur.
 */
public class Chasseur extends Characters {

    /**
     * Constructs a Chasseur object with specified attributes.
     *
     * @param hp     The initial health points.
     * @param damage The damage points.
     * @param shield The initial shield points.
     * @param weight The weight of the character.
     * @param name   The name of the character.
     * @param coins  The number of coins associated with the character.
     */
    public Chasseur(int hp, int damage, int shield, int weight, String name, int coins) {
        super(hp, damage, shield, weight, name, coins);
    }

    /**
     * Overrides the attack method to represent a Chasseur's attack behavior.
     *
     * @param enemy The character to be attacked.
     */
    @Override
    public void attack(Characters enemy) {
        System.out.println("Le " + getName() + " tire sur " + enemy.getName() +
                " avec des dégâts de " + getDamage() + " et a");
        enemy.takeDamage(getDamage());
    }

    /**
     * Overrides the takeDamage method to provide specific behavior for Chasseur taking damage.
     *
     * @param damage The damage to be taken.
     */
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }
}

