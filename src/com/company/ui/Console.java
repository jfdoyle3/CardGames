package com.company.ui;

import com.company.actors.Player;
import com.company.card.Card;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;
import com.company.uno_game.Hand;

import java.util.List;

public class Console {

    public static void displayDiscardPile(List<Card> discardPile) {
        String line = "-|-";
        System.out.println(line.repeat(4) + "| Discard Pile |" + line.repeat(4));
        for (Card card : discardPile)
            System.out.println(card.display());
        System.out.println(line.repeat(13));
    }



    private static void showTopOfPile(List<Card> discardPile) {
        if (discardPile.size() > 0) {
            System.out.println(discardPile.get(discardPile.size() - 1) + "| :Discard Pile");
        } else {
            System.out.println("empty| :Discard Pile");
        }
    }

    private static void showHand(Hand hand) {
        System.out.println(hand.displayHand());
    }

    public static void displayTable( Hand hand, Deck deck, List<Card> discardPile) {
        System.out.println(hand.getName());
        System.out.print("Deck: |" + deck.deckSize() + "| |");
        showTopOfPile(discardPile);
        showHand(hand);
    }
    public static void menuPrompt(Hand hand, UnoDeck deck, int min, int max, List<Card> discardPile) {
        int menu = Input.getInt("1. play\n2. draw", 0, 3, "enter a number.");
        switch (menu) {
            case 0 -> System.exit(0);
            case 1 -> {
                // Play Card
//                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
//                playCard(hand);
            }
            case 2 -> hand.addCard(deck.unoDraw());
            case 3 -> Console.displayDiscardPile(discardPile);
            default -> System.out.println("Error!!");
        }
    }
}
