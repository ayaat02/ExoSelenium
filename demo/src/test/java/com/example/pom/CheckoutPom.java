package com.example.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

public class CheckoutPom {
    WebDriver driver ;

    //locators 

    // saisir Country
    By Country = By.id("BillingNewAddress_CountryId");
    // city
    By City = By.id("BillingNewAddress_City");
    //state 
    By State = By.id("BillingNewAddress_StateProvinceId");
    //address 1
    By address = By.id("BillingNewAddress_Address1");
    // code postale
    By ZipCode = By.id("BillingNewAddress_ZipPostalCode");

    //phone number 
    By PhoneNumber = By.id("BillingNewAddress_PhoneNumber");

    //button continue 

    By ContinueBtn = By.cssSelector("#billing-buttons-container .button-1.new-address-next-step-button");

    //storePickUp btn
    By storePickUp = By.id("PickUpInStore");

    // locator continue 2
    By ContBtn = By.cssSelector("#shipping-buttons-container .button-1.new-address-next-step-button");

    // Credit Card Btn
    By CrdtCard = By.id("paymentmethod_2");

    // Continue Btn

    By ContCardBtn = By.cssSelector("#payment-method-buttons-container .button-1.payment-method-next-step-button");
    //
    By CardHolder = By.id("CardholderName");
    By CardNbr = By.id("CardNumber");
    By ExpMonth = By.id("ExpireMonth");
    By ExpYear = By.id("ExpireYear");
    By CardCode = By.id("CardCode");

    /// continue button Confirme 
    /// 
    By ConfBeforeOrderBtn = By.cssSelector("#payment-info-buttons-container .button-1.payment-info-next-step-button");

    // By FinalCont = By.cssSelector("#confirm-order-buttons-container .button-1.confirm-order-next-step-button");
    public By FinalCont = By.cssSelector("[onclick='ConfirmOrder.save()']");
    public CheckoutPom(WebDriver driver){
        this.driver = driver;
    }
    public void SelectCountry(Integer cont){
        Select select = new Select(driver.findElement(Country));
        select.selectByIndex(cont);
    }
    
    public void SelectState(Integer state){
        Select select = new Select(driver.findElement(State));
        select.selectByIndex(state);
    }

    public void SaisirCity(String ct){
        driver.findElement(City).sendKeys(ct);
    }

    public void SaisirAddress(String ads){
        driver.findElement(address).sendKeys(ads);
    }
    public void SaisirZipCode(String zip){
        driver.findElement(ZipCode).sendKeys(zip);
    }

    public void SaisirPhoneNbr(String Phnbr){
        driver.findElement(PhoneNumber).sendKeys(Phnbr);
    }
    public void ClickContinue(){
        driver.findElement(ContinueBtn).click();
    }

    public void CheckStorePick(){
        driver.findElement(storePickUp).click();
    }
    public void ClickAddressCont(){
        driver.findElement(ContBtn).click();
    }
    public void ChosePaiementMethod(){
        driver.findElement(CrdtCard).click();
    }
    public void ClickCardContinue(){
        driver.findElement(ContCardBtn).click();
    }
    public void SaisirCardHolder(String s){
        driver.findElement(CardHolder).sendKeys(s);
    }
    public void SaisirCardNbr(String s){
        driver.findElement(CardNbr).sendKeys(s);
    }
    public void SaisirExpMonth(String s){
        Select select = new Select(driver.findElement(ExpMonth));
        select.selectByValue(s);
    }
    public void SaisirExpYear(String s){
        Select select = new Select(driver.findElement(ExpYear));
        select.selectByValue(s);
    }
    public void SaisirCardCode(String s){
        driver.findElement(CardCode).sendKeys(s);
    }
    public void ClickBeforeOrderBtn(){
        driver.findElement(ConfBeforeOrderBtn).click();
    }
    public void ClickConfOrderBtn(){
        driver.findElement(FinalCont).click();
    }

    
    
}
