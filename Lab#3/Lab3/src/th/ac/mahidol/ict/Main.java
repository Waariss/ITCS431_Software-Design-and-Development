package th.ac.mahidol.ict;
import th.ac.mahidol.ict.heroes.Hero;
import th.ac.mahidol.ict.heroes.Superhuman;
import th.ac.mahidol.ict.heroes.Villain;
import th.ac.mahidol.ict.human.Human;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("\nStart creating heroes!");

        // creating heroes
        Hero spidey = new Hero("Spider-Man", "Spider sense", "Peter Parker");
        spidey.addWeapon("spider web");
        spidey.addWeapon("mechanical arms");
        System.out.println(spidey);

        Hero ironman = new Hero("Iron Man", "Rich", "Tony Stark");
        ironman.addWeapon("lasers");
        ironman.addWeapon("energy blade");
        ironman.addWeapon("missiles");
        System.out.println(ironman);

        System.out.println("\nStart creating villains");
        Villain thanos = new Villain("Thanos", "Strength", "Titan");
        thanos.addWeapon("gaunlet");
        thanos.addWeapon("infinity stones");
        thanos.addWeapon("double-edged sword");
        System.out.println(thanos);

        ArrayList<Superhuman> supHumans = new ArrayList<>();
        supHumans.add(spidey);
        supHumans.add(ironman);
        supHumans.add(thanos);

        System.out.println("\nStart creating humans");
        Human ned = new Human("Ned");
        System.out.println("Added: " + ned);

        // polymorphism & dynamic binding
        for (Superhuman sh : supHumans) {
            System.out.println(sh.getName() + "'s weapon: " + sh.getWeapon());
        }

        System.out.println("\nAdding friends");
        // association
        ned.addFriend(spidey);
        spidey.addFriend(ned);

        System.out.println(spidey.getName() + "'s friends: " + spidey.getFriends());
        System.out.println(ned.getName() + "'s friends: " + ned.getFriends());
    }
}