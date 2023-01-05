package testNG;

import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTest extends BaseTest {



    @DataProvider(name = "getTestDataFromExcel")
    public Object[][] getTestData() throws InterruptedException {
        return new Object[][]{{"First Name1", "Last Name1", "Address1", "City1"}, {"First Name2", "Last Name2", "Address2", "City2"}, {"First Name3", "Last Name3", "Address23", "City12"}};
    }
        @Test(dataProvider = "getTestDataFromExcel")
        public void loginShowSucceed(String username, String password) throws InterruptedException{
        WebElement usernameE1 = driver.findElement(By.name("username"));
        usernameE1.isDisplayed();
        usernameE1.clear();
        usernameE1.sendKeys("password");
        Thread.sleep(3000);

        WebElement passwordE1 = driver.findElement(By.name("password"));
        passwordE1.isDisplayed();
        passwordE1.clear();
        passwordE1.sendKeys("password");
        Thread.sleep(3000);
    }

        public void registrationShouldSucceed(String firstName, String lastName, String address, String city) throws InterruptedException {
        WebElement registerLink=driver.findElement(By.xpath("//a[@href='register.htm']"));
       registerLink.isDisplayed();
       registerLink.click();
       Thread.sleep(3000);


        WebElement firstnameEl=driver.findElement(By.id("id=customer.firstName"));
        firstnameEl.isDisplayed();
        firstnameEl.clear();
        firstnameEl.sendKeys(firstName);
       Thread.sleep(3000);


        WebElement lastNameEl=driver.findElement(By.id("id=customer.lastName"));
        lastNameEl.isDisplayed();
        lastNameEl.clear();
        lastNameEl.sendKeys(lastName);
       Thread.sleep(3000);

       WebElement addressEl=driver.findElement(By.id("id=customer.address.street"));
       addressEl.isDisplayed();
       addressEl.clear();
       addressEl.sendKeys(address);
       Thread.sleep(3000);


       WebElement cityEl=driver.findElement(By.id("id=customer.address.city"));
       cityEl.isDisplayed();
       cityEl.clear();
       cityEl.sendKeys(city);
       Thread.sleep(3000);

   }


        public Object[][] getTestDataFromExcel() {
        String path = System.getProperty("user.dir") + "src/test/resources/Excel_login.xlsx";
        Workbook book = null;
        Sheet sheet;
        FileInputStream file = null;
        try {
            file = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet("Sheet1_First2");
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                System.out.println(data[i][k]);
            }
        }
        return data;
    }
}




