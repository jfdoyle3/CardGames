package com.company.console;

import com.company.uno_game.Hand;

public class Console {

    public static void chooseCard(Hand hand){
        Input.getInt("Choose a card to play",0,hand.size(),"no such card");
    }
}
