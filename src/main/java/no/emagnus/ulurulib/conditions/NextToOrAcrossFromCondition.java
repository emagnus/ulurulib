package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;

public class NextToOrAcrossFromCondition extends Condition {
    
    private final Condition nextToCondition;
    private final AcrossFromCondition acrossFromCondition;

    public NextToOrAcrossFromCondition(PieceColor affected, PieceColor other) {
	super(affected, other);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
	nextToCondition = new NextToCondition(affected, other);
	acrossFromCondition = new AcrossFromCondition(affected, other);
    }

    @Override
    public boolean isMetSpecifically(BoardContext context) {
	return !nextToCondition.isMet(context) && !acrossFromCondition.isMet(context);
    }

}
