package com.company.card;

import com.company.deck.UnoColor;

public class UnoCard extends Card {

        private final int value;
        private final String color;

    public UnoCard(int value, String color) {
        super(value, color);
        this.value = value;
        this.color = color;
    }

//    public UnoCard(int value, UnoColor color) {
//        super(true);
//        this.value = value;
//        this.color = color;
//    }

    // Abstract method for getters on Value/Rank , Color/Suit????

    public int getValue() {
        return value;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String display() {
        StringBuilder cardOutput=new StringBuilder();
        cardOutput.append(color).append(value).append(UnoColor.RESET);
        return  cardOutput.toString();
    }

    @Override
    public void flip() {

    }

    @Override
    public String toString() {
        StringBuilder cardOutput=new StringBuilder();
        cardOutput.append(color).append(value).append(UnoColor.RESET);
        return  cardOutput.toString();
               // color+UnoColor.RESET;
    }

}

