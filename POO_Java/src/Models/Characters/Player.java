package Models.Characters;

/**
 * The Player class represents a player character in the game, extending the base Characters class.
 */
public class Player extends Characters {

    /**
     * Constructs a Player object with specified attributes.
     *
     * @param hp     The initial health points.
     * @param damage The damage points.
     * @param shield The initial shield points.
     * @param weight The weight of the player character.
     * @param name   The name of the player character.
     * @param coins  The number of coins associated with the player character.
     */
    public Player(int hp, int damage, int shield, int weight, String name, int coins) {
        super(hp, damage, shield, weight, name, coins);
    }

    /**
     * Overrides the attack method to provide a custom message for player attacks.
     *
     * @param enemy The character to be attacked.
     */
    @Override
    public void attack(Characters enemy) {
        System.out.println(getName() + " tire sur " + enemy.getName() + " avec des dégâts de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }

    /**
     * Overrides the takeDamage method to invoke the base class method.
     *
     * @param damage The damage to be taken.
     */
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }
}
