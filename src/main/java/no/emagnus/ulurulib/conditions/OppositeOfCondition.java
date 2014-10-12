package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;

public class OppositeOfCondition extends Condition {

    public OppositeOfCondition(PieceColor affected, PieceColor other) {
	super(affected, other, true);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
    }

    @Override
    public boolean isMetSpecifically(BoardContext context) {
	return !context.getCondition(other).isMetSpecifically(context);
    }
    
    @Override
    public String toString() {
	return affected + " opposite of " + other;    
    }

}
