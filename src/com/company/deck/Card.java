package com.company.card;

public class Card {

    protected boolean faceDown;
    private int value;
    private String suit;


    public Card(int value, String suit) {
        this.value = value;
        this.suit = suit;
        this.faceDown = true;

    }

    public void flip() {
        faceDown = !faceDown;
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
