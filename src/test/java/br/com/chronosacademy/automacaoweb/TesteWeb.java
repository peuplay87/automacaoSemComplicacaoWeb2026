package br.com.chronosacademy.automacaoweb;

import br.com.chronosacademy.core.Driver;
import br.com.chronosacademy.pages.PrincipalPage;
import br.com.chronosacademy.pages.SolarPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TesteWeb {
    Driver driverWeb;
    WebDriver driver;
    PrincipalPage principalPage;
    SolarPage solarPage;

    @Before
    public void inicializaTeste() {
        driverWeb = new Driver("chrome");
        driver = driverWeb.getDriver();
        driver.get("https://cec-claro--preprod.sandbox.my.salesforce.com");
        principalPage = new PrincipalPage(driver);
    }

    @Test
    public void primeiroTesteLeia() {
        String titulo = principalPage.getTitulo();
        assertEquals("Nome do usuário", titulo);

    }

    public String getTitulo() {
        return "Nome do usuário";
    }


    @Test
    public void segundoTesteDigite() {
        WebElement campoUsuario = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        campoUsuario.sendKeys("pmarquec@emeal.nttdata.com.preprod");
        String textoDigitado = campoUsuario.getAttribute("value");
        assertEquals("pmarquec@emeal.nttdata.com.preprod", textoDigitado);

    }

    @Test
    public void terceiroTesteClickLogin() {
        WebElement campoUsuario = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        campoUsuario.sendKeys("pmarquec@emeal.nttdata.com.preprod");
        WebElement botaoLogin1 = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
        botaoLogin1.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement campoSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='password']")));
        campoSenha.sendKeys("Ped0056758900!!!!####");

        WebElement botaoLogin2 = driver.findElement(By.xpath("//*[@id=\"Login\"]"));
        botaoLogin2.click();

        //  WebElement cabecalhoSalesforce = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"oneHeader\"]/div[1]/div")));

        //  assertTrue(cabecalhoSalesforce.isDisplayed());
    }

    @After
    public void finalizaTeste() {
        driver.quit();
    }
}
