package gameLogic;

import java.util.Scanner;

import board.Board;

public class Game {
	
	static Board gameBoard = new Board();
	Player p1, p2;
	
	public void printBoard(){
		gameBoard.printBoard();
	}
	
	public void start(){
		Scanner sc = new Scanner(System.in); 
		System.out.println("Que tipo de jogo deseja?\n"
				+ "1.Computador vs Computador\n"
				+ "2.Jogador vs Computador\n"
				+ "3.JogadorvsJogador");
		int mode=sc.nextInt();
		
		if(mode == 3){
			System.out.println("Nome do Jogador1:");
			while(sc.nextLine() == null){} //porque esta a ler em branco e o jogador1 fica sem nome
			String name1=sc.nextLine();
			p1 = new Player(name1,"B");
			
			System.out.println("Nome do Jogador2:");
			String name2=sc.nextLine();
			p2 = new Player(name2,"R");
		}
		gameBoard.init();
		play(p1);
		sc.close();
	}
	
	public String getP1Name(){
		return p1.getName();
	}
	public String getP2Name(){
		return p2.getName();
	}
	
	public void play(Player player){
		
		printBoard();
		Scanner sc = new Scanner(System.in);
		System.out.println(player.getName()+" wich piece you wish to move?");
		int position = sc.nextInt();
		while(!validPick(position,player)){
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
			System.out.println("In which direction you wish to move the selected piece?\n"
					+ "1-northeast\n"
					+ "2-east\n"
					+ "3-southeast\n"
					+ "4-southwest\n"
					+ "5-west\n"
					+ "6-northwest\n");
			direction = sc.nextInt();
		}
		int newPosition = directionEnd(position, direction);
		move(position,newPosition,player.getPiece());
		gameBoard.printBoard();
	}
	
	public void move(int position, int newPosition, String playerPiece){
		gameBoard.replace(position, newPosition, "E", playerPiece);
	}
	
	public boolean validPick(int position,Player player){
		
		if(gameBoard.getBoard().getNode(position)==null || gameBoard.getBoard().getNode(position).getName() != player.getPiece()){
			System.out.println("You must choose one of your pieces! (" +player.getPiece()+")\n");
			return false;
		}
			
		
		if(isStuck(position)){
			System.out.println("The piece you chose is stuck!\n");

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
				System.out.println("You cant move the selected piece in the northeast direction, as it would leave the board!\n");
			else if(direction == 2)
				System.out.println("You cant move the selected piece in the east direction, as it would leave the board!\n");
			else if(direction == 3)
				System.out.println("You cant move the selected piece in the southeast direction, as it would leave the board!\n");
			else if(direction == 4)
				System.out.println("You cant move the selected piece in the southwest direction, as it would leave the board!\n");
			else if(direction == 5)
				System.out.println("You cant move the selected piece in the west direction, as it would leave the board!\n");
			else if(direction == 6)
				System.out.println("You cant move the selected piece in the northwest direction, as it would leave the board!\n");

			return false;
		}
		else if(gameBoard.getBoard().getNode(newPosition).getName()==ending){
			if(direction == 1)
				System.out.println("You cant move the selected piece in the northeast direction, as it would land on your opponents winning spot!\n");
			else if(direction == 2)
				System.out.println("You cant move the selected piece in the east direction, as it would land on your opponents winning spot!\n");
			else if(direction == 3)
				System.out.println("You cant move the selected piece in the southeast direction, as it would land on your opponents winning spot!\n");
			else if(direction == 4)
				System.out.println("You cant move the selected piece in the southwest direction, as it would land on your opponents winning spot!\n");
			else if(direction == 5)
				System.out.println("You cant move the selected piece in the west direction, as it would land on your opponents winning spot!\n");
			else if(direction == 6)
				System.out.println("You cant move the selected piece in the northwest direction, as it would land on your opponents winning spot!\n");
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
}
