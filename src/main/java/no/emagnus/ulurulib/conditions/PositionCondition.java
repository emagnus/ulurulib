package no.emagnus.ulurulib.conditions;

import java.util.Arrays;
import java.util.List;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class PositionCondition extends Condition {

    private List<Integer> validPositions;
    private String nickname;

    private PositionCondition(PieceColor affected, List<Integer> validPositions, String nickname) {
	super(affected, null, false);
	this.validPositions = validPositions;
	this.nickname = nickname;
    }

    @Override
    public boolean isMetSpecifically(BoardContext context) {
	PieceConfiguration conf = context.getPieceConfiguration();
	return validPositions.contains(conf.posOf(affected));
    }

    public static PositionCondition bigBoomerang(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(0, 1, 2, 6, 7), "big boomerang");
    }

    public static PositionCondition smallBoomerang(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(3, 4, 5), "small boomerang");
    }

    public static PositionCondition shortSides(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(3, 6, 7), "short sides");
    }

    public static PositionCondition longSides(PieceColor affected) {
	return new PositionCondition(affected, Arrays.asList(0, 1, 2, 4, 5), "long sides");
    }
    
    @Override
    public String toString() {
        return affected + " placed in/on " + nickname;
    }

}
