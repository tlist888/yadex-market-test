import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;
import tools.DriverManager;
import tools.Tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Test class for market.yandex.ru
 *
 */
public class MarketTest {
    static WebDriver driver;
    static WebDriverWait wait; // explicit wait
    static OperaOptions options;

    @BeforeClass
    public static void setUp() {

        options = new OperaOptions();
        options.setBinary("C:\\Program Files\\Opera\\launcher.exe");
        System.setProperty("webdriver.opera.driver", "C:\\Users\\tanya\\Documents\\Selenium\\operadriver.exe");
        driver = new OperaDriver(options);

        //driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public static void quitDriver() {
        driver.quit();
    }

    @Test
    public void tvTest(){

        Page pageTv = new Page(driver);
        pageTv
                .load("http://yandex.ru/")
                .goByLinkText("Маркет")
                .goByLinkText("Электроника")
                .goByLinkText("Телевизоры")
                .setPriceById("glf-pricefrom-var", "20000")
                .selectCheckById("glf-7893318-153074") //LG
                .selectCheckById("glf-7893318-153061") //Samsung
                .clickButtonByXpath(
                        "//div[@class='n-filter-panel-aside__apply']//button[.='Применить']", 10);

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        String tvName = list.get(0).getText();
        pageTv.search(
                tvName, "header-search", "//span[@class='search2__button']//button[.='Найти']", 10);

        WebElement title = driver.findElement(By.xpath("//div[@class='n-title__text']"));
        Assert.assertEquals(tvName, title.getText());
        //System.out.println(tvName);
    }

   @Test
    public void headphoneTest(){
        Page pageHeadphones = new Page(driver);
        pageHeadphones
                .load("http://yandex.ru/")
                .goByLinkText("Маркет")
                .goByLinkText("Электроника")
                .goByLinkText("Наушники и Bluetooth-гарнитуры")
                .clickButtonByXpath(
                    "//div[@class='n-filter-panel-aside__content']//button[.='Показать всё']", 0)
                .setPriceById("glf-pricefrom-var", "5000")
                .selectCheckById("glf-7893318-8455647")  //Beats
                .clickButtonByXpath(
                    "//div[@class='n-filter-panel-aside__apply']//button[.='Применить']", 10);

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        String headphoneName = list.get(0).getText();

        pageHeadphones.search(
                headphoneName, "header-search", "//span[@class='search2__button']//button[.='Найти']", 10);

        WebElement title = driver.findElement(By.xpath("//div[@class='n-title__text']"));
        Assert.assertEquals(headphoneName, title.getText());

    }
}