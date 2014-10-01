package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

public class NoCondition extends Condition {

    public NoCondition(PieceColor affected) {
	super(affected, null);
    }

    @Override
    public boolean isMetSpecifically(PieceConfiguration conf) {
	return conf.isPresent(affected);
    }
    
    @Override
    public String toString() {
        return affected + " is happy wherever";
    }

}
