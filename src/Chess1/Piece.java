package Chess1;

import java.awt.Color;

public abstract class Piece {
	 
	protected String nom ; 
	protected Color couleur ;
	
	
	
	
	public Piece(String nom ,Color couleur)
	{
		this.nom = nom  ; 
		this.couleur = couleur ; 
	
	}
	
	public abstract boolean  verifDeplacement(Case depart , Case arrive)  ;   //verifier la validité du deplacement de chaque piece
	
	
	
	public void seDeplacer(Echiquier e , Case depart , Case arrive)                // assure le deplacement du piece on ajoutant le Piece tué au corbeille correspondant
	{ 
		
		Piece p = arrive.getP() ;
		if (p != null )          
			e.ajoutPanel(arrive);
		arrive.setP(this) ;
		depart.setP(null);
		
		
	}
	
	public Piece seDeplacer( Case depart , Case arrive)                // assure le deplacement du piece
	{ 
		
		Piece p = arrive.getP() ;
		arrive.setP(this) ;
		depart.setP(null);
		return p ;
		
		
	}



	public String getNom() {
		return nom;
	}



	public void setNom(String nom) {
		this.nom = nom;
	}



	public Color getCouleur() {
		return couleur;
	}



	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	
	
	
	
	
	
}
