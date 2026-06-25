package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPomPage {
    WebDriver driver;

    //btn register
    By btnReg = By.cssSelector(".ico-register");
    By logoutbtn = By.cssSelector((".ico-logout"));
    By loginbnt = By.cssSelector(".ico-login");
    By linkproduit1 = By.cssSelector("input[onclick*='addproducttocart/catalog/31/1/1']");
    public By MsgAddPro = By.cssSelector(".content");
    By UrlShopingcart = By.cssSelector(".content a[href='/cart']");
    
    public MainPomPage(WebDriver driver){
        this.driver = driver;
    }

    public void RegisterClick(){
        driver.findElement(btnReg).click();
    }
    public void clicklogout(){
        driver.findElement(logoutbtn).click();
    }
    public void bouttonlogin(){
        driver.findElement(loginbnt).click();
    }

    public void clickaddtocard(){
        driver.findElement(linkproduit1).click();
    }

    public String MessageAddPro(){
        return driver.findElement(MsgAddPro).getText();
    }
    
    public void clickGoToCart(){
        driver.findElement(UrlShopingcart).click();
    }
    

}
