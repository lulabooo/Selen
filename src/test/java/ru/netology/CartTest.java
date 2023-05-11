package ru.netology;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CartTest {
    private WebDriver driver;
    @BeforeAll
    static void setUpAll() {
        System.setProperty("Webdriver.chrome.driver", "./Selen/Driver/chromedriver.exe");
    }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver = null;
    }

    @Test
    void shouldTestV1() {
        driver.get("http://localhost:7777/");
        driver.findElements(By.tagName("input")).get(0).sendKeys("Василий Иванов");
        driver.findElements(By.tagName("input")).get(1).sendKeys("+79219864218");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String expected = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        String actual = driver.findElement(By.className("order-success")).getText().trim();
        assertEquals(expected, actual);
    }
}
