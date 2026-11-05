package br.com.chronosacademy.automacaoweb;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;


public class TesteWeb {
    ChromeDriver driver;

    @Before
    public void inicializaTeste() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://cec-claro--preprod.sandbox.my.salesforce.com");
    }

    @Test
    public void primeiroTeste() {

        String xpathTitulo = "//*[@id=\"usernamegroup\"]/label";
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        assertEquals("Nome do usuário", titulo);

    }

    @After
    public void finalizaTeste() {
        driver.quit();
    }


}
