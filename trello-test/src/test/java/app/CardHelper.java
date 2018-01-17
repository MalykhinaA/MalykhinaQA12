package app;

import model.CardData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CardHelper extends HelperBase {

    public CardHelper(WebDriver wd) {
        super(wd);
    }

    //CardAddingMethod
    public void confirmCardAdding() {
        click(By.xpath("//*[@class='primary confirm mod-compact js-add-card']"));
    }

    public int getCardCount() {
        return wd.findElements(By.xpath("//*[@class='list-card-title js-card-name']")).size();
    }

    public void typeCardTitle(CardData cardData) {
        type(By.xpath("//*[@class='list-card-composer-textarea js-card-title']"), "cardTitle");
    }

    public void initCardAdding() {
        click(By.xpath("//*[@class='open-card-composer js-open-card-composer']"));
    }

    //CardArchivingMethods
    public void closeCard() {
        click(By.xpath("//*[@class='icon-lg icon-close dialog-close-button js-close-window']"));
    }

    public void submitCardArchiving() {
        click(By.xpath("//*[@class='button-link js-archive-card']"));
    }

    public void openCard() {
        click(By.xpath("//*[@class='list-card-details']"));
    }

    //adds
    public void addCard(String cardTitle) {
        initCardAdding();
        typeCardTitle(new CardData(cardTitle));
        confirmCardAdding();
    }
}
