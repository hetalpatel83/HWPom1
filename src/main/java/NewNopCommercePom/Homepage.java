package NewNopCommercePom;

import org.openqa.selenium.By;

public class Homepage extends Utils
{
    private By _registerLink = By.linkText("Register");

    public void clickOnRegisterButton(){
        clickElementBy(_registerLink);
    }

}
