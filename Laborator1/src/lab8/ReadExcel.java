package lab8;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcel {
    public static void main(String[] args) {
        XSSFWorkbook workbook = null;
        FileInputStream file = null;
        try {
            file = new FileInputStream(new File("laborator8_input.xlsx"));
            workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case NUMERIC -> System.out.print(cell.getNumericCellValue() + "\t");
                        case STRING -> System.out.print(cell.getStringCellValue() + "\t");
                        default -> System.out.print("UNKNOWN\n");
                    }
                }
                System.out.println();
            }
            file.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
    }
}