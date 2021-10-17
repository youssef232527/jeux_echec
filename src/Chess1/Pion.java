package Chess1;

import java.awt.Color;

public class Pion extends Piece {
	
	private boolean a_Deplacé ;        // c'est un attribut qui verifie est ce qu'un pion a deplacé ou pas 

	public Pion(Color couleur) {
		super("Pion", couleur);
		a_Deplacé = false ; 
		
	}
	
	public void a_deplacé()
	{
		a_Deplacé = true ;
	}

	
	public boolean verifDeplacement(Case depart , Case arrive) {
		 
		
		int x = arrive.getX() - depart.getX() ;
		int y = Math.abs(arrive.getY() - depart.getY());
		
		if ((this.getCouleur() ==Echiquier.couleurPiece1 && (x < 1)) || (this.getCouleur()==Echiquier.couleurPiece2 && (x > -1)))                       //pion ne peut pas reculer ! 
			return false ;                 // condition sur le deplacement d'un pion ( en avance )
		
		if (arrive.getP() != null )
				return 	((Math.abs(x)==1) && (y== 1) && (this.getCouleur() != arrive.getP().getCouleur()) ) ;
		else
			{
				if(! a_Deplacé )
					return((Math.abs(x)==2 && y==0) || (Math.abs(x)==1 && y==0) ) ;
				else 
					return (Math.abs(x)==1 && y==0)  ;
			}
	}

}
