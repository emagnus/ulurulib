package no.emagnus.ulurulib.conditions;

import static org.fest.assertions.Assertions.assertThat;

import java.util.Arrays;

import no.emagnus.ulurulib.BoardContext;
import no.emagnus.ulurulib.PieceConfiguration;
import no.emagnus.ulurulib.SetOfConditions;

import org.junit.Before;

public abstract class AbstractConditionTest {

    protected PieceConfiguration conf;
    
    @Before
    public void setup() {
	conf = PieceConfiguration.emptyConfiguration();
    }
    
    protected void assertThatConditionIsMetSpecifically(Condition condition, boolean isMet) {
	BoardContext context = new BoardContext(conf, new SetOfConditions(Arrays.asList(condition)));
	assertThat(condition.isMetSpecifically(context)).isEqualTo(isMet);
    }
    
}
