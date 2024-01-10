package Models.Objects;


import Models.Characters.Characters;

public class Shields extends Objects implements Interactuable{

    private int defense;

    public Shields(String name, int defense, int weight) {
        super(name, weight);
        this.defense = defense;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    @Override
    public void Interact(Characters Player) {
        System.out.println(Player.getName() +" (old stat) "+
                "\n - Defence : " + Player.getShield() +
                "\n - Weight : " + Player.getWeight());

        Player.setShield(Player.getShield() + this.defense);
        Player.setWeight(Player.getWeight() - this.getWeight());

        System.out.println("\n" + Player.getName() + " (new stat) " +
                "\n - Defence : " + Player.getShield() +
                "\n - Weight : " + Player.getWeight());
    }
}
