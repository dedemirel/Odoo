package odoo.pages;

import odoo.utilities.ConfigurationReader;
import odoo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//according to page object model design
//we have to create corresponded page class
//for each page of application
//login page = login page class
//every page class will store webelements and methods related to that page
public class LoginPage extends BasePage{

    @FindBy(id = "login") //this line will initialize web element
    public WebElement userNameInput;

    @FindBy(id = "password")//without findby, web element will be null
    public WebElement passwordInput;

    public LoginPage() {
        //it's mandatory if you want to use @FindBy annotation
        //this means LoginPage class
        //Driver.get() return webdriver object
        PageFactory.initElements(Driver.get(), this);
    }

    /**
     * reusable login method
     * just call this method to login
     * provide username and password as parameters
     * @param userName
     * @param password
     */

    public void login(String userName, String password){
        userNameInput.sendKeys(userName);
        //Keys.ENTER to replace login click
        passwordInput.sendKeys(password,Keys.ENTER);

    }


    public void login(String role) {
        String userName = "";
        String password = "";

        switch (role) {
            case "crm manager":
                userName = ConfigurationReader.getProperty("crm_manager");
                password = ConfigurationReader.getProperty("crm_manager_password");
                break;
            case "pos manager":
                userName = ConfigurationReader.getProperty("pos_manager");
                password = ConfigurationReader.getProperty("pos_manager_password");
                break;
            default:
                throw new RuntimeException("Invalid role!");
        }
        login(userName, password);
    }

}