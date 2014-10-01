package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;
import no.emagnus.ulurulib.PieceColor;
import no.emagnus.ulurulib.PieceConfiguration;

import org.junit.Before;
import org.junit.Test;

public class PositionConditionTest {

    private PieceConfiguration conf;
    
    @Before
    public void setup() {
	conf = PieceConfiguration.emptyConfiguration();
    }
    
    @Test
    public void should_be_met_if_in_big_boomerang() {
	conf.setPos(0, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.bigBoomerang(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_not_in_big_boomerang() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.bigBoomerang(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }
    
    @Test
    public void should_be_met_if_in_small_boomerang() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.smallBoomerang(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_not_in_small_boomerang() {
	conf.setPos(2, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.smallBoomerang(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }
    
    @Test
    public void should_be_met_if_on_short_sides() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.shortSides(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_not_on_short_sides() {
	conf.setPos(2, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.shortSides(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }
    
    @Test
    public void should_be_met_if_on_long_sides() {
	conf.setPos(2, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.longSides(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isTrue();
    }
    
    @Test
    public void should_not_be_met_if_not_on_long_sides() {
	conf.setPos(3, PieceColor.BLACK);
	
	PositionCondition cond = PositionCondition.longSides(PieceColor.BLACK);
	assertThat(cond.isMetSpecifically(conf)).isFalse();
    }

}
