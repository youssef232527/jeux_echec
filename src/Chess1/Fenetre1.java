package Chess1;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class Fenetre1 extends JFrame implements ActionListener {
	
	private JLabel p  ;
	private JButton quitter;
	private JButton commencer ;
	private JButton aide ;
	
	
	
	public Fenetre1() throws IOException
	{
		p = new JLabel (new ImageIcon(ImageIO.read(new File("fene1.png")))) ;
		quitter=new JButton("QUITTER LE JEU");
		commencer=new JButton("NOUVELLE PARTIE");
		aide = new JButton("COMMENT JOUER") ;
		JLabel jl = new JLabel (new ImageIcon(ImageIO.read(new File("xxa.png")))) ;
	
		
		this.add(jl) ;
		this.setVisible(true);
		this.setTitle("Jeu D'echec");
		setSize(750,650);
		setVisible(true);
		setLocation(350, 50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jl.setLayout(null);
		this.add(p);
	    jl.add(commencer);
		jl.add(quitter);
		jl.add(aide) ;
		commencer.setBounds(150,170,250,60);commencer.setContentAreaFilled(false);commencer.setBorderPainted(false);commencer.setFont(new Font("",Font.BOLD,16));
		aide.setBounds(160,270,250,60);aide.setContentAreaFilled(false);aide.setBorderPainted(false);aide.setFont(new Font("",Font.BOLD,16));
		quitter.setBounds(170,380,250,60) ;quitter.setContentAreaFilled(false);quitter.setBorderPainted(false);quitter.setFont(new Font("",Font.BOLD,16)) ;
		this.add(p);
		commencer.addActionListener(this);
		quitter.addActionListener(this);
		aide.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==commencer )
			try {
				new Mode ();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	
		if(e.getSource()==quitter ) {
			this.dispose();
		
		}
		
		if(e.getSource()==aide)
		{
			aide a =new aide();
			a.run();
		}
}
		
	


	
	

}
