package application;

import model.GroupData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GroupHelper extends HelperBase {

    public GroupHelper(FirefoxDriver wd) {
        super(wd);
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }


    public void submitGroupCreate() {
        click(By.name("submit"));
    }

    public void returnToGroupPage() {
        click(By.linkText("group page"));
    }

    public void submitGroupDelete() {
        click(By.xpath("//input[@name='delete']"));
    }

    public void selectGroupTodelete() {
        click(By.xpath("//input[@type='checkbox']"));
    }

    public void fillGroupForm(GroupData groupData) {
        type(By.name("group_name"), groupData.getGroupName());
        type(By.name("group_header"), groupData.getHeader());
        type(By.name("group_footer"), groupData.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }
}
