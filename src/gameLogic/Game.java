package gamelogic;

import java.util.ArrayList;
import java.util.Scanner;

import board.Board;

@SuppressWarnings("resource")

public class Game {

	static Board gameBoard = new Board();
	Player p1, p2;
	ArrayList<String> moves;
	String endMessage, errorMessage;

	public void printBoard(){
		gameBoard.printBoard();
	}

	public void start(){
		Scanner sc = new Scanner(System.in); 
		System.out.println("What type of game do you want?\n"
				+ "1 - CPU vs CPU\n"
				+ "2 - Player vs CPU\n"
				+ "3 - Player vs Player");
		int mode=Integer.parseInt(sc.nextLine());
		
		moves = new ArrayList<String>();
		
		if(mode == 1){
			p1 = new Player("CPU1","B",true, 5);
			p2 = new Player("CPU2","R",true, 3);
		}
		else if(mode ==2){
			System.out.print("Player name: ");
			String name=sc.nextLine();
			System.out.print("Which color do you want to be?\n1-Blue\n2-Red ");
			int color = sc.nextInt();
			if(color==1){
				p1 = new Player(name,"B",false, 0);
				p2 = new Player("CPU2","R",true, 3);
			}
			else{
				p1 = new Player("CPU1","B",true, 3);
				p2 = new Player(name,"R",false, 0);
			}
		}
		else if(mode == 3){
			System.out.print("Nome do Jogador1: ");
			String name1=sc.nextLine();
			p1 = new Player(name1,"B",false, 0);

			System.out.print("Nome do Jogador2: ");
			String name2=sc.nextLine();
			p2 = new Player(name2,"R",false, 0);

		}
		
		p1.addPiece(12);
		p1.addPiece(13);
		p1.addPiece(14);
		p1.addPiece(15);
		p1.addPiece(22);
		p1.addPiece(21);
		p1.addPiece(31);
		p1.addPiece(41);
		p1.addPiece(51);
		
		p2.addPiece(59);
		p2.addPiece(69);
		p2.addPiece(79);
		p2.addPiece(89);
		p2.addPiece(88);
		p2.addPiece(98);
		p2.addPiece(97);
		p2.addPiece(96);
		p2.addPiece(95);
		
		gameBoard.init();
		
		Player currentPlayer = p1;
		while(endGame() == null){
			play(currentPlayer);
			if(currentPlayer == p1)
				currentPlayer = p2;
			else
				currentPlayer = p1;
			
		}
		
		System.out.println(endMessage);
		sc.close();
	}

	public String getP1Name(){
		return p1.getName();
	}
	public String getP2Name(){
		return p2.getName();
	}

	public void play(Player player){

		int position, newPosition;
		printBoard();
		if(player.isCPU()){

			Move movement = chooseMove(player, player, player.getDifficulty(), -2000, 2000);
			position = movement.getOrigin();
			newPosition = movement.getDestination();
			System.out.println(player.getName() + " moved from " + position + " to " + newPosition);
		}
		else{
			Scanner sc = new Scanner(System.in);
			System.out.println(player.getName()+" which piece you wish to move?");
			position = sc.nextInt();
			while(!validPick(position,player)){
				System.out.println(errorMessage);
				System.out.println(player.getName()+" which piece you wish to move?");
				position = sc.nextInt();
			}
			System.out.println("In which direction you wish to move the selected piece?\n"
					+ "1-northeast\n"
					+ "2-east\n"
					+ "3-southeast\n"
					+ "4-southwest\n"
					+ "5-west\n"
					+ "6-northwest\n");
			int direction = sc.nextInt();
			while(!validDirection(position, direction)){
				System.out.println(errorMessage);
				System.out.println("In which direction you wish to move the selected piece?\n"
						+ "1-northeast\n"
						+ "2-east\n"
						+ "3-southeast\n"
						+ "4-southwest\n"
						+ "5-west\n"
						+ "6-northwest\n");
				direction = sc.nextInt();
			}
			newPosition = directionEnd(position, direction);
		}
		move(position,newPosition,player.getPiece(),player);

	}

	public void move(int position, int newPosition, String playerPiece,Player player){

		if(gameBoard.getBoard().getNode(newPosition).getName()=="R"){
			p2.removePiece(newPosition);
			p1.removePiece(position);
			p1.addPiece(newPosition);
			moves.add("R");
		}
		else if(gameBoard.getBoard().getNode(newPosition).getName()=="B"){
			p1.removePiece(newPosition);
			p2.removePiece(position);
			p2.addPiece(newPosition);
			moves.add("B");
		}
		else if(gameBoard.getBoard().getNode(newPosition).getName()=="W" || gameBoard.getBoard().getNode(newPosition).getName()=="L"){
			player.removePiece(position);
			player.addPiece(newPosition);
			moves.add(gameBoard.getBoard().getNode(newPosition).getName());
		}
		else{
			player.removePiece(position);
			player.addPiece(newPosition);
			moves.add("E");
		}
		gameBoard.replace(position, newPosition, "E", playerPiece);

	}
	
	public void undo(int position, int newPosition, Player player){
		
		String dest = moves.get(moves.size()-1), orig;
		
		if(dest=="R"){
			p1.removePiece(newPosition);
			p1.addPiece(position);
			p2.addPiece(newPosition);
			orig = "B";
		}
		else if(dest=="B"){
			p2.removePiece(newPosition);
			p2.addPiece(position);
			p1.addPiece(newPosition);
			orig = "R";
		}
		else{
			player.addPiece(position);
			player.removePiece(newPosition);
			orig = player.getPiece();
		}
		gameBoard.replace(position, newPosition, orig, dest);
		moves.remove(moves.size()-1);
	}
	
	public boolean validPick(int position,Player player){

		if(gameBoard.getBoard().getNode(position)==null || gameBoard.getBoard().getNode(position).getName() != player.getPiece()){
			errorMessage = "You must choose one of your pieces! (" +player.getPiece()+")\n";
			return false;
		}


		if(isStuck(position)){
			errorMessage = "The piece you chose is stuck!\n";
			return false;
		}


		return true;
	}

	public boolean isStuck(int position){

		String ally = gameBoard.getBoard().getNode(position).getName();
		String opponent;

		if(ally == "B")
			opponent = "R";
		else
			opponent = "B";


		if(gameBoard.getBoard().getNode(position+1)!=null && gameBoard.getBoard().getNode(position+1).getName() == opponent) //check northeast
			return true;

		if(gameBoard.getBoard().getNode(position+11)!=null && gameBoard.getBoard().getNode(position+11).getName() == opponent) //check east
			return true;

		if(gameBoard.getBoard().getNode(position+10)!=null && gameBoard.getBoard().getNode(position+10).getName() == opponent) //check southeast
			return true;

		if(gameBoard.getBoard().getNode(position-1)!=null && gameBoard.getBoard().getNode(position-1).getName() == opponent) //check southwest
			return true;

		if(gameBoard.getBoard().getNode(position-11)!=null && gameBoard.getBoard().getNode(position-11).getName() == opponent) //check west
			return true;

		if(gameBoard.getBoard().getNode(position-10)!=null && gameBoard.getBoard().getNode(position-10).getName() == opponent) //check norththwest
			return true;

		return false;
	}


	public boolean allStuck(Player player){

		for(int i = 0; i<player.getAllPieces().size();i++){
			if(!isStuck(player.getAllPieces().get(i)))
				return false;
		}

		return true;
	}
	public boolean validDirection(int position, int direction){

		int newPosition = directionEnd(position, direction);

		String ally = gameBoard.getBoard().getNode(position).getName();
		String ending;

		if(ally == "B")
			ending = "L";
		else
			ending = "W";


		if(gameBoard.getBoard().getNode(newPosition)==null){
			if(direction == 1)
				errorMessage = "You cant move the selected piece in the northeast direction, as it would leave the board!\n";
			else if(direction == 2)
				errorMessage = "You cant move the selected piece in the east direction, as it would leave the board!\n";
			else if(direction == 3)
				errorMessage = "You cant move the selected piece in the southeast direction, as it would leave the board!\n";
			else if(direction == 4)
				errorMessage = "You cant move the selected piece in the southwest direction, as it would leave the board!\n";
			else if(direction == 5)
				errorMessage = "You cant move the selected piece in the west direction, as it would leave the board!\n";
			else if(direction == 6)
				errorMessage = "You cant move the selected piece in the northwest direction, as it would leave the board!\n";

			return false;
		}
		else if(gameBoard.getBoard().getNode(newPosition).getName()==ending){
			if(direction == 1)
				errorMessage = "You cant move the selected piece in the northeast direction, as it would land on your opponents winning spot!\n";
			else if(direction == 2)
				errorMessage = "You cant move the selected piece in the east direction, as it would land on your opponents winning spot!\n";
			else if(direction == 3)
				errorMessage = "You cant move the selected piece in the southeast direction, as it would land on your opponents winning spot!\n";
			else if(direction == 4)
				errorMessage = "You cant move the selected piece in the southwest direction, as it would land on your opponents winning spot!\n";
			else if(direction == 5)
				errorMessage = "You cant move the selected piece in the west direction, as it would land on your opponents winning spot!\n";
			else if(direction == 6)
				errorMessage = "You cant move the selected piece in the northwest direction, as it would land on your opponents winning spot!\n";
			return false;
		}
		return true;
	}

	public int directionEnd(int position, int direction){

		int newPosition = position;

		String ally = gameBoard.getBoard().getNode(position).getName();

		if(direction == 1){ //northeast +1
			newPosition++;

			while(gameBoard.getBoard().getNode(newPosition)!=null && gameBoard.getBoard().getNode(newPosition).getName() == ally) 
				newPosition++;
		}
		else if(direction == 2){ //east +11
			newPosition+=11;

			while(gameBoard.getBoard().getNode(newPosition)!=null && gameBoard.getBoard().getNode(newPosition).getName() == ally)
				newPosition+=11;
		}
		else if(direction == 3){ //southeast +10
			newPosition+=10;

			while(gameBoard.getBoard().getNode(newPosition)!=null && gameBoard.getBoard().getNode(newPosition).getName() == ally) 
				newPosition+=10;
		}
		else if(direction == 4){ //southwest -1
			newPosition--;

			while(gameBoard.getBoard().getNode(newPosition)!=null && gameBoard.getBoard().getNode(newPosition).getName() == ally)
				newPosition--;
		}
		else if(direction == 5){ //west -11
			newPosition-=11;

			while(gameBoard.getBoard().getNode(newPosition)!=null && gameBoard.getBoard().getNode(newPosition).getName() == ally)
				newPosition-=11;
		}
		else if(direction == 6){ //northwest -10
			newPosition-=10;

			while(gameBoard.getBoard().getNode(newPosition)!=null && gameBoard.getBoard().getNode(newPosition).getName() == ally)
				newPosition-=10;
		}

		return newPosition;
	}

	public Player endGame(){
		if(gameBoard.getBoard().getNode(99).getName()=="B"){
			endMessage = "Congratulations "+p1.getName()+" you managed to land a piece on your victory spot!!!";
			return p1;
		}
		else if(gameBoard.getBoard().getNode(11).getName()=="R"){
			endMessage = "Congratulations "+p2.getName()+" you managed to land a piece on your victory spot!!!";
			return p2;
		}
		else if(allStuck(p1)){
			endMessage = "Congratulations "+p2.getName()+" you managed to immobilize all you opponent's pieces!!!";
			return p2;
		}
		else if(allStuck(p2)){
			endMessage = "Congratulations "+p1.getName()+" you managed to immobilize all you opponent's pieces!!!";
			return p1;
		}
		return null;
	}
	
	//__________________________________________COMPUTER MOVEMENT FUCNTIONS____________________________________________________________________
	public Move chooseMove(Player player, Player turn, int depth, int alpha, int beta){
		
		Move currentBest = new Move();
		
		int boardValue = evalFunction(player); 
		
		if(boardValue == 1000 || boardValue == -1000 || depth == 0){
			currentBest.setScore(boardValue);
			return currentBest;
		}
		
		Player opponent;
		
		if(turn == p1)
			opponent = p2;
		else
			opponent = p1;
		
		
		if(turn == player)
			currentBest.setScore(alpha);
		else
			currentBest.setScore(beta);
		
		
		ArrayList<ArrayList<Integer> > allMoves = getAllMoves(turn);
		
		for(int i = 0; i < allMoves.size(); i++){
			
			move(allMoves.get(i).get(0), allMoves.get(i).get(1), gameBoard.getBoard().getNode(allMoves.get(i).get(0)).getName(), turn);
			
			Move reply = chooseMove(player, opponent, depth-1, alpha, beta);
			
			undo(allMoves.get(i).get(0), allMoves.get(i).get(1), turn);
			
			if((turn == player) && (reply.getScore() > currentBest.getScore())){
				currentBest.setScore(reply.getScore());
				currentBest.setPositions(allMoves.get(i).get(0), allMoves.get(i).get(1));
				alpha = reply.getScore();
			}
			else if((turn != player) && (reply.getScore() < currentBest.getScore())) {
				currentBest.setScore(reply.getScore());
				currentBest.setPositions(allMoves.get(i).get(0), allMoves.get(i).get(1));
				beta = reply.getScore();
			}
			if(alpha >= beta)
				return currentBest;
		}
		return currentBest;
	}
	
	public ArrayList<ArrayList<Integer> > getAllMoves(Player player){
		
		ArrayList<ArrayList<Integer> > allMoves = new ArrayList<ArrayList<Integer> >();
		
		ArrayList<Integer> allPieces = player.getAllPieces();
		for(int i = 0; i < allPieces.size(); i++){
			int position = allPieces.get(i);
			if(validPick(position,player)){
				for(int dir = 1; dir <= 6; dir++){
					if(validDirection(position,dir)){
						int newPosition = directionEnd(position, dir);
						ArrayList<Integer> move = new ArrayList<Integer>();
						move.add(position);
						move.add(newPosition);
						allMoves.add(move);
					}
				}
			}
		}
		
		return allMoves;
	}
	
	public int evalFunction(Player player){
		int ret = 0;
		Player current, opponent;
		
		if(player == p1){
			current = p1;
			opponent = p2;
		}
		else{
			current = p2;
			opponent = p1;
		}
		
		int CurrentStuckPieces = numberofPiecesStuck(current);
		int OpponentStuckPieces = numberofPiecesStuck(opponent);
		int CurrentNumberofPieces = current.getAllPieces().size();
		int OpponentNumberofPieces = opponent.getAllPieces().size();
				
		//calcEval
		if(endGame() == current)
			ret = 1000;
		else if(endGame() == opponent)
			ret = -1000;
		else {
			ret = OpponentStuckPieces + CurrentNumberofPieces - CurrentStuckPieces - OpponentNumberofPieces - calcDistanceToWin(current); 
		}
		return ret;
	}
	
	public int numberofPiecesStuck(Player player){
		int piecesStuck=0;
		
		for(int i = 0; i<player.getAllPieces().size();i++){
			if(isStuck(player.getAllPieces().get(i)))
				piecesStuck++;
		}
		
		return piecesStuck;
	}

	public int calcDistanceToWin(Player player){
		int dist = 10, goal;
		
		if(player == p1)
			goal = 9;
		else
			goal = 1;
		
		for(int i = 0; i < player.getAllPieces().size(); i++){
			if(!isStuck(player.getAllPieces().get(i))){
				int temp = calcDist(player.getAllPieces().get(i), goal);
				if(temp < dist)
					dist = temp;
			}
		}
		
		return dist;
	}
	
	public int calcDist(int position, int dest){
		int posX = position/10, posY = position%10;
		
		int d1= Math.abs(dest-posX), d2= Math.abs(dest-posY);
		if(d1>=d2)
			return d1;
		return d2;
	}
	//__________________________________________________________________________________________________________________________________________
}
