package no.emagnus.ulurulib;

import org.junit.Test;

public class ConditionTest {

    @Test
    public void should_accept_two_pieces_of_different_colors() {
	new TestCondition(PieceColor.BLACK, PieceColor.BLUE);
    }

    @Test
    public void should_accept_two_pieces_of_the_same_colors() {
	new TestCondition(PieceColor.BLACK, PieceColor.BLACK);
    }
    
    @Test
    public void should_accept_one_color() {
	new TestCondition(PieceColor.BLACK, null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void should_not_accept_no_colors() {
	new TestCondition(null, null);
    }
    
    private static class TestCondition extends Condition {

	public TestCondition(PieceColor affected, PieceColor other) {
	    super(affected, other);
	}

	@Override
	public boolean isMet(PieceConfiguration conf) {
	    return false;
	}
	
    }

}
