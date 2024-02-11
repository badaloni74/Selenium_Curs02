package com.mesajapp.stepdefinitions;

import com.mesajapp.pageobjects.GooglePageObject;
import com.mesajapp.stepdefinitions.auxiliars.iniciarWebDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ca.Aleshores;
import io.cucumber.java.ca.Donat;
import io.cucumber.java.ca.Quan;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleStepDefs implements iniciarWebDriver {

    private ChromeDriver driver;
    private GooglePageObject googlePO;

    @BeforeEach
    public void setUp() {
        System.out.println("BeforeEach");
    }

    @AfterEach
    public void setAfterEach() {
        System.out.println("BeforeEach");
    }

    @Before()
    public void iniciar() throws InterruptedException {
        System.out.println("Iniciar");
        driver = iniciaWebDriver();
        googlePO = new GooglePageObject(driver);
    }

    @After()
    public void tearDown() {
        System.out.println("After");
        googlePO.mostraFinal();
        if (driver != null) {
            driver.quit();
        }
    }

    @Donat("que es navega a {string}")
    public void queSAccedeixA(String link) {
        driver.get("http://"+link);
        googlePO.clicarAcceptarCookies();
    }

    @Donat("que sescriu al buscador {string}")
    public void queEscribimAlBuscador(String paraula) {
        googlePO.escriureCerca(paraula);
    }

    @Quan("es pulsa Cerca a Google")
    public void esPulsaCercaaGoogle() {
        googlePO.clicarCercar();
    }

    @Aleshores("es valida que apareix {string}")
    public void es_valida_que_apareix(String paraula) {
        googlePO.validarResultat(paraula);
    }

}
