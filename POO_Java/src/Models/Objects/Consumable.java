package Models.Objects;

import Models.Characters.Characters;

public class Consumable extends Objects implements Interactuable {

    private int damage;
    private int defense;
    private int heal;

    public Consumable(String name, int weight, int damage, int defense, int heal) {
        super(name, weight);
        this.damage = damage;
        this.defense = defense;
        this.heal = heal;
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
    public int getHeal() {
        return heal;
    }

    public void setHeal(int heal) {
        this.heal = heal;
    }
    @Override
    public void Interact(Characters Player) {
        System.out.println(Player.getName() +" (old stat) "+
                " : \n - HP : " + Player.getHp() +
                "\n - Damage : " + Player.getDamage() +
                "\n - Defence : " + Player.getShield() +
                "\n - Weight : " + Player.getWeight());

        Player.setHp(Player.getHp() + this.heal);
        Player.setDamage(Player.getDamage() + this.damage);
        Player.setShield(Player.getShield() + this.defense);
        Player.setWeight(Player.getWeight() - this.getWeight());

        System.out.println("\n" + Player.getName() + " (new stat) " +
                " : \n - HP : " + Player.getHp() +
                "\n - Damage : " + Player.getDamage() +
                "\n - Defence : " + Player.getShield() +
                "\n - Weight : " + Player.getWeight() +
                "\n\n |||||||||||||||||||||||||||||||||||| \n");
    }
}
