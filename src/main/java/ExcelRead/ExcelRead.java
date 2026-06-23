package ExcelRead;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

    public static void main(String[] args) throws IOException {

        // File path
        FileInputStream fis = new FileInputStream(
                "./src/main/java/ExcelRead/Indigo_Selenium_Practice.xlsx");

        // Workbook
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // Correct sheet name (IMPORTANT)
        XSSFSheet sheet = workbook.getSheet("IndigoData");

        // Check if sheet exists
        if (sheet == null) {
            System.out.println("Sheet not found. Please check sheet name.");
            workbook.close();
            return;
        }

        // Row count
        int rows = sheet.getPhysicalNumberOfRows();
        System.out.println("Total no of rows: " + rows);

        // Column count (from first row)
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Total no of columns: " + columns);

        // Print single cell
        System.out.println("Sample Cell Value: " +
                sheet.getRow(1).getCell(1).toString());

        // Nested for loop (print all data)
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < columns; j++) {

                String data = sheet.getRow(i).getCell(j).toString();
                System.out.print(data + " | ");
            }
            System.out.println();
        }

        // Close workbook
        workbook.close();
    }
}
