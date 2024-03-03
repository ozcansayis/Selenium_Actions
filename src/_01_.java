import Utility.BaseDriver;
import Utility.MyFunction;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _01_ extends BaseDriver {
    @Test
    public void _01_(){
        Actions actions=new Actions(driver);
        driver.get("http://dhtmlgoodies.com/scripts/drag-drop-quiz/drag-drop-quiz-d2.html");
        List<WebElement> capitals= driver.findElements(By.cssSelector("[class='dragDropSmallBox'][id^='a']"));
        List<WebElement> countries=driver.findElements(By.cssSelector("[class='dragDropSmallBox'][id^='q']"));
        for (WebElement e: capitals){
            for (WebElement ee: countries){
                if (e.getAttribute("id").substring(1).equals(ee.getAttribute("id").substring(1))){
                    actions.clickAndHold(e).build().perform();
                    MyFunction.Wait(1);
                    actions.moveToElement(ee).release().build().perform();
                }
            }
        }
        WaitAndClose();
    }
}