package Models.Characters;

import java.util.Random;

public class Characters {

    private int hp;
    private int damage;
    private int defence;
    private int weight;
    private String name;

    public Characters(int hp, int damage, int defence, int weight) {
        this.hp = hp;
        this.damage = damage;
        this.defence = defence;
        this.weight = weight;
    }

    public void attack() {
        System.out.println("J'attaque");
    }

    public void takeDamage(int damage) {
        Random r = new Random();
        int random = r.nextInt(101);
        if (random <= this.weight){
            this.hp = this.hp - damage;
            System.out.println("Touché !");
        } else if (random <= this.weight + 10) {
            this.hp = this.hp - (damage / 2);
            System.out.println("Éraflé !");
        }
        else {
            System.out.println("Raté !");
        }
    }


    // Getter and Setter of HP
    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // Getter and Setter of damage
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    // Getter and Setter of defence
    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    // Getter and Setter of weight
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
