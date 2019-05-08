package Backend.Map;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CurveCard_Test {

	CurveCard tester;

	@Before
	public void initialize() {
		tester = new CurveCard(null, null);
	}

	@Test
	public void checkRotateLeft() {
		
		System.out.println(Arrays.toString(tester.getWall()));
		tester.rotateLeft();
		System.out.println(Arrays.toString(tester.getWall()));
	}

	@Test
	public void checkRotateRight() {
		
		System.out.println(Arrays.toString(tester.getWall()));
		tester.rotateRight();
		System.out.println(Arrays.toString(tester.getWall()));
	}

}
