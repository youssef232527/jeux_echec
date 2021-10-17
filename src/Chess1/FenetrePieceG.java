package Chess1;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FenetrePieceG extends JFrame {
	
	private JPanel p1,p2 ;
	private JLabel j ;
	
	
	
	public FenetrePieceG(Vector v)
	{
		
		this.setBounds(550,50,550,450);
		this.setResizable(true);
		this.setLayout(null);
		p1 = new JPanel() ; p2= new JPanel() ; this.add(p1); p1.add(p2) ; p1.setBounds(0,0,550,450);p1.setLayout(null);p1.setBackground(new Color(44,62,80));
		j= new JLabel("Voici les Pieces gagnées : ") ; p1.add(j) ;j.setBounds(150,40,150,50);j.setForeground(Color.white);p2.setBackground(new Color(44,62,80));
		p2.setBounds(70,90,400,320); p2.setLayout(new GridLayout(2,8));
		this.setVisible(true);
		Iterator <Icon> it = v.iterator() ;
		while(it.hasNext())
			{
				JLabel J = new JLabel() ;
				J.setIcon((Icon)it.next());
				p2.add(J) ;
			}
		
		
	}

}
