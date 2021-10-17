package Chess1;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case extends JButton {
	private int x ; 
	private int y ; 
	private Piece p ;
	private Color couleur ;
	
	  
	
	
	public Case () {} ;
	
	
	public Case(int x , int y ) 
	{
		this.x = x ;
		this.y = y ;
		p=null ;
	
	}
	
	public Case(int x , int y , Piece p ) 
	{
		this.x = x ;
		this.y = y ;
		this.p=p ;
	
	}
	
	public Case(int x , int y , Piece p , ImageIcon i , Color c  ) 
	{
		this.x = x ;
		this.y = y ;
		this.p=p ;
		this.setIcon(i) ;
		couleur = c ;
		
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}


	public Piece getP() {
		return p;
	}

	public void setP(Piece p) {
		this.p = p;
	}
	
	
	

	public boolean estVide()
	{
		return p==null ;
	}
	
	public Color getCouleur()
	{
		return couleur ;
	}
	
	public String toString()
	{
		return (char)(this.getY()+64)+Integer.toString(this.getX()) ;// quoi !!
		
	}
	
	
}
