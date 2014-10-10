package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceColor;

public class TwoSpacesAwayCondition extends Condition {

    public TwoSpacesAwayCondition(PieceColor affected, PieceColor other) {
	super(affected, other);
	if(other == null) {
	    throw new IllegalArgumentException("Other piece cannot be null");
	}
    }

    @Override
    public boolean isMetSpecifically(BoardContext context) {
	int affectedPos = context.getPieceConfiguration().posOf(affected);
	int otherPos = context.getPieceConfiguration().posOf(other);
	int diff = Math.abs(affectedPos - otherPos);

	return diff > 2 && diff < 6;
    }

}
