import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {

        Characters Perso = new Player(100, 30, 50, 50, "McAdam");
        Characters Cargo = new Chasseur(100, 40, 75, 80, "BkZam");


        Cargo.attack(Perso);
    }
}