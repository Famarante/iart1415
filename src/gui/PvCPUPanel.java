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

public class PvCPUPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PvCPUPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(450, 400));
		
		JLabel lblPlayerName = new JLabel("Insira o seu nome");
		lblPlayerName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPlayerName.setBounds(64, 25, 145, 43);
		add(lblPlayerName);
		
		JLabel lblColorPick = new JLabel("Escolha a sua cor");
		lblColorPick.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblColorPick.setBounds(64, 89, 145, 43);
		add(lblColorPick);
		
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
		
		JRadioButton rdbtnBlue = new JRadioButton("Azul");
		rdbtnBlue.setSelected(true);
		rdbtnBlue.setBounds(226, 96, 127, 25);
		add(rdbtnBlue);
		
		JRadioButton rdbtnRed = new JRadioButton("Vermelho");
		rdbtnRed.setBounds(226, 126, 127, 25);
		add(rdbtnRed);
		
		ButtonGroup btnCor = new ButtonGroup();
		btnCor.add(rdbtnBlue);
		btnCor.add(rdbtnRed);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(226, 35, 162, 25);
		add(textField);
		textField.setColumns(10);
		
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name = textField.getText();
				int color, difficulty;
				if(rdbtnBlue.isSelected()){
					color = 1;
					difficulty = StartMenu.getWindow().getCpu2Difficulty() + 2;
				}
				else{
					color = 2;
					difficulty = StartMenu.getWindow().getCpu1Difficulty() + 2;
				}
				System.out.println(difficulty);
				Game newGame= new Game();
				newGame.initGUI(name, difficulty, color);
				JPanel gameBoard = new HexBoard(StartMenu.getWindow().getWindowSize(), StartMenu.getWindow().getSCREEN_WIDTH(), StartMenu.getWindow().getSCREEN_HEIGHT(), newGame);
				PlayerInfoPanel pl1Info = new PlayerInfoPanel("Jogador 1", newGame.getP1Name(), "left");
				PlayerInfoPanel pl2Info = new PlayerInfoPanel("Jogador 2", newGame.getP2Name(), "right");
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
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - PvCPU	");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		});
	}
}
