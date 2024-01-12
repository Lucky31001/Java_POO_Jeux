package Models.Objects;

import Models.Characters.Characters;

/**
 * The Interactuable interface represents objects that can be interacted with by characters in the game.
 */
public interface Interactuable {

    /**
     * Interacts with a player character.
     *
     * @param player The player character to interact with.
     */
    void Interact(Characters player);
}
