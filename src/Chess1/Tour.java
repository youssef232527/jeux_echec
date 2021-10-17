package Chess1;

import java.awt.Color;

public class Tour extends Piece {
	private boolean a_Deplacé ; 

	public Tour(Color couleur) {
		super("Tour",couleur);
		a_Deplacé = false ; 
	}

	public boolean verifDeplacement(Case depart , Case arrive) {
		int x = (arrive.getX() - depart.getX()) ;
		int y = (arrive.getY() - depart.getY()) ;
		
		return ((x != 0 && y==0) || (x==0 && y!=0)) ;
	}
	
	
	public boolean voirEtat()
	{
		return a_Deplacé ;
	}
	
	public void a_deplacé()
	{
		a_Deplacé = true ;
	}


}
