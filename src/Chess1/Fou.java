package Chess1;

import java.awt.Color;

public class Fou extends Piece {

	public Fou(Color couleur)
	{
		super("Fou" ,couleur) ;
	}
	
	public boolean verifDeplacement(Case depart , Case arrive) {
		int x = Math.abs(arrive.getX() - depart.getX()) ;
		int y = Math.abs(arrive.getY() - depart.getY()) ;
		
 		return( x==y ) ;
	}
	

}
