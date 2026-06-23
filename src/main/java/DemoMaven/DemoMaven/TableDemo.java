package DemoMaven.DemoMaven;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import util.BaseClass;

public class TableDemo extends BaseClass {

    public static void main(String[] args) {

        invokeBrowser("Chrome");
        driver.get("https://demo.guru99.com/test/web-table-element.php");

        // Total no of columns
        List<WebElement> columns = driver.findElements(
                By.xpath("//table[@class='dataTable']/thead/tr/th"));
        int size = columns.size();
        System.out.println("No of columns: " + size);

        // Total no of rows
        List<WebElement> rows = driver.findElements(
                By.xpath("//table[@class='dataTable']/tbody/tr"));
        int totalrows = rows.size();
        System.out.println("Total no of rows: " + totalrows);

        // ✅ Nested loop to print all table data
        for (int i = 1; i <= totalrows; i++) {

            for (int j = 1; j <= size; j++) {

                String value = driver.findElement(
                        By.xpath("//table[@class='dataTable']/tbody/tr[" + i + "]/td[" + j + "]"))
                        .getText();

                System.out.print(value + "   ");
            }
            System.out.println();
        }

        // ✅ To get particular cell value (Example: Row 2, Column 3)
        String cellValue = driver.findElement(
                By.xpath("//table[@class='dataTable']/tbody/tr[2]/td[3]")).getText();

        System.out.println("Specific Cell Value: " + cellValue);
    }
}