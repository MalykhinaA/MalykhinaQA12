package tests;

import model.BoardData;
import model.CardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardArchivingTest extends TestBase {
    @Test
    public void cardArchivingTest() {
        if (!appManager.boards().isBoardPresent()) {
            appManager.boards().createBoard(new BoardData().withBoardTitle("New board Title"));
        }
       appManager.goTo().pause(2000);
        int boardCount = appManager.boards().getBoardCount();
       // app.getNavigationHelper().openBoard();
        appManager.goTo().openBoardByIndex(boardCount - 1);
        if (!appManager.lists().isListPresent()) {
            appManager.lists().addList(new ListData().withListTitle("List Title"));
        }
        if (!appManager.cards().isCardPresent()) {
            appManager.cards().addCard(new CardData().withCardTitle("Card Title"));
        }
        int before = appManager.cards().getCardCount();
        //app.getCardHelper().openCard();
        appManager.cards().openCardByIndex(before - 1);
        //submitCardArchiving
        appManager.cards().submitCardArchiving();
        //closeCard
        appManager.cards().closeCard();
        int after = appManager.cards().getCardCount();
        Assert.assertEquals(before, after + 1);
        appManager.goTo().boardsPage();

    }


}
