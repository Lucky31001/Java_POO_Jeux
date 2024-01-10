package Models.Objects;


public class Shields extends Objects {

    private int defense;

    public Shields(String name, int defense, int weight) {
        super(name, weight);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

}
