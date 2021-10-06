package com.company.deck;

import com.company.card.Card;
import com.company.card.UnoNumberCard;
import java.util.ArrayList;
import java.util.List;

public class UnoDeck {

    private final static UnoColor[] COLORS = {UnoColor.RED_BOLD_BRIGHT,UnoColor.GREEN_BOLD_BRIGHT,UnoColor.BLUE_BOLD_BRIGHT,UnoColor.YELLOW_BOLD_BRIGHT};
    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 4 colors of each 2 per color,   Zero Card: 4 colors 1 per color = 76 cards
    private final static int[] ACTIONS={13,14,15}; // 13 = Draw 2, 14 = Reverse, 15 = Skip - 4 of each 2 per color = 24 cards
    private final static int WILD=98; // 4 Wild Cards  / ( 4  4+ Wild ) not used- extra challenge = 8 cards
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

    public Card getCard(int index) {
        return cards.get(index);
    }

    @Override
    public String toString() {
        return "UnoDeck: " +
                cards.toString();
    }
}