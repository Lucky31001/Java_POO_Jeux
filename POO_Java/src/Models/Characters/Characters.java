package Models.Characters;

import java.util.Random;

public class Characters {

    private int hp;
    private int damage;
    private int shield;
    private int weight;
    private String name;
    private int initialShield;

    public Characters(int hp, int damage, int shield, int weight, String name, int initialShield) {
        this.hp = hp;
        this.damage = damage;
        this.shield = shield;
        this.name = name;
        this.weight = weight;
        this.initialShield = initialShield;
    }


    public void takeDamage(int damage) {
        Random r = new Random();
        int random = r.nextInt(101);
        //Toucher
        if (random <= this.weight){
            if (this.shield > 0) {
                this.shield = this.shield - damage;
                if (this.shield < 0){
                    this.hp = this.hp + (this.shield / 2);
                    this.shield = 0;
                }
            }
            else {
                this.shield = 0;
                this.hp = this.hp - damage;
            }
            System.out.println("Touché !");
        //Errafler
        } else if (random <= this.weight + 10) {
            if (this.shield > 0) {
                this.shield = this.shield - (damage / 2);
            }
            else {
                this.shield = 0;
                this.hp = this.hp - (damage / 2);
            }
            System.out.println("Éraflé !");
        //Raté
        } else {
            System.out.println("Raté !");
        }
        if (this.hp < 0) {
            System.out.println(this.name + " est mort");
            this.hp = 0;
        }
        System.out.println("shield :" + this.shield + " vie : " + this.hp);
    }

    public void attack(Characters Ennemis) {
        Ennemis.takeDamage(this.damage);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
