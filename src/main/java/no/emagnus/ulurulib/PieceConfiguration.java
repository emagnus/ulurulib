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
    
    public boolean isPresent(PieceColor color) {
	return pieces.contains(color);
    }
    
    public static PieceConfiguration emptyConfiguration() {
	return new PieceConfiguration(Arrays.<PieceColor>asList(null, null, null, null, null, null, null, null));
    }
    
    @Override
    public String toString() {
        return String.format("   %s  %s  %s     \n", getPos(0), getPos(1), getPos(2)) + 
        	String.format("%s              %s\n", getPos(7), getPos(3)) + 
        	String.format("%s                \n", getPos(6)) +
        	String.format("    %s  %s        ", getPos(5), getPos(4));
    }
    
}
