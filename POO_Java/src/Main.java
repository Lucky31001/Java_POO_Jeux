import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {


        View.cli.startMenu();
        //Characters Perso = new Player(100, 200, 50, 50, "McAdam");
        //Characters Ennemis = new Cargo(100,30,75,80, "Destructor");

        //Perso.attack(Ennemis);

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