package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

import org.junit.Test;

public class SharedCornerConditionTest {

    @Test
    public void should_be_met_if_pieces_sharing_ne_corner() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(2, PieceColor.GREEN);
	conf.setPos(3, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isTrue();
    }
    
    @Test
    public void should_be_met_if_pieces_sharing_se_corner() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(3, PieceColor.BLUE);
	conf.setPos(4, PieceColor.GREEN);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isTrue();
    }
    
    @Test
    public void should_be_met_if_pieces_sharing_sw_corner() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(5, PieceColor.GREEN);
	conf.setPos(6, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isTrue();
    }
    
    @Test
    public void should_be_met_if_pieces_sharing_nw_corner() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(7, PieceColor.BLUE);
	conf.setPos(0, PieceColor.GREEN);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isTrue();
    }
    
    @Test
    public void should_be_met_if_same_color_and_present() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(1, PieceColor.GREEN);
	
	Condition cond = new SharedCornerCondition(PieceColor.GREEN, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isTrue();
    }

    @Test
    public void should_not_be_met_if_pieces_are_on_opposite_sides() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(0, PieceColor.GREEN);
	conf.setPos(5, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isFalse();
    }
    
    @Test
    public void should_not_be_met_if_pieces_are_neighbours() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	conf.setPos(1, PieceColor.GREEN);
	conf.setPos(2, PieceColor.BLUE);
	
	Condition cond = new SharedCornerCondition(PieceColor.BLUE, PieceColor.GREEN);
	assertThat(cond.isMet(conf)).isFalse();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new SharedCornerCondition(PieceColor.BLACK, null);
    }

}