package tests;

import static org.junit.Assert.*;
import graph.Node;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.Test;

import board.Board;

public class BoardTest {

	@SuppressWarnings("rawtypes")
	@Test
	public void testBoard() {
		Board board = new Board();
		board.init();
		assertEquals(board.board.nodes.size(), 61);
		assertEquals(board.board.getNode(11).name, "L");
		assertEquals(board.board.getNode(99).name, "W");
		System.out.println("Board print...");
		board.printBoard();
		int bluePieces = 0, redPieces = 0;
		Iterator it = board.board.nodes.entrySet().iterator();
		while (it.hasNext()) {
			HashMap.Entry pair = (HashMap.Entry)it.next();
			if( ((Node)pair.getValue()).name == "R")
				redPieces++;
			if( ((Node)pair.getValue()).name == "B")
				bluePieces++;
			it.remove(); // avoids a ConcurrentModificationException
		}
		assertEquals(bluePieces, 9);
		assertEquals(redPieces, 9);
	}

}
