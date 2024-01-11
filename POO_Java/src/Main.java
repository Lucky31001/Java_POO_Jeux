import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {
        Characters Perso = new Player(100, 30, 50, 50, "McAdam", 50);
        Characters Cargo = new Chasseur(0, 0, 0, 0, "BkZam", 0);


        Cargo.attack(Perso);
    }
}