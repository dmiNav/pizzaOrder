package pages;

import models.User;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DefaultUrl("http://localhost:4200/order-status")
public class StatusPage extends PageObject {

    private String acceptBtnXpath = ".//span[@class='accept']";
    private String cancelBtnXpath = ".//span[@class='cancel']";
    private String statusAcceptedXpath = ".//span[@class='accepted']";
    private String statusCompletedXpath = ".//span[@class='completed']";
    private String completedBtnXpath = "./div[contains(@class, 'mark-completed')]";

    @FindBy(xpath = "//div[contains(@class,'table-body')]")
    private List<WebElementFacade> orders;

    public void verifyTableContainsOrder(User user) {
        var myOrder = getOrder(user);
        assertThat(myOrder).isNotNull();
    }

    public void clickApproveBtn(User user) {
        getOrder(user).findElement(By.xpath(acceptBtnXpath)).click();
    }

    public void verifyOrderApproved(User testUser) {
        assertThat(getOrder(testUser).findElement(By.xpath(statusAcceptedXpath)).getText())
                .isEqualTo("Accepted");
    }

    private WebElementFacade getOrder(User user) {
        return orders.stream()
                .filter(order -> order.getText().contains(user.getAddress()))
                .findFirst()
                .orElse(null);
    }

    public void clickCompletedBtn(User testUser) {
        getOrder(testUser).findElement(By.xpath(completedBtnXpath)).click();
    }

    public void verifyOrderCompleted(User testUser) {
        assertThat(getOrder(testUser).findElement(By.xpath(statusCompletedXpath)).getText())
                .isEqualTo("Completed");
    }
}
