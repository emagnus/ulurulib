package no.emagnus.ulurulib.conditions;

import java.util.Arrays;
import java.util.List;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class PositionCondition extends Condition {

    private List<Integer> validPositions;

    private PositionCondition(PieceColor affected, List<Integer> validPositions) {
	super(affected, null);
	this.validPositions = validPositions;
    }

    @Override
    public boolean isMetSpecifically(PieceConfiguration conf) {
	return validPositions.contains(conf.posOf(affected));
    }

    public static PositionCondition bigBoomerang(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(0, 1, 2, 6, 7));
    }

    public static PositionCondition smallBoomerang(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(3, 4, 5));
    }

    public static PositionCondition shortSides(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(3, 6, 7));
    }

    public static PositionCondition longSides(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(0, 1, 2, 4, 5));
    }

}
