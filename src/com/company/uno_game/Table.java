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

    public void playGame() {
        Hand hand = new Hand();
        UnoDeck deck = new UnoDeck();
        //   System.out.println(deck.toString());
        deck.shuffle();
        dealHand(hand, deck, 7);
        turnDiscardDeck(hand, deck);
        //   gameTurn(hand, deck);

    }

    private void turnDiscardDeck(Hand hand, UnoDeck deck) {

        while (true) {

            // Display Hand
            displayTable(hand,deck);

            // Pick Card by Index
            int min = 0;
            int max = hand.getHandSize() - 1;

            // Menu Prompt
            int menu = Input.getInt("1. play\n2. draw", 1, 2, "enter a number.");
            if (menu == 1) {

                // Play Card
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                playCard(hand);

            } else {

                // Draw card
                hand.addCard(deck.unoDraw());
            }

            //   Empty Hand breaks Loop
            if (hand.getHandSize() == 0 || deck.isDeckEmpty())
                break;
        }
        System.out.println("ran out of cards");
        System.out.println("end of line.");
    }

    private void displayTable(Hand hand, Deck deck) {
        System.out.print("Deck: "+deck.deckSize()+" ");
        showTopOfPile();
        showHand(hand);
    }

    private void playCard(Hand hand) {
        Card discard = hand.removeCard(card);
        discardPile.add(discard);
        showTopOfPile();

        //       displayDiscardPile();


    }

    private void showTopOfPile() {

        if (discardPile.size() > 0) {
            System.out.println(discardPile.get(discardPile.size() - 1));
        } else {
            System.out.println("Discard pile empty");
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

            int menu = Input.getInt("1. play\n2. draw", 1, 2, "enter a number.");
            if (menu == 1) {
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                Card discard = hand.removeCard(card);

            } else {
                hand.addCard(deck.unoDraw());
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


}
