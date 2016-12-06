package drawing;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.border.Border;

/**
 * Listener pour gérer la souris dans la zone de dessin
 */
public class DrawingMouseListener implements MouseMotionListener, MouseListener {

	Drawing drawing;
	Shape currentShape = null;
	private ArrayList<Shape> selectedFigure = new ArrayList<Shape>();
	
	public DrawingMouseListener(Drawing d){
		drawing = d;
	}
	
	/**
	 * Bouge la forme sélectionnée (si une forme est sélectionnée)
	 */
	public void mouseDragged(MouseEvent e) {
		System.out.println(currentShape);
		System.out.println("Shapes selected : " + selectedFigure);
		
		if(currentShape instanceof CommandGrouper){
			for(Shape s : this.selectedFigure){
				s.setOrigin(e.getPoint());
				drawing.repaint();
			}				
		}
		else{
			if(currentShape != null){
				currentShape.setOrigin(e.getPoint());
				drawing.repaint();
			}
		}
	}
	
	/**
	 * Sélectionne la forme sur laquelle l'utilisateur a cliqué
	 */
	public void mousePressed(MouseEvent e) {
		for(Shape s : drawing){
			if(s.isOn(e.getPoint())){
				currentShape = s;
				if(!selectedFigure.contains(s)){
					selectedFigure.add(s); //Ajoute dans le tableau la figure selected
				}
				
				//ToDo Mise en forme selected !!
				break;
			}
		}
	}

	/**
	 * Désélectionne la forme
	 */
	public void mouseReleased(MouseEvent e) {
		currentShape = null;
		
		//Pour enlever figure selected unselected
		/*for(Shape s : drawing){
			if(s.isOn(e.getPoint())){	
				continue;
			}
			else{
				selectedFigure.remove(s);
				break;
			}
		}
		*/
		

	}

	public void mouseMoved(MouseEvent e) {
		
	}

	public void mouseClicked(MouseEvent e) {
        for (Shape s : drawing) {

            if (s.isOn((e.getPoint()))) {
            	
                if (s instanceof Rectangle) {
                    System.out.println("Click sur rectangle");
                } else if (s instanceof Circle) {
                    System.out.println("Click sur cercle");
                }

            }
        }
	}
	

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}
	
	public ArrayList<Shape> getSelectedFigure(){
		return this.selectedFigure;
	}
}
