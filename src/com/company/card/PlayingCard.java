package com.company.card;

public class PlayingCard extends Card {
    private final int rank;
    private final String suit;

    public PlayingCard(int rank, String suit) {
        super(rank,suit);

        this.rank= rank;
        this.suit = suit;
    }

    public PlayingCard(boolean isFaceDown, int rank, String suit) {
        super(rank,suit);
        this.rank = rank;
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

    @Override
    public String display() {
        return null;
    }

    public void flip() {
        isFaceDown = !isFaceDown;
    }

    public int getValue() {
        return this.rank;
    }

    public boolean isFaceDown() {
        return isFaceDown;
    }

    @Override
    public String toString() {
        return "PlayingCard{" +
                "faceDown=" + isFaceDown +
                ", value=" + rank +
                ", color='" + suit + '\'' +
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