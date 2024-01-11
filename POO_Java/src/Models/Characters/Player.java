package Models.Characters;

public class Player extends Characters{


    public Player(int hp, int damage, int shield, int weight, String name) {
        super(hp, damage, shield, weight, name);
    }
    @Override
    public void attack(Characters enemy) {
        System.out.println(getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }

}
