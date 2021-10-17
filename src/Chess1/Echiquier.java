package Chess1;



import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class Echiquier  {
	
	private Case [][] Cases ;
	public static String num1 , num2 ;             // le numero des icones du piece 
	public static Color couleurCase1 ;             // static car on va les initialiser avant l'echiquier 
	public static Color couleurCase2 ;			  // et on va les utilisés dans les autres classes
	public static Color couleurPiece1 ;
	public static Color couleurPiece2 ;
/************************************/
	
	
	public static Icon ImageResize(Icon icon)            // c = icon qui va etre redimentionnée  
	{
		
		Image im = ((ImageIcon) icon).getImage() ;
		Image im_modif = im.getScaledInstance(50,50, Image.SCALE_SMOOTH) ;
		icon = new ImageIcon(im_modif) ;
		return icon;
		
	}
	
	
	
	public static ImageIcon ImageResize(String c )            // c = localisation de l'icone c 
	{
		ImageIcon icon  = new ImageIcon(c) ;
		Image im = icon.getImage() ;
		Image im_modif = im.getScaledInstance(80,80, Image.SCALE_SMOOTH) ;
		icon = new ImageIcon(im_modif) ;
		return icon;
		
	}
		
	

	
	/*********************************/
	

	
	public Echiquier(String num1 , String num2) 
	{		
		this.num1 = num1 ;
		this.num2=num2 ;
 		
		Cases = new Case[8][8] ; 
		
		
		for (int i=1 ; i<7 ; i++)                      // pour initialiser l'echiquier avec tous les pieces 
		{											  //Pion et cases vides
			
				if (i==1)                           
		
					for (int j = 0 ; j<8; j++)
					{
						Color CO = (i+j)%2 == 0 ? couleurCase1 : couleurPiece2 ;
						Cases[i][j] = new Case(i+1,j+1,new Pion(couleurPiece1),this.ImageResize("icon/p"+num1+".png"),CO) ;
						
					}
			
				if(i==6)
						for (int j = 0 ; j<8; j++)
						{
							Color CO = (i+j)%2 == 0 ? couleurCase1 : couleurPiece2 ;
							Cases[i][j] = new Case(i+1,j+1,new Pion(couleurPiece2),this.ImageResize("icon/p"+num2+".png"),CO) ;
						}
				if( i != 6 && i != 1)
						for (int j = 0 ; j<8 ; j++) {
							Color CO = (i+j)%2 == 0 ? couleurCase1 : couleurPiece2 ;
							Cases[i][j] = new Case(i+1,j+1,null,null,CO) ;
						}
					
	
		}
		
		
		Cases[0][0] = new Case(1,1, new Tour(couleurPiece1),this.ImageResize("icon/t"+num1+".png"),couleurCase1) ;
		Cases[0][7] = new Case(1,8, new Tour(couleurPiece1),this.ImageResize("icon/t"+num1+".png"),couleurCase2) ;
		Cases[0][1] = new Case(1,2, new Chevalier(couleurPiece1),this.ImageResize("icon/c"+num1+".png"),couleurCase2) ;
		Cases[0][6] = new Case(1,7, new Chevalier(couleurPiece1),this.ImageResize("icon/c"+num1+".png"),couleurCase1) ;
		Cases[0][2] = new Case(1,3 , new Fou(couleurPiece1),this.ImageResize("icon/f"+num1+".png"),couleurCase1) ;
		Cases[0][5] = new Case(1,6, new Fou(couleurPiece1),this.ImageResize("icon/f"+num1+".png"),couleurCase2) ;
		Cases[0][4] = new Case(1,5, new Roi(couleurPiece1),this.ImageResize("icon/ro"+num1+".png"),couleurCase1) ;
		Cases[0][3] = new Case(1,4, new Reine(couleurPiece1),this.ImageResize("icon/r"+num1+".png"),couleurCase2) ;
		
		
		Cases[7][0] = new Case(8,1, new Tour(couleurPiece2),this.ImageResize("icon/t"+num2+".png"),couleurCase2) ;
		Cases[7][7] = new Case(8,8, new Tour(couleurPiece2),this.ImageResize("icon/t"+num2+".png"),couleurCase1) ;
		Cases[7][1] = new Case(8,2, new Chevalier(couleurPiece2),this.ImageResize("icon/c"+num2+".png"),couleurCase1) ;
		Cases[7][6] = new Case(8,7, new Chevalier(couleurPiece2),this.ImageResize("icon/c"+num2+".png"),couleurCase2) ;
		Cases[7][2] = new Case(8, 3 , new Fou(couleurPiece2),this.ImageResize("icon/f"+num2+".png"),couleurCase2) ;
		Cases[7][5] = new Case(8,6, new Fou(couleurPiece2),this.ImageResize("icon/f"+num2+".png"),couleurCase1) ;
		Cases[7][4] = new Case(8,5, new Roi(couleurPiece2),this.ImageResize("icon/ro"+num2+".png"),couleurCase2) ;
		Cases[7][3] = new Case(8,4, new Reine(couleurPiece2),this.ImageResize("icon/r"+num2+".png"),couleurCase1) ;
		
		
		
	}
	


	
	
	
	public Case getCase(int i , int j)
	{
		return Cases[i-1][j-1] ;
	} ;
	
	
	
	
	
	
	public boolean verifCaseVide(Case depart , Case arrive)           //verifier que les cases sont vides lors d'un deplacement 
	{
		boolean a ; 
		Piece p = depart.getP() ;
		
		if (arrive.getP() != null)             // verification des le debut que la case d'arrivee verifie les conditions necessaires
			a = arrive.getP().getCouleur() != p.getCouleur() ;
		else
			a=true ;
		
		int x = arrive.getX() - depart.getX() ;
		int y = arrive.getY() - depart.getY() ;
		
	
		if (p.getNom()=="Tour" || p.getNom()=="Fou" || p.getNom()=="Reine" || p.getNom()=="Roi" || p.getNom()=="Pion")				// Tour|Fou|Reine|Roi
		{
			int dx = x==0 ? 0 : (int)(Math.abs(x)/x) ;       // une unite de deplacement selon x ( 1 ou 0 ou -1 ) on l'utilise dans le boucle 
			int dy = y==0 ? 0 : (int)(Math.abs(y)/y) ;		// une unitee de deplacement selon y ( 1 ou 0 ou -1 )
			
			for (int i = depart.getX()-1+dx , j = depart.getY()-1+dy  ; (i != arrive.getX()-1 || j != arrive.getY()-1) && a ; i += dx , j+=dy)
				if( ! Cases[i][j].estVide() )
					a= false ; 
		
		}
		
		return a ; 
	}
	
	
	public boolean deplacementRoiTour(Case depart , Case arrive)
	{
		boolean a = false ;
		Piece p1 = depart.getP() ;
		Piece p2 = arrive.getP() ;
		
		int dy = (int) (Math.abs((arrive.getY() - depart.getY()))/(arrive.getY() - depart.getY())) ;
		
		Case c = this.getCase(depart.getX(),depart.getY()+(2*dy)) ;           /*case du Roi*/
		Case c2 = this.getCase(depart.getX(),depart.getY()+(dy)) ;			/*case du tour */ 
		
		
		if( ((Roi)p1).verifDeplacementAvecTour(depart, arrive) && this.verifCaseVide(depart,c) && !(((Roi)p1).voirEtat()) && !(((Tour)p2).voirEtat()) && !this.Roi_Attaqué_apres_deplacement_vituel(depart,c) )
		{
			
			((Roi)p1).a_deplacé() ;
			((Tour)p2).a_deplacé(); 
			this.getCase(depart.getX(),depart.getY()+(2*dy)).setIcon(depart.getIcon());
			depart.setIcon(null) ;
			this.getCase(depart.getX(),depart.getY()+(dy)).setIcon(arrive.getIcon());
			arrive.setIcon(null);
			p1.seDeplacer(this , depart, c);
			p2.seDeplacer(this , arrive, c2 );
			a = true ;
			
		}		
		return a ;
			
	}
	
	
	
	public boolean deplacerPiece (Case depart , Case arrive)
	{
		boolean ax = false ;
		Piece p1 = depart.getP() ;
		try
		{
		
			if(depart != arrive)	
			{
				if((this.verifCaseVide(depart, arrive)) && (p1.verifDeplacement(depart, arrive)) && !this.Roi_Attaqué_apres_deplacement_vituel(depart, arrive) )
		
				{
					
					p1.seDeplacer(this, depart, arrive);
					arrive.setIcon(depart.getIcon());
					depart.setIcon(null);
					ax =true ;
					
					
					/** on va changer l'etat du Piece deplacé **/	
						
						if(p1 instanceof Roi)
							((Roi)p1).a_deplacé() ;
						if (p1 instanceof Pion) 
							((Pion) p1).a_deplacé();
						if(p1 instanceof Tour)
							((Tour)p1).a_deplacé() ;
					
				}
			}
		}
		catch(Exception e) {}
		
		
		
			
			return ax ;
		}
	
	
	
	
	public Case Case_Roi(Color c )                 /** donner la  case du roi de couleur c selon le coleur **/ 
	{
		for(int i = 0 ; i<8;i++)
			for(int j = 0 ; j < 8 ; j++)
				if(Cases[i][j].getP() != null)
					if( (Cases[i][j].getP().getCouleur() == c) && (Cases[i][j].getP() instanceof Roi)  )
						return Cases[i][j] ;
		return null ;

	}
	
	public boolean Roi_Attaqué(Case c)          //verifier si le roi est attaqué dans la case c 
	{
		for(int i = 0 ; i<8;i++)
			for(int j = 0 ; j < 8 ; j++)
				if(Cases[i][j].getP() != null)
					if( Cases[i][j].getP().getCouleur() != FenetreJeu.CouleurJoueur)
						try
						{
							if(verifCaseVide(Cases[i][j],c) && Cases[i][j].getP().verifDeplacement(Cases[i][j], c))
								return true ;
						}
						catch(Exception e ) {}
		return false ;
	}
	
	
	public boolean Roi_Attaqué_apres_deplacement_vituel(Case depart , Case arrive) /** verifier si le roi est attaqué apres un deplacement virtuel **/
	{
		boolean a = false  ;	
		
		Piece p = depart.getP().seDeplacer(depart, arrive) ;
		if(this.Roi_Attaqué(this.Case_Roi(FenetreJeu.CouleurJoueur)))
			a = true ;
		
		depart.setP(arrive.getP());
		arrive.setP(p);
		
		return a ;
		
	}
	
	
	
	
	public Vector Coup_Possible(Case c)                  // retourner les Coups possibles
	{
		Vector v = new Vector() ;
	
		if (c.getP() != null) 
		{
			if( ! (c.getP() instanceof Roi) )
			{
					for(Case[] a : Cases )
						for(Case b : a )
						{	
							try
				
							{
								if(this.verifCaseVide(c,b) && c.getP().verifDeplacement(c,b) )
								{
									
								    if(! this.Roi_Attaqué_apres_deplacement_vituel(c,b))    /** verifier qu'apres le deplacement du piece le roi n'est pas attaqué **/
								   
								    	v.add(b) ;
								   
								    }
								   
								}
							
							catch (Exception e) {}
						}
					
				}
			
			else
			{
				for(Case[] a : Cases )
					for(Case b : a )
					{	
						try
				
						{
							if((b.getP() instanceof Tour) && b.getP().getCouleur()==c.getP().getCouleur())       // verifier la possibilitée de deplacement avec Tour
							{
								int dy = (int) (Math.abs((b.getY() - c.getY()))/(b.getY() - c.getY())) ;
								Case b1 = this.getCase(b.getX(), b.getY()-dy) ;
								if( ((Roi)(c.getP())).verifDeplacementAvecTour(c,b) && this.verifCaseVide(c,b1) && !(((Roi)(c.getP())).voirEtat()) && !(((Tour)(b.getP())).voirEtat()) )
									if(!this.Roi_Attaqué(b1))
											v.add(b) ;
							}
							else
								
								if(this.verifCaseVide(c,b) && c.getP().verifDeplacement(c,b)  )
									{	
										
										
										if(! this.Roi_Attaqué_apres_deplacement_vituel(c,b))
											v.add(b) ;
										
								
									}
							
						}
					
						catch (Exception e) {}
					}
				
			}
				
		}
		return v ;
	}
	
	
	public Case Pion_promu()  //plusieurs cases                
	{
		if(FenetreJeu.CouleurJoueur == this.couleurPiece1)
		{
			for (int i =0 ; i<8;i++)
				if(Cases[7][i].getP() instanceof Pion)
					return Cases[7][i] ;
		}
		else
			for (int i =0 ; i<8;i++)
				if(Cases[0][i].getP() instanceof Pion)
					return Cases[0][i] ;

		return null ;
	}
	
	
	public boolean FinJeu() 
	{
		Vector v ;
		boolean a = true ;
		
		for (int i=0 ; i<8 && a ; i++)
			for(int j =0 ; j<8 && a;j++)
			{
				if(Cases[i][j].getP() != null)
					if(Cases[i][j].getP().getCouleur() == FenetreJeu.CouleurJoueur)
					{
				
						v = this.Coup_Possible(Cases[i][j]) ;
						if(! v.isEmpty())
							a =false ;
					}
			}
		return a ;
	}
		
	
	
	
	
	
	
	

	
	
	
	public void ajoutPanel(Case a )                      // ajouter la piece gagner dans sa panel corresponante 
	{
		Piece p = a.getP() ;
		if (p.getCouleur() == couleurPiece1)
		{
			JLabel J = new JLabel() ;
			J.setIcon(this.ImageResize(a.getIcon()));
			(FenetreJeu.PieceGagne2).add(J) ;
		}
		else
		{
			JLabel J = new JLabel() ;
			J.setIcon(this.ImageResize(a.getIcon()));
			(FenetreJeu.PieceGagne1).add(J) ;
		}
	}
	
	


}





