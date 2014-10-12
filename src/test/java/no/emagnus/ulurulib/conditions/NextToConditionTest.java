package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;
import no.emagnus.ulurulib.PieceColor;

import org.junit.Test;

public class NextToConditionTest extends AbstractConditionTest {
    
    @Test
    public void should_be_met_if_affected_piece_is_next_to_other_piece_on_north_side() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(1, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, true);
    }
    
    @Test
    public void should_not_be_met_if_affected_piece_is_not_next_to_other_piece_on_north_side() {
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(2, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_not_be_met_if_pieces_next_to_eachother_in_ne_corner() {
	conf.setPos(2, PieceColor.BLACK);
	conf.setPos(3, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_not_be_met_if_pieces_on_different_sides() {
	conf.setPos(2, PieceColor.BLACK);
	conf.setPos(5, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThatConditionIsMetSpecifically(cond, false);
    }
    
    @Test
    public void should_not_be_complex() {
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.WHITE);
	assertThat(cond.isComplex()).isFalse();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new NextToCondition(PieceColor.BLACK, null);
    }
}
