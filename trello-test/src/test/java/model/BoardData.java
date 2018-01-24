package model;

public class BoardData {
    private String boardTitle;

    public String getBoardTitle() {
        return boardTitle;
    }

    public BoardData withBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
        return this;
    }
}
