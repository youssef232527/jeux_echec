package Chess1;


import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JFrame {
	JLabel b,b1;
	Panel p;
	public GameOver(Color c) throws IOException {
		b = new JLabel (new ImageIcon(ImageIO.read(new File("GameOver.jpg")))) ;
		b.setBounds(0,0,150,150);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(700,700);
		this.setLocation(400,50);
		this.setVisible(true);
		this.setResizable(true);
		this.add(b);
		p=new Panel ();//p.setBackground(new Color(44,62,80));
		this.add(p);
		p.add(b);
		if( c.equals(Echiquier.couleurPiece1)) {
			b1=new JLabel(" joueur 2 a gagné ");
			b1.setBounds(60, 200, 200, 20);b1.setFont(new Font("",Font.BOLD,40));		
			p.add(b1);
		}
		else {
			b1=new JLabel(" joueur 1 a gagné ");
			b1.setBounds(60, 200, 200, 20);b1.setBackground(new Color(44,62,80));		
			p.add(b1);
		}
		
	
	}
	
	

}