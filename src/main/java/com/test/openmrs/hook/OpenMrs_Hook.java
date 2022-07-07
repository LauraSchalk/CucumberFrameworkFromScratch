package com.test.openmrs.hook;

import com.test.openmrs.utils.utils.BrowserUtils;
import com.test.openmrs.utils.utils.ConfigReader;
import com.test.openmrs.utils.utils.DriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class OpenMrs_Hook {
    WebDriver driver = DriverHelper.getDriver(); // to centralize driver
    @Before
    public void setup(){
        driver.navigate().to(ConfigReader.readProperty("QA_url"));
    }
//    @After
//        public void tearDown(Scenario scenario){
//        Date currentDate = new Date();
//        String screenShotFileName=currentDate.toString().replace(":","-");
//        if(scenario.isFailed()){
//            File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//            try {
//                FileUtils.copyFile(screenShotFile,new File("src/main/java/com/test/openmrs/screenshot/" + screenShotFileName+".png"));
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        driver.quit();
//    }
    // from Elif
    @After
    public void tearDown(Scenario scenario){
        BrowserUtils.getScreenShot(scenario, driver);
        driver.quit();
    }


    //end
}
