package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class TelaJogo extends JPanel {
	
	public TelaJogo() {
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
		JLabel background = new JLabel(new ImageIcon(".\\resources\\VideoPokerBackground.jpg"));
		background.setBounds(0, 0, 1000, 667);
		layers.setLayer(background, 1);
		add(background);
		
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(3, 1));
		
		//Aposta que aparece na parte superior da tela
		JPanel aposta = new JPanel();
		aposta.setLayout(new GridLayout(1, 2));
		aposta.add(new JLabel ("VALOR DA APOSTA: "));
		aposta.add(new JLabel("XXX")); //Valor da aposta atual escolhida pelo usuario
		
		//Cartas atualmente na mesa
		JPanel cartas = new JPanel();
		cartas.setLayout(new GridLayout(1, 5));
		cartas.add(new JLabel(new ImageIcon(".\\resources\\deck\\13_copas.jpg")));
		cartas.add(new JLabel(new ImageIcon(".\\resources\\deck\\4_espadas.jpg")));
		cartas.add(new JLabel(new ImageIcon(".\\resources\\deck\\5_espadas.jpg")));
		cartas.add(new JLabel(new ImageIcon(".\\resources\\deck\\6_ouros.jpg")));
		cartas.add(new JLabel(new ImageIcon(".\\resources\\deck\\8_copas.jpg")));
		
		//Botoes para trocar ou nao cartas
		JPanel botoes = new JPanel();
		botoes.setLayout(new GridLayout (1, 2));
		botoes.add(new JLabel("TROCAR CARTA(S)"));
		botoes.add(new JLabel("MANTER CARTAS"));
		
		jp.add(aposta);
		jp.add(cartas);
		jp.add(botoes);
		
		add(jp);
	}
}
