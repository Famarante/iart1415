package gui;

import gamelogic.Game;
import gamelogic.Player;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.JTextArea;

import java.awt.SystemColor;
import java.awt.Cursor;

public class EndgameWindow {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	protected static double SCREEN_WIDTH = screenSize.getWidth();
	protected static double SCREEN_HEIGHT = screenSize.getHeight();
	
	protected static JFrame endgameFrame;
	protected static int windowSize = 1;
	protected static EndgameWindow window;

	public Dimension getScreenSize() {
		return screenSize;
	}

	public double getSCREEN_WIDTH() {
		return SCREEN_WIDTH;
	}

	public double getSCREEN_HEIGHT() {
		return SCREEN_HEIGHT;
	}

	public static EndgameWindow getWindow() {
		return window;
	}

	public static void setWindow(EndgameWindow window) {
		EndgameWindow.window = window;
	}

	/**
	 * Create the application.
	 */
	public EndgameWindow(String winText, Color color) {
		initialize(winText, color);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String winText, Color color) {
		endgameFrame = new JFrame();
		endgameFrame.setAlwaysOnTop(true);
		endgameFrame.setResizable(false);
		endgameFrame.setTitle("Aboyne - Menu Inicial");
		endgameFrame.setLocation((int)(SCREEN_WIDTH/2 - 450/2), (int)(SCREEN_HEIGHT/2 - 440/2));
		endgameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		endgameFrame.getContentPane().add(getEndgamePanel(winText, color), BorderLayout.CENTER);
		
		endgameFrame.pack();
		endgameFrame.setVisible(true);
	}
	
	public static JPanel getEndgamePanel(String winText, Color color) {
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 400));
		panel.setLayout(null);
		
		JButton btnExit = new JButton("Sair");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				endgameFrame.dispose();
				StartMenu.closeGame();
				StartMenu newGame = new StartMenu();
			}
		});
		btnExit.setBounds(132, 327, 186, 43);
		panel.add(btnExit);
		
		JTextArea textArea = new JTextArea(winText);
		textArea.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		textArea.setBackground(SystemColor.control);
		textArea.setForeground(color);
		textArea.setFont(new Font("Tahoma", Font.PLAIN, 30));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setBounds(23, 60, 404, 137);
		panel.add(textArea);
			
		return panel;
	}

	public JFrame getEndgameFrame() {
		return endgameFrame;
	}
	
	public static int getWindowSize() {
		return windowSize;
	}
}
