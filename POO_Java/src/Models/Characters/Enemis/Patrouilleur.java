package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Patrouilleur extends Characters {
    public Patrouilleur(int hp, int damage, int shield, int weight, String name, int coins) {
        super(hp, damage, shield, weight, name, coins);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public void attack(Characters enemy) {
        System.out.println("La " + getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }
}
