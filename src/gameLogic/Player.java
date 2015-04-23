package gameLogic;

public class Player {
	String name;
	String piece;
	
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
}