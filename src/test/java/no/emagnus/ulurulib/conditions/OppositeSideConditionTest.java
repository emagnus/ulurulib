package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

import org.junit.Before;
import org.junit.Test;

public class OppositeSideConditionTest {
    
    private PieceConfiguration conf;
    
    @Before
    public void setup() {
	conf = PieceConfiguration.emptyConfiguration();
    }

    @Test
    public void should_be_met_if_other_color_on_opposite_short_side() {
	conf.setPos(3, PieceColor.BLACK);
	conf.setPos(7, PieceColor.BLUE);
	
	Condition cond = new OppositeSideCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_other_color_on_same_side() {
	conf.setPos(6, PieceColor.BLACK);
	conf.setPos(7, PieceColor.BLUE);
	
	Condition cond = new OppositeSideCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }
    
    @Test
    public void should_not_be_met_if_other_color_on_adjacent_side() {
	conf.setPos(5, PieceColor.BLACK);
	conf.setPos(6, PieceColor.BLUE);
	
	Condition cond = new OppositeSideCondition(PieceColor.BLACK, PieceColor.BLUE);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void should_not_accept_only_one_color() {
	new OppositeSideCondition(PieceColor.BLACK, null);
    }

}
