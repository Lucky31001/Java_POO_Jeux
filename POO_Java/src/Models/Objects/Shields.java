package Models.Objects;

import Models.Characters.Characters;

/**
 * The Shields class represents a type of object that provides defense when interacted with by a player.
 */
public class Shields extends Objects implements Interactuable {

    private int defense;

    /**
     * Constructs a Shields object with specified attributes.
     *
     * @param name    The name of the shield.
     * @param defense The defense points provided by the shield.
     * @param weight  The weight of the shield.
     */
    public Shields(String name, int defense, int weight) {
        super(name, weight);
        this.defense = defense;
    }

    /**
     * Gets the defense points provided by the shield.
     *
     * @return The defense points of the shield.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Sets the defense points provided by the shield.
     *
     * @param defense The new defense points of the shield.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Interacts with the player, providing defense and updating the player's stats.
     *
     * @param player The player character.
     */
    @Override
    public void Interact(Characters player) {
        System.out.println(player.getName() + " (old stat) " +
                "\n - Defence : " + player.getShield() +
                "\n - Weight : " + player.getWeight());

        player.setShield(player.getShield() + this.defense);
        player.setWeight(player.getWeight() - this.getWeight());

        System.out.println("\n" + player.getName() + " (new stat) " +
                "\n - Defence : " + player.getShield() +
                "\n - Weight : " + player.getWeight() +
                "\n\n |||||||||||||||||||||||||||||||||||| \n");
    }
}
