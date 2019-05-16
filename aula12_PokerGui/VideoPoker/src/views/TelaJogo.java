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
		
		JLabel lblAposta = new JLabel("Valor da Aposta: ");
		lblAposta.setFont(new Font("Impact", Font.BOLD, 48));
		lblAposta.setForeground(new Color(0xe4,0xe4,0xe4));
		aposta.add(lblAposta);
		
		JLabel lblValorAposta = new JLabel("XXX");
		lblValorAposta.setFont(new Font("Impact", Font.BOLD, 48));
		lblValorAposta.setForeground(new Color(0xe4,0xe4,0xe4));
		aposta.add(lblValorAposta);
		
		JLabel lblCreditos = new JLabel(" | Créditos Atuais: ");
		lblCreditos.setFont(new Font("Impact", Font.BOLD, 48));
		lblCreditos.setForeground(new Color(0xe4,0xe4,0xe4));
		aposta.add(lblCreditos);
		
		JLabel lblValorCreditos = new JLabel("YYY");
		lblValorCreditos.setFont(new Font("Impact", Font.BOLD, 48));
		lblValorCreditos.setForeground(new Color(0xe4,0xe4,0xe4));
		aposta.add(lblValorCreditos);
		add(aposta);
		
		/**
		 * Configurações das Cartas
		 */
		JPanel jpCartas = new JPanel();
		jpCartas.setBackground(null);
		jpCartas.setBorder(new EmptyBorder(60,0,60,0));
		jpCartas.setLayout(new GridLayout(1, 5));
		
		JLabel[] carta = new JLabel[5];
		
		for(int i = 0; i < 5; i++) {
			carta[i] = new JLabel(new ImageIcon(".\\aula12_PokerGui\\VideoPoker\\resources\\deck\\13_copas.jpg"));
			carta[i].setBorder(new EmptyBorder(3,3,3,3));
//			carta[i].setBorder(new CompoundBorder(
//				    BorderFactory.createMatteBorder(1, 1, 1, 1, new Color(0x00, 0x38, 0x33)), 
//				    BorderFactory.createMatteBorder(2, 2, 2, 2, new Color(188, 21, 75) )));
			jpCartas.add(carta[i]);
		}
		add(jpCartas);
		
		
		/**
		 * Configurações dos Botões
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
		
		add(jpBotoes);
		
	}
}
