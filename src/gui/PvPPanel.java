package gui;

import gamelogic.Game;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale.Category;

import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PvPPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public PvPPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(450, 400));
		
		JLabel lblPlayerName = new JLabel("Nome jogador 1");
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName.setBounds(64, 25, 145, 43);
		add(lblPlayerName);
		
		JButton btnStart = new JButton("Começar");
		
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnStart.setBounds(255, 275, 133, 43);
		add(btnStart);
		
		
		JButton btnCancel = new JButton("Cancelar");
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(StartMenu.getStartMenuPanel());
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - Menu inicial");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancel.setBounds(61, 275, 133, 43);
		add(btnCancel);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(226, 35, 162, 25);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNomeJogador = new JLabel("Nome jogador 2");
		lblNomeJogador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeJogador.setBounds(64, 121, 145, 43);
		add(lblNomeJogador);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField_1.setColumns(10);
		textField_1.setBounds(226, 131, 162, 25);
		add(textField_1);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String namePl1 = textField.getText(), namePl2 = textField_1.getText();
				System.out.println("Jogador 1: " + namePl1 + " jogador2: " + namePl2);
				Game newGame= new Game();
				newGame.initGUI(namePl1, namePl2);
				JPanel gameBoard = new HexBoard(StartMenu.getWindow().getWindowSize(), StartMenu.getWindow().getSCREEN_WIDTH(), StartMenu.getWindow().getSCREEN_HEIGHT(), newGame);
				PlayerInfoPanel pl1Info = new PlayerInfoPanel("Jogador 1", namePl1, "left");
				PlayerInfoPanel pl2Info = new PlayerInfoPanel("Jogador 2", namePl2, "right");
				MenuPanel menu = new MenuPanel();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(gameBoard, BorderLayout.CENTER);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(pl1Info, BorderLayout.WEST);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(pl2Info, BorderLayout.EAST);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(menu, BorderLayout.NORTH);
				StartMenu.getWindow().getFrmAboyneMenu().pack();
				Dimension playerInfoSize = pl1Info.getPreferredSize();
				Dimension boardSize = gameBoard.getPreferredSize();
				StartMenu.getWindow().getFrmAboyneMenu().setLocation((int)(StartMenu.getWindow().getSCREEN_WIDTH()/2 - (boardSize.getWidth() + playerInfoSize.getWidth() * 2)/2), (int)(StartMenu.getWindow().getSCREEN_HEIGHT()/2 - boardSize.getHeight()/2) - 40);
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne PVP");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		});

	}
}
