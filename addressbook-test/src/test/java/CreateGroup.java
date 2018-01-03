import org.testng.annotations.Test;

import org.openqa.selenium.*;

public class CreateGroup extends TestBase {

    @Test
    public void createGroup() {
        //openGroupPage
        openGroupPage();
        //initGroupCreation
        initGroupCreation();
        //fillGroupForm
        fillGroupForm("New group", "Header", "Footer");
        //submitGroupCreate
        submitGroupCreate();
        //returnToGroupPage
        returnToGroupPage();
    }




    public void fillGroupForm(String groupName, String header, String footer) {
        wd.findElement(By.name("group_name")).click();
        wd.findElement(By.name("group_name")).clear();
        wd.findElement(By.name("group_name")).sendKeys(groupName);
        wd.findElement(By.name("group_header")).click();
        wd.findElement(By.name("group_header")).clear();
        wd.findElement(By.name("group_header")).sendKeys(header);
        wd.findElement(By.name("group_footer")).click();
        wd.findElement(By.name("group_footer")).clear();
        wd.findElement(By.name("group_footer")).sendKeys(footer);
    }

    public void initGroupCreation() {
        wd.findElement(By.name("new")).click();
    }


}
    
