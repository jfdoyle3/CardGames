package com.company.deck;

public interface Actor {
    byte getAction(Hand hand, int dealer);

    int placeBet();

    int getBalance();

    String getName();

    void addBalance(int i);
}
