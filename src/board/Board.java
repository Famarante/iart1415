package board;
import graph.*;


public class Board {
	Graph board;
	
	public void init(){
		Node a1 = new Node("RedWins");
		Node a2 = new Node("Blue");
		Node a3 = new Node("Blue");
		Node a4 = new Node("Blue");
		Node a5 = new Node("Blue");
		Node b1 = new Node("Blue");
		Node b2 = new Node("Blue");
		Node b3 = new Node("Empty");
		Node b4 = new Node("Empty");
		Node b5 = new Node("Empty");
		Node b6 = new Node("Empty");
		Node c1 = new Node("Blue");
		Node c2 = new Node("Empty");
		Node c3 = new Node("Empty");
		Node c4 = new Node("Empty");
		Node c5 = new Node("Empty");
		Node c6 = new Node("Empty");
		Node c7 = new Node("Empty");
		Node d1 = new Node("Blue");
		Node d2 = new Node("Empty");
		Node d3 = new Node("Empty");
		Node d4 = new Node("Empty");
		Node d5 = new Node("Empty");
		Node d6 = new Node("Empty");
		Node d7 = new Node("Empty");
		Node d8 = new Node("Empty");
		Node e1 = new Node("Blue");
		Node e2 = new Node("Empty");
		Node e3 = new Node("Empty");
		Node e4 = new Node("Empty");
		Node e5 = new Node("Empty");
		Node e6 = new Node("Empty");
		Node e7 = new Node("Empty");
		Node e8 = new Node("Empty");
		Node e9 = new Node("Red");
		Node f2 = new Node("Empty");
		Node f3 = new Node("Empty");
		Node f4 = new Node("Empty");
		Node f5 = new Node("Empty");
		Node f6 = new Node("Empty");
		Node f7 = new Node("Empty");
		Node f8 = new Node("Empty");
		Node f9 = new Node("Red");
		Node g3 = new Node("Empty");
		Node g4 = new Node("Empty");
		Node g5 = new Node("Empty");
		Node g6 = new Node("Empty");
		Node g7 = new Node("Empty");
		Node g8 = new Node("Empty");
		Node g9 = new Node("Red");
		Node h4 = new Node("Empty");
		Node h5 = new Node("Empty");
		Node h6 = new Node("Empty");
		Node h7 = new Node("Empty");
		Node h8 = new Node("Red");
		Node h9 = new Node("Red");
		Node i5 = new Node("Red");
		Node i6 = new Node("Red");
		Node i7 = new Node("Red");
		Node i8 = new Node("Red");
		Node i9 = new Node("BlueWins");
		
		board.
/*		
		Edge a1a2 = new Edge(a1, a2, "NESW");
		Edge a1b2 = new Edge(a1, b2, "E");
		Edge a1b1 = new Edge(a1, b1, "SE");
		Edge a2a3 = new Edge(a2, a3, "NE");
		Edge a2b3 = new Edge(a2, b3, "E");
		Edge a2b2 = new Edge(a2, b2, "SE");
		Edge a3a4 = new Edge(a3, a4, "NE");
		Edge a3b4 = new Edge(a3, b4, "E");
		Edge a3b3 = new Edge(a3, b3, "SE");
		Edge a4a5 = new Edge(a4, a5, "NE");
		Edge a4b5 = new Edge(a4, b5, "E");
		Edge a4b4 = new Edge(a4, b4, "SE");
		Edge a5b6 = new Edge(a5, b6, "E");
		Edge a5b5 = new Edge(a5, b5, "SE");
		Edge b1b2 = new Edge(b1, b2, "NE");
		Edge b1c1 = new Edge(b1, c1, "SE");
		Edge b1c2 = new Edge(b1, c2, "E");
		Edge b2b3 = new Edge(b2, b3, "NE");
		Edge b2c3 = new Edge(b2, c3, "E");
		Edge b2c2 = new Edge(b2, c2, "SE");
		Edge b3b4 = new Edge(b3, b4, "NE");
		Edge b3c4 = new Edge(b3, c4, "E");
		Edge b3c3 = new Edge(b3, c3, "SE");
		Edge b4b5 = new Edge(b4, b5, "NE");
		Edge b4c5 = new Edge(b4, c5, "E");
		Edge b4c4 = new Edge(b4, c4, "SE");
		Edge b5b6 = new Edge(b5, b6, "NE");
		Edge b5c6 = new Edge(b5, c6, "E");
		Edge b5c5 = new Edge(b5, c5, "SE");
		Edge b6c7 = new Edge(b6, c7, "E");
		Edge b6c6 = new Edge(b5, c6, "SE");
		Edge c1c2 = new Edge(c1, c2, "NE");
		Edge c1d2 = new Edge(c1, d2, "E");
		Edge c1d1 = new Edge(c1, d1, "SE");
		Edge c2c3 = new Edge(c2, c3, "NE");
		Edge c2d3 = new Edge(c2, d3, "E");
		Edge c2d2 = new Edge(c2, d2, "SE");
		Edge c3c4 = new Edge(c3, c4, "NE");
		Edge c3d4 = new Edge(c3, d4, "E");
		Edge c3d3 = new Edge(c3, d3, "SE");
		Edge c4c5 = new Edge(c4, c5, "NE");
		Edge c4d5 = new Edge(c4, d5, "E");
		Edge c4d4 = new Edge(c4, d4, "SE");
		Edge c5c6 = new Edge(c5, c6, "NE");
		Edge c5d6 = new Edge(c5, d6, "E");
		Edge c5d5 = new Edge(c5, d5, "SE");
		Edge c6c7 = new Edge(c6, c7, "NE");
		Edge c6d7 = new Edge(c6, d7, "E");
		Edge c6d6 = new Edge(c6, d6, "SE");
		Edge c7d8 = new Edge(c7, d8, "E");
		Edge c7d7 = new Edge(c7, d7, "SE");
		Edge d1d2 = new Edge(d1, d2, "NE");
		Edge d1e2 = new Edge(d1, e2, "E");
		Edge d1e1 = new Edge(d1, e1, "SE");
		Edge d2d3 = new Edge(d2, d3, "NE");
		Edge d2e3 = new Edge(d2, e3, "E");
		Edge d2e2 = new Edge(d2, e2, "SE");
		Edge d3d4 = new Edge(d3, d4, "NE");
		Edge d3e4 = new Edge(d3, e4, "E");
		Edge d3e3 = new Edge(d3, e3, "SE");
		Edge d4d5 = new Edge(d4, d5, "NE");
		Edge d4e5 = new Edge(d4, e5, "E");
		Edge d4e4 = new Edge(d4, e4, "SE");
		Edge d5d6 = new Edge(d5, d6, "NE");
		Edge d5e6 = new Edge(d5, e6, "E");
		Edge d5e5 = new Edge(d5, e5, "SE");
		Edge d6d7 = new Edge(d6, d7, "NE");
		Edge d6e7 = new Edge(d6, e7, "E");
		Edge d6e6 = new Edge(d6, e6, "SE");
		Edge d7d8 = new Edge(d7, d8, "NE");
		Edge d7e8 = new Edge(d7, e8, "E");
		Edge d7e7 = new Edge(d7, e7, "SE");
		Edge d8e9 = new Edge(d8, e9, "E");
		Edge d8e8 = new Edge(d8, e8, "SE");
		Edge e1e2 = new Edge(e1, e2, "NE");
		Edge e1f2 = new Edge(e1, f2, "E");
		Edge e2e3 = new Edge(e2, e3, "NE");
		Edge e2f3 = new Edge(e2, f3, "E");
		Edge e2f2 = new Edge(e2, f2, "SE");
		Edge e3e4 = new Edge(e3, e4, "NE");
		Edge e3f4 = new Edge(e3, f4, "E");
		Edge e3f3 = new Edge(e3, f3, "SE");
		Edge e4e5 = new Edge(e4, e5, "NE");
		Edge e4f5 = new Edge(e4, f5, "E");
		Edge e4f4 = new Edge(e4, f4, "SE");
		Edge e5e6 = new Edge(e5, e6, "NE");
		Edge e5f6 = new Edge(e5, f6, "E");
		Edge e5f5 = new Edge(e5, f5, "SE");
		Edge e6e7 = new Edge(e6, e7, "NE");
		Edge e6f7 = new Edge(e6, f7, "E");
		Edge e6f6 = new Edge(e6, f6, "SE");
		Edge e7e8 = new Edge(e7, e8, "NE");
		Edge e7f8 = new Edge(e7, f8, "E");
		Edge e7f7 = new Edge(e7, f7, "SE");
		Edge e8e9 = new Edge(e8, e9, "NE");
		Edge e8f9 = new Edge(e8, f9, "E");
		Edge e8f8 = new Edge(e8, f8, "SE");
		Edge e9f9 = new Edge(e9, f9, "SE");
		Edge f2f3 = new Edge(f2, f3, "NE");
		Edge f2g3 = new Edge(f2, g3, "E");
		Edge f3f4 = new Edge(f3, f4, "NE");
		Edge f3g4 = new Edge(f3, g4, "E");
		Edge f3g3 = new Edge(f3, g3, "SE");
		Edge f4f5 = new Edge(f4, f5, "NE");
		Edge f4g5 = new Edge(f4, g5, "E");
		Edge f4g4 = new Edge(f4, g4, "SE");
		Edge f5f6 = new Edge(f5, f6, "NE");
		Edge f5g6 = new Edge(f5, g6, "E");
		Edge f5g5 = new Edge(f5, g5, "SE");
		Edge f6f7 = new Edge(f6, f7, "NE");
		Edge f6g7 = new Edge(f6, g7, "E");
		Edge f6g6 = new Edge(f6, g6, "SE");
		Edge f7f8 = new Edge(f7, f8, "NE");
		Edge f7g8 = new Edge(f7, g8, "E");
		Edge f7g7 = new Edge(f7, g7, "SE");
		Edge f8f9 = new Edge(f8, f9, "NE");
		Edge f8g9 = new Edge(f8, g9, "E");
		Edge f8g8 = new Edge(f8, g8, "SE");
		Edge f9g9 = new Edge(f9, g9, "SE");
		Edge g3g4 = new Edge (g3, g4, "NE");
		Edge g3h4 = new Edge (g3, h4, "E");
		Edge g4g5 = new Edge (g4, g5, "NE");
		Edge g4h5 = new Edge (g4, h5, "E");
		Edge g4h4 = new Edge (g4, h4, "SE");
		Edge g5g6 = new Edge (g5, g6, "NE");
		Edge g5h6 = new Edge (g5, h6, "E");
		Edge g5h5 = new Edge (g5, h5, "SE");
		Edge g6g7 = new Edge (g6, g7, "NE");
		Edge g6h7 = new Edge (g6, h7, "E");
		Edge g6h6 = new Edge (g6, h6, "SE");
		Edge g7g8 = new Edge (g7, g8, "NE");
		Edge g7h8 = new Edge (g7, h8, "E");
		Edge g7h7 = new Edge (g7, h7, "SE");
		Edge g8g9 = new Edge (g8, g9, "NE");
		Edge g8h9 = new Edge (g8, h9, "E");
		Edge g8h8 = new Edge (g8, h8, "SE");
		Edge g9h9 = new Edge (g9, h9, "SE");
		Edge h4h5 = new Edge (h4, h5, "NE");
		Edge h4i5 = new Edge (h4, i5, "E");
		Edge h5h6 = new Edge (h5, h6, "NE");
		Edge h5i6 = new Edge (h5, i6, "E");
		Edge h5i5 = new Edge (h5, i5, "SE");
		Edge h6h7 = new Edge (h6, h7, "NE");
		Edge h6i7 = new Edge (h6, i7, "E");
		Edge h6i6 = new Edge (h6, i6, "SE");
		Edge h7h8 = new Edge (h7, h8, "NE");
		Edge h7i8 = new Edge (h7, i8, "E");
		Edge h7i7 = new Edge (h7, i7, "SE");
		Edge h8h9 = new Edge (h8, h9, "NE");
		Edge h8i9 = new Edge (h8, i9, "E");
		Edge h8i8 = new Edge (h8, i8, "SE");
		Edge h9i9 = new Edge (h9, i9, "SE");
		Edge i5i6 = new Edge (i5, i6, "NE");
		Edge i6i7 = new Edge (i6, i7, "NE");
		Edge i7i8 = new Edge (i7, i8, "NE");
		Edge i8i9 = new Edge (i8, i9, "NE");
*/

		
		
	}
	
	private static char tabuleiro[][] = new char[17][9];
	private static final int TAB_A = 0;
	private static final int TAB_B = 1;
	private static final int TAB_C = 2;
	private static final int TAB_D = 3;
	private static final int TAB_E = 4;
	private static final int TAB_F = 5;
	private static final int TAB_G = 6;
	private static final int TAB_H = 7;
	private static final int TAB_I = 8;
	private static final int TAB_1 = 0;
	private static final int TAB_2 = 1;
	private static final int TAB_3 = 2;
	private static final int TAB_4 = 3;
	private static final int TAB_5 = 4;
	private static final int TAB_6 = 5;
	private static final int TAB_7 = 6;
	private static final int TAB_8 = 7;
	private static final int TAB_9 = 8;

	public Tabuleiro(){

	}

	public void preencheTabuleiro(){
		for(int i = 0; i < 9; i++){
			for(int j = 0; j < 9; j++){
				tabuleiro[i][j] = '*';
			}
		}
	}
/*
	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append("    " + tabuleiro[TAB_A][TAB_5] + " " + tabuleiro[TAB_B][TAB_5] + "")
		s.append("    "+tabuleiro[TAB_E][TAB_10]+" "+tabuleiro[TAB_G][TAB_11]+"    ");
		s.append(System.lineSeparator());
		s.append("   "+tabuleiro[TAB_D][TAB_9]+" "+tabuleiro[TAB_F][TAB_10]+" "+tabuleiro[TAB_H][TAB_11]+"   ");
		s.append(System.lineSeparator());
		s.append("  "+tabuleiro[TAB_C][TAB_8]+" "+tabuleiro[TAB_E][TAB_9]+" "+tabuleiro[TAB_G][TAB_10]+" "+tabuleiro[TAB_I][TAB_11]+"  ");
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_7]+" "+tabuleiro[TAB_D][TAB_8]+" "+tabuleiro[TAB_F][TAB_9]+" "+tabuleiro[TAB_H][TAB_10]+" "+tabuleiro[TAB_J][TAB_11]+" ");
		s.append(System.lineSeparator());
		s.append("  "+tabuleiro[TAB_C][TAB_7]+" "+tabuleiro[TAB_E][TAB_8]+" "+tabuleiro[TAB_G][TAB_9]+" "+tabuleiro[TAB_I][TAB_10]+"  ");
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_6]+" "+tabuleiro[TAB_D][TAB_7]+" "+tabuleiro[TAB_F][TAB_8]+" "+tabuleiro[TAB_H][TAB_9]+" "+tabuleiro[TAB_J][TAB_10]+" ");
		s.append(System.lineSeparator());
		s.append(tabuleiro[TAB_A][TAB_5]+" "+tabuleiro[TAB_C][TAB_6]+" "+tabuleiro[TAB_E][TAB_7]+" "+tabuleiro[TAB_G][TAB_8]+" "+tabuleiro[TAB_I][TAB_9]+" "+tabuleiro[TAB_K][TAB_10]);
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_5]+" "+tabuleiro[TAB_D][TAB_6]+" "+tabuleiro[TAB_F][TAB_7]+" "+tabuleiro[TAB_H][TAB_8]+" "+tabuleiro[TAB_J][TAB_9]+"  ");
		s.append(System.lineSeparator());
		s.append(tabuleiro[TAB_A][TAB_4]+" "+tabuleiro[TAB_C][TAB_5]+" "+tabuleiro[TAB_E][TAB_6]+" "+tabuleiro[TAB_G][TAB_7]+" "+tabuleiro[TAB_I][TAB_8]+" "+tabuleiro[TAB_K][TAB_9]);
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_4]+" "+tabuleiro[TAB_D][TAB_5]+" "+tabuleiro[TAB_F][TAB_6]+" "+tabuleiro[TAB_H][TAB_7]+" "+tabuleiro[TAB_J][TAB_8]+"  ");
		s.append(System.lineSeparator());
		s.append(tabuleiro[TAB_A][TAB_3]+" "+tabuleiro[TAB_C][TAB_4]+" "+tabuleiro[TAB_E][TAB_5]+" "+tabuleiro[TAB_G][TAB_6]+" "+tabuleiro[TAB_I][TAB_7]+" "+tabuleiro[TAB_K][TAB_8]);
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_3]+" "+tabuleiro[TAB_D][TAB_4]+" "+tabuleiro[TAB_F][TAB_5]+" "+tabuleiro[TAB_H][TAB_6]+" "+tabuleiro[TAB_J][TAB_7]+"  ");
		s.append(System.lineSeparator());
		s.append(tabuleiro[TAB_A][TAB_2]+" "+tabuleiro[TAB_C][TAB_3]+" "+tabuleiro[TAB_E][TAB_4]+" "+tabuleiro[TAB_G][TAB_5]+" "+tabuleiro[TAB_I][TAB_6]+" "+tabuleiro[TAB_K][TAB_7]);
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_2]+" "+tabuleiro[TAB_D][TAB_3]+" "+tabuleiro[TAB_F][TAB_4]+" "+tabuleiro[TAB_H][TAB_5]+" "+tabuleiro[TAB_J][TAB_6]+" ");
		s.append(System.lineSeparator());
		s.append("  "+tabuleiro[TAB_C][TAB_2]+" "+tabuleiro[TAB_E][TAB_3]+" "+tabuleiro[TAB_G][TAB_4]+" "+tabuleiro[TAB_I][TAB_5]+"  ");
		s.append(System.lineSeparator());
		s.append(" "+tabuleiro[TAB_B][TAB_1]+" "+tabuleiro[TAB_D][TAB_2]+" "+tabuleiro[TAB_F][TAB_3]+" "+tabuleiro[TAB_H][TAB_4]+" "+tabuleiro[TAB_J][TAB_5]+" ");
		s.append(System.lineSeparator());
		s.append("  "+tabuleiro[TAB_C][TAB_1]+" "+tabuleiro[TAB_E][TAB_2]+" "+tabuleiro[TAB_G][TAB_3]+" "+tabuleiro[TAB_I][TAB_4]+"  ");
		s.append(System.lineSeparator());
		s.append("   "+tabuleiro[TAB_D][TAB_1]+" "+tabuleiro[TAB_F][TAB_2]+" "+tabuleiro[TAB_H][TAB_3]+"   ");
		s.append(System.lineSeparator());
		s.append("    "+tabuleiro[TAB_E][TAB_1]+" "+tabuleiro[TAB_G][TAB_2]+"    ");
		s.append(System.lineSeparator());
		return s.toString();
	}
*/
	public int insereAnel(char c, int n, char j) {
		int linha;
		switch(c){
		case 'A':
			linha = TAB_A;
			break;
		case 'B':
			linha = TAB_B;
			break; 
		case 'C':
			linha = TAB_C;
			break;
		case 'D':
			linha = TAB_D;
			break;
		case 'E':
			linha = TAB_E;
			break;
		case 'F':
			linha = TAB_F;
			break;
		case 'G':
			linha = TAB_G;
			break;
		case 'H':
			linha = TAB_H;
			break;	
		case 'I':
			linha = TAB_I;
			break;	
		case 'J':
			linha = TAB_J;
			break;	
		case 'K':
			linha = TAB_K;
			break;	
		default:
			linha = -1;
			break;
		}
		if(linha == -1 || n-1 < 0 || n-1 > 10){
			System.out.println("Valor invalido!");
			return -1;
		}
		else if (tabuleiro[linha][n-1] != '*'){
			System.out.println("Casa j� ocupada!");
			return -1;
		}
		else{
			if(j == 'b')
				tabuleiro[linha][n-1] = 'B';
			else
				tabuleiro[linha][n-1] = 'P';
		}
		return 0;

	}
}
