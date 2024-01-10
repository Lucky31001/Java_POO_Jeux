package Models.Characters;

public class Enemies extends Characters {

    private int type;

    public Enemies(int hp, int damage, int shield, int weight, String name, int initialShield, int type) {
        super(hp, damage, shield, weight, name, initialShield);
        this.type = type;
        //Cargo
        if (this.type == 1){
            setHp(100);
            setDamage(30);
            setShield(75);
            setInitialShield(75);
            setWeight(80);
        //Chasseur
        } else if (this.type == 2) {
            setHp(50);
            setDamage(10);
            setShield(25);
            setInitialShield(25);
            setWeight(20);
        //Patrouilleur
        } else if (this.type == 3) {
            setHp(75);
            setDamage(20);
            setShield(50);
            setInitialShield(50);
            setWeight(50);
        }
        else {
            System.out.println("Ce type n'existe pas");
        }
    }
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
