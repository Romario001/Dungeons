package Controllers;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

public class RecordOfTheGame {
    private static String FILE_PATH = "C:\\Users\\postgres\\IdeaProjects\\Dungeons\\src\\main\\java\\Repositories\\SavedGames.xls";

    public RecordOfTheGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String watchRecord = scanner.next();

        if (watchRecord.equals("Yes") | watchRecord.equals("yes")) {
            FileInputStream inputStream = new FileInputStream(new File(FILE_PATH));
            HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
            HSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    CellType cellType = cell.getCellType();

                    switch (cellType) {
                        case _NONE:
                            System.out.print("");
                            System.out.print("\t || \t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue());
                            System.out.print("\t || \t");
                            break;
                        case BLANK:
                            System.out.print("");
                            System.out.print("\t || \t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue());
                            System.out.print("\t || \t");
                            break;
                        case STRING:
                            System.out.print(cell.getStringCellValue());
                            System.out.print("\t\t");
                            break;
                        case ERROR:
                            System.out.print("!");
                            System.out.print("\t || \t");
                            break;
                    }
                }
                System.out.println("");
            }
            inputStream.close();
        }
        scanner.close();
    }
}
