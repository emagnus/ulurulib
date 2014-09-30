package no.emagnus.ulurulib;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

public class NextToConditionTest {
    
    @Test
    public void should_be_met_if_affected_piece_is_next_to_other_piece_on_north_side() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(1, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMet(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_affected_piece_is_not_next_to_other_piece_on_north_side() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(0, PieceColor.BLACK);
	conf.setPos(2, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMet(conf)).isFalse();
    }
    
    @Test
    public void should_not_be_met_if_pieces_next_to_eachother_in_ne_corner() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(2, PieceColor.BLACK);
	conf.setPos(3, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMet(conf)).isFalse();
    }
    
    @Test
    public void should_not_be_met_if_pieces_on_different_sides() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(2, PieceColor.BLACK);
	conf.setPos(5, PieceColor.BLUE);
	
	Condition cond = new NextToCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMet(conf)).isFalse();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new NextToCondition(PieceColor.BLACK, null);
    }
}
