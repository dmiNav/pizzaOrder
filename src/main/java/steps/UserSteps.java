package steps;

import net.thucydides.core.annotations.Steps;
import net.thucydides.core.steps.ScenarioSteps;

public class UserSteps extends ScenarioSteps {

    @Steps
    public OrderPageSteps atOrderPage;

    @Steps
    public StatusPageSteps atStatusPage;
}
