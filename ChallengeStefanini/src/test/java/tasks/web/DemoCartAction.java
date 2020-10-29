package tasks.web;

import elements.DemoCartElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverFactory;
import java.sql.Driver;

public class DemoCartAction extends DemoCartElements {

    public static void homePage(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.presenceOfAllElementsLocatedBy(DemoCartElements.ASSERT_HOME));
    }

    public static void inputSearch(String search){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_SEARCH)).sendKeys(search);
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_SEARCH)).submit();
    }

}
