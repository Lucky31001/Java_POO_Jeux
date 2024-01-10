package Models.Characters.Enemis;

import Models.Characters.Characters;

public class Cargo extends Characters {
    public Cargo(int hp, int damage, int shield, int weight, String name, int initialShield) {
        super(hp, damage, shield, weight, name, initialShield);
        setHp(100);
        setDamage(30);
        setShield(75);
        setInitialShield(75);
        setWeight(80);
    }
}
