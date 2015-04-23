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
		System.out.println("Que tipo de jogo deseja?\n1.Computador vs Computador\n2.Jogador vs Computador\n3.JogadorvsJogador");
		int mode=sc.nextInt();
		
		if(mode == 3){
			
			System.out.println("Nome do Jogador1:\n");
			while(sc.nextLine() == null){} //porque estava a ler em branco e o jogador1 ficava sem nome
			String name1=sc.nextLine();
			p1 = new Player(name1,"B");
			
			System.out.println("Nome do Jogador2:\n");
			String name2=sc.nextLine();
			p2 = new Player(name2,"R");
		}
		gameBoard.init();
		play(p1);
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
		while(!validPick(position,p1)){
			System.out.println(player.getName()+" wich piece you wish to move?");
			position = sc.nextInt();
		}
		System.out.println(position);
	}
	
	public boolean validPick(int position,Player player){
		
		if(gameBoard.getBoard().getNode(position).getName() != player.getPiece()){
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
		
		if(gameBoard.getBoard().getNode(position+1).getName() == opponent) //check northeast
			return true;
		
		if(gameBoard.getBoard().getNode(position+11).getName() == opponent) //check east
			return true;
		
		if(gameBoard.getBoard().getNode(position+10).getName() == opponent) //check southeast
			return true;
		
		if(gameBoard.getBoard().getNode(position-10).getName() == opponent) //check southwest
			return true;
		
		if(gameBoard.getBoard().getNode(position-11).getName() == opponent) //check west
			return true;
		
		if(gameBoard.getBoard().getNode(position-1).getName() == opponent) //check norththwest
			return true;
		
		return false;
	}
}
