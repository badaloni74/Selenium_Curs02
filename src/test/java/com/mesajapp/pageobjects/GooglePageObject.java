package com.mesajapp.pageobjects;

import com.mesajapp.arquitectura.BasePO;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class GooglePageObject extends BasePO {

    private final String ID_CERCA_TEXTBOX = "APjFqb";
    private final String ID_RESULTATS_LABEL = "result-stats";
    private final String XPATH_CERCA_BUTTON = "//input[@value='Cerca de Google']";
    private final String ID_ACCEPTAR_COOKIES = "L2AGLb";

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
