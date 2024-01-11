package Models.Characters;

public class Player extends Characters{


    public Player(int hp, int damage, int shield, int weight, String name, int coins) {
        super(hp, damage, shield, weight, name, coins);
    }
    @Override
    public void attack(Characters enemy) {
        System.out.println(getName() + " tire sur " + enemy.getName() + " avec des degat de " + getDamage() + " et à");
        enemy.takeDamage(getDamage());
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        System.out.println("Player : \n" + this.getShield() + "/" + this.getInitialShield()
                + " Shield\n" + this.getHp() + "/" + this.getInitialHP() + " HP\n");
    }


}
