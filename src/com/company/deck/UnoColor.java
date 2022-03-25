package com.company.deck;

public enum UnoColor {

    // WILD
    WILD("\033[1;91m"+"W"+"\033[0m"+
               "\033[1;92m"+"I"+"\033[0m"+
               "\033[1;93m"+"L"+"\033[0m"+
               "\033[1;94m"+"D"+"\033[0m"),
    // SUITS
    HEARTS("\033[1;91m"+"♥"+"\033[0m"),
    SPADES( "\033[1;90m"+"♠"+"\033[0m"),
    CLUBS("\033[1;90m"+"♧"+"\033[0m"),
    DIAMONDS ("\033[1;91m"+"♦"+"\033[0m"),


    //Color end string, color reset
    RESET("\033[0m"),

    // Regular Colors. Normal color, no bold, background color etc.
    BLUE("\033[0;34m"),     // BLUE

    // Bold
    RED_BOLD("\033[1;31m"),     // RED
    CYAN_BOLD("\033[1;36m"),    // CYAN


    // Bold High Intensity
    BLACK_BOLD_BRIGHT("\033[1;90m"),    // BLACK
    RED_BOLD_BRIGHT("\033[1;91m"),      // RED
    GREEN_BOLD_BRIGHT("\033[1;92m"),    // GREEN
    YELLOW_BOLD_BRIGHT("\033[1;93m"),   // YELLOW
    BLUE_BOLD_BRIGHT("\033[1;94m");     // BLUE


    private static Actor hand;
    private final String code;

    UnoColor(String code) {
        this.code = code;
    }


    @Override
    public String toString() {
        return code;
    }
}
