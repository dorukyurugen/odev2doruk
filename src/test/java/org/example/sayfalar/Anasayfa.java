package org.example.sayfalar;

import com.thoughtworks.gauge.Step;

import org.example.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Anasayfa extends StepImplementation {

    @Step("Açılış Sayfası Kontrol")
    public void open() {
        String alisveriseBaslaBtn = findElement(By.id("com.ozdilek.ozdilekteyim:id/tv_startShoppingStore")).getText();
        Assertions.assertEquals("ALIŞVERİŞE BAŞLA",alisveriseBaslaBtn,"Hatalı alışveris Butonu");
        logger.info("Uygulama düzgün olarak başladı");
    }
}