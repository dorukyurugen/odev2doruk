package org.example;

import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    protected static AndroidDriver appiumDriver;
    protected static WebDriverWait wait;
    protected boolean localAndroid = true;
    public Logger logger = LogManager.getLogger(getClass().getName());


    @BeforeScenario
    public void Education() throws MalformedURLException {
        if (localAndroid) {
            System.out.println("Android  testi başlıyor");
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities
                    .setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
            desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.ozdilek.ozdilekteyim");
            desiredCapabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "com.ozdilek.ozdilekteyim.MainActivity");
            desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 3000);
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            appiumDriver = new AndroidDriver(url, desiredCapabilities);
            wait = new WebDriverWait(appiumDriver, 15);

        }
    }

    @AfterScenario
    public void afterScenario() {
        if (appiumDriver != null)
            appiumDriver.quit();
    }


}
