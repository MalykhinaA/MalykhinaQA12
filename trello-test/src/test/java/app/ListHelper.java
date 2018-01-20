package app;

import model.ListData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ListHelper extends HelperBase {
    public ListHelper(WebDriver wd) {
        super(wd);
    }

    //ListCreationMethods
    public void submitListCreation() {
        click(By.xpath("//*[@class='primary mod-list-add-button js-save-edit']"));
    }

    public int getListCount() {
        return wd.findElements(By.xpath("//*[@class='list js-list-content']")).size();
    }

    public void typeListTitle(ListData listData) {
        type(By.xpath("//*[@class='list-name-input']"), listData.getListTitle());
    }

    public void initListAdding() {
        click(By.xpath("//*[@class='placeholder js-open-add-list']"));
    }

    //ListArchivingMethods
    public void submitListArchiving() {
        click(By.xpath("//*[@class='js-close-list']"));
    }

    public void openListActions() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal']"));
    }
    public void openListActionsByIndex(int index) {
        wd.findElements(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal']")).get(index).click();
    }

    public void addList(ListData list) {
        initListAdding();
        typeListTitle(list);
        submitListCreation();
    }

    public boolean isListPresent() {
        return isElementPresent(By.xpath("//*[@class='list js-list-content']"));
    }
}
