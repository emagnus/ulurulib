package no.emagnus.ulurulib.conditions;

import static java.util.Arrays.asList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class OppositeSideCondition extends Condition {

    private Map<Integer, List<Integer>> validOppositePositions;
    
    public OppositeSideCondition(PieceColor affected, PieceColor other) {
	super(affected, other);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
	validOppositePositions = createValidOppositePositions();
    }

    @Override
    public boolean isMetSpecifically(PieceConfiguration conf) {
	int posOfAffected = conf.posOf(affected);
	int posOfOther = conf.posOf(other);
	return validOppositePositions.get(posOfAffected).contains(posOfOther);
    }
    
    @Override
    public String toString() {
        return affected + " on the opposite side of " + other;
    }

    private Map<Integer, List<Integer>> createValidOppositePositions() {
	Map<Integer, List<Integer>> map = new HashMap<>();
	map.put(0, asList(5));
	map.put(1, asList(5, 4));
	map.put(2, asList(4));
	map.put(3, asList(6,7));
	map.put(4, asList(1,2));
	map.put(5, asList(0,1));
	map.put(6, asList(3));
	map.put(7, asList(3));
	return map;
    }

}
