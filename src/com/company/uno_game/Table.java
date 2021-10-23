package com.company.uno_game;

import com.company.actors.Player;
import com.company.card.Card;
import com.company.ui.Console;
import com.company.ui.Input;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;

import java.util.*;


public class Table {

    private final List<Card> discardPile = new ArrayList<>();
    private Queue<Hand> players = new LinkedList<>();
    //   private  List<Hand> playersHand=new ArrayList<>();
    private int card;
    private Hand hand;
    private final String BREAK_LINE = "-";


    public void playGameQueue() {
        // *********************
        //Add Players
        // int playerCount = Input.getInt("How many players? 2-10", 2, 10, "Error");
        int playerCount = 4;
        for (int idx = 1; idx <= playerCount; idx++) {
            players.add(new Hand(new Player("Player " + idx)));

        }
        //*************************
        // Create Deck / Shuffle
        UnoDeck deck = new UnoDeck();
        deck.shuffle();

        // *************************
        //   Deal
        deal(playerCount, deck);
        Card firstCard = deck.unoDraw();
//        if(firstCard.getRank()>=10){
//            deck.insertCard(firstCard);

        discardPile.add(firstCard);


        /* ========================
           Start of Game Loop
         *  Check for empty deck - re-stack if is.
         *    hand=poll()   -  get player hand
         *    player chooses to play / draw - refactor
               input:menu
               play / draw ends turn
               play: plays card
               draw: add card to hand
         *    hand.add(Queue)
          *     end turn
          Game has to check for these cards at end of turn:
             Check discard Pile after turn.
                draw 2:   poll(), add cards , add() / itr: next(), add cards, add()
                skip:     poll, add() / itr: next(), add()
                reverse : call reverse method to reverse Queue

                wild:     during play, color menu
                wild +4:  poll(), add cards, add() / itr: next(), add cards, add()

             ==========================================

        */
        while (true) {

            // Check for empty Deck
            if (deck.isDeckEmpty()) {
                Deck newDeck = restackDeck();
                deck = (UnoDeck) newDeck;
            }

            // Get Card value for Action Cards played
            int card = cardPlayed().getRank();
            System.out.println(">>---> " + card);

            hand = players.poll();

            // UI
            System.out.println(hand.getName());
            System.out.print("Deck: |" + deck.deckSize() + "| |");
            if (discardPile.size() > 0) {
                System.out.println(discardPile.get(discardPile.size() - 1).display() + "| :Discard Pile");
            } else {
                System.out.println("empty| :Discard Pile");
            }
            System.out.println(hand.displayHand());


            // Game turn method - displays table and input/run choice
            System.out.println("Game Turn next");
            if (hand.getHandSize() != 0)
                gameTurn(hand, deck);
            else {
                endGame(hand);
                break;
            }

            players.add(hand);
//            if(hand.getHandSize()==0)
//                break;


        }
    }

    private void showTable() {
        System.out.println(BREAK_LINE.repeat(25));
        Iterator iterator = players.iterator();
        while (iterator.hasNext()) {
            hand = (Hand) iterator.next();
            System.out.println(hand.getName() + ":  " + hand.displayHandFaceDown());
            System.out.println(BREAK_LINE.repeat(25));
        }
    }

    private Queue reverse(Queue<Hand> q) {
        Stack<Hand> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.poll());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
        return q;
    }

    private void skipCard() {
        players.add(hand);
        players.poll();
        players.add(hand);
    }

    private Card cardPlayed() {
        Card card = discardPile.get(discardPile.size() - 1);
        return card;
    }

    private void itrPlayers() {
        Iterator iterator = players.iterator();

        while (iterator.hasNext()) {
            hand = (Hand) iterator.next();
            System.out.println(hand.getName() + " " + hand.displayHand());
        }
    }

    private void deal(int playerCount, UnoDeck deck) {
        int UNO_HAND = 7;
        for (int card = 0; card < playerCount * UNO_HAND; card++) {
            hand = players.poll();
            hand.addCard(deck.unoDraw());
            players.add(hand);
        }
    }


    private void endGame(Hand hand) {
        System.out.println(hand.getName() + " Wins");
        System.exit(0);
    }


    private void gameTurn(Hand hand, UnoDeck deck) {

        //  while (true) {
        boolean end = false;
        // Display Hand
        int min = 0;
        int max = hand.getHandSize() - 1;
        //       Console.displayTable(hand, deck, discardPile);
//        switch (discardPile.get(discardPile.size()-1).getRank()){
//            case 10 -> {drawTwo(hand, deck);
//                        isDraw2=false;}
//            case 12 -> System.out.println("Skipped");
//            case 11 -> System.out.println("Reverse");
//            default -> menuPrompt(hand, deck, min, max);
//
//        }

        // Pick Card by Index
//            int min = 0;
//            int max = hand.getHandSize() - 1;

        // Menu Prompt
        menuPrompt(hand, deck, min, max);

//        if(isSkip){
//            isSkip=false;
//        }
//        else {
//
//            // Pick Card by Index
//            int min = 0;
//            int max = hand.getHandSize() - 1;
//
//            // Menu Prompt
//            menuPrompt(hand, deck, min, max);
//        }

        System.out.println("end of Turn");
    }

    private Deck restackDeck() {
        Card topCard = discardPile.remove(discardPile.size() - 1);
        Deck newDeck = new UnoDeck(discardPile);
        newDeck.shuffle();
        discardPile.clear();
        discardPile.add(topCard);
        return newDeck;
    }

    private void menuPrompt(Hand hand, UnoDeck deck, int min, int max) {
        int menu = Input.getInt("1. play\n2. draw", 0, 5, "enter a number.");
        switch (menu) {
            case 0 -> System.exit(0);
            case 1 -> {
                // Play Card
                card = Input.getInt("pick a card " + min + " thru " + max, min, max, "enter a number.");
                playCard(hand, deck);
            }
            case 2 -> hand.addCard(deck.unoDraw());
            case 3 -> Console.displayDiscardPile(discardPile);
            case 4 -> {
                boolean end = true;
            }
            case 5 -> showTable();
            default -> System.out.println("Error!!");
        }
    }

    private void playCard(Hand hand, Deck deck) {
        Card playedCard = hand.getCard(card);
        Card pile = discardPile.get(discardPile.size() - 1);
        if (validateCardColor(playedCard, pile) || validateCardValue(playedCard, pile)) {
            discardPile.add(playedCard);
            hand.removeCard(card);
        }
        System.out.println("not a playable card");
    }

    private boolean validateCardColor(Card cardA, Card cardB) {
        return cardA.getSuit().equals(cardB.getSuit());
    }

    private boolean validateCardValue(Card cardA, Card cardB) {
        return cardA.getRank() == cardB.getRank();
    }

    //   NOT USED  -- POSSIBLE DELETE
    private static void validateCard(Card card) {
        if (card.getRank() == card.getRank() &&
                card.getSuit().equals(card.getSuit()))
            System.out.println("V/C: True");
        else
            System.out.println("V/C: False");
    }
}
