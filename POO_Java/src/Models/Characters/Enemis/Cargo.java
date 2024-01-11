package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Cargo extends Characters {
    public Cargo(int hp, int damage, int shield, int weight, String name, int coins) {
        super(hp, damage, shield, weight, name, coins);
    }
    @Override
    public void attack(Characters enemy) {
        System.out.println("Le " + getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }



    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println(this.getName() + ": \n" + this.getShield() + "/" + this.getInitialShield()
        + " Shield \n" + this.getHp() + "/" + this.getInitialHP() + " HP \n");
    }

}
