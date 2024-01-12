package Models.Objects;

import Models.Characters.Characters;

/**
 * The Consumable class represents a consumable item in the game, extending the Objects class
 * and implementing the Interactuable interface.
 */
public class Consumable extends Objects implements Interactuable {

    private int damage;
    private int defense;
    private int heal;

    /**
     * Constructs a Consumable object with specified attributes.
     *
     * @param name    The name of the consumable item.
     * @param weight  The weight of the consumable item.
     * @param damage  The damage points provided by the consumable.
     * @param defense The defense points provided by the consumable.
     * @param heal    The healing points provided by the consumable.
     */
    public Consumable(String name, int weight, int damage, int defense, int heal) {
        super(name, weight);
        this.damage = damage;
        this.defense = defense;
        this.heal = heal;
    }

    /**
     * Gets the damage points provided by the consumable.
     *
     * @return The damage points.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Sets the damage points provided by the consumable.
     *
     * @param damage The damage points to set.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }

    /**
     * Gets the defense points provided by the consumable.
     *
     * @return The defense points.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense points provided by the consumable.
     *
     * @param defense The defense points to set.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Gets the healing points provided by the consumable.
     *
     * @return The healing points.
     */
    public int getHeal() {
        return heal;
    }

    /**
     * Sets the healing points provided by the consumable.
     *
     * @param heal The healing points to set.
     */
    public void setHeal(int heal) {
        this.heal = heal;
    }

    /**
     * Interacts with the player character, updating its stats based on the consumable's attributes.
     *
     * @param player The player character to interact with.
     */
    @Override
    public void Interact(Characters player) {
        System.out.println(player.getName() + " (old stat) " +
                " : \n - HP : " + player.getHp() +
                "\n - Damage : " + player.getDamage() +
                "\n - Defense : " + player.getShield() +
                "\n - Weight : " + player.getWeight());

        player.setHp(player.getHp() + this.heal);
        player.setDamage(player.getDamage() + this.damage);
        player.setShield(player.getShield() + this.defense);
        player.setWeight(player.getWeight() - this.getWeight());

        System.out.println("\n\n |||||||||||||||||||||||||||||||||| \n" +
                "\n" + player.getName() + " (new stat) " +
                " : \n - HP : " + player.getHp() +
                "\n - Damage : " + player.getDamage() +
                "\n - Defense : " + player.getShield() +
                "\n - Weight : " + player.getWeight() +
                "\n\n |||||||||||||||||||||||||||||||||| \n");
    }
}
