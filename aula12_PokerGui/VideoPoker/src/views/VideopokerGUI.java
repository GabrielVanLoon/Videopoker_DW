package views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import videopoker.Baralho;
import videopoker.Carta;
import videopoker.Jogador;
import videopoker.Mesa;

/**
 * JFrame que irá fazer as chamadas de telas, alem de controlar todo o fluxo
 * de código do jogo (Funciona como uma especie de Controller).
 * 
 * @author gabriel
 */
public class VideopokerGUI extends JFrame {
	
	TelaInicio telaInicio = new TelaInicio(); // extends Jpanel
	
	public Baralho 	baralho;
	public Jogador 	jogador;
	public Mesa    	mesa;
	
	public int		valorAposta = -1;
	public int 		trocasDisponiveis = 3;
	
	/**
	 * Contrutor do Jframe.
	 * @param nome
	 */
	public VideopokerGUI(String nome) {
		super(nome);
		configurarFrame();
		configurarTelaInicial();
		abrirTelaInicial();
		setVisible(true);
	}
	
	/**
	 * Configura os atributos basicos da tela.
	 */
	public void configurarFrame() {
		/**
		 * Configurando o JFrame
		 */
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1000, 667);  // Fixa o tamanho da tela
		setResizable(false);
		setLocationRelativeTo(null); // Inicia a tela no centro 
	}
	
	/**
	 * Configura todo os codigos referentes a tela inicio.
	 */
	public void configurarTelaInicial() {
		telaInicio.btnJogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirTelaJogo();
            }
        });
	}
	
	/**
	 * Inicia a tela inicio e insere ela no JFrame
	 */
	public void abrirTelaInicial() {
		setContentPane(telaInicio);
		revalidate();
		telaInicio.btnJogar.repaint();
	}
	
	
	/**
	 * Atualiza as 5 cartas que aparecer na Tela de Jogo.
	 * @param jp objeto TelaJogo instanciado para o JFrame.
	 * @param resetarMesa Caso positivo reseta as 5 cartas na mesa.
	 */
	public void atualizarMesa(TelaJogo jp, boolean resetarMesa) {
		if(resetarMesa) {
			ImageIcon   icon = new ImageIcon("./aula12_PokerGui/VideoPoker/resources/deck/0_back.jpg");
			EmptyBorder border = new EmptyBorder(3,3,3,3);
			for(int i = 0; i < 5; i++) {
				jp.carta[i].setIcon(icon);
				jp.carta[i].setNumero(0);
				jp.carta[i].setSelecionado(false);
				jp.carta[i].setBorder(border);
			}
		} else {
			Carta[] cartas = jogador.getCartas();
			for(int i = 0; i < 5; i++) {
				char naipe   		= cartas[i].getNaipeChar();
				int  numero 	    = cartas[i].getNumero();
				String nomeCarta 	= "";
				
				if(numero != 14)
					nomeCarta += numero + "_";
				else
					nomeCarta += "a_";
				
				switch(naipe) {
					case 'c':
						nomeCarta += "copas.jpg";
						break;
					case 'o':
						nomeCarta += "ouros.jpg";
						break;
					case 'p':
						nomeCarta += "paus.jpg";
						break;
					case 'e':
						nomeCarta += "espadas.jpg";
						break;
				}
				
				jp.carta[i].setIcon(new ImageIcon("./aula12_PokerGui/VideoPoker/resources/deck/" + nomeCarta));
				jp.carta[i].setNumero(numero);
				jp.carta[i].setNaipe(cartas[i].getNaipe());
			}
		}
	}
	
	/**
	 * Cria a instancia de uma nova TelaJogo e faz as configurações necessarias
	 * para que as rodadas ocorram.
	 */
	public void abrirTelaJogo() {
		TelaJogo telaJogo = new TelaJogo();
		setContentPane(telaJogo);
		revalidate();
		
		this.baralho 	= new Baralho();
		this.jogador 	= new Jogador();
		this.mesa		= new Mesa();
		
		/**
		 * 1ª Etapa - Inserindo o valor da aposta
		 */
		telaJogo.btnApostar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	valorAposta = -1;
            	try {
            		valorAposta = Integer.parseInt(telaJogo.txtAposta.getText());
            	} catch(Exception e) {
            		valorAposta = -1;
            	} finally {
            		if(valorAposta <= 0) {
            			JOptionPane.showMessageDialog(telaJogo, "Por favor, insira um valor de aposta válido!");
            		} else if (valorAposta > jogador.getCreditos()){
            			JOptionPane.showMessageDialog(telaJogo, "Você não possui essa quantidade de créditos!");
            		} else {
            			jogador.apostarCreditos(valorAposta);
            			jogador.comprarMao(baralho);
            			
            			telaJogo.lblValorAposta.setText(Integer.toString(valorAposta));
            			telaJogo.lblValorCreditos.setText(Integer.toString(jogador.getCreditos()));
            			atualizarMesa(telaJogo, false);
            			telaJogo.jpFazerAposta.setVisible(false);
            			telaJogo.jpBotoes.setVisible(true);
            		}
            	}
            }
        });
		
		/**
		 * Configurando o evento para a troca de cartas
		 */
		for(int i = 0; i < 5; i++) {
			telaJogo.carta[i].addMouseListener(new MouseAdapter(){  
			    public void mouseClicked(MouseEvent e) {  
			    	ImagemCarta c = (ImagemCarta) e.getSource();
			    	// JOptionPane.showMessageDialog(telaJogo, "Valor: !" + c.getNumero() + " " + c.getNaipe());	
			    	c.swapSelecionado();
			    }  
			}); 
		}
		
		/**
		 * Configurar etapa de troca de cartas
		 */
		trocasDisponiveis = 3;
		telaJogo.btnTrocar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	if(trocasDisponiveis == 0)
            		return;
            	
            	String quaisTrocar = "";
            	for(int i = 0; i < 5; i++) {
            		if(telaJogo.carta[i].isSelecionado()) {
            			quaisTrocar += (i+1) + " ";
            			telaJogo.carta[i].swapSelecionado();
            		}
            	}
            	jogador.trocarCarta(baralho, quaisTrocar);
            	atualizarMesa(telaJogo, false);
            	trocasDisponiveis -= 1;
            	
            	telaJogo.btnTrocar.setText("TROCAR CARTAS ("+trocasDisponiveis +"x)");
            	if(trocasDisponiveis == 0)
            		telaJogo.btnTrocar.setEnabled(false);
            }
        });
		
		telaJogo.btnManter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	int multiplicador = mesa.aposta(jogador.getCartas());
            	if(multiplicador == 0) {
            		telaJogo.lblResultado.setText("VOCÊ NÃO FEZ NENHUMA COMBINAÇÃO!");
        		} else {
        			jogador.receberCreditos(valorAposta*multiplicador);
        			telaJogo.lblResultado.setText( mesa.strCombinacao(multiplicador) + " !");
        			telaJogo.lblValorCreditos.setText(Integer.toString(jogador.getCreditos()));
        		}
            	
            	if(jogador.getCreditos() == 0) {
            		telaJogo.lblResultado.setText("VOCÊ PERDEU TODOS OS CRÉDITOS!");
            		telaJogo.btnNovaRodada.setEnabled(false);
            	}
            	
            	telaJogo.jpBotoes.setVisible(false);
            	telaJogo.jpFimRodada.setVisible(true);
            }
        });
		
		/**
		 * Configurando a tela de fim de rodada
		 */
		telaJogo.btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	abrirTelaInicial();
            }
        });
		
		telaJogo.btnNovaRodada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	
            	atualizarMesa(telaJogo, true);
            	baralho.reset();
            	
            	trocasDisponiveis = 3;
            	telaJogo.btnTrocar.setText("TROCAR CARTAS (3x)");
            	telaJogo.btnTrocar.setEnabled(true);
            	telaJogo.lblValorAposta.setText("???");
            	
            	telaJogo.jpFazerAposta.setVisible(true);
            	telaJogo.jpFimRodada.setVisible(false);
            	
            }
        });
		
		
	}
	
	public static void main(String[] args) {
		VideopokerGUI frame = new VideopokerGUI("Video Poker");
	}
	
}
