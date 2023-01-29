import com.beust.ah.A;
import com.sun.source.util.SourcePositions;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.remote.tracing.opentelemetry.SeleniumSpanExporter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import javax.swing.text.html.parser.Element;
import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Makeanorder extends Data {
    Data getDate = new Data();
    private By iconForDogs = By.xpath("//div[@class='mainCategory__block']/div[@class='mainCategory__img'][1]");
    private By setFilterProplan = By.xpath("//div[@class='customSorting__list']/a[@class='customSorting__item'][2]");
    private By setFilterProplanDone = By.xpath("//div[@class='kzjhk']");
    private By moveToSecondOrder = By.xpath("//div[@id='bx_3966226736_151289']");
    private By seeSecondOrder = By.xpath("//div[@class='fast_view_block' and @data-param-id='151289']");
    private By clickOrderPlus = By.xpath("//*[@id=\"bx_3966226736_151289\"]/div/div[3]/div[2]/div/div[1]/span[2]");

    //div[@class='basket_sort']/div[@class='basket_title']
    private By clickOrderPut = By.xpath("//div[@class='button_block ']/span[@data-bakset_div='bx_basket_div_5187605']");

    private By cheekSet = By.xpath("//a[@href='/basket/' and @class='dark-color basket-link']");
    private By cheekCloseBasket = By.xpath("//div[@class='basket_sort']/div[@class='basket_title']");

    private By btnClickBack = By.xpath("//div[@class='basket_close']/span");
    private By btnClickOrder = By.xpath("//a[@href='/catalog/item/151296/']");
    private By cheekPageOrder = By.xpath("//span[@class='btn-lg w_icons to-cart btn btn-default transition_bg animate-load']");
    private By btnClick3kg = By.xpath("//div[@atr='5856980']");
    private By btnClick7kg = By.xpath("//div[@atr='4849024']");
    private By btnClick25kg = By.xpath("//div[@atr='2811788']");
    private By btnLetMiniBasket = By.xpath("//div[@data-type='AnDelCanBuy']//div[@class='count']");
    //div[@data-type='AnDelCanBuy']//div[@class='count']
    private By btnLetBasket = By.xpath("//div[@class='wrap_button']/a[@class='btn btn-default white']");
    private By btnClickFinishOrder = By.xpath("//button[@class='btn btn-lg btn-default basket-btn-checkout white']");
    private By btnClickShopDelivery = By.xpath("//button[@class='b-new-order__btn sam_shop' and @shop_id=338]");
    private By setFormName = By.xpath("//div[@class='main-form__block']/input[@name='name']");
    private By setFormPhone = By.xpath("//div[@class='main-form__block']/input[@name='phone']");
    private By setFormEmail = By.xpath("//div[@class='main-form__block']/input[@name='email']");
    private By setFormComment = By.xpath("//textarea[@name='comment']");
    private By btnClickCheekBox = By.xpath("//*[@id=\"form-order\"]/div[6]/label");
    private By btnClickContinue = By.xpath("//div[@class='col-xs-4']/input[@value='Далее']");
    private By btnClickPayCard = By.xpath("//div[@style='background-image: url(/upload/sale/paysystem/logotip/da4/da4addf5afb2b64a5f02dbd9da0b0bb1.gif);']");
    private By btnClickPayContinue = By.xpath("//button[@class='b-new-order__btn pay_next ']");
    private By btnClickPayFinish = By.xpath("//button[@class='b-new-order__btn oform704']");
    private By getOrder = By.xpath("//div[@class='b-new-order__block b-new-order__title border success-title']");


















    @Test
    public void ordertest() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            Actions actions = new Actions(driver);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {


            System.out.print("Открываем сайт");
            driver.get(getDate.getUrl);
            WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
            driver.manage().window().maximize();
            System.out.println(" - Сайт открыт");

            js.executeScript("window.scrollBy(0,850)");
            System.out.print("Кликаем на категорию \"Для собак\"");
           driver.findElement(iconForDogs).click();
            System.out.println(" - Перешли в категорию \"Для собак\"");

        System.out.print("Кликаем на фильтр \"Pro Plan\" в плитках");
            driver.findElement(setFilterProplan).click();
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(setFilterProplanDone));
                System.out.println(" - Применен фильтр \"Pro Plan\"");

                System.out.print("Наводим на второй товар в листинге");
                WebElement moveSet = driver.findElement(moveToSecondOrder);
                actions.moveToElement(moveSet).build().perform();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(seeSecondOrder));
                System.out.println(" - Навелись на 2 товар");
                System.out.print("Кликаем на +");
                driver.findElement(clickOrderPlus).click();
                System.out.println(" - Поменяли значения товара на 2");
                System.out.print("Кликаем на кнопку в корзину");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(clickOrderPut));
                driver.findElement(clickOrderPut).click();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cheekSet));
                System.out.println(" - Добавили в корзину 2 товара");
                System.out.print("Кликаем на кнопку продолжить покупки");
                sleep(2000);
                driver.findElement(btnClickBack).click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(cheekCloseBasket));
                System.out.println(" - Мини корзина закрыта");
                System.out.print("Кликаем на четвёртый товар в листинге");
                driver.findElement(btnClickOrder).click();
                System.out.println(" - Перешли в карточку товара");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cheekPageOrder));
                sleep(3000);
                System.out.print("Кликаем на кнопку добавления 3кг фасовки");
                driver.findElement(btnClick3kg).click();
                System.out.println(" - Товар добавлен");
                System.out.print("Кликаем на кнопку добавления 7кг фасовки");
                driver.findElement(btnClick7kg).click();
                System.out.println(" - Товар добавлен");
                System.out.print("Кликаем на кнопку добавления 2,5кг фасовки");
                driver.findElement(btnClick25kg).click();
                System.out.println(" - Товар добавлен");
                System.out.print("Кликаем на иконку корзины");
                driver.findElement(btnLetMiniBasket).click();
                System.out.println(" - Перешли в мини корзину");
                System.out.print("Кликаем на кнопку перейти в корзину");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnLetBasket));
                driver.findElement(btnLetBasket).click();
                System.out.println(" - Перешли в корзину");
                System.out.print("Кликаем на кнопку оформить заказ");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnClickFinishOrder));
                driver.findElement(btnClickFinishOrder).click();
                System.out.println(" - Перешли на второй шаг оформления заказа");
                System.out.print("Кликаем на кнопку выбрать магазин");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnClickShopDelivery));
                driver.findElement(btnClickShopDelivery).click();
                System.out.println(" - Перешли на третий шаг оформления заказа");
                System.out.print("Заполняем поле ввода имени");
                driver.findElement(setFormName).sendKeys(name);
                WebElement element0 = driver.findElement(setFormName);
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element0, "TestUm")));
                System.out.println(" - Ввели имя");
                System.out.print("Заполняем поле ввода телефон");
                driver.findElement(setFormPhone).sendKeys(phonebasket);
                WebElement element1 = driver.findElement(setFormPhone);
                wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(element1, "89999999999")));
                System.out.println(" - Ввели телефон");
                System.out.print("Заполняем поле ввода Email");
                driver.findElement(setFormEmail).sendKeys(email);
                System.out.println(" - Ввели Email");
                System.out.print("Заполняем поле ввода Комментарий");
                driver.findElement(setFormComment).sendKeys(code);
                System.out.println(" - Ввели коммент");
                //System.out.print("Кликаем на чекбокс согласия с обработкой персональных данных");
                //wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnClickCheekBox));
                //driver.findElement(btnClickCheekBox).click();
                //System.out.println(" - заполнили чекбокс");
                System.out.print("Кликаем на кнопку Далее");
                driver.findElement(btnClickContinue).click();
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(btnClickPayCard));
                System.out.print("Кликаем на кнопку Оплата картой при получении");
                driver.findElement(btnClickPayCard).click();
                System.out.println(" - выбран способ оплаты картой");
                System.out.print("Кликаем на кнопку далее");
                driver.findElement(btnClickPayContinue).click();
                System.out.println(" - Переходим на 5 шаг");
                System.out.print("Кликаем на кнопку оформить заказ");
                driver.findElement(btnClickPayFinish).click();
                //Integer interIcon1 = Integer.valueOf(driver.findElement(getOrder).getText());
                //System.out.println(interIcon1);
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getOrder));
                System.out.println(" - Заказ оформлен");
               System.out.println(" - Присвоен номер заказа = ");

    }
            catch (Exception e) {
                System.err.println("Ошибка " + e);
                Assert.fail("Тест провален");
            }
        //File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
           // FileUtils.c


    }
}

