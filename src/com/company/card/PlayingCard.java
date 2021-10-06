package com.company.card;

public class PlayingCard extends Card {
    private final int value;
    private final String color;

    public PlayingCard(int value, String color) {
        super(true);
        this.value = value;
        this.color = color;
    }

    public PlayingCard(boolean faceDown, int value, String suit) {
        super(faceDown);
        this.value = value;
        this.color = suit;
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

    @Override
    public String toString() {
        return "PlayingCard{" +
                "faceDown=" + faceDown +
                ", value=" + value +
                ", color='" + color + '\'' +
                '}';
    }

    //    public String toString() {
//        String output = switch (value) {
//            case 1 -> "A";
//            case 11 -> "J";
//            case 12 -> "Q";
//            case 13 -> "K";
//            default -> value == 10 ? Integer.toString(value) : "" + value;
//        };
//        return output + color;
//    }
}