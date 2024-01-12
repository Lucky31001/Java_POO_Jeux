package Models.Characters;

import java.util.Random;

public class Characters {

    private int hp;
    private int damage;
    private int shield;
    private int weight;
    private String name;
    private int initialShield;
    private int initialHP;
    private int coins;

    public Characters(int hp, int damage, int shield, int weight, String name, int coins) {
        this.hp = hp;
        this.damage = damage;
        this.shield = shield;
        this.name = name;
        this.weight = weight;
        this.initialShield = shield;
        this.initialHP = hp;
        this.coins = coins;
    }


    public void takeDamage(int damage) {
        Random r = new Random();
        int random = r.nextInt(1001);
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
            System.out.println("Touché !\n");
        //Errafler
        } else if (random <= this.weight + 100) {
            if (this.shield > 0) {
                this.shield = this.shield - (damage / 2);
                if (this.shield < 0){
                    this.hp = this.hp + (this.shield / 2);
                    this.shield = 0;
                }
            }
            else {
                this.shield = 0;
                this.hp = this.hp - (damage / 2);
            }
            System.out.println("Éraflé !\n");
        //Raté
        } else {
            System.out.println("Raté !\n");
        }
        if (this.hp < 0) {
            System.out.println(getName() + " est mort\n");
            this.hp = 0;
        }
    }

    public void attack(Characters Ennemis) {
        Ennemis.takeDamage(this.damage);
    }

    public void retrieveShield(){
        if (this.shield >= this.initialShield){
            this.shield = this.initialShield;
            System.out.println("Bouclier max\n");
        } else{
            this.shield += this.initialShield / 4;
            System.out.println("Régénération du bouclier de " + this.initialShield / 4 +"\n");
        }
    }

    public void choice(Characters Ennemis){
        Random r = new Random();
        int n;
        if (this.shield == 0){
            if (this.hp <= this.initialShield /2){
                n = r.nextInt(2);
                if (n == 0){
                    this.retrieveShield();
                } else {
                    this.attack(Ennemis);
                }
            } else {
                n = r.nextInt(4);
                if (n == 0) {
                    this.retrieveShield();
                } else {
                    this.attack(Ennemis);
                }
            }
        } else if (this.shield <= this.initialShield / 2) {
            n = r.nextInt(5);
            if (n == 0){
                this.retrieveShield();
            } else {
                this.attack(Ennemis);
            }
        }else {
            this.attack(Ennemis);
        }
    }
    public static void addCoins(Characters enemy,Characters player){
        player.setCoins(player.getCoins() + enemy.getCoins());
        if (enemy.getCoins() == 1){
            System.out.println(enemy.getCoins() + " StarDust a été ajouté à votre reserve, suite à la mort de : " + enemy.getName() + "\n");
        } else {
            System.out.println(enemy.getCoins() + " StarDust ont été ajoutés à votre reserve, suite à la mort de : " + enemy.getName() + "\n");
        }

    }
    public int getInitialHP() {
        return initialHP;
    }

    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
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

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }
}
