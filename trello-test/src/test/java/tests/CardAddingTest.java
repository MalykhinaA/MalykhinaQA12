package tests;

import model.BoardData;
import model.CardData;
import model.ListData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CardAddingTest extends TestBase {
    @Test
    public void cardAddingTest() {
        if (!appManager.boards().isBoardPresent()) {
            appManager.boards().createBoard(new BoardData().withBoardTitle("New board Title"));
        }
        int boardCount = appManager.boards().getBoardCount();
        appManager.goTo().openBoardByIndex(boardCount - 1);
        if (!appManager.lists().isListPresent()) {
            appManager.lists().addList(new ListData().withListTitle("title of list"));
        }
        int listCount = appManager.lists().getListCount();
        int before = appManager.cards().getCardCount();
        appManager.lists().openListActionsByIndex(listCount-1);
        appManager.cards().initCardAdding();
        appManager.cards().typeCardTitle(new CardData().withCardTitle("new card"));
        appManager.cards().confirmCardAdding();
        int after = appManager.cards().getCardCount();
        Assert.assertEquals(before, after - 1);
        appManager.goTo().boardsPage();
    }




}
