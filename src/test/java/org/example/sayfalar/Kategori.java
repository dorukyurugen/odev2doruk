package org.example.sayfalar;

import com.thoughtworks.gauge.Step;
import org.example.StepImplementation;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class Kategori extends StepImplementation {
    @Step("Kategori Sayfası Kontrol")
    public void checkCategoryPage(){
        String textCheck = findElement(By.xpath("//android.widget.LinearLayout[@content-desc='Kategoriler']")).getAttribute("content-desc");
        Assertions.assertEquals("Kategoriler",textCheck,"Kategori sayfası hatalı");
        logger.info("Kategoriler sayfasında olduğu doğrulandı");
    }
}