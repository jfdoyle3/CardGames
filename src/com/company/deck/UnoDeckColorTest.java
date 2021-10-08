package com.company.deck;

import com.company.card.AltCard;
import com.company.card.UnoCard;

import java.util.ArrayList;
import java.util.List;

public class UnoDeckColorTest {

    private final static UnoColor[] COLORS = {UnoColor.RED,UnoColor.GREEN,UnoColor.BLUE,UnoColor.YELLOW};
    private final static UnoColor[] COLORS_BOLD = {UnoColor.RED_BOLD,UnoColor.GREEN_BOLD,UnoColor.BLUE_BOLD,UnoColor.YELLOW_BOLD};
    private final static UnoColor[] COLORS_BRIGHT = {UnoColor.RED_BRIGHT,UnoColor.GREEN_BRIGHT,UnoColor.BLUE_BRIGHT,UnoColor.YELLOW_BRIGHT};
    private final static UnoColor[] COLORS_BOLD_BRIGHT = {UnoColor.RED_BOLD_BRIGHT,UnoColor.GREEN_BOLD_BRIGHT,UnoColor.BLUE_BOLD_BRIGHT,UnoColor.YELLOW_BOLD_BRIGHT};
    private final static UnoColor[] COLORS_BACKGROUND = {UnoColor.RED_BACKGROUND,UnoColor.GREEN_BACKGROUND,UnoColor.BLUE_BACKGROUND,UnoColor.YELLOW_BACKGROUND};
    private final static UnoColor[] COLORS_BACKGROUND_BRIGHT= {UnoColor.RED_BACKGROUND_BRIGHT,UnoColor.GREEN_BACKGROUND_BRIGHT,UnoColor.BLUE_BACKGROUND_BRIGHT,UnoColor.YELLOW_BACKGROUND_BRIGHT};

    private final static int[] VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 4 colors of each 2 per color,   Zero Card: 4 colors 1 per color = 76 cards
    private final static int[] ACTIONS={13,14,15}; // 13 = Draw 2, 14 = Reverse, 15 = Skip - 4 of each 2 per color = 24 cards
    private final static int WILD=98; // 4 Wild Cards  / ( 4  4+ Wild ) not used- extra challenge = 8 cards
    private List<AltCard> altCards;
    private List<AltCard> cardsBold;
    private List<AltCard> cardsBright;
    private List<AltCard> cardsBoldBright;
    private List<AltCard> cardsBackground;
    private List<AltCard> cardsBackgroundBright;
    private boolean isEmpty=false;

    public UnoDeckColorTest() {
        altCards = new ArrayList<>();
        cardsBold=new ArrayList<>();
        cardsBright=new ArrayList<>();
        cardsBoldBright = new ArrayList<>();
        cardsBackground = new ArrayList<>();
        cardsBackgroundBright = new ArrayList<>();

        for (UnoColor color : COLORS) {
            for (int value : VALUES) {
                altCards.add(new UnoCard(value, color));
                altCards.add(new UnoCard(value, color));
            }
            altCards.add(new UnoCard(0, color));
        }
         System.out.println(altCards.toString());
        for (UnoColor color : COLORS_BOLD) {
            for (int value : VALUES) {
                cardsBold.add(new UnoCard(value, color));
                cardsBold.add(new UnoCard(value, color));
            }
            cardsBold.add(new UnoCard(0, color));
        }
        System.out.println(cardsBold.toString());
        for (UnoColor color : COLORS_BRIGHT) {
            for (int value : VALUES) {
                cardsBright.add(new UnoCard(value, color));
                cardsBright.add(new UnoCard(value, color));
            }
            cardsBright.add(new UnoCard(0, color));
        }
        System.out.println(cardsBright.toString());
        for (UnoColor color : COLORS_BOLD_BRIGHT) {
            for (int value : VALUES) {
                cardsBoldBright.add(new UnoCard(value, color));
                cardsBoldBright.add(new UnoCard(value, color));
            }
            cardsBoldBright.add(new UnoCard(0, color));
        }
        System.out.println(cardsBoldBright.toString());
        for (UnoColor color : COLORS_BACKGROUND) {
            for (int value : VALUES) {
                cardsBackground.add(new UnoCard(value, color));
                cardsBackground.add(new UnoCard(value, color));
            }
            cardsBackground.add(new UnoCard(0, color));
        }
        System.out.println(cardsBackground.toString());
        for (UnoColor color : COLORS_BACKGROUND_BRIGHT) {
            for (int value : VALUES) {
                cardsBackgroundBright.add(new UnoCard(value, color));
                cardsBackgroundBright.add(new UnoCard(value, color));
            }
            cardsBackgroundBright.add(new UnoCard(0, color));
        }
        System.out.println(cardsBackgroundBright.toString());
    }

    @Override
    public String toString() {
        return "UnoDeck: " +
                altCards.toString();
    }
}
