package pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.support.FindBy;

import java.util.Collections;
import java.util.List;
import java.util.Random;

@DefaultUrl("http://localhost:4200/new-order")
public class NewOrderPage extends PageObject {

    @FindBy(xpath = "//input[@ng-reflect-name='name']")
    private WebElementFacade nameInput;

    @FindBy(xpath = "//input[@ng-reflect-name='email']")
    private WebElementFacade emailInput;

    @FindBy(xpath = "//input[@ng-reflect-name='address']")
    private WebElementFacade addressInput;

    @FindBy(xpath = "//input[@ng-reflect-name='phone']")
    private WebElementFacade phoneInput;

    @FindBy(xpath = "//button[@ng-reflect-klass='btn order-btn']")
    private WebElementFacade placeOrderBtn;

    @FindBy(xpath = "//div[@class='pizza-size']//button")
    private List<WebElementFacade> pizzaSizes;

    @FindBy(xpath = "//div[@class='pizza-toppings']//button")
    private List<WebElementFacade> pizzaToppings;

    public void enterName(String name) {
        nameInput.sendKeys(name);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterAddress(String address) {
        addressInput.sendKeys(address);
    }

    public void enterPhone(String phone) {
        phoneInput.sendKeys(phone);
    }

    public void clickPlaceOrder() {
        placeOrderBtn.click();
    }

    public void selectRandomSize() {
        pizzaSizes.get(new Random().nextInt(pizzaSizes.size()))
                .click();
    }

    public void selectRandomToppings(int count) {
        for (int i = 0; i < count; i++) {
            pizzaToppings.get(new Random().nextInt(pizzaToppings.size())).click();
        }
    }

    public void acceptAlert() {
        getAlert().accept();
    }
}
