package Controllers;

import Models.Hero;


import java.util.ArrayList;
import java.util.Scanner;

public class PlayGame {

    public void play(ArrayList<Hero> heroesList, boolean whoseTurn) {
        int currentIndexInHeroesList;
        int utilityIndexInHeroesList;

        //Создаем копию героя (его выносливости и уровня) на случай некорректного хода
        Hero hero1Copy = new Hero();
        Hero hero2Copy = new Hero();
        if (whoseTurn) {
            hero1Copy.stamina = heroesList.get(0).stamina;
            hero1Copy.level = heroesList.get(0).level;
            hero2Copy.stamina = heroesList.get(1).stamina;
            hero2Copy.level = heroesList.get(1).level;
            currentIndexInHeroesList = 0;
            utilityIndexInHeroesList = 1;
            heroesList.get(0).SpecialPower = false;
        } else {
            hero1Copy.stamina = heroesList.get(1).stamina;
            hero1Copy.level = heroesList.get(1).level;
            hero2Copy.stamina = heroesList.get(0).stamina;
            hero2Copy.level = heroesList.get(0).level;
            currentIndexInHeroesList = 1;
            utilityIndexInHeroesList = 0;
            heroesList.get(1).SpecialPower = false;
        }

        //Реализация игрового хода
        Scanner scanner = new Scanner(System.in);
        boolean stepCompleted;
        String action;
        do {
            stepCompleted = false;
            System.out.println(heroesList.get(currentIndexInHeroesList).playerName + ", what will you do?");
            action = scanner.next();

            heroesList.get(currentIndexInHeroesList).stamina = hero1Copy.stamina;
            heroesList.get(currentIndexInHeroesList).level = hero1Copy.level;
            heroesList.get(utilityIndexInHeroesList).stamina = hero2Copy.stamina;
            heroesList.get(utilityIndexInHeroesList).level = hero2Copy.level;
            switch (action) {
                case "1":
                    heroesList.get(currentIndexInHeroesList).rest();
                    stepCompleted = true;
                    break;
                case "2":
                    heroesList.get(currentIndexInHeroesList).descent();
                    stepCompleted = true;
                    break;
                case "3":
                    heroesList.get(currentIndexInHeroesList).fastDescent();
                    stepCompleted = true;
                    break;
                case "4":
                    heroesList.get(currentIndexInHeroesList).specialAbility(heroesList, whoseTurn);
                    stepCompleted = true;
                    break;
                case "0":
                    System.out.println("Rest - 1; " + "Descent - 2; " + "Fast descent - 3; " +
                            "Special ability - 4; " + "Help - 0");
                    System.out.println(heroesList);
                    break;
                default:
                    System.out.println("Please, choose action from 1 to 4. Press 0 for the help.");
                    break;
            }
            //Проверка хватает ли выносливости для хода
            if (heroesList.get(currentIndexInHeroesList).stamina < 0) {
                System.out.println("Not enough stamina, you should rest");
            }
            //Проверка не применил ли другой герой суперспособность препятствующую нашему ходу
            if (heroesList.get(utilityIndexInHeroesList).SpecialPower) {
                if ((heroesList.get(currentIndexInHeroesList).level >= heroesList.get(utilityIndexInHeroesList).level) &
                        (hero1Copy.level <= heroesList.get(utilityIndexInHeroesList).level) &
                        (heroesList.get(currentIndexInHeroesList).level != hero1Copy.level)) {
                    stepCompleted = false;
                    System.out.println("Sorry,Gnome special ability is on");
                }
            }
            //Проверка не превысило ли значение нашей выносливости максимум
            if (heroesList.get(currentIndexInHeroesList).stamina > heroesList.get(currentIndexInHeroesList).MAX_STAMINA) {
                heroesList.get(currentIndexInHeroesList).stamina = heroesList.get(currentIndexInHeroesList).MAX_STAMINA;
            }

        } while ((heroesList.get(currentIndexInHeroesList).stamina < 0) | (!stepCompleted));

        heroesList.get(currentIndexInHeroesList).getAction(action);

        System.out.println(heroesList.get(currentIndexInHeroesList).toString());
        heroesList.get(currentIndexInHeroesList).stamina += 2;
           }

}
