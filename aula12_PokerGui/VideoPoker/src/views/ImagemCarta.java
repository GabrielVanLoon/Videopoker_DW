package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

public class ImagemCarta extends JLabel {
	
	private int 	numero = 0;
	private int 	naipe  = 0;
	private boolean selecionado = false;
	
	public ImagemCarta(ImageIcon icon) {
		super(icon);
		this.setBorder(new EmptyBorder(3,3,3,3));
	}
	
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
