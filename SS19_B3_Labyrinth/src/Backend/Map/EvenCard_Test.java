package Backend.Map;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class EvenCard_Test {

	EvenCard tester;
	EvenCard tester2;
	EvenCard tester3;
	EvenCard tester4;

	@Before
	public void initialize() {
		tester = new EvenCard();
		tester2 = new EvenCard();
		tester3 = new EvenCard();
		tester4 = new EvenCard();

	}

	@Test
	public void checkRotateLeft() {
		int[] a = { 0, 1, 0, 1 };
		int[] b = { 1, 0, 1, 0 };
		System.out.println(Arrays.toString(tester.getWall()));
		if (Arrays.equals(tester.getWall(), a)) {
			tester.rotateLeft();
			for (int i = 0; i < tester.wall.length; i++) {
				assertTrue(b[i] == tester.getWall()[i]);
			}
		} else {
			tester.rotateLeft();
			for (int i = 0; i < tester.wall.length; i++) {
				assertTrue(a[i] == tester.getWall()[i]);
			}
		}
		

		System.out.println(Arrays.toString(tester.getWall()));

	}

	@Test
	public void checkRotateRight() {

		int[] a = { 0, 1, 0, 1 };
		int[] b = { 1, 0, 1, 0 };
		System.out.println(Arrays.toString(tester.getWall()));
		if (Arrays.equals(tester.getWall(), a)) {
			tester.rotateRight();
			for (int i = 0; i < tester.wall.length; i++) {
				assertTrue(b[i] == tester.getWall()[i]);
			}
		} else {
			tester.rotateRight();
			for (int i = 0; i < tester.wall.length; i++) {
				assertTrue(a[i] == tester.getWall()[i]);
			}
		}
		

		System.out.println(Arrays.toString(tester.getWall()));

	}
}
