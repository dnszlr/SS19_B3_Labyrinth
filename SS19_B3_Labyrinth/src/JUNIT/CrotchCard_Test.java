package JUNIT;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import Backend.Treasure;
import Backend.Map.CrotchCard;

public class CrotchCard_Test {

	CrotchCard tester1;
	CrotchCard tester2;
	CrotchCard tester3;
	CrotchCard tester4;
	CrotchCard tester5;
	CrotchCard tester6;
	CrotchCard tester7;
	CrotchCard tester8;
	CrotchCard tester9;
	CrotchCard tester10;
	CrotchCard tester11;
	CrotchCard tester12;
	CrotchCard tester13;
	CrotchCard tester14;
	CrotchCard tester15;
	CrotchCard tester16;
	CrotchCard tester17;
	CrotchCard tester18;

	@Before
	public void initialize() {
		tester1 = new CrotchCard(Treasure.book);
		tester2 = new CrotchCard(Treasure.moneybag);
		tester3 = new CrotchCard(Treasure.map);
		tester4 = new CrotchCard(Treasure.crown);
		tester5 = new CrotchCard(Treasure.key);
		tester6 = new CrotchCard(Treasure.skull);
		tester7 = new CrotchCard(Treasure.ring);
		tester8 = new CrotchCard(Treasure.chest);
		tester9 = new CrotchCard(Treasure.emerald);
		tester10 = new CrotchCard(Treasure.sword);
		tester11 = new CrotchCard(Treasure.menorah);
		tester12 = new CrotchCard(Treasure.helmet);
		tester13 = new CrotchCard(Treasure.bat);
		tester14 = new CrotchCard(Treasure.dragon);
		tester15 = new CrotchCard(Treasure.gnome);
		tester16 = new CrotchCard(Treasure.scarab);
		tester17 = new CrotchCard(Treasure.moth);
		tester18 = new CrotchCard(Treasure.sorceress);

	}

	@Test
	public void checkRotateLeft() {

		System.out.println(Arrays.toString(tester1.getWall()));
		tester1.rotateLeft();
		int[] a = { 0, 0, 0, 1 };
		for (int i = 0; i < tester1.getWall().length; i++) {
			assertTrue(a[i] == tester1.getWall()[i]);
		}
		tester1.rotateLeft();
		int[] b = { 0, 0, 1, 0 };
		for (int i = 0; i < tester1.getWall().length; i++) {
			assertTrue(b[i] == tester1.getWall()[i]);
		}

		System.out.println(Arrays.toString(tester1.getWall()));

	}

	@Test
	public void checkRotateRight() {
		System.out.println(Arrays.toString(tester3.getWall()));
		tester3.rotateRight();
		int[] a = { 1, 0, 0, 0 };
		for (int i = 0; i < tester3.getWall().length; i++) {
			assertTrue(a[i] == tester3.getWall()[i]);
		}

		tester3.rotateRight();

		int[] b = { 0, 1, 0, 0 };
		for (int i = 0; i < tester3.getWall().length; i++) {
			assertTrue(b[i] == tester3.getWall()[i]);
		}

		System.out.println(Arrays.toString(tester3.getWall()));
	}

}
