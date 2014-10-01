package no.emagnus.ulurulib;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import no.emagnus.ulurulib.conditions.Condition;
import no.emagnus.ulurulib.conditions.NextToCondition;
import no.emagnus.ulurulib.conditions.NoCondition;
import no.emagnus.ulurulib.conditions.OppositeSideCondition;
import no.emagnus.ulurulib.conditions.PositionCondition;
import no.emagnus.ulurulib.conditions.SharedCornerCondition;

public class UluruTester {

    public static void main(String[] args) {
	SetOfConditions conditions = generateConditions();
	PieceConfiguration conf = generateRandomConfiguration();
	
	System.out.println("RANDOM GAME OF ULURU :D");
	System.out.println("-----------------------\n");
	System.out.println(conf);
	System.out.println("\n");
	System.out.println(conditions);
	
	ConfigurationEvaluator evaluator = new ConfigurationEvaluator(conditions);
	int conditionsMet = evaluator.evaluate(conf);
	System.out.println("Conditions met: " + conditionsMet);
    }

    private static PieceConfiguration generateRandomConfiguration() {
	PieceConfiguration conf = PieceConfiguration.emptyConfiguration();
	List<Integer> positions = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4,
		5, 6, 7));
	Collections.shuffle(positions);

	for(int i = 0; i<8; i++) {
	    conf.setPos(positions.get(i), PieceColor.values()[i]);
	}

	return conf;
    }

    private static SetOfConditions generateConditions() {
	List<Condition> conditions = new ArrayList<>();
	Random rand = new Random();
	for (PieceColor color : PieceColor.values()) {
	    int nextCond = rand.nextInt(8);
	    switch (nextCond) {
	    case 0:
		conditions.add(new NextToCondition(color, PieceColor.random()));
		break;
	    case 1:
		conditions.add(new NoCondition(color));
		break;
	    case 2:
		conditions.add(new OppositeSideCondition(color, PieceColor
			.random()));
		break;
	    case 3:
		conditions.add(PositionCondition.bigBoomerang(color));
		break;
	    case 4:
		conditions.add(PositionCondition.smallBoomerang(color));
		break;
	    case 5:
		conditions.add(PositionCondition.shortSides(color));
		break;
	    case 6:
		conditions.add(PositionCondition.longSides(color));
		break;
	    case 7:
		conditions.add(new SharedCornerCondition(color, PieceColor
			.random()));
		break;

	    default:
		break;
	    }
	}
	return new SetOfConditions(conditions);
    }

}
