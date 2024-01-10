package Models.Objects;

public class Consumable extends Objects{

    private int damage;
    private int defense;

    public Consumable(String name, int damage, int defense) {
        super(name);
        this.damage = damage;
        this.defense = defense;
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
}
