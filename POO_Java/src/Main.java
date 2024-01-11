import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {
        Characters player = new Player(1000,350,500,550, "hehe", 500);

        View.cli.garage(player);
        //Characters Perso = new Player(100, 200, 50, 50, "McAdam");
        //Characters Ennemis = new Cargo(100,30,75,80, "Destructor");

        //Perso.attack(Ennemis);


    }
}