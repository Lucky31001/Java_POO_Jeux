package Controller;
import Models.Characters.Characters;
import Models.Characters.Enemis.Cargo;
import Models.Characters.Enemis.Patrouilleur;
import Models.Characters.Enemis.Chasseur;
import Models.Characters.Player;
import Models.Objects.Consumable;
import java.util.ArrayList;
public class Generate {

    public static void easy(String name) {
        Characters player = new Player(1000,350,500,550, name);
        ArrayList<Characters> Enemies = new ArrayList<>();
        Characters cargo = new Cargo(1000,500,750,800, "Destructor");
        Characters patrouilleur = new Patrouilleur(1000,350,500,550, "gravalax");
        Characters chasseur = new Chasseur(1000,200,350,250, "Vraxx");
        Enemies.add(patrouilleur);
        Enemies.add(cargo);
        Enemies.add(chasseur);

        System.out.println(Enemies);
        System.out.println(player.getName());
        for(int i = 0; i <=2 ;i++ ) {

            System.out.println(Enemies.get(i).getName());
        }
    }

    public static void normal(String name) {
        Characters player = new Player(1000,350,500,550,name);
        ArrayList<Characters> Enemies = new ArrayList<>();
        Characters cargo = new Cargo(1000,500,750,800, "Destructor");
        Characters patrouilleur = new Patrouilleur(1000,350,500,550, "gravalax");
        Characters chasseur = new Chasseur(1000,200,350,250, "Vraxx");
        Enemies.add(patrouilleur);
        Enemies.add(cargo);
        Enemies.add(chasseur);
    }
    public static void hard(String name) {
        Characters player = new Player(1000,350,500,550,name);
        ArrayList<Characters> Enemies = new ArrayList<>();
        Characters cargo = new Cargo(1000,500,750,800, "Destructor");
        Characters patrouilleur = new Patrouilleur(1000,350,500,550, "gravalax");
        Characters chasseur = new Chasseur(1000,200,350,250, "Vraxx");
        Enemies.add(patrouilleur);
        Enemies.add(cargo);
        Enemies.add(chasseur);
    }
}


