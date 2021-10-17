package Chess1;

import java.awt.Color;

public class Reine extends Piece {

	public Reine(Color couleur) {
		super("Reine", couleur);
		
	}

	
	public boolean verifDeplacement(Case depart , Case arrive) {
		int x = Math.abs(arrive.getX() - depart.getX()) ;
		int y = Math.abs(arrive.getY() - depart.getY()) ;
		return  ((x==y)||(x > 0 && y==0)||(y > 0 && x==0)) ;
	}

}
