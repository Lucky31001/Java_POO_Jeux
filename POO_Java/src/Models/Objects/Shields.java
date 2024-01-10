package Models.Objects;


public class Shields extends Objects {

    private int defense;
    private int weight;

    public Shields(String name, int defense, int weight) {
        super(name);
        this.defense = defense;
        this.weight = weight;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}
