package gui;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class HexagonComponent extends JPanel {

    private static final long serialVersionUID = 1L;
    private Hexagon hex;
    private int color;
    private static int piece;        

    public HexagonComponent(int x, int y, int r, int c, int p) {
    	hex = new Hexagon(x, y, r);
    	color = c;
    	piece = p;
    }
    
    public Hexagon getHexagon(){
    	return hex;
    }
    
    public void changeColor(int cor){
    	this.color = cor;
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        hex.draw(g2d, 0, color, true, piece);

        g.setColor(new Color(0xFFFFFF));
    }
    
    
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        hex.draw(g2d, 0, color, true, piece);

        g.setColor(new Color(0xFFFFFF));
    }
    
}