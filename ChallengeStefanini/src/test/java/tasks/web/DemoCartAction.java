package tasks.web;

import elements.DemoCartElements;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.WebDriverFactory;


public class DemoCartAction extends DemoCartElements {

    public static void homePage(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.presenceOfAllElementsLocatedBy(DemoCartElements.ASSERT_HOME));
    }

    public static void inputSearch(String search){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_SEARCH)).sendKeys(search);
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_SEARCH)).submit();
    }

    public static void clickResultSearch (String search) throws InterruptedException {
        boolean flag = false;
        while (flag == false){
            try {
                WebDriverFactory.getWaitDriver().until(ExpectedConditions.presenceOfAllElementsLocatedBy(DemoCartElements.BTN_PRODUCT));
                if (WebDriverFactory.getDriver().findElement(By.xpath("//a[contains(text(), '" + search + "')]")).isDisplayed()) {
                    WebDriverFactory.getDriver().findElement(By.xpath("//a[contains(text(), '" + search + "')]")).click();
                    flag = true;
                }
            } catch (NoSuchElementException e){
                Assert.fail("Search results were not found on any page displayed");
            }
        }
    }

    public static void clickAddCart(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_ADD_CART)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_ADD_CART)).click();
    }

    public static void clickCart(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_CART)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_CART)).click();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_VIEW_CART)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_VIEW_CART)).click();
    }

    public static void validatProduct(String search) {
        boolean flag = false;
        while (flag == false) {
            try {
                WebDriverFactory.getWaitDriver().until(ExpectedConditions.presenceOfAllElementsLocatedBy(DemoCartElements.BTN_PROCEED_CHECKOUT));
                if (WebDriverFactory.getDriver().findElement(By.xpath("//a[contains(text(), '" + search + "')]")).isDisplayed()) {
                    WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_PROCEED_CHECKOUT)).click();
                    flag = true;
                }
            } catch (NoSuchElementException e) {
                Assert.fail("Product in cart does not match selected");
            }
        }
    }

    public static void clickProceedCheckout(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_PROCEED_CHECKOUT)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_PROCEED_CHECKOUT)).click();
    }
    public static void inputInformtion(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_ADDRESS)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_ADDRESS)).click();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_ADDRESS)).sendKeys("Street fake");
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_EMAIL)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_EMAIL)).click();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_EMAIL)).sendKeys("Street fake");
    }

    public static void selectPaymentMethods(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_PAYMENT_PHONE)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_PAYMENT_PHONE)).click();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_PHONE)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_PHONE)).click();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.INPUT_PHONE)).sendKeys("5581978747571");
    }

    public static void checkTermsCaptcha(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.CHECK_TERMS)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.CHECK_TERMS)).click();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.CHECK_CAPTCHA)).click();
    }

    public static void clickPlaceOrder(){
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_ORDER)).isDisplayed();
        WebDriverFactory.getWaitDriver().until(ExpectedConditions.visibilityOfElementLocated(DemoCartElements.BTN_ORDER)).click();
    }

    public static void validateOrder() {
        boolean flag = false;
        while (flag == false) {
            try {
                WebDriverFactory.getWaitDriver().until(ExpectedConditions.presenceOfAllElementsLocatedBy(DemoCartElements.ASSERT_SUCESS));
                if (WebDriverFactory.getDriver().findElement(By.xpath("//p[contains(text(), 'Congratulations! Your order has been successfully placed.')]")).isDisplayed()) {
                    System.out.println("Purchase completed successfully");
                    flag = true;
                }
            } catch (NoSuchElementException e) {
                Assert.fail("Product in cart does not match selected");
            }
        }
    }

}


