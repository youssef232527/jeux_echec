package Chess1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

public class FenetreJeu extends JFrame implements  MouseListener{

	private Echiquier e ;
	private Panel P  ;
	private JTextArea t1,t2 ;
	private JLabel fin , jl5, jl6, labelPiece1 , labelPiece2;
	private int Numero_coup ;
	private int it ;                        /**  1er clique  ou 2 clique  **/                     
	private Case CaseDepart ;				/**        sont utilisés dans les MouseEvent  **/  	
	private  BufferedWriter bw ;
	
	
	public static Color CouleurJoueur ;
	public static JLabel  PieceGagne2, PieceGagne1;
	public static boolean niveau ;
	
	
	/**********partie chrono *********/
	public int heure1,minute1,seconde1;
	public int heure2,minute2,seconde2;
	/*initialisation des variables de chrono*/
	public int heure=0,minute=0,seconde=0;
	public int delais=1000;
	public ActionListener tache_timer;
	public Timer timer1;
	public JLabel temps=new JLabel(""+heure+":"+minute+":"+seconde);
	public JLabel temps1=new JLabel(""+heure1+":"+minute1+":"+seconde1);
	public JLabel temps2=new JLabel(""+heure2+":"+minute2+":"+seconde2);
	/************************************/
	
	
	
	
	
	public FenetreJeu (String num1 ,String num2) throws IOException
	{
		
	
		bw = new BufferedWriter(new FileWriter("Chess.txt")) ;
		e = new Echiquier(num1,num2) ;
		CouleurJoueur = Echiquier.couleurPiece1 ;
		this.setUndecorated(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setBounds(0,0,1900,980);
		this.setResizable(true);
		this.setLayout(new GridLayout(1,1));
		/****************Corp du Jeu ********************/
		JLabel  jl = new JLabel(new ImageIcon(ImageIO.read(new File("10.jpg")))) ;
		JLabel  jlx = new JLabel(new ImageIcon(ImageIO.read(new File("mk.png")))) ;
		this.add(jl) ; jl.setLayout(null);
		P = new Panel() ;
		P.setLayout(new GridLayout(8,8));
		jl.add(jlx) ; jlx.setLayout(null) ;  jlx.add(P) ;  P.setBounds(70,42,710,677);              
		jlx.setBounds(270,55,850,760);
	
		
		/***************Coté Gauche**********************/
		
		JLabel jl3 =new JLabel(new ImageIcon(ImageIO.read(new File("cg.png")))) ;
		JLabel jl4 =new JLabel(new ImageIcon(ImageIO.read(new File("cg.png")))) ;
		jl.add(jl3) ;jl3.setBounds(40,80,240,330);jl3.setLayout(null) ;
		jl.add(jl4) ;jl4.setBounds(40,480,240,330);jl4.setLayout(null) ;
		
		t1 = new JTextArea() ;t1.setBackground(new Color(0,0,0,64));t1.setOpaque(false);t1.setFont(new Font("",Font.BOLD,14));
		JPanel px1 = new JPanel () ; px1.setBackground(new Color(44,62,80)) ;
		JLabel lx1 = new JLabel("les Coups du Joueur 1 ") ;lx1.setForeground(Color.white); 
		JScrollPane listScroller = new JScrollPane(t1);listScroller.setOpaque(false);listScroller.getViewport().setOpaque(false);listScroller.setBorder(null);listScroller.setViewportBorder(null);
		px1.add(lx1) ;
		jl3.add(listScroller) ; listScroller.setBounds(17,35,204,186);
		jl3.add(px1) ; px1.setBounds(19,288,200,30);
		
		
		t2 = new JTextArea() ;t2.setBackground(new Color(0,0,0,64));t2.setOpaque(false);t2.setFont(new Font("",Font.BOLD,14));
		JPanel px2 = new JPanel () ; px2.setBackground(new Color(44,62,80));
		JLabel lx2 = new JLabel("les Coups du Joueur 2 ") ;lx2.setForeground(Color.white); 
		JScrollPane listScroller2 = new JScrollPane(t2);listScroller2.setOpaque(false);listScroller2.getViewport().setOpaque(false);listScroller2.setBorder(null);listScroller2.setViewportBorder(null);
		px2.add(lx2) ;
		jl4.add(listScroller2) ; listScroller2.setBounds(17,32,205,186);
		jl4.add(px2) ; px2.setBounds(19,288,200,30);
		
		
	
		
	
		/********************* en haut**************************/
		
	    JLabel labelchrono1 = new JLabel(new ImageIcon(ImageIO.read(new File("egg2.png")))) ;
	   jl.add(labelchrono1) ;
	   labelchrono1.setBounds(320,0,250,80);
	   jl.add(temps1) ;
	   temps1.setBounds(410,0,250,80);
	   temps1.setFont(new Font("",Font.BOLD,28));
	   temps1.setForeground(Color.white);
	   
	   
	   
	   JLabel labelchrono2 = new JLabel(new ImageIcon(ImageIO.read(new File("egg2.png")))) ;
	   jl.add(labelchrono2) ;
	   labelchrono2.setBounds(820,0,250,80);
	   jl.add(temps2) ;
	   temps2.setBounds(910,0,250,80);
	   temps2.setFont(new Font("",Font.BOLD,28));
	   temps2.setForeground(Color.black);
	   
	   
	   
	   JLabel labelchrono3 = new JLabel(new ImageIcon(ImageIO.read(new File("egg2.png")))) ;
	    jl.add(labelchrono3) ;
	   labelchrono3.setBounds(570,0,250,80);
	   jl.add(temps) ;
	   temps.setBounds(660,0,250,80);
	   temps.setFont(new Font("",Font.BOLD,28));
	   
		
		/***********************droite*************************/
	 
	//les deux demi cercle jl5 et jl6	
	 jl5 = new JLabel(new ImageIcon(ImageIO.read(new File("ek.png")))) ;
	 jl.add(jl5) ;
	 jl5.setBounds(1050,110,150,280);
	 jl5.addMouseListener(this);
		
	 jl6 = new JLabel(new ImageIcon(ImageIO.read(new File("ek.png")))) ;
	 jl.add(jl6) ;
	 jl6.setBounds(1050,480,150,280);
	 jl6.addMouseListener(this);	
		
	
	 /********************/
	 labelPiece1 = new JLabel(new ImageIcon(ImageIO.read(new File("j1.png")))) ;  ; PieceGagne1= new JLabel() ;jl.add(labelPiece1); labelPiece1.add( PieceGagne1)  ; labelPiece1.setBounds(1070,80,330,330);labelPiece1.setLayout(null);
	 PieceGagne1.setBounds(50,38,270,270);  PieceGagne1.setLayout(new GridLayout(4,4)) ; PieceGagne1.setBackground(new Color(235,235,235,64)); 
	 
		
     	labelPiece1.hide();
		labelPiece1.addMouseListener(this);
		PieceGagne1.addMouseListener(this);
		
		 
		 labelPiece2 = new JLabel(new ImageIcon(ImageIO.read(new File("j1.png")))) ;  ;  PieceGagne2= new JLabel() ; jl.add(labelPiece2); labelPiece2.add( PieceGagne2); labelPiece2.setBounds(1070,440,330,330);labelPiece2.setLayout(null);
		 PieceGagne2.setBounds(50,32,270,270);  PieceGagne2.setLayout(new GridLayout(4,4));
		 labelPiece2.hide();
		 labelPiece2.addMouseListener(this);
		 PieceGagne2.addMouseListener(this);
		 
	
		fin = new JLabel(new ImageIcon(ImageIO.read(new File("exit.png")))) ; 
		jl.add(fin) ; fin.setBounds(1410,20,100,100); fin.addMouseListener(this);
		
	 /*******************/
	 
		for(int i=1 ; i<9;i++ )
			for(int j = 1; j<9 ;j++ )
				{
					Case b = e.getCase(i, j) ;
					if((b.getX()+b.getY())%2 == 0)
						b.setBackground(e.couleurCase1);
					else
						b.setBackground(e.couleurCase2);
					P.add(b) ;
					b.addMouseListener(this) ;
				}
		
		
		this.setVisible(true);
		
		
		it = 0 ;
		Numero_coup = 1;
		chrono(); //demarrer le chrono 
	}
	

	
	public void changerJoueur() throws IOException                   /** a changer avec Youssef **/
	{
		chronoT(CouleurJoueur);
		
		if(e.Pion_promu() != null)           
			new FenetrePion(e.Pion_promu()) ;
		CouleurJoueur = CouleurJoueur == Echiquier.couleurPiece1 ? Echiquier.couleurPiece2 : Echiquier.couleurPiece1 ;
		
		if( e.FinJeu()  )
		{
			bw.close();
			new GameOver(CouleurJoueur) ;
		}
		if((minute1<=0 && seconde1 <= 0)||(minute2<=0 && seconde2<= 0))
		{
			Color col = CouleurJoueur ==Echiquier.couleurPiece1 ? Echiquier.couleurPiece2 : Echiquier.couleurPiece1 ;
			new GameOver(col);
		}

			 
	}
	
	
	
	
	public void Colorer_Case_Possible(Case c ,Color a)
	{
		Vector v = e.Coup_Possible(c) ;
		Iterator<Case> iw = v.iterator() ;
		while(iw.hasNext()) 
			iw.next().setBackground(a);
	}
	
	public void Decolorer_Case_Possible(Case c)
	{
		Vector v = e.Coup_Possible(c) ;
		Iterator<Case> iw = v.iterator() ;
		while(iw.hasNext()) 
		{
			Case x = iw.next() ;
			x.setBackground(x.getCouleur());
		}
	}
	

	
	public void EcrireDernierCoup(Case c1 , Case c2)
	{
		if(CouleurJoueur == e.couleurPiece1)
		{	
			if(c1.getP() == null && c2.getP()==null)
			{
				t1.setText(t1.getText() + "\n\n  "+((int)((this.Numero_coup+1)/2)) + ") " + "ROQUE" );
			}
			else	
			{	
				
				t1.setText(t1.getText()+"\n\n  "+((int)((this.Numero_coup+1)/2)) +") "+c2.getP().getNom().toUpperCase()+" : "+c1+ " >> " +c2);			
	
			}
		}
		else
		{
			if(c1.getP() == null && c2.getP()==null)
			{
				t2.setText(t2.getText() + "\n\n  "+(int)(this.Numero_coup/2)+") " + "ROQUE" );
			}
			else	
			{	
				
				t2.setText(t2.getText()+"\n\n  "+(int)(this.Numero_coup/2)+") "+c2.getP().getNom().toUpperCase()+" : "+c1+ " >> " +c2);			
	
			}
		}
			
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent a) {
		if(a.getSource() ==fin)
		{
			this.dispose();
			try {
				bw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
		if( a.getSource() != jl5 && a.getSource() != jl6 && a.getSource() != PieceGagne1 && a.getSource() != PieceGagne2 && a.getSource() != labelPiece1 && a.getSource() != labelPiece2)
		{
			
			Case c = (Case) (a.getSource()) ;
			boolean bol = true ;     /** pour connaitre la deuxieme clique **/
			boolean bol2 = true ;    /** pour changer la 1er piece choisie (1er clique) **/
	
			while(bol2)
			{	
				bol2=false ;
				if((c.getP() != null) && (it == 0))         /*la 1er clique */
				{
					
					if(c.getP().getCouleur() == CouleurJoueur)
					{
				
						CaseDepart = c ;
						it = 1 ;
						bol = false ;           // pour n'entrer pas dans la verification suivante !
						if(niveau)
							Colorer_Case_Possible(CaseDepart, Color.cyan) ;
				
					}
				}
				if( ( c.getP() != null) && (it == 1) && bol ) /*deuxieme clique*/
				{
					if(c.getP().getCouleur() != CaseDepart.getP().getCouleur())
					{
						if(niveau)
							Decolorer_Case_Possible(CaseDepart) ;
						if(e.deplacerPiece(CaseDepart, c))
						{
							
							int i = this.CouleurJoueur == e.couleurPiece1 ? 1 : 2 ;
							try {
								
								EcrireDernierCoup(CaseDepart , c) ;
								bw.write("\n >> Coup "+Numero_coup+" : Joueur "+i +" \t "+ c.getP().getNom() +" : "+CaseDepart+" -> " + c);	
								Numero_coup ++ ;
								changerJoueur() ;
								
							}
							catch (IOException e1) {}
							
						

						}
						CaseDepart = null ; 
						it = 0 ;
					}
					else
					{
						if((c.getP().getNom()=="Tour")&& (CaseDepart.getP().getNom()=="Roi"))
						{
							if(niveau)
								Decolorer_Case_Possible(CaseDepart) ;
							if (e.deplacementRoiTour(CaseDepart,c))
							{
								EcrireDernierCoup(CaseDepart , c) ;
								Numero_coup ++ ;
								
								try {
									
									int i = this.CouleurJoueur == e.couleurPiece1 ? 1 : 2 ;
									bw.write("\n >> Coup "+Numero_coup+" : Joueur "+i +" \tRoque -> Roi " +CaseDepart+" -> Tour " + c);
									changerJoueur() ;
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							it = 0 ; 
							CaseDepart = null ;
						}
						else
						{
				
							if(niveau)
								Decolorer_Case_Possible(CaseDepart) ;
							bol2 = true ;
							CaseDepart = null ;
							it = 0 ;
							
				
						}
				
					}
				}	 
				if( (c.getP() == null) && (it == 1) )
				{
					if(niveau)
						Decolorer_Case_Possible(CaseDepart) ;
					if(e.deplacerPiece(CaseDepart,c))
					{	
						
						int i = this.CouleurJoueur == e.couleurPiece1 ? 1 : 2 ;
						try {
							EcrireDernierCoup(CaseDepart , c) ;
							bw.write("\n >> Coup "+Numero_coup+" : Joueur "+i +" \t "+ c.getP().getNom() +" : "+CaseDepart+" -> " + c);	
							changerJoueur() ;
							Numero_coup ++ ;
							
						} 
						catch (IOException e1) {}
						
					}
					else
						bol2 = true ;
			
					it = 0 ;                  /**Retourner a la 1er clique**/
					CaseDepart = null ;
				}
				
			}
		}
		}
	
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
	public void mouseEntered(MouseEvent a) {
		if(a.getSource()==jl5 || a.getSource()==PieceGagne1)
		{
			jl5.setBounds(1380,110,150,280);
			labelPiece1.show();
			
		} 
		if(a.getSource()==jl6 || a.getSource()==PieceGagne2)
		{
			jl6.setBounds(1380,480,150,280);
			labelPiece2.show();
			
		}
		
		
	}

	@Override
	public void mouseExited(MouseEvent a) {
		
		if(a.getSource()==labelPiece1 )
		{
			jl5.setBounds(1050,110,150,280);
			labelPiece1.hide();
			
		}
		if(a.getSource()==labelPiece2)
		{
			jl6.setBounds(1050,480,150,280);
			labelPiece2.hide();
			
		}
	}





/***************partie chrono*************/
	public void chrono(){
		tache_timer= new ActionListener()  {
		  public void actionPerformed(ActionEvent e)  {
		    seconde++;
		     if(seconde==60)  {
		          seconde=0;
		          minute++;
		      }
		  if(minute==60) {
		      minute=0;
		      heure++;
		   }
		  //Afficher le chrono dans un JLabel
		 temps.setText(heure+":"+minute+":"+seconde);
		 
		 }
		};
     
     //Action et temps execution de la tache
     timer1=new Timer(delais,tache_timer);
     //Demarrer le chrono
    timer1.start();
	}
	public void chronoT(Color c) {
		

		if(c==e.couleurPiece1) {
			 timer1.stop();
			 
			 if((seconde1-seconde)<0) {
				 seconde1=Math.abs(seconde1-seconde);
				 minute1=minute1-(1+minute);
						
			 }
			 else {
				 seconde1=seconde1-seconde;
				 minute1=minute1-minute;
			 }
			 
			 
			 
				/*this.minute1=minute1-minute;
				this.seconde1=seconde1-seconde;
				if(seconde1>59) {
					minute1--;
				}*/
				
				temps1.setText(""+heure1+":"+minute1+":"+seconde1);
				heure=0;minute=0;seconde=0;
				
				temps.setText(heure+":"+minute+":"+seconde);
				timer1.start();
			 
		 }
		 else
		 {
			 timer1.stop();
			 
			 if((seconde2-seconde)<0) {
				 seconde2=Math.abs(seconde2-seconde);
				 minute2=minute2-(1+minute);
						
			 }
			 else {
				 seconde2=seconde2-seconde;
			     minute2=minute2-minute;
			 
			 }	/*this.minute2=minute2+minute;
				this.seconde2=seconde2+seconde;
				if(seconde2>59) {
					minute2++;
				}*/
				temps2.setText(""+heure2+":"+minute1+":"+seconde2);
				heure=0;minute=0;seconde=0;
				
				temps.setText(heure+":"+minute+":"+seconde);
				timer1.start();
		 }


	}
	public void ChangerTime(int m,int s) {
		this.seconde1=s;
		this.seconde2=s;
		this.minute1=m;
		this.minute2=m;
		temps1.setText(heure1+":"+minute1+":"+seconde1);
		temps2.setText(heure2+":"+minute2+":"+seconde2);
		

	
}

/*****************************************/
	
	
}