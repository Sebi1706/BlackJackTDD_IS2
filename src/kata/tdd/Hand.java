package kata.tdd;

public interface Hand {

    int value();

    boolean isBlackJack();

    default boolean isBust() {
        return value() > 21;
    }
    
    static Hand create(Card... ranks) {
        return new Hand() {
            
            @Override
            public int value() {
                return sum() + addedValue();
            }

            private int addedValue() {
                return hasAddedValue() ? 10 : 0;
            }

            private boolean hasAddedValue() {
                return hasAce() && sum() <= 11;
            }

            private boolean hasAce() {
                for (Card rank : ranks)
                    if (rank == Card.Ace) return true;
                return false;
            }

            private int sum() {
                int sum = 0;
                for (Card rank : ranks)
                    sum += rank.value();
                return sum;
            }

            @Override
            public boolean isBlackJack() {
                return ranks.length == 2 && value() == 21;
            }
        };
    }  
}
