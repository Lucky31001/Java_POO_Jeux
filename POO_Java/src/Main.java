import Models.Characters.Characters;
import Models.Characters.Enemies;
import Models.Characters.Player;

public class Main {
    public static void main(String[] args) {
        Characters Perso = new Player(100, 30, 50, 50, "McAdam", 50);
        Characters Ennemis = new Enemies(0, 0, 0, 0, "McZam", 0, 1);

        while (Ennemis.getHp() > 0) {
            Perso.attack(Ennemis);
        }
    }
}