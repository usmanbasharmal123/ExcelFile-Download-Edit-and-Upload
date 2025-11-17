import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.time.Duration;

public class ExcelDownloadUpload {




    public ExcelDownloadUpload() throws FileNotFoundException {}

    @Test
    public void verifyExcelUpload() throws IOException {
        String filePath = "C:\\Users\\Basharmal Safi\\Downloads\\download.xlsx";
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
        driver.findElement(By.id("downloadButton")).click();

        String sheetName = "Sheet1";
        String fruitName = "Apple";
        String columName="Price";
        String updatedValue = "598";
        try(
        ExcelUtils excelHelper = new ExcelUtils(filePath,sheetName)){
        int rowIndex = excelHelper.findRowIndex(fruitName);
        int columnIndex = excelHelper.findColumnIndex(columName);

        if (rowIndex == -1 || columnIndex == -1) {
            throw new IllegalStateException("Could not find specified row or column. Row: " + rowIndex + ", Column: " + columnIndex);
        }

        Assert.assertTrue(excelHelper.updateCellValue(rowIndex, columnIndex, updatedValue));}

        WebElement btnUpload = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='file']")));
        btnUpload.sendKeys(filePath);

        By toastMessage = By.cssSelector(".Toastify__toast-body");
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage));
        String message = driver.findElement(toastMessage).getText();
        Assert.assertEquals(message, "Updated Excel Data Successfully.");

        String itemPriceId = driver.findElement(By.xpath("//div[text()='Price']")).getAttribute("data-column-id");

        String price = driver.findElement(By.xpath("//div[@role='row' and .//div[text()='" + fruitName + "']]//div[@data-column-id='" + itemPriceId + "']")).getText();
        Assert.assertEquals(price, updatedValue);
        System.out.println("Price of " + fruitName + " is: " + price + "and in excel file update is "+updatedValue );

        driver.quit();
    }

}
