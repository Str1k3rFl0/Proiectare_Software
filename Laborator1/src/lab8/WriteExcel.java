package lab8;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteExcel
{
    public static void main(String[] args)
    {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Rezultate");

        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"Prenume", "Nume", "Nota1", "Nota2", "Nota3", "Nota4", "Max", "Medie"});
        data.put("2", new Object[]{"Amit", "Shukla", 9, 8, 7, 5});
        data.put("3", new Object[]{"Lokesh", "Gupta", 8, 9, 6, 7});
        data.put("4", new Object[]{"John", "Adwards", 8, 8, 7, 6});
        data.put("5", new Object[]{"Brian", "Schultz", 7, 6, 8, 9});

        CellStyle headerStyle = workbook.createCellStyle();
        Font fontBold = workbook.createFont();
        fontBold.setBold(true);
        headerStyle.setFont(fontBold);
        headerStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        CellStyle yellowStyle = workbook.createCellStyle();
        yellowStyle.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        yellowStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        int rowNum = 0;
        for (Map.Entry<String, Object[]> entry : data.entrySet())
        {
            Row row = sheet.createRow(rowNum);
            Object[] objArr = entry.getValue();

            for (int col = 0; col < objArr.length; col++)
            {
                Cell cell = row.createCell(col);
                Object value = objArr[col];

                if (value instanceof String)
                {
                    cell.setCellValue((String) value);
                }
                else if (value instanceof Integer)
                {
                    cell.setCellValue((Integer) value);
                }

                if (rowNum == 0)
                {
                    cell.setCellStyle(headerStyle);
                }
            }

            if (rowNum != 0)
            {
                String rowExcel = Integer.toString(rowNum + 1); // Excel are index 1-based

                Cell maxCell = row.createCell(6);
                maxCell.setCellFormula("MAX(D" + rowExcel + ":G" + rowExcel + ")");
                maxCell.setCellStyle(yellowStyle);

                Cell avgCell = row.createCell(7);
                avgCell.setCellFormula("AVERAGE(D" + rowExcel + ":G" + rowExcel + ")");
                avgCell.setCellStyle(yellowStyle);
            }

            rowNum++;
        }

        for (int i = 0; i < 8; i++)
        {
            sheet.autoSizeColumn(i);
        }

        try (FileOutputStream out = new FileOutputStream("output8.xlsx"))
        {
            workbook.write(out);
            System.out.println("Fișierul Excel 'output8.xlsx' a fost generat cu succes.");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
