package Models;

import java.util.ArrayList;

public class Gnome extends Hero {
      public Gnome(String playerName) {
        super(playerName, "Gnome", 50);
    }

    @Override
    public void specialAbility(ArrayList<Hero> heroesList, boolean whoseTurn) {
        stamina -= 20;
        level += 1;
        if (whoseTurn) {
            heroesList.get(0).SpecialPower = true;
        } else {
            heroesList.get(1).SpecialPower = true;
        }
    }
}