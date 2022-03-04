package com.company.uno_game;

import com.company.actors.Player;
import com.company.card.Card;
import com.company.card.UnoCard;
import com.company.deck.UnoColor;
import com.company.ui.Console;
import com.company.ui.Input;
import com.company.deck.Deck;
import com.company.deck.UnoDeck;

import java.util.*;


public class Table {

    private final List<Card> discardPile = new ArrayList<>();
    private Queue<Hand> players = new LinkedList<>();
    private final static UnoColor[] COLORS = {UnoColor.RED_BOLD_BRIGHT, UnoColor.GREEN_BOLD_BRIGHT, UnoColor.BLUE_BOLD_BRIGHT, UnoColor.YELLOW_BOLD_BRIGHT};
    private int card;
    private Hand hand;
    private boolean isActionCard = false;


    public void playGame() {
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


        while (true) {

            // Check for empty Deck
            deck = getUnoDeck(deck);


            // Get Player
            hand = players.poll();

            // Console display
            Console.displayPlayer(deck, discardPile, hand);


            // UI: player turn - menu input
            playerChoice(deck);

            if (hand.getHandSize() == 1) {
                Console.actionCardMessage(hand.getName(), " UNO!!");
            }
            if (hand.getHandSize() == 0) {
                Console.actionCardMessage(hand.getName(), " WINS!!!");
                System.exit(0);
            }
            players.add(hand);
            // player made a choice
            // end turn
            int card;
            // Card played evaluation for Action/Wild card
            // Get Card value for Action Cards played
            if (isActionCard)
                card = cardPlayed().getRank();
            else
                card = 9;

            //Action cards
            switch (card) {
                case 10 -> draw2Card(deck);
                case 11 -> reverseCard();
                case 12 -> skippedCard();
                case 13 -> wildCard();
                case 14 -> wild4Card(deck);
                default -> System.out.println("error");
            }
        }
    }

    private void playerChoice(UnoDeck deck) {
        int min = 0;
        int max = hand.getHandSize() - 1;
        int menu = Input.getInt("1. Play a card\n2. draw a card\n3. Display table", 1, 3, "enter a number.");
        switch (menu) {

            case 1: {
                isActionCard = true;
                // Play Card
                card = Input.getInt("If you don't have a card to play\npick any card and a card will be drawn.\npick a card " + min + " thru " + max,
                        min,
                        max,
                        "enter a number.");

                Card playedCard = hand.getCard(card);
                Card pile = discardPile.get(discardPile.size() - 1);
                if (validateCardColor(playedCard, pile) || validateCardValue(playedCard, pile) || playedCard.getRank() >= 13) {
                    discardPile.add(playedCard);
                    hand.removeCard(card);
                    break;
                }
                System.out.println("not a playable card - Drawing a card.");
            }
            case 2: {
                isActionCard = false;
                hand.addCard(deck.unoDraw());
                break;
            }
            case 3: {
                Console.showTable(players);
                Console.displayPlayer(deck, discardPile, hand);
                playerChoice(deck);
                break;
            }
            default: {
                System.out.println("Error!!");
                break;
            }
        }
    }


    private void draw2Card(UnoDeck deck) {
        hand = players.poll();
        Console.actionCardMessage(hand.getName(), " Drew 2 Cards.");
        hand.addCard(deck.unoDraw());
        hand.addCard(deck.unoDraw());
        players.add(hand);
    }

    private void wild4Card(UnoDeck deck) {
        int card;
        int colorChoice = Input.getInt("Choose Color:\n1. Red\n2. Green\n3. Blue\n4. Yellow", 1, 4, "error");
        Card dupeCard = new UnoCard(14, COLORS[colorChoice - 1].toString());
        discardPile.set(discardPile.size() - 1, dupeCard);
        hand = players.poll();
        Console.actionCardMessage(hand.getName(), " Drew 4 Cards.");
        for (card = 1; card <= 4; card++)
            hand.addCard(deck.unoDraw());
        players.add(hand);
    }

    private void wildCard() {
        int colorChoice = Input.getInt("Choose Color:\n1. Red\n2. Green\n3. Blue\n4. Yellow", 1, 4, "error");
        Card dupeCard = new UnoCard(13, COLORS[colorChoice - 1].toString());
        discardPile.set(discardPile.size() - 1, dupeCard);
    }

    private void skippedCard() {
        hand = players.poll();
        Console.actionCardMessage(hand.getName() + "'s", " turn is Skipped");
        players.add(hand);
    }

    private void reverseCard() {
        players = reverse(players);
        hand = players.poll();
        Console.actionCardMessage(">>-->", " Reverse");
        players.add(hand);
    }


    private UnoDeck getUnoDeck(UnoDeck deck) {
        if (deck.isDeckEmpty()) {
            Deck newDeck = restackDeck();
            deck = (UnoDeck) newDeck;
        }
        return deck;
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


    private Deck restackDeck() {
        Card topCard = discardPile.remove(discardPile.size() - 1);
        Deck newDeck = new UnoDeck(discardPile);
        newDeck.shuffle();
        discardPile.clear();
        discardPile.add(topCard);
        return newDeck;
    }


    private boolean validateCardColor(Card cardA, Card cardB) {
        return cardA.getSuit().equals(cardB.getSuit());
    }

    private boolean validateCardValue(Card cardA, Card cardB) {
        return cardA.getRank() == cardB.getRank();
    }
}
