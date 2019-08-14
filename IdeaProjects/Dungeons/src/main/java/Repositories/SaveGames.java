package Repositories;

import Models.Hero;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class SaveGames {
    private static String FILE_PATH = "C:\\Users\\postgres\\IdeaProjects\\Dungeons\\src\\main\\java\\Repositories\\SavedGames.xls";
    private static final int MAX_LEVEL = 20;

    private static HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        return style;
    }

    public void createGame(HSSFWorkbook workbook, HSSFSheet sheet, ArrayList<Hero> heroesList) throws IOException {
        int rownum = 0;
        Cell cell;
        Row row;

        HSSFCellStyle style = createStyleForTitle(workbook);

        row = sheet.createRow(rownum);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue((heroesList.get(0).playerName));
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("Action");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("Stamina");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("Level");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue(heroesList.get(1).playerName);
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("Action");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("Stamina");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("Level");
        cell.setCellStyle(style);

        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        //System.out.println("Created file: " + file.getAbsolutePath());
        outFile.close();
    }

    public void saveGame(HSSFWorkbook workbook, HSSFSheet sheet, int rownum, Hero hero, boolean whoseTurn) throws IOException {
        Cell cell;
        Row row;

        if (whoseTurn) {
            row = sheet.createRow(rownum);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(hero.character);

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(hero.action);

            cell = row.createCell(2, CellType.NUMERIC);
            cell.setCellValue(hero.stamina);

            cell = row.createCell(3, CellType.NUMERIC);
            cell.setCellValue(hero.level);
        } else {
            row = sheet.getRow(rownum);
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(hero.character);

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(hero.action);

            cell = row.createCell(6, CellType.NUMERIC);
            cell.setCellValue(hero.stamina);

            cell = row.createCell(7, CellType.NUMERIC);
            cell.setCellValue(hero.level);
        }
        if (hero.level >= MAX_LEVEL) {
            cell = row.createCell(cell.getColumnIndex(), CellType.STRING);
            cell.setCellValue("Win");
        }
        ;
        File file = new File(FILE_PATH);
        file.getParentFile().mkdirs();

        FileOutputStream outFile = new FileOutputStream(file);
        workbook.write(outFile);
        outFile.close();
    }
}
