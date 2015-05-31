package gui;

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

public class StartMenu {

	static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	protected static double SCREEN_WIDTH = screenSize.getWidth();
	protected static double SCREEN_HEIGHT = screenSize.getHeight();
	
	protected static JFrame frmAboyneMenu;
	protected static int windowSize = 1;
	protected static int cpu1Difficulty = 2;
	protected static int cpu2Difficulty = 2;
	protected static StartMenu window;

	public Dimension getScreenSize() {
		return screenSize;
	}

	public double getSCREEN_WIDTH() {
		return SCREEN_WIDTH;
	}

	public double getSCREEN_HEIGHT() {
		return SCREEN_HEIGHT;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window = new StartMenu();
					window.getWindow().getFrmAboyneMenu().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static StartMenu getWindow() {
		return window;
	}

	public static void setWindow(StartMenu window) {
		StartMenu.window = window;
	}

	/**
	 * Create the application.
	 */
	public StartMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAboyneMenu = new JFrame();
		frmAboyneMenu.setResizable(false);
		frmAboyneMenu.setTitle("Aboyne - Menu Inicial");
		frmAboyneMenu.setLocation((int)(SCREEN_WIDTH/2 - 450/2), (int)(SCREEN_HEIGHT/2 - 440/2));
		frmAboyneMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmAboyneMenu.getContentPane().add(getStartMenuPanel(), BorderLayout.CENTER);
		frmAboyneMenu.pack();
		frmAboyneMenu.setVisible(true);
	}
	
	public static JPanel getStartMenuPanel() {
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(450, 400));
		panel.setLayout(null);
		
		JButton btnPlayerVsCPU = new JButton("Jogador vs CPU");
		btnPlayerVsCPU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel pvsCPU = new PvCPUPanel();
				frmAboyneMenu.getContentPane().removeAll();
				frmAboyneMenu.getContentPane().add(pvsCPU);
				frmAboyneMenu.pack();
				frmAboyneMenu.setTitle("Aboyne - PvCPU");
				frmAboyneMenu.revalidate();
				frmAboyneMenu.repaint();
			}
		});
		btnPlayerVsCPU.setBounds(129, 77, 186, 43);
		panel.add(btnPlayerVsCPU);
		
		JButton btnOptions = new JButton("Op\u00E7\u00F5es");
		btnOptions.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OptionsPanel opcoes = new OptionsPanel();
				frmAboyneMenu.getContentPane().removeAll();
				frmAboyneMenu.getContentPane().add(opcoes);
				frmAboyneMenu.setTitle("Aboyne - Opções");
				frmAboyneMenu.revalidate();
				frmAboyneMenu.repaint();
			}
		});
		btnOptions.setBounds(129, 272, 186, 43);
		panel.add(btnOptions);
		
		JButton btnPlayerVsPlayer = new JButton("Jogador vs Jogador");
		btnPlayerVsPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel pvp = new PvPPanel();
				frmAboyneMenu.getContentPane().removeAll();
				frmAboyneMenu.getContentPane().add(pvp);
				frmAboyneMenu.pack();
				frmAboyneMenu.setTitle("Aboyne - PvP");
				frmAboyneMenu.revalidate();
				frmAboyneMenu.repaint();
			}
		});
		btnPlayerVsPlayer.setBounds(129, 22, 186, 43);
		panel.add(btnPlayerVsPlayer);
		
		JButton btnCPUvsCPU = new JButton("CPU vs CPU");
		btnCPUvsCPU.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JPanel CPUvsCPU = new CPUvCPUPanel();
				frmAboyneMenu.getContentPane().removeAll();
				frmAboyneMenu.getContentPane().add(CPUvsCPU);
				frmAboyneMenu.pack();
				frmAboyneMenu.setTitle("Aboyne - CPUvCPU");
				frmAboyneMenu.revalidate();
				frmAboyneMenu.repaint();
			}
		});
		btnCPUvsCPU.setBounds(129, 133, 186, 43);
		panel.add(btnCPUvsCPU);
		
		JButton btnRules = new JButton("Regras");
		btnRules.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				RulesPanel opcoes = new RulesPanel();
				frmAboyneMenu.getContentPane().removeAll();
				frmAboyneMenu.getContentPane().add(opcoes);
				frmAboyneMenu.setTitle("Aboyne - Regras");
				frmAboyneMenu.revalidate();
				frmAboyneMenu.repaint();
			}
		});
		btnRules.setBounds(129, 216, 186, 43);
		panel.add(btnRules);
		
		JButton btnExit = new JButton("Sair");
		btnExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAboyneMenu.dispose();
			}
		});
		btnExit.setBounds(129, 327, 186, 43);
		panel.add(btnExit);
		
		return panel;
	}

	public JFrame getFrmAboyneMenu() {
		return frmAboyneMenu;
	}
	
	public void setGameSettings(int windSiz, int cpu1Dif, int cpu2Dif){
		windowSize = windSiz;
		cpu1Difficulty = cpu1Dif;
		cpu2Difficulty = cpu2Dif;
	}

	public static int getWindowSize() {
		return windowSize;
	}
	
	public static void closeGame(){
		frmAboyneMenu.dispose();
	}

	public static int getCpu1Difficulty() {
		return cpu1Difficulty;
	}
	
	public static int getCpu2Difficulty() {
		return cpu2Difficulty;
	}
}
