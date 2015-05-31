package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OptionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public OptionsPanel() {
		setLayout(null);
		
		JLabel lblWindowSize = new JLabel("Tamanho da janela");
		lblWindowSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblWindowSize.setBounds(64, 25, 145, 43);
		add(lblWindowSize);
		
		JComboBox windowSize = new JComboBox();
		lblWindowSize.setLabelFor(windowSize);
		windowSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		windowSize.setModel(new DefaultComboBoxModel(new String[] {"Pequena", "Normal", "Grande"}));
		windowSize.setSelectedIndex(StartMenu.getWindow().getWindowSize());
		windowSize.setBounds(248, 25, 133, 43);
		add(windowSize);
		
		JLabel lblDifficultyCPU1 = new JLabel("Dificuldade do CPU 1");
		lblDifficultyCPU1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDifficultyCPU1.setBounds(64, 89, 145, 43);
		add(lblDifficultyCPU1);
		
		JComboBox difficultyCPU1 = new JComboBox();
		lblDifficultyCPU1.setLabelFor(difficultyCPU1);
		difficultyCPU1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difficultyCPU1.setModel(new DefaultComboBoxModel(new String[] {"Muito f\u00E1cil", "F\u00E1cil", "M\u00E9dio", "Dif\u00EDcil", "Muito dif\u00EDcil"}));
		difficultyCPU1.setSelectedIndex(StartMenu.getWindow().getCpu1Difficulty());
		difficultyCPU1.setBounds(248, 89, 133, 43);
		add(difficultyCPU1);
		
		JLabel lblDifficultyCPU2 = new JLabel("Dificuldade do CPU 2");
		lblDifficultyCPU2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDifficultyCPU2.setBounds(64, 154, 145, 43);
		add(lblDifficultyCPU2);
		
		JComboBox difficultyCPU2 = new JComboBox();
		lblDifficultyCPU2.setLabelFor(difficultyCPU2);
		difficultyCPU2.setModel(new DefaultComboBoxModel(new String[] {"Muito f\u00E1cil", "F\u00E1cil", "M\u00E9dio", "Dif\u00EDcil", "Muito dif\u00EDcil"}));
		difficultyCPU2.setSelectedIndex(StartMenu.getWindow().getCpu2Difficulty());
		difficultyCPU2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		difficultyCPU2.setBounds(248, 154, 133, 43);
		add(difficultyCPU2);
		
		JButton btnSave = new JButton("Guardar");
		btnSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int windSiz = windowSize.getSelectedIndex();
				int cpu1Dif = difficultyCPU1.getSelectedIndex();
				int cpu2Dif = difficultyCPU2.getSelectedIndex();
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().removeAll();
				StartMenu.getWindow().setGameSettings(windSiz, cpu1Dif, cpu2Dif);
				StartMenu.getWindow().getFrmAboyneMenu().getContentPane().add(StartMenu.getStartMenuPanel());
				StartMenu.getWindow().getFrmAboyneMenu().setTitle("Aboyne - Menu inicial");
				StartMenu.getWindow().getFrmAboyneMenu().revalidate();
				StartMenu.getWindow().getFrmAboyneMenu().repaint();
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSave.setBounds(158, 229, 133, 43);
		add(btnSave);

	}
	
}
