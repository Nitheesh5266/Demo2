package ExcelRead;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Excel {

    static WebDriver driver;

    public static void main(String[] args) throws IOException, InterruptedException {

        driver = new ChromeDriver();

        //  Use resources folder for Excel file
        String excelPath = "src/main/main/java/Selenium_excelDemo.xlsx";

        try (FileInputStream fis = new FileInputStream(excelPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            int rows = sheet.getPhysicalNumberOfRows();
            int columns = sheet.getRow(0).getPhysicalNumberOfCells();

            System.out.println("Total no of records: " + rows);
            System.out.println("Total no of columns: " + columns);

            driver.manage().window().maximize();
            driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

            Thread.sleep(3000);

            //  Start from 1 (skip header row)
            for (int i = 1; i < rows; i++) {

                String username = sheet.getRow(i).getCell(0).getStringCellValue();
                String pwd = sheet.getRow(i).getCell(1).getStringCellValue();

                WebElement user = driver.findElement(By.name("username"));
                WebElement password = driver.findElement(By.name("password"));

                // Clear before sendKeys
                user.clear();
                password.clear();

                user.sendKeys(username);
                password.sendKeys(pwd);

                Thread.sleep(2000);

                driver.navigate().refresh();
                Thread.sleep(2000);
            }
        }

        driver.quit();  //  Proper close
    }
}
