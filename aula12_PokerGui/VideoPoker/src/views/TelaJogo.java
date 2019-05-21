package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class TelaJogo extends JPanel {
	
	public TelaJogo() {
		setLayout(new FlowLayout());
		configurarPainel();
	}
	
	public void configurarPainel() {
		/**
		 * Configurações do JPanels 
		 */
		setBackground(new Color(0x00, 0x38, 0x33));
		setBorder(new EmptyBorder(60,60,60,60));
	
		
		/**
		 * Configurações das Apostas
		 */
		JPanel aposta = new JPanel();
		aposta.setLayout(new FlowLayout());
		aposta.setBackground(null);
		
		Font  fontApostas      = new Font("Impact", Font.BOLD, 36);
		Color fontColorApostas = new Color(0xe4,0xe4,0xe4); 
		
		JLabel lblAposta = new JLabel("Valor da Aposta: ");
		lblAposta.setFont(fontApostas);
		lblAposta.setForeground(fontColorApostas);
		aposta.add(lblAposta);
		
		JLabel lblValorAposta = new JLabel("???");
		lblValorAposta.setFont(fontApostas);
		lblValorAposta.setForeground(fontColorApostas);
		aposta.add(lblValorAposta);
		
		JLabel lblCreditos = new JLabel(" | Créditos Atuais: ");
		lblCreditos.setFont(fontApostas);
		lblCreditos.setForeground(fontColorApostas);
		aposta.add(lblCreditos);
		
		JLabel lblValorCreditos = new JLabel("200");
		lblValorCreditos.setFont(fontApostas);
		lblValorCreditos.setForeground(fontColorApostas);
		aposta.add(lblValorCreditos);
		add(aposta);
		
		/**
		 * Configurações das Cartas
		 */
		JPanel jpCartas = new JPanel();
		jpCartas.setBackground(null);
		jpCartas.setBorder(new EmptyBorder(40,0,40,0));
		jpCartas.setLayout(new GridLayout(1, 5));
		
		JLabel[] carta = new JLabel[5];
		
		for(int i = 0; i < 5; i++) {
			carta[i] = new JLabel(new ImageIcon("./aula12_PokerGui/VideoPoker/resources/deck/13_copas.jpg"));
			carta[i].setBorder(new EmptyBorder(3,3,3,3));
//			carta[i].setBorder(new CompoundBorder(
//				    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0x00, 0x38, 0x33)), 
//				    BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(188, 21, 75) )));
			jpCartas.add(carta[i]);
		}
		add(jpCartas);
		
		/**
		 * Painel para leitura da aposta
		 */
		JPanel jpFazerAposta = new JPanel();
		jpFazerAposta.setLayout(new FlowLayout());
		jpFazerAposta.setBackground(null);
		jpFazerAposta.setSize(this.getWidth(), 0);
		
		JLabel		lblTxtAposta	= new JLabel("Insira o valor da aposta: ");
		lblTxtAposta.setFont(fontApostas);
		lblTxtAposta.setForeground(fontColorApostas);
		
		JTextField 	txtAposta 		= new JTextField("(valor)");
		txtAposta.setPreferredSize(new Dimension(140, 40));
		txtAposta.setBorder(new EmptyBorder(2, 10, 2, 10));
		txtAposta.setFont(new Font("Impact", Font.BOLD, 18));
		
		JButton		btnApostar = new JButton("APOSTAR CRÉDITOS");
		btnApostar.setPreferredSize(new Dimension(200,40));
		
		jpFazerAposta.add(lblTxtAposta);
		jpFazerAposta.add(txtAposta);
		jpFazerAposta.add(btnApostar);
		jpFazerAposta.setVisible(false);
		add(jpFazerAposta);
		
		/**
		 * Painel de Botoes 
		 */
		JPanel jpBotoes = new JPanel();
		jpBotoes.setLayout(new FlowLayout());
		jpBotoes.setBackground(null);
		
		JButton btnTrocar = new JButton("TROCAR CARTA(S)");
		btnTrocar.setPreferredSize(new Dimension(200,40));
		jpBotoes.add(btnTrocar);
		
		JButton btnManter = new JButton("MANTER CARTAS");
		btnManter.setPreferredSize(new Dimension(200,40));
		jpBotoes.add(btnManter);
		
		jpBotoes.setVisible(false);
		add(jpBotoes);
		
		/**
		 * Painel de fim de rodada
		 */
		JPanel jpFimRodada = new JPanel();
		jpFimRodada.setLayout(new GridLayout(2,1));
		jpFimRodada.setBackground(null);
		
		JPanel jpResultado = new JPanel();
		jpResultado.setLayout(new FlowLayout());
		jpResultado.setBackground(null);
		
		JPanel jpOpcoes = new JPanel();
		jpOpcoes.setLayout(new FlowLayout());
		jpOpcoes.setBackground(null);
		
		
		JLabel lblResultado = new JLabel("Acabaram os seus créditos!!!");
		lblResultado.setFont(fontApostas);
		lblResultado.setForeground(fontColorApostas);
		jpResultado.add(lblResultado);
		
		JButton btnNovaRodada = new JButton("NOVA RODADA");
		btnNovaRodada.setPreferredSize(new Dimension(200,40));
		jpOpcoes.add(btnNovaRodada);
		
		JButton btnSair = new JButton("SAIR DO JOGO");
		btnSair.setPreferredSize(new Dimension(200,40));
		jpOpcoes.add(btnSair);
		
		
		
		jpFimRodada.add(jpResultado);
		jpFimRodada.add(jpOpcoes);
		add(jpFimRodada);
		
	}
}
