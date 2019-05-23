package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

/**
 * Classe que implementa uma versão extendida de um JPanel mas que possui os atributos
 * de uma Carta de baralho. Além disso possui uma propriedade para verificar se a mesma
 * está ativada ou nao.
 * 
 * @author gabriel
 */
public class ImagemCarta extends JLabel {
	
	private int 	numero = 0;
	private int 	naipe  = 0;
	private boolean selecionado = false;
	
	/**
	 * Construtor que recebe um Icone.
	 * @param icon
	 */
	public ImagemCarta(ImageIcon icon) {
		super(icon);
		this.setBorder(new EmptyBorder(3,3,3,3));
	}
	
	/**
	 * Alterna o elemento como selecionado e não selecionado. Além disso também ajusta
	 * sua configuração visual conforme seu status.
	 */
	public void swapSelecionado() {
		if(numero == 0)
			return;
		
		this.selecionado = !selecionado;
		if(!selecionado) {
			this.setBorder(new EmptyBorder(3,3,3,3));
		} else {
			this.setBorder(new CompoundBorder(
				    BorderFactory.createMatteBorder(0, 0, 0, 0, new Color(0x00, 0x38, 0x33)), 
				    BorderFactory.createMatteBorder(3, 3, 3, 3, new Color(188, 21, 75) )));
		}
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getNaipe() {
		return naipe;
	}

	public void setNaipe(int naipe) {
		this.naipe = naipe;
	}
	
	public boolean isSelecionado() {
		return selecionado;
	}

	public void setSelecionado(boolean selecionado) {
		this.selecionado = selecionado;
	}

}
