package no.emagnus.ulurulib;

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
    
    public abstract boolean isMet(PieceConfiguration conf);
}
