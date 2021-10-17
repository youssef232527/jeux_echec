package Chess1;

import java.awt.Color;

public class Roi extends Piece {
	public boolean a_Deplac� ;  

	public Roi( Color couleur) {
		super("Roi", couleur);
		a_Deplac� = false ;
		
	}


	public boolean verifDeplacement(Case depart , Case arrive) {
		int x = arrive.getX() - depart.getX() ;
		int y = arrive.getY() - depart.getY() ;
		return ((Math.abs(x)==1) || (Math.abs(y)==1)) ;
	}
	
	
	public boolean verifDeplacementAvecTour(Case depart , Case arrive)
	{
		int x = arrive.getX() - depart.getX() ;
		int y = Math.abs(arrive.getY() - depart.getY()) ;
		return ( (x==0) && ( (y==3) || (y==4) ) ) ;
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
