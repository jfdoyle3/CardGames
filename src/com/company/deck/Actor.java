package com.company.deck;

import com.company.uno_game.Hand;

public interface Actor {
    byte getAction(Hand hand, int dealer);

    int placeBet();

    int getBalance();

    String getName();

    void addBalance(int i);
}
