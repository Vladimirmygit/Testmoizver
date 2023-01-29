import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.awt.*;
import java.time.Duration;

import static java.lang.Thread.sleep;

public class Catalog extends Data {
    private By btnCatalog = By.xpath("//div[@class='wrap']/a[1]");
    private By btnCatalogCAT = By.xpath("//td[@class='section_info']//span[text()='Товары для кошек']");
    private By setPriceOne = By.xpath("//span[@class='values_wrapper']/span[@class='price_value'][1]");
    private By btnPut = By.xpath("//div[@class='like_icons']//span[@data-props='CODE_GESS;CODE_TT;SHOPS'][1]");
    private By btnComparison = By.xpath("//div[@class='compare_item_button'][1]");
    private By btnAddToCart = By.xpath("//div[@class='button_block'][1]");
    private By filterPrice = By.linkText("По цене");
    private By setPriceTwoMin = By.xpath("//span[@class='values_wrapper']/span[@class='price_value'][1]");
    private By btnPutMin = By.xpath("//div[@class='like_icons']//span[@data-props='CODE_GESS;CODE_TT;SHOPS'][1]");
    private By btnComparisonMin = By.xpath("//div[@class='compare_item_button'][1]");
    private By btnAddToCartMin = By.xpath("//div[@class='button_block'][1]");
    private By setMinFilter = By.xpath("//input[@class='min-price']");
    private By setMaxFilter = By.xpath("//input[@class='max-price']");
    private By filterRoyalCanin = By.xpath("//span[@class='bx_filter_param_text' and @title='Royal Canin']");
    private By btnShowFilter = By.xpath("//a[@class='btn btn-default white white-bg'][1]");
    //проверка работы фильтра
    private By btnPutRoyal = By.xpath("//div[@class='like_icons']//span[@data-props='CODE_GESS;CODE_TT;SHOPS'][1]");
    private By btnComparisonRoyal = By.xpath("//div[@class='compare_item_button'][1]");
    private By btnAddToCartRoyal = By.xpath("//div[@class='button_block'][1]");
    private By setIcon1 = By.xpath("//div[@class='wraps_icon_block basket']//span[@class='items']");
    private By setIcon2 = By.xpath("//div[@class='button_block'][2]");
    private By setIcon3 = By.xpath("//div[@class='button_block'][3]");
    private By btnClearFilter = By.xpath("//div[@class='clearF']");


    @Test (retryAnalyzer = Retry.class)
    public void catalog() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        Data getDate = new Data();
        Actions actions = new Actions(driver);

        try {
            System.out.print("Открываем сайт");
            driver.get(getDate.getUrl);
            driver.manage().window().maximize();
            sleep(3000);
            System.out.println(" - Сайт открылся"); //System.out.println(" - Сайт открыт"); //System.out.println(" - ОК");
            //Клик по кнопке каталога в шапке
            System.out.print("Кликаем на кнопку каталога");
            driver.findElement(btnCatalog).click();

            System.out.println(" - Каталог открылся"); //System.out.println(" - Каталог открылся"); //System.out.println(" - ОК");
            sleep(3000);
            //Клик по категории корм для кошек
            System.out.print("Кликаем по категории \"корм для кошек\" ");
            driver.findElement(btnCatalogCAT).click();
            System.out.println(" - Открылась категория \"корм для кошек\" "); // System.out.println(" - ОК"); //System.out.println(" - Открылась категория \"корм для кошек\" ");
            sleep(5000);
            // берем цену
            System.out.print("Создаем новую переменную и помещаем туда стоимость из 1 карточки в листинге");
            Integer priceOne = Integer.valueOf(driver.findElement(setPriceOne).getText());
            System.out.println(" - Переменная создана");
            sleep(3000);
            //наводим на карточку товара
            System.out.print("Наводим на карточку товара");
            WebElement moveSet = driver.findElement(By.xpath("//div[@class='catalog_item main_item_wrapper item_wrap '][1]"));//div[@class='catalog_item main_item_wrapper item_wrap '][1]
            actions.moveToElement(moveSet).build().perform();
            System.out.println(" - Навелись на карточку товара");
            sleep(3000);
            //Клик по кнопке добавления товара в избранное
            System.out.print("Кликаем на кнопку добавления товара в избранное");
            driver.findElement(btnPut).click();
            System.out.println(" - Товар добавлен в избранное");
            sleep(300);
            //Клик по кнопке добавления товара в сравнение
            System.out.print("Кликаем на кнопку добавления товара в сравнение");
            driver.findElement(btnComparison).click();
            System.out.println(" - Товар добавлен в сравнение");
            sleep(3000);
            //Клик по кнопке добавления товара в корзину
            System.out.print("Кликаем на кнопку добавления товара в корзину");
            driver.findElement(btnAddToCart).click();
            System.out.println(" - Товар добавлен в корзину");
            sleep(3000);
            //Клик по кнопке фильтра по цене
            System.out.print("Кликаем на кнопку фильтр по цене");
            driver.findElement(filterPrice).click();
            System.out.println(" - Товары отфильтрованны по цене");
            sleep(3000);

            // берем отфильтрованную цену
            System.out.print("Создаем новую переменную и помещаем туда стоимость из 1 карточки в листинге");
            Integer priceMin = Integer.valueOf(driver.findElement(setPriceTwoMin).getText());
            System.out.println(" - Переменная создана");
            // сравниваем переменные
            System.out.print("Сравниваем переменные");
            Assert.assertTrue(priceMin < priceOne);
            System.out.println(" - Сравнение прошло успешно");
            //наводим на карточку товара
            System.out.print("Наводим на карточку товара");
            WebElement moveSetMin = driver.findElement(By.xpath("//div[@class='catalog_item main_item_wrapper item_wrap '][1]"));
            actions.moveToElement(moveSetMin).build().perform();
            System.out.println(" - Навелись на карточку товара");

            //Клик по кнопке добавления товара в избранное
            System.out.print("Кликаем на кнопку добавления товара в избранное");
            driver.findElement(btnPutMin).click();
            System.out.println(" - Товар добавлен в избранное");

            sleep(1500);
            //Клик по кнопке добавления товара в сравнение
            System.out.print("Кликаем на кнопку добавления товара в сравнение");
            driver.findElement(btnComparisonMin).click();
            System.out.println(" - Товар добавлен в сравнение");

            sleep(1500);
            //Клик по кнопке добавления товара в корзину
            System.out.print("Кликаем на кнопку добавления товара в корзину");
            driver.findElement(btnAddToCartMin).click();
            System.out.println(" - Товар добавлен в корзину");
            sleep(1500);
            //Вводим 330 в минимальну цену в фильтре
            System.out.print("Вводим в фильтр в минимальное значение число 330");
            driver.findElement(setMinFilter).sendKeys("330");
            System.out.println(" - Введено 330");
            //Вводим 1100 в максимальную цену в фильтре
            System.out.print("Вводим в фильтр в максимальное значение число 1100");
            driver.findElement(setMaxFilter).sendKeys("1100");
            System.out.println(" - Введено 1100");

            //Кликаем по бренду роял канин в фильтре
            System.out.print("Кликаем в фильтре на бренд \"Royal Canin\"");
            driver.findElement(filterRoyalCanin).click();
            System.out.println(" - Фильтр \"Royal Canin\" выбран");
            sleep(2000);
            //Кликаем по кнопке применить фильтр
            System.out.print("Кликаем на кнопку \"Применить\"");
            driver.findElement(btnShowFilter).click();
            sleep(15000);
            //проверка отработки фильтра, сравнения url
            System.out.print("Проверяем применился ли фильтр сравнивая Url");
            String getUrlnow = driver.getCurrentUrl();
            Assert.assertEquals(getUrlnow, getUrlFilter);
            System.out.println(" - Фильтр применился");

            System.out.print("Наводим на карточку товара");
            WebElement moveSetRoyal = driver.findElement(By.xpath("//div[@class='catalog_item main_item_wrapper item_wrap '][1]"));
            actions.moveToElement(moveSetRoyal).build().perform();
            System.out.println(" - Навелись на карточку товара ");

            //Клик по кнопке добавления товара в избранное
            System.out.print("Кликаем на кнопку добавления товара в избранное");
            driver.findElement(btnPutRoyal).click();
            System.out.println(" - Товар добавлен в избранное");
            sleep(1500);
            //Клик по кнопке добавления товара в сравнение
            System.out.print("Кликаем на кнопку добавления товара в сравнение");
            driver.findElement(btnComparisonRoyal).click();
            System.out.println(" - Товар добавлен в сравнение");
            sleep(1500);
            //Клик по кнопке добавления товара в корзину
            System.out.print("Кликаем на кнопку добавления товара в корзину");
            driver.findElement(btnAddToCartRoyal).click();
            sleep(3000);
            System.out.println(" - Товар добавлен в корзину");
            //Клик по кнопке сброса фильтра
            System.out.print("Кликаем на кнопку сброса фильтра");
            driver.findElement(btnClearFilter).click();
            System.out.println(" - Фильтр очищен");
            sleep(1500);
            //проверка работы кнопки очистки фильтра. сравнение url после сброса фильтра
            System.out.print("Проверяем работу кнопки сброса методом сравнения Url");
            String getUrlnow1 = driver.getCurrentUrl();
            Assert.assertEquals(getUrlnow1, getUrlFilterEmpty);
            System.out.println(" - Сравниние прошло успешно");
            sleep(1500);
            // проверка добавления 3 элементов в корзину//div[@class='count']//span[@class='items'][1]
            System.out.print("Проверяем количество текущих элементов в корзине = 3");
            Integer interIcon1 = Integer.valueOf(driver.findElement(setIcon1).getText());

            // сравниваем переменные
            Assert.assertTrue(interIcon1 == 3);
            sleep(1500);
            System.out.print(" - Количество элементов равно 3");
        }
        catch (Exception e) {
            System.err.println("Ошибка " + e);
            Assert.fail("Тест провален");
        }

        // проверка добавления 3 элементов в корзину//div[@class='count']//span[@class='items'][2]
        ///Integer interIcon2 = Integer.valueOf(driver.findElement(setIcon2).getText());
        // сравниваем переменные
        //Assert.assertTrue (interIcon1 == 3);
        ///sleep(1500);

        // проверка добавления 3 элементов в корзину//div[@class='count']//span[@class='items'][3]
        ///Integer interIcon3 = Integer.valueOf(driver.findElement(setIcon3).getText());
        // сравниваем переменные
        ///Assert.assertTrue (interIcon1 == 3);
        ///sleep(1500);


        driver.quit();

    }
}


