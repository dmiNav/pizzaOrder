package steps;

import models.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.NewOrderPage;

public class OrderPageSteps extends ScenarioSteps {

    private NewOrderPage page;

    @Step
    public void makeAnOrderForUser(User user) {
        page.open();
        page.enterName(user.getName());
        page.enterAddress(user.getAddress());
        page.enterEmail(user.getEmail());
        page.enterPhone(user.getPhone());

        page.selectRandomSize();
        page.selectRandomToppings(3);

        page.clickPlaceOrder();

        page.acceptAlert();
    }
}
