package com.company.deck;

import com.company.card.Card;
import com.company.card.UnoNumberCard;
import java.util.ArrayList;
import java.util.List;

public class UnoDeck {

    private final static UnoColor[] COLORS = {UnoColor.RED,UnoColor.GREEN,UnoColor.BLUE,UnoColor.YELLOW};
    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9};
    private final static int[] ACTIONS={13,15,16};
    private final static int WILD=98;
    private List<Card> cards;
    private boolean isEmpty=false;

    public UnoDeck() {
        cards = new ArrayList<>();
        for (UnoColor color : COLORS) {
            for (int value : VALUES) {
                cards.add(new UnoNumberCard(value, color));
                cards.add(new UnoNumberCard(value, color));
            }
            cards.add(new UnoNumberCard(0, color));
        }

    }

    @Override
    public String toString() {
        return "UnoDeck: " +
                cards.toString();
    }
}
