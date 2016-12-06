package drawing;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Classe abstraite de type forme dessinable.
 */
public abstract class Shape {
	
	protected Point origin;
	protected boolean isSelected = false;
	
	public void setOrigin(Point p)
	{
		origin = p;
	}
	
	public void setSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	public boolean isSelected()
	{
		return this.isSelected;
	}
	
	/**
	 * dessine la forme sur un Graphics
	 */
	public abstract void paint(Graphics g);
	
	/**
	 * renvoie true si la forme occupe sur le point donné
	 */
	public abstract boolean isOn(Point p);

}
