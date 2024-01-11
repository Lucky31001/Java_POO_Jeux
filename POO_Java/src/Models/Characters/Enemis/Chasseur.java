package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Chasseur extends Characters {
    public Chasseur(int hp, int damage, int shield, int weight, String name, int initialShield) {
        super(hp, damage, shield, weight, name, initialShield);
        setHp(50);
        setDamage(10);
        setShield(25);
        setInitialShield(25);
        setWeight(20);
        setName("Chasseur");
    }
    @Override
    public void attack(Characters enemy) {
        System.out.println("Le " + getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }
}
