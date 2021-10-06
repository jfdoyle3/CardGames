package com.company.deck;

import com.company.card.Card;
import com.company.card.UnoCard;
import java.util.ArrayList;
import java.util.List;

public class UnoDeck implements Deck{

    private final static UnoColor[] COLORS = {UnoColor.RED_BOLD_BRIGHT,UnoColor.GREEN_BOLD_BRIGHT,UnoColor.BLUE_BOLD_BRIGHT,UnoColor.YELLOW_BOLD_BRIGHT};
    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 4 colors of each 2 per color,   Zero Card: 4 colors 1 per color = 76 cards
    private final static int[] ACTIONS={13,14,15}; // 13 = Draw 2, 14 = Reverse, 15 = Skip - 4 of each 2 per color = 24 cards
    private final static int WILD=98; // 4 Wild Cards  / ( 4  4+ Wild ) not used- extra challenge = 8 cards
    private List<UnoCard> cards;
    private boolean isEmpty=false;

    public UnoDeck() {
        cards = new ArrayList<>();
        for (UnoColor color : COLORS) {
            for (int value : VALUES) {
                cards.add(new UnoCard(value, color));
                cards.add(new UnoCard(value, color));
            }
            cards.add(new UnoCard(0, color));
        }
    }

    public UnoCard getCard(int index) {
        return cards.get(index);
    }

    public int getValue(int index){
        return getCard(index).getValue();
    }

    public UnoColor getColor(int index){
        return getCard(index).getColor();
    }

    @Override
    public String toString() {
        return "UnoDeck: " +
                cards.toString();
    }

    @Override
    public void shuffle() {

    }

    @Override
    public Card draw(boolean facing) {
        return null;
    }

    @Override
    public boolean deckEmpty() {
        return false;
    }
}