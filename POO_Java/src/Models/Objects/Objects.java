package Models.Objects;

/**
 * The Objects class represents the base class for all objects in the game.
 */
public abstract class Objects {

    private String name;
    private int weight;

    /**
     * Constructs an Objects object with specified attributes.
     *
     * @param name   The name of the object.
     * @param weight The weight of the object.
     */
    public Objects(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    /**
     * Gets the weight of the object.
     *
     * @return The weight of the object.
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets the weight of the object.
     *
     * @param weight The new weight of the object.
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets the name of the object.
     *
     * @return The name of the object.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the object.
     *
     * @param name The new name of the object.
     */
    public void setName(String name) {
        this.name = name;
    }
}
