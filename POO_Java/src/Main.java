import Models.Characters.Characters;
import Models.Characters.Player;
import Models.Objects.Consumable;

public class Main {
    public static void main(String[] args) {
        Characters Perso = new Player(100, 30, 50, 50, "McAdam", 50);
        Consumable Potion = new Consumable("Potion", 0, 0, 0, 50);

        Potion.Interact(Perso);
    }
}