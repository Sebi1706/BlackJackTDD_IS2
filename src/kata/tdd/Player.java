package kata.tdd;

import java.util.List;
import kata.tdd.Card;

public class Player {
    private final List<Card> bet;

    
    public Player(List<Card> bet) {
        this.bet = bet;
    }

    
    public List<Card> getBet() {
        return bet;
    }

    
    public void addCard(Card card) {
        bet.add(card);
    }
}