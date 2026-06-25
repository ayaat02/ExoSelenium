package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Register1 {
    WebDriver driver;

    By msg = By.cssSelector(".result");
    By contBtn = By.cssSelector((".button-1.register-continue-button"));
    By contBtn2 = By.cssSelector("input[value='Continue']");
    

    public Register1(WebDriver driver){
        this.driver = driver;
    }

    public String Message(){
        return driver.findElement(msg).getText();
    }

    public void ContinuerBtn(){
        driver.findElement(contBtn).click();
    }

    public void ContinuerBtn2(){
        driver.findElement(contBtn2).click();
    }

}
