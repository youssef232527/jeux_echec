package Chess1;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;

public class Mode extends JFrame implements MouseListener{
	
	private JLabel MODE,niveau,ech,piece  , X,x1 ;
	private JPanel p ,p2 ;
	private JButton Commencer,Retour ;
	private JRadioButton r12,r22,choix1,choix2,choix3 ;
	private ButtonGroup g2,g3 ;
	private JSlider slider ;
	
	public Mode() throws IOException 
	{
		
		
		this.setUndecorated(true);
		this.setVisible(true);
		setSize(500,700);
		setVisible(true);
		setLocation(500,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(null);
	
		
		/** le decore **/
		p = new JPanel() ;
		X = new JLabel("X") ;X.setForeground(Color.white);X.addMouseListener(this);
		x1 = new JLabel("  JEU D'ECHEC ") ;x1.setForeground(Color.white);
		
		this.add(p) ;
		p.setBounds(0,0,500,50);p.setBackground(new Color(248,148,6));
		p.setLayout(null);
		p.add(x1) ;p.add(X);
		x1.setBounds(40,0,300,40);X.setBounds(470,0,20,40);
		
		
		/** la Fenetre **/
		p2 = new JPanel() ; p2.setBackground(new Color(44,62,80));
		this.add(p2);
		p2.setBounds(0,50,500,650);
		p2.setLayout(null);
				
		MODE =new JLabel(" CHRONOMETRE : ");MODE.setForeground(Color.white);
		niveau =new JLabel("NIVEAU DU JEU : ");niveau.setForeground(Color.white);
		ech = new JLabel("CHOISISSEZ L'ECHIQUIER :") ;ech.setForeground(Color.white);
		piece = new JLabel("CHOSISSEZ LES PIECES ");piece.setForeground(Color.white);
		JLabel choix = new JLabel(new ImageIcon(ImageIO.read(new File("choix.png")))) ;
		
		
		Retour=new JButton("Retour");Retour.setBackground(new Color(34,167,240));Retour.setForeground(Color.white);
		Commencer=new JButton("Commencer");Commencer.setBackground(new Color(192,57,43));Commencer.setForeground(Color.white);
		
	    slider = new JSlider(20,180,40) ;p2.add(slider); slider.setBounds(90,50,300,50);slider.setMajorTickSpacing(20);slider.setPaintTicks(true);slider.setPaintLabels(true);slider.setForeground(Color.white);slider.setBackground(new Color(44,62,80));
		r12=new JRadioButton ("Facil (avec aide) ");r12.setBackground(new Color(44,62,80));r12.setForeground(Color.white);
		r22=new JRadioButton ("Difficil (sans aide)");r22.setBackground(new Color(44,62,80));r22.setForeground(Color.white);
		
		choix1=new JRadioButton() ;choix1.setBackground(new Color(44,62,80));
		choix2=new JRadioButton() ;choix2.setBackground(new Color(44,62,80));
		choix3=new JRadioButton();choix3.setBackground(new Color(44,62,80));
				
		
		g2= new ButtonGroup();g2.add(r12);g2.add(r22);
		g3= new ButtonGroup();g3.add(choix1);g3.add(choix2);g3.add(choix3);
		
		
		p2.add(piece) ;p2.add(choix1) ;p2.add(choix2) ;p2.add(choix3) ;p2.add(choix1) ;p2.add(choix) ; 
		p2.add(MODE);p2.add(niveau);p2.add(Retour);p2.add(Commencer);p2.add(r12);p2.add(r22);p2.add(ech);
		
		MODE.setBounds(60,10,200,30);choix.setBounds(120,220,240,350);
		niveau.setBounds(60,95,100,40);r12.setBounds(80,130,160,40);r22.setBounds(300,130,160,40);
		Retour.setBounds(50,590,160,40);Commencer.setBounds(300,590,160,40);Retour.addMouseListener(this);Commencer.addMouseListener(this);
		choix1.setBounds(170,330,20,20);choix2.setBounds(154,475,20,20);choix3.setBounds(230,525,20,20) ;
		piece.setBounds(60,170,200,40); 
		
		
		
		
		
	}
	
	

	

	
		
	


	@Override
	public void mouseClicked(MouseEvent e) {
		FenetreJeu f ;
		if(e.getSource()==X || e.getSource() == Retour)
			this.dispose() ;
		if(e.getSource() == Commencer)
		{
			if( g2.getSelection()!= null && g3.getSelection() != null )
				{
					if(r12.isSelected())
						FenetreJeu.niveau = true ;
					else
						FenetreJeu.niveau = false ;
					if(choix1.isSelected())
						try {
							f = new  FenetreJeu("3","4");
							f.ChangerTime(slider.getValue()-1,59);
							this.dispose();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					else
					{
						if(choix2.isSelected())
							try {
								f = new  FenetreJeu("1","2");
								f.ChangerTime(slider.getValue()-1,59);
								this.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						else
							try {
								f = new FenetreJeu("5","6") ;
								f.ChangerTime(slider.getValue()-1,59);
								this.dispose();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
					}
							
					
				}
	
		
		}
		if(e.getSource() == Retour)
			this.dispose();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
