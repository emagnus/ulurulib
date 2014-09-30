package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class NextToCondition extends Condition {

    public NextToCondition(PieceColor affected, PieceColor other) {
	super(affected, other);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
    }

    @Override
    public boolean isMet(PieceConfiguration conf) {
	int affectedPos = conf.posOf(affected);
	int otherPos = conf.posOf(other);
	if(Math.abs(affectedPos - otherPos) != 1) {
	    return false;
	}
	
	int sumOfPositions = affectedPos + otherPos;
	if(sumOfPositions == 5 || 	// NE corner
	   sumOfPositions == 7 || 	// SE corner
	   sumOfPositions == 11) {	// SW corner
	    return false;
	}
	return true;
    }

}
