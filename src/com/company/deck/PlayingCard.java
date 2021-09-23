package com.company.deck;

public class PlayingCard extends Card{
    private int value;
    private String suit;

    public PlayingCard(int value, String suit) {
        super(true);
        this.value = value;
        this.suit = suit;
    }

    public PlayingCard(boolean faceDown, int value, String suit) {
        super(faceDown);
        this.value = value;
        this.suit = suit;
    }



//    public String getCardFace() {
//        if (this.faceDown)
//            return this.cardFace;
//        return "[#]";
//    }


//    @Override
//    public String toString() {
//        return "Card{ faceUpDown: " + faceDown + ", cardFace: '" + cardFace + " }";
//    }

    public void flip() {
        faceDown = !faceDown;
    }

    public int getValue() {
        return this.value;
    }

    public boolean isFaceDown() {
        return faceDown;
    }

    public String toString() {
        String output = "";
        switch (value) {
            case 1:
                output = "A";
                break;
            case 11:
                output = "J";
                break;
            case 12:
                output = "Q";
                break;
            case 13:
                output = "K";
                break;
            default:
                output = value == 10 ? Integer.toString(value) : "" + value;
        }
        return output + suit;
    }
}