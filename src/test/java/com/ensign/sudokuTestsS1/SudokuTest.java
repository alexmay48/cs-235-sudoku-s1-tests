package com.ensign.sudokuTestsS1;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SudokuTest {

	static Object puzzle0;
	static Object puzzle1;
	static Object puzzle2;
	static Object puzzle3;

	static Class<?> sudokuClass;
	static Constructor<?> constructor;

	@BeforeAll
	void setUp() throws Exception {
		sudokuClass = Class.forName("com.ensign.sudoku.Sudoku");
		constructor = sudokuClass.getConstructor(new Class[] { Class.forName("com.ensign.sudoku.Sudoku") });
	}

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		// PUZZLE 0 UNSOLVED
		puzzle0 = constructor.newInstance(new Object[] { "src/main/resources/samplePuzzles/puzzle0.txt" });
//		Class<?> arguments[] = new Class[] {};
//		Method objMethod = sudokuClass.getMethod("solveSudoku", arguments);
//		Object result = objMethod.invoke(puzzle0, (Object[]) arguments);
//		System.out.println(result);

		// PUZZLE 0 UNSOLVED
		puzzle1 = constructor.newInstance(new Object[] { "src/main/resources/samplePuzzles/puzzle0.txt" });

		// PUZZLE 0 SOLVED
		puzzle2 = constructor.newInstance(new Object[] { "src/main/resources/samplePuzzles/puzzle0Solved.txt" });

		// PUZZLE 0 SOLVED
		puzzle3 = constructor.newInstance(new Object[] { "src/main/resources/samplePuzzles/puzzle0Solved.txt" });

	}
	
	public static Class<?>[] params(Object[] obj) {
		Class<?> params[] = new Class[obj.length];
        for (int i = 0; i < obj.length; i++) {
            if (obj[i] instanceof Integer) {
                params[i] = Integer.TYPE;
            } else if (obj[i] instanceof String) {
                params[i] = String.class;
            }
        }
        return params;
	}

	@Test
	void testValidForRow1() throws Exception {
		Object[] obj = {0, 5};// for method1()
        Class<?> params[] = params(obj);
		Method method = sudokuClass.getMethod("validForRow", params);
		assertTrue((boolean) method.invoke(puzzle0, (Object[]) params));
//		assertTrue(puzzle0.validForRow(0, 5));
//		assertFalse(puzzle0.validForRow(0, 1));
	}

//	@Test
//	void testValidForColumn1() {
//		Sudoku puzzle0;
//		puzzle0 = new Sudoku("src/main/resources/samplePuzzles/puzzle0.txt");
//
//		assertTrue(puzzle0.validForColumn(0, 4));
//		assertFalse(puzzle0.validForColumn(0, 6));
//	}
//
//	@Test
//	void testValidForBox1() {
//		Sudoku puzzle0;
//		puzzle0 = new Sudoku("src/main/resources/samplePuzzles/puzzle0.txt");
//
//		assertTrue(puzzle0.validForBox(2, 3));
//		assertFalse(puzzle0.validForBox(8, 6));
//	}
//
//	@Test
//	void testIsValid1() {
//		Sudoku puzzle0;
//		puzzle0 = new Sudoku("src/main/resources/samplePuzzles/puzzle0.txt");
//
//		assertTrue(puzzle0.isValid(0, 7));
//		assertTrue(puzzle0.isValid(80, 4));
//		assertFalse(puzzle0.isValid(80, 3));
//	}
//
//	@Test
//	void testValidForRow() {
//		assertTrue(puzzle1.validForRow(0, 5));
//	}
//
//	@Test
//	void testValidForBox() {
//		assertTrue(puzzle1.validForBox(0, 7));
//	}
//
//	@Test
//	void testValidForColumn() {
//		assertTrue(puzzle1.validForColumn(0, 1));
//	}
//
//	@Test
//	void testIsValid() {
//		assertTrue(puzzle1.isValid(8, 5));
//	}
//
//	@Test
//	void testIsEquals() {
//		assertTrue(puzzle2.equals(puzzle3));
//	}
//
//	@Test
//	void testFindBox() {
//		assertEquals(0, Sudoku.findBox(0));
//		assertEquals(1, Sudoku.findBox(3));
//		assertEquals(2, Sudoku.findBox(6));
//
//		assertEquals(3, Sudoku.findBox(27));
//		assertEquals(4, Sudoku.findBox(31));
//		assertEquals(5, Sudoku.findBox(35));
//
//		assertEquals(6, Sudoku.findBox(63));
//		assertEquals(7, Sudoku.findBox(67));
//		assertEquals(8, Sudoku.findBox(71));
//	}
//
//	@Test
//	void testPruneBox() {
//		puzzle0 = new Sudoku("src/main/resources/samplePuzzles/puzzle0.txt");
//		puzzle0.createSet();
//
//		assertTrue(puzzle0.getPossibilities().get(57).contains(8));
//		assertTrue(puzzle0.getPossibilities().get(58).contains(8));
//		assertTrue(puzzle0.getPossibilities().get(59).contains(8));
//
//		assertTrue(puzzle0.getPossibilities().get(66).contains(8));
//		assertTrue(puzzle0.getPossibilities().get(68).contains(8));
//
//		assertTrue(puzzle0.getPossibilities().get(76).contains(8));
//		assertTrue(puzzle0.getPossibilities().get(77).contains(8));
//
//		puzzle0.pruneBox(75, 8);
//
//		assertFalse(puzzle0.getPossibilities().get(57).contains(8));
//		assertFalse(puzzle0.getPossibilities().get(58).contains(8));
//		assertFalse(puzzle0.getPossibilities().get(59).contains(8));
//
//		assertFalse(puzzle0.getPossibilities().get(66).contains(8));
//		assertFalse(puzzle0.getPossibilities().get(68).contains(8));
//
//		assertFalse(puzzle0.getPossibilities().get(76).contains(8));
//		assertFalse(puzzle0.getPossibilities().get(77).contains(8));
//	}
//
//	@Test
//	void testPruneRow() throws Exception {
//		puzzle0 = new Sudoku("src/main/resources/samplePuzzles/puzzle0.txt");
//		puzzle0.createSet();
//
//		assertTrue(puzzle0.getPossibilities().get(0).contains(1));
//
//		assertTrue(puzzle0.getPossibilities().get(6).contains(1));
//		assertTrue(puzzle0.getPossibilities().get(7).contains(1));
//		assertTrue(puzzle0.getPossibilities().get(8).contains(1));
//
//		puzzle0.pruneRow(2, 1);
//
//		assertFalse(puzzle0.getPossibilities().get(0).contains(1));
//
//		assertFalse(puzzle0.getPossibilities().get(6).contains(1));
//		assertFalse(puzzle0.getPossibilities().get(7).contains(1));
//		assertFalse(puzzle0.getPossibilities().get(8).contains(1));
//
//	}
//
//	@Test
//	void testPruneColumn() throws Exception {
//		puzzle0 = new Sudoku("src/main/resources/samplePuzzles/puzzle0.txt");
//		puzzle0.createSet();
//
//		assertTrue(puzzle0.getPossibilities().get(0).contains(6));
//
//		assertTrue(puzzle0.getPossibilities().get(36).contains(6));
//		assertTrue(puzzle0.getPossibilities().get(45).contains(6));
//
//		assertTrue(puzzle0.getPossibilities().get(54).contains(6));
//
//		puzzle0.pruneColumn(27, 6);
//
//		assertFalse(puzzle0.getPossibilities().get(0).contains(6));
//
//		assertFalse(puzzle0.getPossibilities().get(36).contains(6));
//		assertFalse(puzzle0.getPossibilities().get(45).contains(6));
//
//		assertFalse(puzzle0.getPossibilities().get(54).contains(6));
//	}
//
//	@Test
//	void solveAllPuzzlesRecursively() {
//
//		ArrayList<Sudoku> puzzles = new ArrayList<Sudoku>();
//		for (int i = 0; i < 41; i++) {
//			// puzzle1.txt takes the longest to complete . Commenting out this line will
//			// skip that puzzle.
//			if (i == 1 || i == 11)
//				continue;
//
//			Sudoku puzzle = new Sudoku("src/main/resources/samplePuzzles/puzzle" + i + ".txt");
//			puzzles.add(puzzle);
//			puzzle.setPuzzleId(i);
//			puzzle.solveSudoku();
//
//			// Puzzles 15, 20, and 25 are not solvable
//			if (i == 15 || i == 20 || i == 25 || i == 40) {
//				assertFalse(puzzle.verify());
//			} else {
//				assertTrue(puzzle.verify());
//			}
//			System.out.println("Puzzle: " + i + " Empty Buckets: " + puzzle.getEmptyBuckets() + " Empty Rows: "
//					+ puzzle.getEmptyRows() + " Empty Columns: " + puzzle.getEmptyColumns() + " Empty Boxes: "
//					+ puzzle.getEmptyBoxes() + " Guess Counts: " + puzzle.getGuessCount());
//		}
////		Collections.sort(puzzles);
////		
////		for (Sudoku s : puzzles) {
////			System.out.println("Puzzle: " + s.getPuzzleId()  
////			+ " Guess Counts: " + s.getGuessCount()
////			+ " Empty Buckets: " + s.getEmptyBuckets()
////			+ " Empty Rows: " + s.getEmptyRows()
////			+ " Empty Columns: " + s.getEmptyColumns()
////			+ " Empty Boxes: " + s.getEmptyBoxes());
////		}
//	}
//
//	@Test
//	void solvePuzzleRecursively() {
//		assertTrue(puzzle0.solveSudoku());
//		assertTrue(puzzle0.verify());
//		assertTrue(puzzle0.equals(puzzle2));
//	}
//
//	@Test
//	void getNumOfEmptyBuckets() {
//		assertEquals(puzzle0.getEmptyBuckets(), 36);
//	}
//
//	@Test
//	void getNumberOfEmptyRows() {
//		assertEquals(new Sudoku("src/main/resources/samplePuzzles/puzzle19.txt").getEmptyRows(), 4);
//	}
//
//	@Test
//	void getNumberofEmptyColumns() {
//		assertEquals(new Sudoku("src/main/resources/samplePuzzles/puzzle19.txt").getEmptyColumns(), 4);
//	}
//
//	@Test
//	void getNumberofEmptyBoxes() {
//		assertEquals(0, new Sudoku("src/main/resources/samplePuzzles/puzzle19.txt").getEmptyBoxes());
//		assertEquals(2, new Sudoku("src/main/resources/samplePuzzles/puzzle1.txt").getEmptyBoxes());
//	}

}
