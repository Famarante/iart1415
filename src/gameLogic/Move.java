package gamelogic;


public class Move {
	int score, origin, destination;
	
	public Move(){
		score = 0;
		origin = 0;
		destination = 0;
	}
	public void setScore(int s){
		score = s;
	}
	public void setPositions(int o, int d){
		origin = o;
		destination = d;
	}
	public int getScore(){
		return score;
	}
	public int getOrigin(){
		return origin;
	}
	public int getDestination(){
		return destination;
	}
}
