package com.mesajapp.pageobjects;

import com.mesajapp.arquitectura.BasePO;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GooglePageObject extends BasePO {

    private String ID_CERCA_TEXTBOX = "APjFqb";
    private String ID_RESULTATS_LABEL = "result-stats";
    private String XPATH_CERCA_BUTTON = "//input[@value='Cerca de Google']";
    private String ID_ACCEPTAR_COOKIES = "L2AGLb";

    protected boolean validarPagina() {
        return false;
    }

    public GooglePageObject(WebDriver driver){
        super(driver);
    }

    public void escriureCerca(String cerca){
        retornaWExId(ID_CERCA_TEXTBOX).clear();
        webElement.sendKeys(cerca);
    }

    public void clicarCercar(){
        retornaWExPath(XPATH_CERCA_BUTTON).click();
    }

    public void validarResultat(String paraula){
        String resultats = retornaWExId(ID_RESULTATS_LABEL).getText();
        Assert.assertTrue( "La consulta no retorna cap resultat per " + paraula, resultats.contains(paraula));
    }

    public void clicarAcceptarCookies(){
        if(retornaWExId(ID_ACCEPTAR_COOKIES).isDisplayed()){
            webElement.click();
        }
    }

}
