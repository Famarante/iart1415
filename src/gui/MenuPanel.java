package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale.Category;

import javax.swing.JFormattedTextField;
import javax.swing.JEditorPane;
import javax.swing.JTree;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.DropMode;

import java.awt.BorderLayout;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;

import javax.swing.JSeparator;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;

public class MenuPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Action action = new SwingAction();
	private final Action action_1 = new SwingAction_1();

	/**
	 * Create the panel.
	 */
	public MenuPanel() {
		setToolTipText("");
		setLayout(null);
		
		setPreferredSize(new Dimension(129, 26));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(true);
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 129, 26);
		add(menuBar);
		
		JMenu mnGame = new JMenu("Jogo");
		menuBar.add(mnGame);
		
		JMenuItem mnItmRestart = new JMenuItem("Recome\u00E7ar\r\n");
		mnGame.add(mnItmRestart);
		
		JMenuItem mnItmSurrender = new JMenuItem("Desistir");
		mnItmSurrender.setAction(action_1);
		mnGame.add(mnItmSurrender);
		
		JSeparator separator = new JSeparator();
		mnGame.add(separator);
		
		JMenuItem mnItmQuit = new JMenuItem("Sair\r\n");
		mnItmQuit.setAction(action);
		mnGame.add(mnItmQuit);
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Sair");
		}
		public void actionPerformed(ActionEvent e) {
			StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
			StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(StartMenu.getStartMenuPanel());
			StartMenu.getWindow().getFrmAboyneMenu().pack();
			StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - Menu inicial");
			StartMenu.getWindow().getFrmAboyneMenu().revalidate();
			StartMenu.getWindow().getFrmAboyneMenu().repaint();
		}
	}
	private class SwingAction_1 extends AbstractAction {
		public SwingAction_1() {
			putValue(NAME, "Desistir");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
