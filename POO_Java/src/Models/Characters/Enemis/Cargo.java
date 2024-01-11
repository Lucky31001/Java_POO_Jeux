package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Cargo extends Characters {


    public Cargo(int hp, int damage, int shield, int weight, String name) {
        super(hp, damage, shield, weight, name);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Cargo : \n" + this.getShield() + "/" + this.getInitialShield()
        + " Shield \n" + this.getHp() + "/" + this.getInitialHP() + " HP");
    }
}
