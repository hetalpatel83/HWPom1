package NewNopCommercePom;

import org.junit.Test;
import org.openqa.selenium.By;

import static NewNopCommercePom.Utils.*;

public class RegistrationPage extends Utils
{
    LoadProperties loadProperties = new LoadProperties();
    private By _register = By.linkText("Register");
    private By _email = By.linkText("Computers");
    private By _register_Btn = By.id("register-button");
    private By _firstName = By.id("FirstName");
    private By _lastName = By.id("LastName");

    public void userShouldBeRegisterSuccessfully()
    {
        //Click on the register button
        clickElementBy(_register);
        //Select the male gender option
        clickElementBy(By.id("gender-male"));
        //Enter MyFirstName in First name field
        enterText(_firstName,loadProperties.getProperty("firstname"));
        //Enter MyLastName in Last name field
        enterText(_lastName,loadProperties.getProperty("lastName"));
        //Select the value 25 for Day field of Date of Birth
        selectByValue(By.name("DateOfBirthday"),loadProperties.getProperty("DOBDay"));
        //Select the value March for the Month field Date of Birth
        selectByIndex(By.name("DateOfBirtMonth"), 5);
        //Select the value 1982 for the Year field Date of Birth
        selectByValue(By.name("DateOfYear"),loadProperties.getProperty("DOBYear"));
        emailWithTimeStamp(_email);
        //Enter the value company in the company field
        enterText(By.id("Company"),loadProperties.getProperty("CompanyName"));
        //Enter the value password in the Password field
        enterText(By.id("Password"),loadProperties.getProperty("password"));
        //Enter the value password in the Confirm Password field
        enterText(By.id("ConfirmPassword"),loadProperties.getProperty("password"));
        //Click on register button
        clickElementBy(_register_Btn);
    }
    public void registrationConfirmation()
    {
        getActualText(By.xpath("//div[@class='result']"));
        //User should be able to see the message "Your registration completed" if successful
        validation(loadProperties.getProperty("confirmRegistration"));
        //Print Results
        System.out.println(actualResult);


    }
}
