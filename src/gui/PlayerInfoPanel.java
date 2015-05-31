package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.SwingConstants;

public class PlayerInfoPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PlayerInfoPanel(String playerSide, String playerName, String position) {
		setToolTipText("");
		setLayout(null);
		
		setPreferredSize(new Dimension(200, 350));
		
		JLabel lblNomeJogador = new JLabel(playerSide);
		if(position == "right")
			lblNomeJogador.setHorizontalAlignment(SwingConstants.RIGHT);
		else
			lblNomeJogador.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeJogador.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNomeJogador.setBounds(12, 30, 176, 45);
		add(lblNomeJogador);
		
		JLabel label = new JLabel(playerName);
		if(position == "right"){
			label.setForeground(Color.RED);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
		}
		else{
			label.setForeground(Color.BLUE);
			label.setHorizontalAlignment(SwingConstants.LEFT);
		}
		label.setFont(new Font("Tahoma", Font.BOLD, 16));
		label.setBounds(12, 82, 176, 45);
		add(label);
		
	}
}
