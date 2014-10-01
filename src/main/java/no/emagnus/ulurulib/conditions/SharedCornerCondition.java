package no.emagnus.ulurulib.conditions;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class SharedCornerCondition extends Condition {

    public SharedCornerCondition(PieceColor affected, PieceColor other) {
	super(affected, other);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
    }

    @Override
    public boolean isMetSpecifically(PieceConfiguration conf) {
	if(conf.posOf(affected) != -1 && affected == other) {
	    return true;
	}
	
	List<Integer> positions = Arrays.asList(conf.posOf(affected), conf.posOf(other));
	Collection<Integer> neCorner = Arrays.asList(2,3);
	Collection<Integer> seCorner = Arrays.asList(3,4);
	Collection<Integer> swCorner = Arrays.asList(5,6);
	Collection<Integer> nwCorner = Arrays.asList(7,0);
	
	if(neCorner.containsAll(positions) ||
		seCorner.containsAll(positions) ||
		swCorner.containsAll(positions) ||
		nwCorner.containsAll(positions)) {
	    return true;
	}
	
	return false;
    }

}
