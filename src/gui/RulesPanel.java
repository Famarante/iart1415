package gui;

import javax.swing.JPanel;
import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

import java.awt.SystemColor;

import javax.swing.UIManager;

public class RulesPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public RulesPanel() {
		setLayout(null);
		
		JButton btnBack = new JButton("Voltar");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(StartMenu.getStartMenuPanel());
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - Menu inicial");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(161, 309, 128, 38);
		add(btnBack);
		
		JTextArea rulesList = new JTextArea();
		rulesList.setEditable(false);
		rulesList.setBackground(SystemColor.menu);
		rulesList.setWrapStyleWord(true);
		rulesList.setTabSize(1);
		rulesList.setFont(UIManager.getFont("Button.font"));
		rulesList.setLineWrap(true);
		rulesList.setText("\u2022\tCasa de vit\u00F3ria: Casa marcada com a sua cor no lado oposto do tabuleiro.\r\n\u2022\tPe\u00E7a bloqueada: Quando uma pe\u00E7a est\u00E1 adjacente a uma pe\u00E7a inimiga.\r\n\u2022\tTurno: Em cada turno, cada jogador pode mover uma das suas pe\u00E7as que n\u00E3o se encontre bloqueada.\r\n\t- Uma pe\u00E7a pode mover-se para uma casa vizinha caso esta se encontre vazia ou saltar por cima de pe\u00E7as aliadas, em linha, posicionando-se na casa imediatamente a seguir. Se esta estiver ocupada por uma pe\u00E7a inimiga, a pe\u00E7a inimiga \u00E9 capturada.\r\n\t- As pe\u00E7as n\u00E3o se podem deslocar para a casa de vit\u00F3ria do advers\u00E1rio.\r\n\r\nTem duas condi\u00E7\u00F5es que proporcionam a vit\u00F3ria a um jogador. S\u00E3s as seguintes:\r\n1.\tO jogador conseguir chegar com uma das suas pe\u00E7as \u00E0 casa de vit\u00F3ria.\r\n2.\tQuando um jogador, no seu turno, n\u00E3o consegue mover nenhuma das suas pe\u00E7as porque se encontram todas bloqueadas, este perde.\r\n");
		rulesList.setBounds(12, 13, 426, 309);
		add(rulesList);

	}
}
