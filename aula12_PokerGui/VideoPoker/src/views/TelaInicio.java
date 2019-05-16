package views;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaInicio extends JPanel {

	public TelaInicio() {
		/**
		 * Configurações Gerais
		 */
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		// setLayout(new BorderLayout(0, 0));
		setLayout(null);
		configurarPainel();
	}

	public void configurarPainel() {
		/**
		 * Gerando o JLayers
		 */
		JLayeredPane layers = new JLayeredPane();
		add(layers, BorderLayout.CENTER);
		layers.setLayout(null);
		
		/**
		 * Imagem de Background
		 */
		JLabel background = new JLabel(new ImageIcon(".\\aula12_PokerGui\\VideoPoker\\resources\\VideoPokerBackground.jpg"));
		background.setBounds(0, 0, 1000, 667);
		layers.setLayer(background, 1);
		add(background);
		
		/**
		 * Adicionado Botão Jogar
		 */
		JButton btnJogar = new JButton("NOVO JOGO");
		btnJogar.setBounds(550, 300, 200, 40);
		layers.setLayer(btnJogar, 2);
		add(btnJogar);
		
	}


}
