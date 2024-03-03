import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class _03_ extends BaseDriver {
    @Test
    public void _03_() {
        Actions actions = new Actions(driver);
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes-quiz/drag-drop-nodes-quiz.html");
        List<WebElement> objects = driver.findElements(By.cssSelector("[groupid^='box']"));
        List<WebElement> countries = driver.findElements(By.cssSelector("[id^='box']"));
        for (WebElement o : objects) {
            for (WebElement c : countries) {
                if (o.getAttribute("groupid").equals(c.getAttribute("id"))) {
                    actions.clickAndHold(o).build().perform();
                    MyFunction.Wait(1);
                    actions.moveToElement(c).release().build().perform();
                }
            }
        }
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        WaitAndClose();
    }
}
