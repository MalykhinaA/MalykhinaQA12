import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeleteGroup extends TestBase {
    @Test
    public void deleteGroup() {
        openGroupPage();
        //selectGroupTodelete
        selectGroupTodelete();
        //submitGroupDelete
        submitGroupDelete();
        //returnToGroupPage
        returnToGroupPage();
    }

    public void submitGroupDelete() {
        wd.findElement(By.xpath("//input[@name='delete']")).click();
    }

    public void selectGroupTodelete() {
        wd.findElement(By.xpath("//input[@type='checkbox']")).click();
    }
}
