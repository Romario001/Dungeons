package Models;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Hero {
    public int MAX_STAMINA;
    public boolean SpecialPower = false;
    public String character;
    public String playerName;
    public int stamina;
    public int level = 0;
    public String action = "0";
    private static List<String> actionCheck = Arrays.asList("Rest     ", "Desent   ", "FastDes  ", "SpecialAb");

    public Hero() {

    }

    @Override
    public String toString() {
        return character + "-" + playerName + " yours stamina is " + stamina + ", you have " + level + " level";
    }


    Hero(String playerName, String character, int MAX_STAMINA) {
        this.playerName = playerName;
        this.character = character;
        this.stamina = MAX_STAMINA;
        this.MAX_STAMINA = MAX_STAMINA;
        this.level = 0;
    }


    public void getAction(String action) {
        this.action = actionCheck.get(Integer.parseInt(action) - 1);
    }

    public void rest() {
        stamina += 3;
    }

    public void descent() {
        stamina -= 5;
        level += 1;
    }

    public void fastDescent() {
        level += 2;
        if (this.character.equals("Human")) {
            stamina -= 13;
        }
        if (this.character.equals("Gnome")) {
            stamina -= 15;
        }
        if (this.character.equals("Elf")) {
            stamina -= 12;
        }
    }

    public void specialAbility(ArrayList<Hero> heroesList, boolean whoseTurn) {
    }
}

