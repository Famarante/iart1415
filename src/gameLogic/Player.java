package gamelogic;

import java.util.ArrayList;

import board.Board;

public class Player {
	String name;
	String piece;
	ArrayList<Integer> pieces = new ArrayList<Integer>();
	boolean cpu;
	
	public Player(String n, String p, boolean c){

		this.name=n;
		this.piece=p;
		this.cpu=c;
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
	
	public boolean isCPU(){
		return this.cpu;
	}
}