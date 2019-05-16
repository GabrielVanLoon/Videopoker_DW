package views;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TelaTeste extends JFrame{
	public TelaTeste() {
		super("Questions");
		//this.setLayout(new GridLayout(3,1));
		JPanel jp = (JPanel) this.getContentPane();
		jp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		JLabel background = new JLabel(new ImageIcon("C:\\Users\\Albert Wolf\\Desktop\\Wallpaper\\Corrin.jpg"));
		background.setLocation(0, 0);
		background.setSize(500, 200);
		add (background);
		JLabel text1 = new JLabel ("Ol�, tudo bem?");
		text1.setIconTextGap(-500);
		//text1.setLocation(0, 0);
		add (text1);
		/*this.add(new JLabel("Qual seu nome?"));
		this.add(new JLabel("Idade?"));*/
	}

	public static void main(String[] args) {
		TelaTeste frame = new TelaTeste();
		frame.setSize(500, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
