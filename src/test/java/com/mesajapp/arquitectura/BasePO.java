package com.mesajapp.arquitectura;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.mesajapp.stepdefinitions.auxiliars.constants.ESPERA;

public abstract class BasePO {

    protected WebDriver driverBasePO;
    protected WebElement webElement;
    protected List<WebElement> llistaWE;
    protected WebDriverWait wait;
    protected JavascriptExecutor js;

    protected BasePO(WebDriver driver){
        driverBasePO = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ESPERA));
        driverBasePO.manage().timeouts().implicitlyWait(ESPERA, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driverBasePO;
        PageFactory.initElements(driverBasePO, this);
    }

    public void mostraFinal(){
        js.executeScript("alert('Prova finalitzada correctament')");
        // Espera un segon perquè l'alerta es mostri
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Accepta l'alerta
        Alert alert = driverBasePO.switchTo().alert();
        alert.accept();
    }

    protected WebElement retornaWExPath(String xPath){
        try{
            webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
        } catch (Exception e){
            Assert.fail("No s'ha trobat l'element per xPath: " + xPath);
        }
        return webElement;
    }

    protected WebElement retornaWExId(String id){
        try{
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
        } catch (Exception e){
            Assert.fail("No s'ha trobat l'element per Id: " + id);
        }
        return webElement;
    }

    protected void go(String url){
        driverBasePO.get(url);
    }

    private WebElement retornaWE(String literal){
        Assert.assertFalse("No s'han trobat elements per xPath: " + literal, llistaWE.isEmpty());
        webElement = llistaWE.get(0);
        return webElement;
    }

}
