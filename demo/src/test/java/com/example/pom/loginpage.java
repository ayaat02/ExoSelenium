package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
WebDriver driver;
// locators
By email = By.id("Email");
By password = By.id("Password");
By rememberm = By.id("RememberMe");
By loginbnt = By.cssSelector(".button-1.login-button");


public loginpage(WebDriver driver){
    this.driver = driver;
}
public void saisiremail(String em){
    driver.findElement(email).sendKeys(em);
}
public void saisirpass(String p){
    driver.findElement(password).sendKeys(p);
}
public void clickreme(){
    driver.findElement(rememberm).click();
}

public void clickbtnlogin(){
    driver.findElement(loginbnt).click();
}

public void AppLogin(String em , String p){
    saisiremail(em);
    saisirpass(p);
    clickreme();
    clickbtnlogin();
}
    
}
