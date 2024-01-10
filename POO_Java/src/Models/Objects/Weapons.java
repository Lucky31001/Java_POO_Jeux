package Models.Objects;

public class Weapons extends Objects{

    private int damage;

    public Weapons(int weight, String name,int damage) {
        super(name, weight);
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
