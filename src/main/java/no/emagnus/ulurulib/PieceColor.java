package no.emagnus.ulurulib;

public enum PieceColor {
    WHITE, 
    PINK, 
    YELLOW, 
    ORANGE, 
    RED, 
    GREEN, 
    BLUE, 
    BLACK;
    
    public static PieceColor random() {
	return values()[(int) (Math.random()*8)];
    }
    
    @Override
    public String toString() {
        return name().substring(0, 3);
    }
}
