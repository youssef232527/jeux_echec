package Chess1;

import java.awt.Color;

public class Chevalier extends Piece {

	public Chevalier( Color couleur) {
		super("Chevalier", couleur);
		
	}


	public boolean verifDeplacement(Case depart , Case arrive)
	{
	
			int x = Math.abs(arrive.getX() - depart.getX()) ;
			int y = Math.abs(arrive.getY() - depart.getY()) ;
			return ( ( ((float)x/(float)y)== 0.5 || (((float)x/(float)y)) == 2)  && (( x == 2 && y== 1) ||  (x==1 && y==2) )) ;
		
	}


}
