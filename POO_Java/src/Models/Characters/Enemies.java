package Models.Characters;

public class Enemies extends Characters {

    private String type;
    private int escape;

    public Enemies(int hp, int damage, int defence, int weight, String type) {
        super(hp, damage, defence, weight);
        this.type = type;
        //Cargo
        if (this.type == "1"){
            setHp(100);
            setDamage(30);
            setDefence(75);
            setWeight(80);
        //Chasseur
        } else if (this.type == "2") {
            setHp(50);
            setDamage(10);
            setDefence(25);
            setWeight(20);
        //Patrouilleur
        } else if (this.type == "3") {
            setHp(75);
            setDamage(20);
            setDefence(50);
            setWeight(50);
        }
        else {
            System.out.println("Ce type n'existe pas");
        }
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
