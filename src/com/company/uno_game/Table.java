package com.company.uno_game;

import com.company.card.Card;
import com.company.console.Input;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;

import java.util.ArrayList;
import java.util.List;


public class Table {

    /*
       discard deck:
       build a new deck
       list Card
       LinkedList Card

     */
    private List<Card> discardPile = new ArrayList<>();
    private int card;
    private Card firstCard;

    public void playGame() {
        Hand hand = new Hand();
        UnoDeck deck = new UnoDeck();
        //   System.out.println(deck.toString());
        deck.shuffle();
        dealHand(hand, deck, 7);
        firstCard = deck.unoDraw();
        discardPile.add(firstCard);
        turnDiscardDeck(hand, deck);
        //   gameTurn(hand, deck);

    }

    private void turnDiscardDeck(Hand hand, UnoDeck deck) {

        while (true) {

            // Display Hand
            displayTable(hand, deck);

            // Pick Card by Index
            int min = 0;
            int max = hand.getHandSize() - 1;

            // Menu Prompt
            int menu = Input.getInt("1. play\n2. draw", 0, 3, "enter a number.");
            switch (menu) {
                case 0 -> System.exit(0);
                case 1 -> {
                    // Play Card
                    card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                    playCard(hand);
                }
                case 2 -> hand.addCard(deck.unoDraw());
                case 3 -> displayDiscardPile();
                default -> System.out.println("Error!!");
            }

            //   Empty Hand breaks Loop
            if (hand.getHandSize() == 0 || deck.isDeckEmpty())
                break;
        }
        System.out.println("ran out of cards");
        System.out.println("end of line.");
    }

    private void displayTable(Hand hand, Deck deck) {
        System.out.print("Deck: |" + deck.deckSize() + "| |");
        showTopOfPile();
        showHand(hand);
    }

    private void playCard(Hand hand) {

        Card playedCard = hand.getCard(card);
        Card pile=discardPile.get(discardPile.size() - 1);
        if (validateCardColor(playedCard, pile) || validateCardValue(playedCard,pile)) {
            discardPile.add(playedCard);
            hand.removeCard(card);
        }

        System.out.println("Can't Play card.");
    }

    private void showTopOfPile() {
        if (discardPile.size() > 0) {
            System.out.println(discardPile.get(discardPile.size() - 1).display() + "| :Discard Pile");
        } else {
            System.out.println("empty| :Discard Pile");
        }
    }

    private void displayDiscardPile() {
        String line = "-|-";
        System.out.println(line.repeat(4) + "| Discard Pile |" + line.repeat(4));
        for (Card card : discardPile)
            System.out.println(card.display());
        System.out.println(line.repeat(13));
    }

    private void showHand(Hand hand) {
        System.out.println(hand.displayHand());
    }

    private void gameTurn(Hand hand, UnoDeck deck) {
        while (true) {
            showHand(hand);

            int min = 0;
            int max = hand.getHandSize() - 1;

            int menu = Input.getInt("1. play\n2. draw", 0, 3, "enter a number.");
            switch (menu) {
                case 1 -> {
                    card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                    Card discard = hand.removeCard(card);
                }
                case 3 -> displayDiscardPile();
                case 2 -> hand.addCard(deck.unoDraw());
                default -> System.out.println("Error!!");
            }

            if (hand.getHandSize() == 0 || deck.isDeckEmpty())
                break;
        }
        System.out.println("ran out of cards");
    }

    private void dealHand(Hand hand, UnoDeck deck, int handCount) {
        for (int crd = 0; crd < handCount; crd++) {
            hand.addCard(deck.unoDraw());
        }
    }
    //   validateCard(carda, cardb);

    // Comparing Card Value
    //  validateCardValue(card);


    //Compare Card Color


    private static void validateCardColorZ(Card cardA, Card cardB) {
        if (cardA.getSuit().equals(cardB.getSuit()))
            System.out.println("C: True- Colors Match");
        else
            System.out.println("C: False - False");
    }

    private boolean validateCardColor(Card cardA, Card cardB) {
        return cardA.getSuit().equals(cardB.getSuit());
    }

    //    private static void validateCardValue(UnoDeck deck) {
//        if (deck.getValue(0) == deck.getValue(1))
//            System.out.println("V: True");
//        else
//            System.out.println("V: False");
//    }
    private boolean validateCardValue(Card cardA, Card cardB) {
        return cardA.getRank() == cardB.getRank();

    }

    private static void validateCard(Card card) {
        if (card.getRank() == card.getRank() &&
                card.getSuit().equals(card.getSuit()))
            System.out.println("V/C: True");
        else
            System.out.println("V/C: False");
    }


}
