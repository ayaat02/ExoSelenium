package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartpom {
    WebDriver driver;
    //locators
    By BtnIgree = By.id("termsofservice");
    By BtnCheck = By.id("checkout");

    public cartpom(WebDriver driver){
        this.driver = driver;
    }
    
    public void ClickIagree(){
     driver.findElement(BtnIgree).click();
    }

    public void ClickCheckOut(){
     driver.findElement(BtnCheck).click();
    }
    
}
