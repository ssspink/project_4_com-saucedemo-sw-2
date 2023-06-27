package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends BaseTest
{
        String baseurl = "https://www.saucedemo.com/";
    //Running @Before Annotation before test
    @Before
    public void setUp() {
        OpenBrowser(baseurl); //Open Browser Setup
    }

    @Test
    public void userShouldLoginSuccessfullyWithValid()
    {
        //Locating element and entering value into UserName
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //Locating element and entering value into password
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //clicking on login Button
        driver.findElement(By.id("login-button")).click();

        String expectedResult="Products";
        String actualResult =driver.findElement(By.xpath("//div[@id='header_container']/div[2]/span")).getText();
        Assert.assertEquals(expectedResult,actualResult);

    }
        @Test
        public void verifyThatSixProductsAreDisplayedOnPage() throws InterruptedException {
                //Locating element and entering value into UserName
            driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
            //Locating element and entering value into password
            driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
            //clicking on login Button
            driver.findElement(By.id("login-button")).click();

            List<WebElement> productsList = driver.findElements(By.xpath("//div[@class='inventory_item']"));

            System.out.println("Total products are" +productsList.size());

            Thread.sleep(5000);
        }
            @After
            public void tearDown()
            {

            }


}
