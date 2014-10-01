package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public abstract class Condition {

    protected final PieceColor affected;
    protected final PieceColor other;

    public Condition(PieceColor affected, PieceColor other) {
	if(affected == null) {
	    throw new IllegalArgumentException("Afftected piece cannot be null.");
	}
	this.affected = affected;
	this.other = other;
    }
    
    public boolean isMet(PieceConfiguration conf) {
	if(conf.isPresent(affected) && affected == other) {
	    return true;
	}
	return isMetSpecifically(conf);
    }
    
    public abstract boolean isMetSpecifically(PieceConfiguration conf);
}
