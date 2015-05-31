package gui;
import gamelogic.Game;
import gamelogic.Move;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import java.util.ArrayList;

public class HexBoard extends JPanel implements MouseListener{
	private static final long serialVersionUID = 1L;
	private int WIDTH;
	private int HEIGHT;
	private int windowSize;
	private Game game;

	ArrayList<HexagonComponent > boardHexagons = new ArrayList<HexagonComponent>();
	int radius;
	ArrayList<Integer> boardPositionsConverter = new ArrayList<Integer>();
	int selectedPiece = -1; 

	public HexBoard(int windSize, double screenWidth, double screenHeight, Game newGame) {
		windowSize = windSize;
		WIDTH = (int)screenWidth;
		HEIGHT = (int)screenHeight;
		game = newGame;
		if(windowSize == 0){
			WIDTH = 500;
			HEIGHT = 400;
		}
		else if(windowSize == 1){
			WIDTH = 924;
			HEIGHT = 768;
		}
		else{
			WIDTH = (int)((screenHeight)*(4/3));
			HEIGHT = (int)screenHeight-100;
		}
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		addMouseListener(this);
	}

	Game getGame() {
		return game;
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Point origin = new Point(WIDTH / 2, HEIGHT / 2);

		radius = HEIGHT/15 - 1;
		drawHexGridLoop(g2d, origin, 9, 2);
	}

	public void drawHexGridLoop(Graphics g, Point origin, int size, int padding) {

		boardHexagons = new ArrayList<HexagonComponent>();

		boardPositionsConverter = new ArrayList<Integer>();

		for(int i = 15; i <= 59; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 14; i <= 69; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 13; i <= 79; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 12; i <= 89; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 11; i <= 99; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 21; i <= 98; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 31; i <= 97; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 41; i <= 96; i+=11)
			boardPositionsConverter.add(i);
		for(int i = 51; i <= 95; i+=11)
			boardPositionsConverter.add(i);

		double ang30 = Math.toRadians(30);
		double xOff = Math.cos(ang30) * (radius + padding);
		double yOff = Math.sin(ang30) * (radius + padding);
		int half = size / 2;
		HexagonComponent hc= new HexagonComponent(0, 0, radius, 0x008844, 2);
		int index = 0;
		for (int row = 0; row < size; row++) {
			int cols = size - Math.abs(row - half);

			for (int col = 0; col < cols; col++,index++) {

				int x = (int) (origin.x + xOff * (col * 2 + 1 - cols));
				int y = (int) (origin.y + yOff * (row - half) * 3);

				String piece = game.getGameBoard().getBoard().getNode(boardPositionsConverter.get(index)).getName();

				if(piece == "B")
					hc = new HexagonComponent(x, y, radius, 0x008844, 2);
				else if(piece == "R") //Red Piece
				hc = new HexagonComponent(x, y, radius, 0x008844, 1);
				else if(piece == "E") //Empty cell
					hc = new HexagonComponent(x, y, radius, 0x008844, 0);
				else if(piece == "W") //Blue wins cell
					hc = new HexagonComponent(x, y, radius, 0x0000FF, 0);
				else if(piece == "L") //Red wins cell
					hc = new HexagonComponent(x, y, radius, 0xFF0000, 0);
				else if(piece == "BS") //Blue piEce SeLeCTEd
					hc = new HexagonComponent(x, y, radius, 0x3ACFFC, 2);
				else if(piece == "RS") //Red piece selected
					hc = new HexagonComponent(x, y, radius, 0x3ACFFC, 1);
				else if(piece == "EH") //Empty cell highlighted
					hc = new HexagonComponent(x, y, radius, 0xB2F78B, 0);
				else if(piece == "BH") //Blue cell highlighted
					hc = new HexagonComponent(x, y, radius, 0xB2F78B, 2);
				else if(piece == "RH") //Red cell highlighted
					hc = new HexagonComponent(x, y, radius, 0xB2F78B, 1);
				else if(piece == "WH") //Blue wins cell highlighted
					hc = new HexagonComponent(x, y, radius, 0xFFD700, 0);
				else if(piece == "LH") //Blue wins cell highlighted
					hc = new HexagonComponent(x, y, radius, 0xFFD700, 0);

				boardHexagons.add(hc);
				hc.draw(g);

			}
		}
	}

	public int isInside(Point point)
	{
		for(int i = 0; i < boardHexagons.size(); i++){
			if(boardHexagons.get(i).getHexagon().contains(point))
				return i;
		}
		return -1;
	}

	public void changeNeighbours(ArrayList<Integer> possibleMoves, int sel){
		if(sel > -1){
			for(int i = 0; i < possibleMoves.size(); i++){
				String positionName = game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).getName(); 
				if(positionName == "E")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("EH");
				else if(positionName == "R")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("RH");
				else if(positionName == "B")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("BH");
				else if(positionName == "L")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("LH");
				else if(positionName == "W")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("WH");
			}
		}
		else{
			for(int i = 0; i < possibleMoves.size(); i++){
				String positionName = game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).getName(); 
				if(positionName == "EH")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("E");
				else if(positionName == "RH")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("R");
				else if(positionName == "BH")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("B");
				else if(positionName == "LH")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("L");
				else if(positionName == "WH")
					game.getGameBoard().getBoard().getNode(possibleMoves.get(i)).changeName("W");
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if(game.getCurrentPlayer().isCPU()){
			Move movement = game.chooseMove(game.getCurrentPlayer(), game.getCurrentPlayer(), game.getCurrentPlayer().getDifficulty(), -2000, 2000);
			int position = movement.getOrigin();
			int newPosition = movement.getDestination();

			game.move(position, newPosition,game.getCurrentPlayer().getPiece(),game.getCurrentPlayer());

			if(game.endGame() != null){
				Color color;
				if(game.endGame().getPiece() == "B")
					color = Color.blue;
				else
					color = Color.red;
				new EndgameWindow(game.getWinningMessage(), color);
			}
			game.changePlayerGUI();
			getParent().revalidate();
			getParent().repaint();
		}
		else{
			int componentClicked = isInside(e.getPoint());

			if(componentClicked == -1)
				return;

			int positionClicked = boardPositionsConverter.get(componentClicked);

			if(positionClicked == -1) {
			} else if(selectedPiece > -1 && selectedPiece != positionClicked){

				String positionClickedName = game.getGameBoard().getBoard().getNode(positionClicked).getName();
				if(positionClickedName == "EH" || positionClickedName == "BH" || positionClickedName == "RH" || positionClickedName == "LH" || positionClickedName == "WH"){

					if("BS" == game.getGameBoard().getBoard().getNode(selectedPiece).getName())
						game.getGameBoard().getBoard().getNode(selectedPiece).changeName("B");
					else
						game.getGameBoard().getBoard().getNode(selectedPiece).changeName("R");

					changeNeighbours(game.possibleMoves(game.getCurrentPlayer(), selectedPiece), -1);
					game.move(selectedPiece, positionClicked,game.getCurrentPlayer().getPiece(),game.getCurrentPlayer());
					selectedPiece = -1;

					if(game.endGame() != null){
						Color color;
						if(game.endGame().getPiece() == "B")
							color = Color.blue;
						else
							color = Color.red;
						new EndgameWindow(game.getWinningMessage(), color);
					}
					game.changePlayerGUI();
					getParent().revalidate();
					getParent().repaint();
				}
			}

			else if(selectedPiece == positionClicked){//unselect a previously selected piece
				if("BS" == game.getGameBoard().getBoard().getNode(selectedPiece).getName())
					game.getGameBoard().getBoard().getNode(positionClicked).changeName("B");
				else
					game.getGameBoard().getBoard().getNode(positionClicked).changeName("R");
				changeNeighbours(game.possibleMoves(game.getCurrentPlayer(), selectedPiece), -1);
				selectedPiece = -1;
				getParent().revalidate();
				getParent().repaint();
			}
			else if((!game.playGUI(game.getCurrentPlayer(), positionClicked)) && selectedPiece == -1){//selected a wrong piece

			}
			else if((game.playGUI(game.getCurrentPlayer(), positionClicked)) && selectedPiece == -1){//selected a valid piece
				selectedPiece = positionClicked;

				changeNeighbours(game.possibleMoves(game.getCurrentPlayer(), selectedPiece), selectedPiece);
				if(game.getGameBoard().getBoard().getNode(positionClicked).getName() == "B")
					game.getGameBoard().getBoard().getNode(positionClicked).changeName("BS");
				else if(game.getGameBoard().getBoard().getNode(positionClicked).getName() == "R")
					game.getGameBoard().getBoard().getNode(positionClicked).changeName("RS");
				getParent().revalidate();
				getParent().repaint();
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}