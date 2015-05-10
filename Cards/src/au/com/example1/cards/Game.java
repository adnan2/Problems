package au.com.example1.cards;

import static au.com.example1.cards.Card.*;

/**
 *
 * @author Adnan
 */
public class Game {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Game().play(CLUBS_ACE_WITH_11, CLUBS_10);
    }

    public void play(Card card1, Card card2) {
        System.out.println("Move: with card1:" + card1.getCardName() + " and card2:" + card2.getCardName());
        if (card1.getCardName().equals(card2.getCardName())) {
            throw new IllegalArgumentException("Both cards are same :" + card1.getCardName());
        }
        int value1 = card1.getFaceValue();
        int value2 = card2.getFaceValue();
        int total = value1 + value2;
        System.out.println("Total : " + total);
    }

}
