package Models.Objects;

import Models.Characters.Characters;

/**
 * The Weapons class represents a type of object that provides damage when interacted with by a player.
 */
public class Weapons extends Objects implements Interactuable {

    private int damage;

    /**
     * Constructs a Weapons object with specified attributes.
     *
     * @param weight The weight of the weapon.
     * @param name   The name of the weapon.
     * @param damage The damage points provided by the weapon.
     */
    public Weapons(int weight, String name, int damage) {
        super(name, weight);
        this.damage = damage;
    }

    /**
     * Gets the damage points provided by the weapon.
     *
     * @return The damage points of the weapon.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage points provided by the weapon.
     *
     * @param damage The new damage points of the weapon.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Interacts with the player, providing damage and updating the player's stats.
     *
     * @param player The player character.
     */
    @Override
    public void Interact(Characters player) {
        System.out.println(player.getName() + " (old stat) " +
                "\n - Damage : " + player.getDamage() +
                "\n - Weight : " + player.getWeight());

        player.setDamage(player.getDamage() + this.damage);
        player.setWeight(player.getWeight() - this.getWeight());

        System.out.println("\n" + player.getName() + " (new stat) " +
                "\n - Damage : " + player.getDamage() +
                "\n - Weight : " + player.getWeight() +
                "\n\n |||||||||||||||||||||||||||||||||||| \n");
    }
}
