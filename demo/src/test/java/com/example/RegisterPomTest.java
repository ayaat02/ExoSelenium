package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.example.pom.MainPomPage;
import com.example.pom.Register1;
import com.example.pom.RegisterPom;

public class RegisterPomTest {

    WebDriver driver;
    MainPomPage mp;
    RegisterPom rp;
    Register1 reg;
    String mail = "user"+Math.floor(Math.random()*5000)+"@gmail.com";
    String pass = "user"+(Math.floor(Math.random()*5000)+1000);

    @BeforeEach
    public void setup(){
        //initialiser le webdriver pour traduire la code ecrit en java vers le navigateur
        //Webdriver c comme le page dans playwright
        driver = new FirefoxDriver();
        mp = new MainPomPage(driver);
        rp = new RegisterPom(driver);
        reg = new Register1(driver);
        driver.get("https://demowebshop.tricentis.com/");
    }

    @AfterEach
    public void TearDown(){
        if(driver!= null){//designe que le navigateur est ouvert 
            driver.quit(); //pour fermer le navigateur automatiquement 
            driver=null; //il devient null apres la fermeture 
        }
    }

    @Test
    public void Register(){
        mp.RegisterClick();
        assertEquals("https://demowebshop.tricentis.com/register", driver.getCurrentUrl());
        //remplir le formulaire d'inscription
        rp.ChoixGenre("F");
        rp.FirstName("Tina");
        rp.LasttName("aitzian");
        rp.Email(mail);
        rp.Password(pass);
        rp.ConfirmPassword(pass);
        rp.ClickRegister();
        assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
        assertEquals("Your registration completed", reg.Message()); 
        //reg.ContinuerBtn();
        reg.ContinuerBtn2();  
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());     
    }


    
}
