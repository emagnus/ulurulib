package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;

public class NoCondition extends Condition {

    public NoCondition(PieceColor affected) {
	super(affected, null);
    }

    @Override
    public boolean isMetSpecifically(BoardContext context) {
	return context.isPresent(affected);
    }
    
    @Override
    public String toString() {
        return affected + " is happy wherever";
    }

}
