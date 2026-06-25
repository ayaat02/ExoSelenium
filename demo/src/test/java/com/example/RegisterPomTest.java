package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.example.pom.CheckoutPom;
import com.example.pom.MainPomPage;
import com.example.pom.Register1;
import com.example.pom.RegisterPom;
import com.example.pom.loginpage;
import com.example.pom.cartpom;


public class RegisterPomTest {

    WebDriver driver;
    MainPomPage mp;
    RegisterPom rp;
    Register1 reg;
    loginpage lp;
    cartpom cp;
    CheckoutPom chp;
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
        lp = new loginpage(driver);
        cp = new cartpom(driver);
        chp = new CheckoutPom(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
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
        rp.RegisterUser("F", "Tina", "aitzian", mail, pass);
        // rp.ChoixGenre("F");
        // rp.FirstName("Tina");
        // rp.LasttName("aitzian");
        // rp.Email(mail);
        // rp.Password(pass);
        // rp.ConfirmPassword(pass);
        // rp.ClickRegister();
        assertEquals("https://demowebshop.tricentis.com/registerresult/1", driver.getCurrentUrl());
        assertEquals("Your registration completed", reg.Message()); 
        //reg.ContinuerBtn();
        reg.ContinuerBtn2();  
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl()); 
        // se deconnecter
        mp.clicklogout();
        // se connecter
        mp.bouttonlogin(); 
        lp.AppLogin(mail, pass);
        assertEquals("https://demowebshop.tricentis.com/", driver.getCurrentUrl());
        mp.clickaddtocard();
        //verifier que le produit est ajouter avec la bare du message
        //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        //String msg = wait.until(ExpectedConditions.visibilityOfElementLocated(mp.MsgAddPro)).getText();
        //assertEquals(msg,"The product has been added to your shopping cart");
        assertEquals(mp.MessageAddPro(),"The product has been added to your shopping cart");
        // clique vers url vers shoping cart
        mp.clickGoToCart();
        // verifier qu on est rederiger vers la page cart
        assertEquals("https://demowebshop.tricentis.com/cart", driver.getCurrentUrl());
        //verifier le produit dans cart
        cp.ClickIagree();
        //clique checkout
        cp.ClickCheckOut();
        // verifier la redirection vers la page checkout
        assertEquals("https://demowebshop.tricentis.com/onepagecheckout", driver.getCurrentUrl());

        //Confirmer le CheckOut
        chp.SelectCountry(1);
        chp.SelectState(1);
        chp.SaisirCity("Arizona");
        chp.SaisirZipCode("97642");
        chp.SaisirAddress("Arizonaifdkdlg");
        chp.SaisirPhoneNbr("0765896432");
        chp.ClickContinue();

        //
        chp.CheckStorePick(); // 
        chp.ClickAddressCont();//
        chp.ChosePaiementMethod();
        chp.ClickCardContinue();

        ////////
        chp.SaisirCardHolder("User");
        chp.SaisirCardNbr("4973559181526815");
        chp.SaisirExpMonth("12");
        chp.SaisirExpYear("2028");
        chp.SaisirCardCode("258");
        chp.ClickBeforeOrderBtn();
        chp.ClickConfOrderBtn();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(chp.FinalCont)).click(); 
        assertEquals("https://demowebshop.tricentis.com/checkout/completed/",driver.getCurrentUrl());
    }
}
