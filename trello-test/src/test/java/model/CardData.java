package model;

public class CardData {
    private String cardTitle;

    public String getCardTitle() {
        return cardTitle;
    }

    public CardData withCardTitle(String cardTitle) {
        this.cardTitle = cardTitle;
        return this;
    }
}
