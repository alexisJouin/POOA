package drawing;

import javax.swing.*;
import java.awt.*;
import java.util.*;
/**
 * JPanel pouvant afficher des objets de type Shape
 */
public class Drawing extends JPanel implements Iterable<Shape>, Observable {

			
	private static final long serialVersionUID = 1L;
	
	ArrayList<Shape> shapes;
	private ArrayList<Observer> observers;
	
	public Drawing(){
		super();
		observers = new ArrayList<Observer>();
		shapes = new ArrayList<Shape>();
	}
	
	/**
	 * Implémentation de l'interface Iterable<Shape>
	 */
	public Iterator<Shape> iterator(){
		return shapes.iterator();
	}
	
	/**
	 * Ajoute une forme au dessin et redessine
	 */
	public void addShape(Shape s){
		shapes.add(s);
		notifyObservers();
		this.repaint();
	}
	
	/**
	 * Supprime une forme au dessin et redessine
	 */
	public void removeShape(Shape s){
		shapes.remove(s);
		notifyObservers();
		this.repaint();
	}
	
	/** 
	 * Redéfinition de la méthode paintComponent() de JComponent
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Shape s : shapes){
			s.paint(g);
		}
	}
	
	/**
	 * Enlève toutes les formes et redessine
	 */
	public void clear(){
		shapes.clear();
		this.repaint();
	}

	@Override
	public void addObserver(Observer o) {
		observers.add(o);	
	}

	@Override
	public void removeObserver(Observer o) {
		observers.remove(o);
		
	}

	@Override
	public void notifyObservers() {
		for(Observer obs : observers ){
	        obs.update(null);
		}
	}
	
}
