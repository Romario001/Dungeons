package Controllers;

import Models.Elf;
import Models.Gnome;
import Models.Hero;
import Models.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class ChooseHero {
    private Hero hero1;
    private Hero hero2;

    public ArrayList<Hero> chooseHero() {
        ArrayList<Hero> heroesList = new ArrayList<Hero>(2);
        System.out.println("Welcome to the Dungeons! What is your name?");
        Scanner scanner = new Scanner(System.in);
        String player1name = scanner.next();
        System.out.println("And you?");
        String player2name = scanner.next();
        System.out.println("What is your race, " + player1name + "? (1-Human,2-Gnome,3-Elf)");
        boolean checkRace;
        String character1;
        do {
            checkRace = false;
            character1 = scanner.next();

            switch (character1) {
                case "1":
                    hero1 = new Human(player1name);
                    break;
                case "2":
                    hero1 = new Gnome(player1name);
                    break;
                case "3":
                    hero1 = new Elf(player1name);
                    break;
                default:
                    System.out.println("Please, choose number from 1 to 3, " + player1name + ".");
                    checkRace = true;

            }
        } while (checkRace);

        System.out.println("What is your race, " + player2name + "? (1-Human,2-Gnome,3-Elf)");
        do {
            checkRace = false;
            String character2 = scanner.next();
            switch (character2) {
                case "1":
                    if (!(character1.equals("1"))) {
                        hero2 = new Human(player2name);
                        break;
                    } else {
                        System.out.println("Your friend is Human, but you don't look like him. (Choose other race)");
                        checkRace = !checkRace;
                    }
                case "2":
                    if (!(character1.equals("2"))) {
                        hero2 = new Gnome(player2name);
                        break;
                    } else {
                        System.out.println("Your friend is Gnome, but you don't look like him. (Choose other race)");
                        checkRace = !checkRace;
                    }
                case "3":
                    if (!(character1.equals("3"))) {
                        hero2 = new Elf(player2name);
                        break;
                    } else {
                        System.out.println("Your friend is Elf, but you don't look like him. (Choose other race)");
                        checkRace = !checkRace;
                    }
                default:
                    System.out.println("Please, choose number from 1 to 3, " + player2name + ".");
                    checkRace = !checkRace;

            }
        } while (checkRace);

        System.out.println("Let's play " + hero1.character + "-" + player1name + " and " + hero2.character + "-" + player2name + "!");
        heroesList.add(0, hero1);
        heroesList.add(1, hero2);
        return heroesList;
    }

}