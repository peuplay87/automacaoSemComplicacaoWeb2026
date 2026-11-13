package br.com.chronosacademy.maps;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrincipalMap {
    @FindBy(xpath = "//*[@id=\"usernamegroup\"]/label")
    public WebElement txtTitulo;

}
