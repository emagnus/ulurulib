package no.emagnus.ulurulib.conditions;

import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class SharedCornerConditionTest extends AbstractConditionTest {
    
    @Test
    public void should_be_met_if_pieces_sharing_ne_corner() {
	conf.setPos(2, PieceColor.GREEN);
	conf.setPos(3, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_be_met_if_pieces_sharing_se_corner() {
	conf.setPos(3, PieceColor.BLUE);
	conf.setPos(4, PieceColor.GREEN);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_be_met_if_pieces_sharing_sw_corner() {
	conf.setPos(5, PieceColor.GREEN);
	conf.setPos(6, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_be_met_if_pieces_sharing_nw_corner() {
	conf.setPos(7, PieceColor.BLUE);
	conf.setPos(0, PieceColor.GREEN);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_pieces_are_on_opposite_sides() {
	conf.setPos(0, PieceColor.GREEN);
	conf.setPos(5, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_not_be_met_if_pieces_are_neighbours() {
	conf.setPos(1, PieceColor.GREEN);
	conf.setPos(2, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new SharedCornerCondition(PieceColor.BLACK, null);
    }

}
