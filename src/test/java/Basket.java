import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

import static java.lang.Thread.sleep;


public class Basket extends Data {
    private By btnCatalogStep1 = By.xpath("//*[@id=\"header\"]/div/div[2]/div/div/div/div/nav/div/table/tbody/tr/td[1]/div/a");
    private By btnCatalogStep2 = By.xpath("//*[@id=\"header\"]/div/div[2]/div/div/div/div/nav/div/table/tbody/tr/td[1]/div/ul/li[3]/div/div[1]/a");
    private By cheekSetPage = By.xpath("//h1[@id='pagetitle']");
    //h1[@id='pagetitle']


    @Test
            public void basket() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Data getDate = new Data();
        Actions actions = new Actions(driver);

        try {
            System.out.print("Открываем сайт");
            driver.get(getDate.getUrl);
            driver.manage().window().maximize();
            System.out.println(" - Сайт открылся");
            System.out.print("Наводим курсор на каталог - ");
            WebElement moveSetStep1 = driver.findElement(btnCatalogStep1);
            System.out.print("Наводим курсор на категорию товары для грызунов и кликаем");
            WebElement moveSetStep2 = driver.findElement(btnCatalogStep2);
                actions.moveToElement(moveSetStep1);
                actions.moveToElement(moveSetStep2);
                actions.click().perform();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cheekSetPage));
            System.out.println(" - Открылась страница каталога");



        }
        catch (Exception e) {
            System.err.println("Ошибка " + e);
            Assert.fail("Тест провален");
        }


        //driver.quit();

    }
}


