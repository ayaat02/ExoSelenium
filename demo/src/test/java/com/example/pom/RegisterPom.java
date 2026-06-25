package com.example.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPom {
    WebDriver driver;

    //choisir genre
    By genreM = By.id("gender-male");
    By genreF = By.id("gender-female");
    //saisir fname
    By fName = By.id("FirstName");
    //saisir lname
    By lName = By.id("LastName");
    //saisir email
    By email = By.id("Email");
    //saisir password
    By pass = By.id("Password");
    //confirme pass
    By passCon = By.id("ConfirmPassword");
    //click  register
    By regiBtn = By.id("register-button");

    public RegisterPom(WebDriver driver){
        this.driver = driver;
    }

    public void ChoixGenre(String g){
        if(g == "F"){
            driver.findElement(genreF).click();
        }else{
            driver.findElement(genreM).click();
        }
    }

    public void FirstName(String fn){
        driver.findElement(fName).sendKeys(fn);
    }
    
    public void LasttName(String ln){
        driver.findElement(lName).sendKeys(ln);
    }

    public void Email(String e){
        driver.findElement(email).sendKeys(e);
    }

    public void Password(String p){
        driver.findElement(pass).sendKeys(p);
    }

    public void ConfirmPassword(String cp){
        driver.findElement(passCon).sendKeys(cp);
    }

    public void ClickRegister(){
        driver.findElement(regiBtn).click();;
    }
}
