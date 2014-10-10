package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;

public class SameAsCondition extends Condition {

    public SameAsCondition(PieceColor affected, PieceColor other) {
	super(affected, other);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
    }

    @Override
    public boolean isMetSpecifically(BoardContext context) {
	return context.getCondition(other).isMet(context);
    }

}
