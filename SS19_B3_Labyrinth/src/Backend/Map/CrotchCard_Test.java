package Backend.Map;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import Backend.Treasure;

public class CrotchCard_Test {

	CrotchCard tester;

	@Before
	public void initialize() {
		tester = new CrotchCard(Treasure.book);
		
	}

	@Test
	public void checkRotateLeft() {
		
		System.out.println(Arrays.toString(tester.getWall()));
		tester.rotateLeft();
		int[] a = {0,0,0,1};
		for(int i = 0; i < tester.wall.length; i++) {
			assertTrue(a[i] == tester.getWall()[i]);
		}
		
		System.out.println(Arrays.toString(tester.getWall()));
		
		
		
	}

	@Test
	public void checkRotateRight() {
		System.out.println(Arrays.toString(tester.getWall()));
		tester.rotateRight();
		int[] a = {0,1,0,0};
		for(int i = 0; i < tester.wall.length; i++) {
			assertTrue(a[i] == tester.getWall()[i]);
		}
		
		System.out.println(Arrays.toString(tester.getWall()));
	}

}
