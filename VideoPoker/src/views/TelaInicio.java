package views;

import java.awt.BorderLayout;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * JPanel que contém as configurações gráficas da Tela Inicial.
 * @author gabriel
 *
 */
public class TelaInicio extends JPanel {
	
	public  JButton btnJogar;
	private JLayeredPane layers;
	private JLabel  background;
	
	public TelaInicio() {
		/**
		 * Configurações Gerais
		 */
		// setBorder(new EmptyBorder(5, 5, 5, 5));
		// setLayout(new BorderLayout(0, 0));
		setLayout(null);
		configurarPainel();
	}
	
	/**
	 * Método que configura os elementos da tela inicial do jogo.
	 */
	public void configurarPainel() {
		/**
		 * Gerando o JLayers
		 */
		layers = new JLayeredPane();
		add(layers, BorderLayout.CENTER);
		layers.setLayout(null);
		
		
		/**
		 * Imagem de Background
		 */
		background = new JLabel(new ImageIcon("./resources/VideoPokerBackground.jpg"));
		background.setBounds(0, 0, 1000, 667);
		layers.setLayer(background, 1);
		add(background);
		
		/**
		 * Adicionado Botão Jogar
		 */
		btnJogar = new JButton("NOVO JOGO");
		btnJogar.setBounds(550, 300, 200, 40);
		
		layers.setLayer(btnJogar, 2);
		add(btnJogar);
		
		
		// garantindo que o background não será desenhado em cima do botão
		setComponentZOrder(background, 1);
		setComponentZOrder(btnJogar,   0);
		
		// Mostrando o caminho relativo atual.
		// Path currentRelativePath = Paths.get("");
		// JOptionPane.showMessageDialog(this, currentRelativePath.toAbsolutePath().toString());
	}
	

}
