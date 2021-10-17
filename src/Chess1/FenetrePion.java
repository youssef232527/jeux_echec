package Chess1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FenetrePion extends JFrame implements ActionListener {

	private Case PionCase ; 
	JLabel p ,p2  ;
	JButton b1,b2,b3,b4 ;

	public FenetrePion(Case c)throws IOException 
	{
		
		PionCase = c ;
		p = new JLabel(new ImageIcon(ImageIO.read(new File("chess2.jpg")))) ;
		this.add(p) ;
		this.setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500, 250);
		this.setLocation(500,260);
		this.setResizable(false);
		this.setVisible(true);
		p.setLayout(null);
		p2=new JLabel("CHOISISSEZ : ");p2.setForeground(Color.white);
		p2.setBounds(200, 20, 300, 70);
		p.add(p2);
		b1 = new JButton() ;b1.addActionListener(this);
		b2 = new JButton() ;b2.addActionListener(this);
		b3 = new JButton() ;b3.addActionListener(this);
		b4 = new JButton() ;b4.addActionListener(this);
				
		
		 p.add(b1) ; p.add(b2); p.add(b3) ; p.add(b4);
		
		
		b1.setBounds(30,100,100,100);b1.setBackground(new Color(44,62,80));
		b2.setBounds(140,100,100,100);b2.setBackground(new Color(44,62,80));
		b3.setBounds(250,100,100,100);b3.setBackground(new Color(44,62,80));
		b4.setBounds(360,100,100,100);b4.setBackground(new Color(44,62,80));
		
		if(Echiquier.couleurPiece1 == c.getP().getCouleur())
		{	b1.setIcon(new ImageIcon("icon/t"+Echiquier.num1+".png"));
			b2.setIcon(new ImageIcon(("icon/c"+Echiquier.num1+".png")));
			b3.setIcon(new ImageIcon(("icon/f"+Echiquier.num1+".png")));
			b4.setIcon(new ImageIcon(("icon/r"+Echiquier.num1+".png")));
		}
		else
		{	b1.setIcon(new ImageIcon("icon/t"+Echiquier.num2+".png"));
			b2.setIcon(new ImageIcon(("icon/c"+Echiquier.num2+".png")));
			b3.setIcon(new ImageIcon(("icon/f"+Echiquier.num2+".png")));
			b4.setIcon(new ImageIcon(("icon/r"+Echiquier.num2+".png")));
		}
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Color co = FenetreJeu.CouleurJoueur == Echiquier.couleurPiece1 ? Echiquier.couleurPiece2 : Echiquier.couleurPiece1 ;
		if(e.getSource() == b1 )
		{
			PionCase.setP(new Tour(co));
			PionCase.setIcon(b1.getIcon());
		}
		if(e.getSource() == b2 )
		{
			PionCase.setP(new Chevalier(co));
			PionCase.setIcon(b2.getIcon());
		}
		
		if(e.getSource() == b3 )
		{
			PionCase.setP(new Fou(co));
			PionCase.setIcon(b3.getIcon());
		}
		if(e.getSource() == b4 )
		{
			PionCase.setP(new Reine(co));
			PionCase.setIcon(b4.getIcon());
		}
		this.dispose();
		
	}
	
	



}
