import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Personalprofile {

    WebDriver driver = new ChromeDriver();
    Data getDate = new Data();

    private By btnJoinFree = By.xpath("//div[@class='wrap_icon inner-table-block']//i[@class='svg inline big svg-inline-cabinet']");
    private By inputEmailLog = By.xpath("//div[@class='input']/input[@id='USER_LOGIN_POPUP']");
    private By inputPassLog = By.xpath("//div[@class='input']/input[@id='USER_PASSWORD_POPUP']");
    private By btnLogin = By.xpath("//div[@class='buttons clearfix']/button");
    private By getPersonalName = By.xpath("//span[@class='wrap']/span[@class='name']");

    private By getErrorText = By.xpath("//div[@class='alert alert-danger']/p");
   // private By btnJoinFree = By.xpath("//div[@class='wrap_icon inner-table-block']//i[@class='svg inline big svg-inline-cabinet']");
    private By btnJoinReg = By.linkText("Регистрация");

    private By inputName = By.xpath("//div[@class='iblock label_block']//input[@id='input_NAME']");
    private By inputEmail = By.xpath("//div[@class='iblock label_block']//input[@id='input_EMAIL']");
    private By inputPhone = By.xpath("//div[@class='iblock label_block']//input[@id='input_PERSONAL_PHONE']");
    private By inputPass = By.xpath("//div[@class='iblock label_block']//input[@id='input_PASSWORD']");
    private By inputPassconfirmation = By.xpath("//div[@class='iblock label_block']//input[@id='input_CONFIRM_PASSWORD']");
    private By inputCode = By.xpath("//div[@class='captcha_input']//input[@name='captcha_word']");
    private By btnJoin = By.xpath("//div[@class='but-r']//button[@name='register_submit_button1']");


    @org.testng.annotations.Test
    public void authorization() throws InterruptedException {

        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        sleep(3000);
        //Клик по кнопке лк в шапке
        driver.findElement(btnJoinFree).click();
        sleep(2000);
        //Ввод валидных данных
        driver.findElement(inputEmailLog).sendKeys(getDate.email);
        driver.findElement(inputPassLog).sendKeys(getDate.passvalid);
        //Клик по кнопке войти
        driver.findElement(btnLogin).click();
        sleep(3000);
        //Проверка вошли ли мы в личный кабинет
        String getError = driver.findElement(getPersonalName).getText();
        //Проверка показа уведомления о вводе невалидных данных
        Assert.assertEquals("Тест УМ", getError);
        driver.quit();
        //Клик на кнопку выйти из аккаунта

        //Проверка вышли ли мы из аккаунта


    }

    @Test
    public void negauthorization() throws InterruptedException {

        driver.get(getDate.getUrl);
        driver.manage().window().maximize();
        sleep(3000);
        //Клик по кнопке лк в шапке
        driver.findElement(btnJoinFree).click();
        sleep(3000);
        //Ввод невалидных данных
        driver.findElement(inputEmailLog).sendKeys(getDate.email);
        driver.findElement(inputPassLog).sendKeys(getDate.passunvalid);
        //Клик по кнопке войти
        driver.findElement(btnLogin).click();
        sleep(2000);
        String getError = driver.findElement(getErrorText).getText();
        //Проверка показа уведомления о вводе невалидных данных
        Assert.assertEquals("Неверный логин или пароль", getError);
        driver.quit();

    }

    @Test
    public void registration() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            Data getDate = new Data();

            driver.get(getDate.getUrl);
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(btnJoinFree).click();
            Thread.sleep(3000);
            driver.findElement(btnJoinReg).click();
            Thread.sleep(3000);
            driver.findElement(inputName).sendKeys(getDate.name);
            driver.findElement(inputEmail).sendKeys(getDate.email);
            driver.findElement(inputPhone).sendKeys(getDate.phone);
            driver.findElement(inputPass).sendKeys(getDate.passunvalid);
            driver.findElement(inputPassconfirmation).sendKeys(getDate.Passconfirmation);
            driver.findElement(inputCode).sendKeys(getDate.code);
            driver.findElement(btnJoin).click();
            sleep(2000);
            driver.quit();


        }

    }
