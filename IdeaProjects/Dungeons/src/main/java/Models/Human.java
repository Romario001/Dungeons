package Models;

import java.util.ArrayList;

public class Human extends Hero {
        public Human(String playerName) {
        super(playerName, "Human", 30);
    }

    @Override
    public void specialAbility(ArrayList<Hero> heroesList, boolean whoseTurn) {
        stamina -= 15;
        int currentIndexInHeroesList;
        int utilityIndexInHeroesList;
        if (whoseTurn) {
            currentIndexInHeroesList = 0;
            utilityIndexInHeroesList = 1;
        } else {
            currentIndexInHeroesList = 1;
            utilityIndexInHeroesList = 0;
        }
        //Реализация суперспособности человека -
        // Если на уровне ниже есть персонаж, то меняется с ним местами иначе спускается на один уровень.
        if ((((heroesList.get(currentIndexInHeroesList).level) + 1) == heroesList.get(utilityIndexInHeroesList).level) &
                (!heroesList.get(utilityIndexInHeroesList).SpecialPower)) {
            heroesList.get(currentIndexInHeroesList).level += 1;
            heroesList.get(utilityIndexInHeroesList).level -= 1;
            System.out.println("Heroes changed places" + heroesList);
        } else {
            heroesList.get(currentIndexInHeroesList).level += 1;
        }
    }
}