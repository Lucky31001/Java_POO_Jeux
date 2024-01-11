package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Patrouilleur extends Characters {
    public Patrouilleur(int hp, int damage, int shield, int weight, String name) {
        super(hp, damage, shield, weight, name);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println(this.getName() + ": \n" + this.getShield() + "/" + this.getInitialShield()
                + " Shield \n" + this.getHp() + "/" + this.getInitialHP() + " HP \n");
    }

    @Override
    public void attack(Characters enemy) {
        System.out.println("La " + getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }
}
