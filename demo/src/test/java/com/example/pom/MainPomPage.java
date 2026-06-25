package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPomPage {
    WebDriver driver;

    //btn register
    By btnReg = By.cssSelector(".ico-register");

    public MainPomPage(WebDriver driver){
        this.driver = driver;
    }

    public void RegisterClick(){
        driver.findElement(btnReg).click();
    }
}
