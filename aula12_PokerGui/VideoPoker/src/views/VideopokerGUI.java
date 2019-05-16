package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VideopokerGUI extends JFrame {
	
	public VideopokerGUI(String nome) {
		super(nome);
	}
	
	
	public static void main(String[] args) {
		VideopokerGUI frame = new VideopokerGUI("Video Poker");
		
		/**
		 * Configurando o JFrame
		 */
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setSize(1000, 667); 
		frame.setBounds(0, 0, 1000, 667); // Fixa o tamanho da tela
		frame.setResizable(false);
		frame.setLocationRelativeTo(null); // Inicia a tela no centro 

		/**
		 * Iniciando o Panel de Boas Vindas!
		 */
		TelaInicio telaInicio = new TelaInicio(); // extends Jpanel
		frame.setContentPane(telaInicio);
		
		// Abrindo a tela
		frame.setVisible(true);
	}
	
}
