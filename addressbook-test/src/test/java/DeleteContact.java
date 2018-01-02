import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

public class DeleteContact extends TestBase {
    @Test
    public void deleteContact() {
        //selectContactDelete
        selectContactDelete();
        //submitContactDelete
        submitContactDelete();
        alertAccept();




    }

    public void submitContactDelete() {
        wd.findElement(By.xpath("//input[@value='Delete']")).click();
    }

    public void selectContactDelete() {
        wd.findElement(By.xpath("//input[@type='checkbox']")).click();
    }
    public void alertAccept() {
        Alert alert;
        alert = wd.switchTo().alert();
        alert.accept();
    }
}
