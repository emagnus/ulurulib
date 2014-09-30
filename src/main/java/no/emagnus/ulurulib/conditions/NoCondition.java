package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class NoCondition extends Condition {

    public NoCondition(PieceColor affected) {
	super(affected, null);
    }

    @Override
    public boolean isMet(PieceConfiguration conf) {
	return true;
    }

}
