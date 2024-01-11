import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {

        Characters Perso = new Player(1000, 300, 500, 500, "Player", 0);
        Characters Cargo = new Cargo(1000, 400, 750, 800, "Mechant", 30);
        Consumable Potion = new Consumable("Potion", 0, 0, 0, 50);

        System.out.println(Perso.getCoins());
        Perso.attack(Cargo);
        Perso.addCoins(Cargo);
        System.out.println(Perso.getCoins());


    }
}