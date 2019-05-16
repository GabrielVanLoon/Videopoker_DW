package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VideopokerGUI extends JFrame {
	
	public VideopokerGUI(String nome) {
		super(nome);
		configurarFrame();
	}
	
	public void configurarFrame() {
		/**
		 * Configurando o JFrame
		 */
		// setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 667);  // Fixa o tamanho da tela
		setResizable(false);
		setLocationRelativeTo(null); // Inicia a tela no centro 

		/**
		 * Iniciando o Panel de Boas Vindas!
		 */
		TelaInicio telaInicio = new TelaInicio(); // extends Jpanel
		setContentPane(telaInicio);
		
		telaInicio.btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirTelaJogo();
            }
        });
		
		// Abrindo a tela
		setVisible(true);
	}
	
	public void abrirTelaJogo() {
		TelaJogo telaJogo = new TelaJogo();
		setContentPane(telaJogo);
		revalidate();
	}
	
	public static void main(String[] args) {
		VideopokerGUI frame = new VideopokerGUI("Video Poker");
	}
	
}
