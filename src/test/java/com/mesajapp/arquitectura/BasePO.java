package com.mesajapp.arquitectura;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static com.mesajapp.stepdefinitions.auxiliars.constants.ESPERA;

public abstract class BasePO {

    protected abstract boolean validarPagina();

    protected WebDriver driver;
    protected WebElement webElement;
    protected List<WebElement> llistaWE;
    protected WebDriverWait wait;

    protected BasePO(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ESPERA));
    }

    protected WebElement retornaWExPath(String xPath){
        try{
            webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));
            webElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
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
        driver.get(url);
    }

    private WebElement retornaWE(String literal){
        Assert.assertTrue( "No s'han trobat elements per xPath: " + literal , llistaWE.size()>0);
        webElement = llistaWE.get(0);
        return webElement;
    }

}
