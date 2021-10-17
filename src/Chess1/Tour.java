package Chess1;

import java.awt.Color;

public class Tour extends Piece {
	private boolean a_Deplac� ; 

	public Tour(Color couleur) {
		super("Tour",couleur);
		a_Deplac� = false ; 
	}

	public boolean verifDeplacement(Case depart , Case arrive) {
		int x = (arrive.getX() - depart.getX()) ;
		int y = (arrive.getY() - depart.getY()) ;
		
		return ((x != 0 && y==0) || (x==0 && y!=0)) ;
	}
	
	
	public boolean voirEtat()
	{
		return a_Deplac� ;
	}
	
	public void a_deplac�()
	{
		a_Deplac� = true ;
	}


}
