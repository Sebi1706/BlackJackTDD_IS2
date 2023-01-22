package test;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import kata.tdd.Hand;
import static kata.tdd.Card.*;
import static org.junit.Assert.*;
import kata.tdd.Card;
import kata.tdd.Player;
import kata.tdd.BlackJack;

public class BlackJack_ {
    
    @Test
    public void given_two_cards_should_calculate_hand_value() {
        assertEquals(5, hand(_2,_3).value());
        assertEquals(6, hand(_2,_4).value());
        assertEquals(19, hand(Ace,_8).value());
        assertEquals(20, hand(King,Queen).value());
        assertEquals(20, hand(Jack,_10).value());
        assertEquals(21, hand(Jack,Ace).value());
    }
    
    @Test
    public void should_check_if_a_hand_is_black_jack() {
        assertEquals(true, hand(Jack,Ace).isBlackJack());        
        assertEquals(false, hand(Jack,Jack).isBlackJack());        
        assertEquals(false, hand(Jack,_5,_6).isBlackJack());
        assertEquals(false, hand(Jack,Ace,Queen).isBlackJack()); 
    }

    @Test
    public void should_check_if_a_hand_is_bust() {
        assertEquals(false, hand(Queen, Queen).isBust());
        assertEquals(true, hand(Queen, Queen, Queen).isBust());
    }

    @Test
    public void given_three_cards_should_calculate_hand_value() {
        assertEquals(30, hand(Queen, Queen, Queen).value());
        assertEquals(20, hand(_5, _7, _8).value());
        
    }
    
    @Test
    public void given_bust_hand_with_aces_should_aces_can_value_as_one() {
        assertEquals(12, hand(Ace, Ace).value());
        assertEquals(12, hand(Ace, Ace, Queen).value());        
        assertEquals(13, hand(Ace, Ace, Ace, Queen).value());        
        
    }
    
    @Test
    public void given_3_players_and_croupier_should_return_croupier_as_winner() {
        List<Card> croupierBet = new ArrayList<>();
        croupierBet.add(Card.Ace); croupierBet.add(Card.King);
        
        List<Card> player1Bet = new ArrayList<>();
        player1Bet.add(Card._5); player1Bet.add(Card.Queen);
        
        List<Card> player2Bet = new ArrayList<>();
        player2Bet.add(Card._8); player2Bet.add(Card.Jack);
        
        List<Card> player3Bet = new ArrayList<>();
        player3Bet.add(Card.Jack); player3Bet.add(Card.King);player3Bet.add(Card._9);
        
        
        Player croupier = new Player(croupierBet);
        Player player1 = new Player(player1Bet);
        Player player2 = new Player(player2Bet);
        Player player3 = new Player(player3Bet);
        
        List<Card> deck = new ArrayList<>();
        deck.add(Card._8); deck.add(Card._2); deck.add(Card.Ace); deck.add(Card._5);
        
        List<Player> winners = new ArrayList<>();
        winners.add(croupier);
        assertEquals(winners, BlackJack.getWinners(player1, player2, player3, croupier, deck));
        
        
        
    }
    
    @Test
    public void given_3_players_and_croupier_should_return_player1_and_player2_as_winners() {
        List<Card> croupierBet = new ArrayList<>();
        croupierBet.add(Card._10); croupierBet.add(Card._8);
        
        List<Card> player1Bet = new ArrayList<>();
        player1Bet.add(Card.Ace); player1Bet.add(Card.Queen);
        
        List<Card> player2Bet = new ArrayList<>();
        player2Bet.add(Card.Ace); player2Bet.add(Card.Jack);
        
        List<Card> player3Bet = new ArrayList<>();
        player3Bet.add(Card._2); player3Bet.add(Card.Ace);
        
        
        Player croupier = new Player(croupierBet);
        Player player1 = new Player(player1Bet);
        Player player2 = new Player(player2Bet);
        Player player3 = new Player(player3Bet);
        
        List<Card> deck = new ArrayList<>();
        deck.add(Card._8); deck.add(Card._2); deck.add(Card.Ace); deck.add(Card._5);
        
        List<Player> winners = new ArrayList<>();
        winners.add(player1);winners.add(player2);
        assertEquals(winners, BlackJack.getWinners(player1, player2, player3, croupier, deck));
        
    }
    
    
    
    private Hand hand(Card... cards) {
        return Hand.create(cards);
    }
    
    
    

    
}
