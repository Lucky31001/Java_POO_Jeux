package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Patrouilleur extends Characters {
    public Patrouilleur(int hp, int damage, int shield, int weight, String name, int initialShield) {
        super(hp, damage, shield, weight, name, initialShield);
        setHp(75);
        setDamage(20);
        setShield(50);
        setInitialShield(50);
        setWeight(50);
        setName("Patrouilleur");
    }
    @Override
    public void attack(Characters enemy) {
        System.out.println("La " + getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }

}
