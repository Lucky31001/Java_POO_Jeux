package Models.Objects;

import Models.Characters.Characters;

public class Weapons extends Objects implements  Interactuable{

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
    @Override
    public void Interact(Characters Player) {
        System.out.println(Player.getName() +" (old stat) "+
                "\n - Damage : " + Player.getDamage() +
                "\n - Weight : " + Player.getWeight());

        Player.setDamage(Player.getDamage() + this.damage);
        Player.setWeight(Player.getWeight() - this.getWeight());

        System.out.println("\n" + Player.getName() + " (new stat) " +
                "\n - Damage : " + Player.getDamage() +
                "\n - Weight : " + Player.getWeight());
    }
}
