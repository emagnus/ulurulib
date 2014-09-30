package no.emagnus.ulurulib;

import java.util.Arrays;
import java.util.List;

public class PieceConfiguration {

    /**
     *      0 1 2 
     *     7     3 
     *     6 
     *        5 4
     */
    
    private final List<PieceColor> pieces;
    
    public PieceConfiguration(List<PieceColor> pieces) {
	if(pieces == null || pieces.size() != 8) {
	    throw new IllegalArgumentException("A piece configuration can only be created using a list of size 8.");
	}
	this.pieces = pieces;
    }
    
    public PieceColor getPos(int pos) {
    	return pieces.get(pos);
    }
    
    public void setPos(int pos, PieceColor color) {
    	pieces.set(pos, color);
    }
    
    public int posOf(PieceColor color) {
	return pieces.indexOf(color);
    }
    
    static PieceConfiguration emptyConfiguration() {
	return new PieceConfiguration(Arrays.<PieceColor>asList(null, null, null, null, null, null, null, null));
    }
}
