package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;

public abstract class Condition {

    protected final PieceColor affected;
    protected final PieceColor other;

    public Condition(PieceColor affected, PieceColor other) {
	if(affected == null) {
	    throw new IllegalArgumentException("Affected piece cannot be null.");
	}
	this.affected = affected;
	this.other = other;
    }
    
    public boolean isMet(BoardContext context) {
	if(context.isPresent(affected) && affected == other) {
	    return true;
	}
	return isMetSpecifically(context);
    }
    
    public abstract boolean isMetSpecifically(BoardContext context);
    
    public PieceColor getAffected() {
	return affected;
    }
}
