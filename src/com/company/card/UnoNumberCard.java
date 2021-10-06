package com.company.card;

import com.company.deck.UnoColor;

public class UnoNumberCard extends Card {

        private final int value;
        private final UnoColor color;
//    private final static UnoColor[] COLORS = {UnoColor.RED,UnoColor.GREEN,UnoColor.BLUE,UnoColor.YELLOW};
//    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9};


    public UnoNumberCard(int value, UnoColor color) {
        super(true);
        this.value = value;
        this.color = color;
    }


    @Override
    public void flip() {

    }

    @Override
    public String toString() {
        return "|" +
                color + value +
                UnoColor.RESET+
                '|';
    }
}

