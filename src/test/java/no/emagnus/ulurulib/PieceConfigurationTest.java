package no.emagnus.ulurulib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PieceConfigurationTest {

    @Test
    public void should_accept_list_of_size_8() {
	List<PieceColor> allColors = Arrays.asList(PieceColor.values());
	new PieceConfiguration(allColors);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void should_not_accept_null_list() throws Exception {
	new PieceConfiguration(null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void should_not_accept_list_of_size_7() throws Exception {
	new PieceConfiguration(new ArrayList<PieceColor>());
    }

}
