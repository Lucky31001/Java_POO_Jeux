package Models.Objects;

public class Consumable extends Objects {

    private int damage;
    private int defense;
    private int weight;

    public Consumable(String name, int weight, int damage, int defense) {
        super(name);
        this.damage = damage;
        this.defense = defense;
        this.weight = weight;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
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
