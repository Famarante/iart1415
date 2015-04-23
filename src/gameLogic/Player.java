package gameLogic;

import java.util.ArrayList;

public class Player {
	String name;
	String piece;
	ArrayList<Integer> pieces = new ArrayList<Integer>();
	
	public Player(String n, String p){
		this.name=n;
		this.piece=p;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getPiece(){
		return this.piece;
	}
	
	public void addPiece(int position){
		pieces.add(position);
	}
	
	public void removePiece(int position){
		pieces.remove(new Integer(position));
	}
	
	public ArrayList<Integer> getAllPieces(){
		return this.pieces;
	}
}