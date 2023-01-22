package kata.tdd;

import java.util.HashSet;
import java.util.Set;

public enum Card {
    Ace, _2, _3, _4, _5, _6, _7, _8, _9, _10, Jack, Queen, King;

    public int value() {
        if (isFace()) {
            return 10;
        }
        return this.ordinal() + 1;
    }

    private boolean isFace() {
        return FACE_RANKS.contains(this);
    }
    private static final Set<Card> FACE_RANKS = new HashSet<>();
    static {
        FACE_RANKS.add(King);
        FACE_RANKS.add(Queen);
        FACE_RANKS.add(Jack);
    } 
}
