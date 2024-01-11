import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {

        Characters Perso = new Player(1000, 300, 500, 500, "Player");
        Characters Cargo = new Cargo(1000, 400, 750, 800, "Mechant");
        Consumable Potion = new Consumable("Potion", 0, 0, 0, 50);

        Perso.attack(Cargo);
        Perso.attack(Cargo);
        Perso.attack(Cargo);
        Perso.attack(Cargo);
        Perso.attack(Cargo);
        Cargo.choice(Perso);
        Cargo.choice(Perso);

    }
}