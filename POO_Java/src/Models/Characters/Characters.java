package Models.Characters;

import java.util.Random;

public class Characters {

    private int hp;
    private int damage;
    private int shield;
    private int weight;
    private String name;
    private int initialShield;

    public Characters(int hp, int damage, int shield, int weight, int initialShield) {
        this.hp = hp;
        this.damage = damage;
        this.shield = shield;
        this.weight = weight;
        this.initialShield = initialShield;
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

    public void retrieveShield(){
        if (this.shield >= this.initialShield){
            this.shield = this.initialShield;
            System.out.println("Bouclier max");
        } else{
            this.shield += 5;
            System.out.println("Régénération du bouclier");
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

    // Getter and Setter of shield
    public int getShield() {
        return shield;
    }

    public void setShield(int shield) {
        this.shield = shield;
    }

    // Getter and Setter of weight
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    // Getter and Setter of initialShield
    public int getInitialShield() {
        return initialShield;
    }
    public void setInitialShield(int initialShield) {
        this.initialShield = initialShield;
    }
}
