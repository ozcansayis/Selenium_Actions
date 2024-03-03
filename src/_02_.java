import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _02_ extends BaseDriver {
    @Test
    public void _02_() {
        //http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html
        //buradaki bütün öğrencileri bütün kutucukları doldurana kadar atınız.
        Actions actions = new Actions(driver);
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-nodes/drag-drop-nodes.html");
        List<WebElement> nodes = driver.findElements(By.cssSelector("[id^='node']"));
        List<WebElement> box = driver.findElements(By.cssSelector("[id^='box']"));
        int y=0;
        for (WebElement e : nodes) {
            actions.clickAndHold(e).build().perform();
            MyFunction.Wait(1);
            int x= Integer.parseInt(e.getAttribute("id").substring(4))%5;
            if (x==3)
                y++;
            if (y==4) {
                actions.moveToElement(box.get(4)).release().build().perform();
                continue;
            }
            actions.moveToElement(box.get(x)).release().build().perform();
        }
        WaitAndClose();
    }
}