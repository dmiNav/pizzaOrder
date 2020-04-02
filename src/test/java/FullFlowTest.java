import models.User;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.UserSteps;
import utils.DataFaker;

@RunWith(SerenityRunner.class)
public class FullFlowTest {

    private User testUser;

    @Managed
    private WebDriver driver;

    @Steps
    UserSteps user;

    @Before
    public void setUp() {
        testUser = new DataFaker().getUser();
    }

    @Test
    public void completeOrder() {
        user.atOrderPage.makeAnOrderForUser(testUser);
        user.atStatusPage.verifyNewOrderAddedForUser(testUser);

        user.atStatusPage.approveUserOrder(testUser);
        user.atStatusPage.completeUserOrder(testUser);
    }
}
