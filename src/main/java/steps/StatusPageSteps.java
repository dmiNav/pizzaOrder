package steps;

import models.User;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import pages.StatusPage;

public class StatusPageSteps extends ScenarioSteps {

    private StatusPage page;

    @Step
    public void verifyNewOrderAddedForUser(User user) {
        page.open();
        page.verifyTableContainsOrder(user);
    }

    @Step
    public void approveUserOrder(User testUser) {
        page.clickApproveBtn(testUser);
        page.verifyOrderApproved(testUser);
    }

    @Step
    public void completeUserOrder(User testUser) {
        page.clickCompletedBtn(testUser);
        page.verifyOrderCompleted(testUser);
    }
}
