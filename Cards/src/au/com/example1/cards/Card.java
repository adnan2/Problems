package au.com.example1.cards;

/**
 *
 * @author Adnan
 */
public enum Card {

    CLUBS_ACE_WITH_1(1),
    CLUBS_ACE_WITH_11(11),
    CLUBS_2(2),
    CLUBS_3(3),
    CLUBS_4(4),
    CLUBS_5(5),
    CLUBS_6(6),
    CLUBS_7(7),
    CLUBS_8(8),
    CLUBS_9(9),
    CLUBS_10(10),
    CLUBS_JACK(10),
    CLUBS_QUEEN(10),
    CLUBS_KING(10),
    DIAMONDS_ACE_WITH_1(1),
    DIAMONDS_ACE_WITH_11(11),
    DIAMONDS_2(2),
    DIAMONDS_3(3),
    DIAMONDS_4(4),
    DIAMONDS_5(5),
    DIAMONDS_6(6),
    DIAMONDS_7(7),
    DIAMONDS_8(8),
    DIAMONDS_9(9),
    DIAMONDS_10(10),
    DIAMONDS_JACK(10),
    DIAMONDS_QUEEN(10),
    DIAMONDS_KING(10),
    HEARTS_ACE_WITH_1(1),
    HEARTS_ACE_WITH_11(11),
    HEARTS_2(2),
    HEARTS_3(3),
    HEARTS_4(4),
    HEARTS_5(5),
    HEARTS_6(6),
    HEARTS_7(7),
    HEARTS_8(8),
    HEARTS_9(9),
    HEARTS_10(10),
    HEARTS_JACK(10),
    HEARTS_QUEEN(10),
    HEARTS_KING(10),
    SPADES_ACE_WITH_1(1),
    SPADES_ACE_WITH_11(11),
    SPADES_2(2),
    SPADES_3(3),
    SPADES_4(4),
    SPADES_5(5),
    SPADES_6(6),
    SPADES_7(7),
    SPADES_8(8),
    SPADES_9(9),
    SPADES_10(10),
    SPADES_JACK(10),
    SPADES_QUEEN(10),
    SPADES_KING(10);

    private String cardName;
    private Integer faceValue = 0;

    Card(String uniqueName, Integer faceValue) {
        this.faceValue = faceValue;
        this.cardName = uniqueName;
    }

    Card(Integer faceValue) {
        this.faceValue = faceValue;
        if (name().contains("_WITH")) {
            this.cardName = name().substring(0, name().indexOf("_WITH"));
        } else {
            this.cardName = name();
        }

    }

    public Integer getFaceValue() {
        return faceValue;
    }

    public String getCardName() {
        return cardName;
    }

}
