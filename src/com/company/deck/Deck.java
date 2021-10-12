package com.company.deck;

import com.company.card.Card;

public interface Deck {
    void shuffle();
 Card unoDraw();
    Card draw(boolean facing);

<<<<<<< HEAD
    Card draw();

    Card flipDraw();

    boolean isDeckEmpty();


=======
    boolean isDeckEmpty();
>>>>>>> development
}
