package gui;

import gamelogic.Game;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class CPUvCPUPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public CPUvCPUPanel() {
		setLayout(null);
		setPreferredSize(new Dimension(450, 400));
		
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
		
		JLabel lblNewLabel = new JLabel("CPU1 - Profundidade(" + (StartMenu.getWindow().getCpu1Difficulty() + 2) + ")");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(36, 39, 377, 43);
		add(lblNewLabel);
		
		JLabel lblCpu = new JLabel("CPU2 - Profundidade(" + (StartMenu.getWindow().getCpu2Difficulty() + 2) + ")");
		lblCpu.setForeground(Color.RED);
		lblCpu.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblCpu.setBounds(36, 151, 377, 43);
		add(lblCpu);
		
		JLabel lblVs = new JLabel("vs");
		lblVs.setHorizontalAlignment(SwingConstants.CENTER);
		lblVs.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblVs.setBounds(119, 95, 211, 43);
		add(lblVs);
				
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int difficultyCPU1, difficultyCPU2;
				difficultyCPU1 = StartMenu.getWindow().getCpu1Difficulty() + 2;
				difficultyCPU2 = StartMenu.getWindow().getCpu2Difficulty() + 2;

				Game newGame= new Game();
				newGame.initGUI(difficultyCPU1, difficultyCPU2);
				JPanel gameBoard = new HexBoard(StartMenu.getWindow().getWindowSize(), StartMenu.getWindow().getSCREEN_WIDTH(), StartMenu.getWindow().getSCREEN_HEIGHT(), newGame);
				PlayerInfoPanel pl1Info = new PlayerInfoPanel("Jogador 1", newGame.getP1Name(), "left");
				PlayerInfoPanel pl2Info = new PlayerInfoPanel("Jogador 2", newGame.getP2Name(), "right");
				MenuPanel menu = new MenuPanel("cpuvcpu");
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(gameBoard, BorderLayout.CENTER);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(pl1Info, BorderLayout.WEST);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(pl2Info, BorderLayout.EAST);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(menu, BorderLayout.NORTH);
				StartMenu.getWindow().getFrmAboyneMenu().pack();
				Dimension playerInfoSize = pl1Info.getPreferredSize();
				Dimension boardSize = gameBoard.getPreferredSize();
				StartMenu.getWindow().getFrmAboyneMenu().setLocation((int)(StartMenu.getWindow().getSCREEN_WIDTH()/2 - (boardSize.getWidth() + playerInfoSize.getWidth() * 2)/2), (int)(StartMenu.getWindow().getSCREEN_HEIGHT()/2 - boardSize.getHeight()/2) - 40);
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - CPUvCPU");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		});
	}
}
