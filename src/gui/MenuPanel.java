package gui;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
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
	private final Action action_2 = new SwingAction_2();
	private String gametype;

	/**
	 * Create the panel.
	 */
	public MenuPanel(String gT) {
		setToolTipText("");
		setLayout(null);
		gametype = gT;
		setPreferredSize(new Dimension(129, 26));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(true);
		menuBar.setToolTipText("");
		menuBar.setBounds(0, 0, 129, 26);
		add(menuBar);
		
		JMenu mnGame = new JMenu("Jogo");
		menuBar.add(mnGame);
		
		JMenuItem mnItmRestart = new JMenuItem("Recome\u00E7ar\r\n");
		mnItmRestart.setAction(action_1);
		mnGame.add(mnItmRestart);
		
		JMenuItem mnItmSurrender = new JMenuItem("Desistir");
		mnItmSurrender.setAction(action_2);
		mnGame.add(mnItmSurrender);
		
		JSeparator separator = new JSeparator();
		mnGame.add(separator);
		
		JMenuItem mnItmQuit = new JMenuItem("Sair\r\n");
		mnItmQuit.setAction(action);
		mnGame.add(mnItmQuit);
		
	}
	
	public String getGametype(){
		return gametype;
	}
	
	private class SwingAction extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
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
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_1() {
			putValue(NAME, "Recome\u00E7ar\r\n");
		}
		public void actionPerformed(ActionEvent e) {
			if(gametype == "pvp"){
				removeAll();
				PvPPanel pvp = new PvPPanel();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(pvp);
				StartMenu.getWindow().getFrmAboyneMenu().pack();
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - PvP");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
			else if(gametype == "cpuvcpu"){
				removeAll();
				CPUvCPUPanel cpuvcpu = new CPUvCPUPanel();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(cpuvcpu);
				StartMenu.getWindow().getFrmAboyneMenu().pack();
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - CPUvCPU");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
			else{
				removeAll();
				PvCPUPanel pvcpu = new PvCPUPanel();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(pvcpu);
				StartMenu.getWindow().getFrmAboyneMenu().pack();
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - CPUvCPU");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		}
	}
	
	private class SwingAction_2 extends AbstractAction {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		public SwingAction_2() {
			putValue(NAME, "Desistir");
		}
		public void actionPerformed(ActionEvent e) {
			if(!((HexBoard)getParent().getComponent(0)).getGame().getCurrentPlayer().isCPU()){
				if(((HexBoard)getParent().getComponent(0)).getGame().getCurrentPlayer().getPiece() == "B")
					new EndgameWindow(((HexBoard)getParent().getComponent(0)).getGame().surrender(((HexBoard)getParent().getComponent(0)).getGame().getCurrentPlayer()), Color.RED);
				else
					new EndgameWindow(((HexBoard)getParent().getComponent(0)).getGame().surrender(((HexBoard)getParent().getComponent(0)).getGame().getCurrentPlayer()), Color.BLUE);
			}			
		}
	}
}
