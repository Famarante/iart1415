package gameLogic;

import board.Board;

public class Game {
	
	static Board gameBoard = new Board();
	
	public static void main(String[] args){
		gameBoard.init();
		gameBoard.printBoard();
	}
}
