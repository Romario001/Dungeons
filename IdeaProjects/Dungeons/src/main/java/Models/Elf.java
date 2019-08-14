package Models;

import java.util.ArrayList;

public class Elf extends Hero {

    public Elf(String playerName) {
        super(playerName, "Elf", 40);
    }

    @Override
    public void specialAbility(ArrayList<Hero> heroesList, boolean whoseTurn) {
        stamina -= 24;
        level += 3;
    }
}

