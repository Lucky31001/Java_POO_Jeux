package Models.Objects;

public class Weapons extends Objects{

    private int damage;
    private int weight;

    public Weapons(int weight, String name,int damage) {
        super(name);
        this.damage = damage;
        this.weight = weight;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
