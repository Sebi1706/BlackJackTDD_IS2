package kata.tdd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kata.tdd.Hand;

public class BlackJack { 
    
    private static int sum(List<Card> bet) {
                int sum = 0;
                for (Card card : bet)
                    sum += card.value();
                return sum;
    }
    private static boolean hasAce(List<Card> bet) {
                for (Card card : bet)
                    if (card == Card.Ace) return true;
                return false;
    }
    private static boolean hasAddedValue(List<Card> bet) {
                return hasAce(bet) && sum(bet) <= 11;
    }
    
    private static int addedValue(List<Card> bet) {
                return hasAddedValue(bet) ? 10 : 0;
    }
    
    public static int value(List<Card> bet){
                return sum(bet) + addedValue(bet);
            }
    
    public static boolean isBust(List<Card> bet) {
        return value(bet) > 21;
    }
    
    public static boolean isBlackJack(List<Card> bet) {
                return bet.size() == 2 && value(bet) == 21;
    }
    
    
    public static List<Player> getWinners(Player p1, Player p2, Player p3, Player croupier, List<Card> deck) {
        
        List<Player> players = new ArrayList<>(Arrays.asList(p1,p2,p3));
        List<Player> winners = new ArrayList<>();
        
        
        while (value(croupier.getBet()) < 17) {
            croupier.addCard(deck.remove(0));
        }

        if (isBlackJack(croupier.getBet())){
            winners.add(croupier);
            return winners;
        } 

        for (Player player : players) {
            if (isBlackJack(player.getBet())){
                winners.add(player);
                continue;
            }
            if (value(player.getBet()) > value(croupier.getBet()) && !isBust(player.getBet())) winners.add(player);
        }
        return winners;

    }
    
    
    
}
