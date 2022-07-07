package com.test.openmrs.utils.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    // Browser Utils is a location for the reusable methods.
    // Advantage 1: You do not need to repeat yourself
            //   2: less code
            //   3: less time (*)
    public static void selectBy(WebElement element, String value, String methodName) {
        Select select = new Select(element);
        switch(methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Use Text, Value, or index for Method Name.");
        }}
    public static String getText(WebElement element) {
        return element.getText().trim();
    }
    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString(); // it gets the title
    }
    public static void clickWithJS(WebElement driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }
    public static void scrollWithJS(WebElement driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }
    public static void switchByID(WebDriver driver, String mainId){
    Set<String> allPageIds=driver.getWindowHandles();
        for(String id : allPageIds){
        System.out.println(id);
        if(!id.equals(mainId)){
            driver.switchTo().window(id);
        }}}
    public static void switchByTitle(WebDriver driver, String title){
        Set<String> allIds = driver.getWindowHandles();
        for (String id : allIds){
            driver.switchTo().window(id);
            if (driver.getTitle().contains(title)) {
                break;
            }}}
//    public static void getScreenShot(WebDriver driver, String packageName){
//        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String location = System.getProperty("user.dir")+"/src/java/screenshot" + packageName;
//        try {
//            FileUtils.copyFile(file,new File(location + System.currentTimeMillis()));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // system.currentTimeMills will make the data unique all the time
 //   }

  // from Elif:

    public static void getScreenShot(Scenario scenario, WebDriver driver){
        Date currentDate=new Date();
        String screenShotFileName=currentDate.toString().replace(" ", "-")
                .replace(":", "-");
        if(scenario.isFailed()){
            File screenShotFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile, new File("src/main/java/com/test/openmrs/screenshot/"+screenShotFileName+".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //end
}
