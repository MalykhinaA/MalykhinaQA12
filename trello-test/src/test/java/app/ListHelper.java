package app;

import model.ListData;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ListHelper extends HelperBase{
    public ListHelper(FirefoxDriver wd) {
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

    public void initListArchiving() {
        click(By.xpath("//*[@class='icon-sm icon-overflow-menu-horizontal']"));
    }
    public void addList(String listTitle) {
        initListAdding();
        typeListTitle(new ListData(listTitle));
        submitListCreation();
    }
}
