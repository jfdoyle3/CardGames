package com.company.deck;

import com.company.card.Card;
import com.company.card.UnoCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class UnoDeck implements Deck {

    private final static UnoColor[] COLORS = {UnoColor.RED_BOLD_BRIGHT, UnoColor.GREEN_BOLD_BRIGHT, UnoColor.BLUE_BOLD_BRIGHT, UnoColor.YELLOW_BOLD_BRIGHT};
    private final static int[] VALUES = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // 4 colors of each 2 per color,   Zero Card: 4 colors 1 per color = 76 cards
    private final static int[] ACTIONS = {10, 11, 12}; // 10 = Draw 2, 11 = Reverse, 12 = Skip - 4 of each 2 per color = 24 cards
    private final static int[] WILD = {13,14}; // 4 Wild Cards  / ( 4  4+ Wild ) not used- extra challenge = 8 cards
    private List<Card> cards;
    private Random rand = new Random();

    public UnoDeck() {
        cards = new ArrayList<>();
        for (UnoColor color : COLORS) {
            for (int value : VALUES) {
                cards.add(new UnoCard(value, color.toString()));
                cards.add(new UnoCard(value, color.toString()));
            }
            cards.add(new UnoCard(0, color.toString()));

            cards.add(new UnoCard(ACTIONS[0],color.toString()));
            cards.add(new UnoCard(ACTIONS[0],color.toString()));
            cards.add(new UnoCard(ACTIONS[2],color.toString()));
            cards.add(new UnoCard(ACTIONS[2],color.toString()));
            cards.add(new UnoCard(ACTIONS[1],color.toString()));
            cards.add(new UnoCard(ACTIONS[1],color.toString()));
        }
        for(int crd=0; crd<4; crd++){
            for(int value : WILD){
                cards.add(new UnoCard(value,UnoColor.BLACK_BOLD_BRIGHT.toString()));
            }
        }

    }

    public UnoDeck(int deckSize) {
        cards = new ArrayList<>();
        for (int idx = 0; idx < deckSize; idx++) {
            cards.add(new UnoCard(rand.nextInt(9), COLORS[rand.nextInt(4)].toString()));
        }
    }

    public UnoDeck(List<Card> cardList) {
        cards = new ArrayList<>();
        for(Card card : cardList)
            cards.add(card);
    }
//        for (int idx=0; idx<12; idx++) {
//            for (UnoColor color : COLORS) {
//                for (int value : ACTIONS)
//                    cards.add(new UnoCard(value, color));
//            }
//        }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public int getValue(int index) {
        return getCard(index).getRank();
    }

    public String getColor(int index) {
        return getCard(index).getSuit();
    }

//    public void insertCard(Card card){ cards.add(card);}

    @Override
    public String toString() {
        return "UnoDeck: " +
                cards.toString();
    }

    public Card unoDraw() {
        return cards.remove(cards.size() - 1);
    }

    @Override
    public void shuffle() {
        Collections.shuffle(cards);
    }

    @Override
    public Card draw(boolean facing) {
        return null;
    }

    @Override
    public boolean isDeckEmpty() {
        return cards.size() == 0;
    }

    @Override
    public int deckSize() {
        return cards.size();
    }
}