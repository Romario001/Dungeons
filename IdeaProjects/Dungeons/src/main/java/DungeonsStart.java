
import Controllers.ChooseHero;
import Controllers.PlayGame;
import Controllers.RecordOfTheGame;
import Models.Hero;
import Repositories.SaveGames;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import java.util.ArrayList;


public class DungeonsStart {
    private static final int MAX_LEVEL = 10;

    public static void main(String[] args) {
        ChooseHero chooseHero = new ChooseHero();
        ArrayList<Hero> heroesList = new ArrayList<Hero>(chooseHero.chooseHero());
        Hero hero1 = heroesList.get(0);
        Hero hero2 = heroesList.get(1);

        SaveGames saveGames = new SaveGames();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Game");

        try {
            saveGames.createGame(workbook, sheet, heroesList);
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("Rest - 1; " + "Descent - 2; " + "Fast descent - 3; " +
                "Special ability - 4; " + "Help - 0");

        int rownum = 1;
        PlayGame playGame = new PlayGame();
        boolean whoseTurn = true;

        try {
            saveGames.saveGame(workbook, sheet, rownum, hero1, true);
            saveGames.saveGame(workbook, sheet, rownum, hero2, false);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while ((hero1.level < MAX_LEVEL) && (hero2.level < MAX_LEVEL)) {

            if (whoseTurn) {
                rownum++;
                playGame.play(heroesList, whoseTurn);
                try {
                    saveGames.saveGame(workbook, sheet, rownum, hero1, whoseTurn);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                playGame.play(heroesList, whoseTurn);
                try {
                    saveGames.saveGame(workbook, sheet, rownum, hero2, whoseTurn);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            whoseTurn = !whoseTurn;
        }
        if (hero1.level >= MAX_LEVEL) {
            System.out.println("Congratulations " + hero1.playerName + ", you win!!!");
        } else {
            System.out.println("Congratulations " + hero2.playerName + ", you win!!!");
        }
        System.out.println("If you want to watch record of the game press - Yes");
        try {
            RecordOfTheGame recordOfTheGame = new RecordOfTheGame();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("We hope that you enjoyed the game!");
    }

}
