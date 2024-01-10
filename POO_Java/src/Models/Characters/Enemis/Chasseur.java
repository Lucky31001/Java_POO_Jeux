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
    }
}
