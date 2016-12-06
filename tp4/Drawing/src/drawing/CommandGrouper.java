package drawing;

import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class CommandGrouper extends Shape {

	private ArrayList<Shape> shapes;
	
	public CommandGrouper(){
		super();
		shapes = new ArrayList<Shape>();
	}
	
	public CommandGrouper(ArrayList<Shape> shapes){
		this.shapes = shapes;
	}
	
	
	public void addFigure(Shape s){
		shapes.add(s);
	}
	
	public void removeFigure(Shape s){
		shapes.remove(s);
	}
	
	public Iterator getFigure(){
		return shapes.iterator();
	}
	
	public ArrayList<Shape> getListShapeGroupe(){
		return this.shapes;
	}
	
	public Shape getShape(int n){
		return shapes.get(n);
	}


	@Override
	public void paint(Graphics g) {
		for(Shape s : shapes){
			s.paint(g);
		}
	}

	@Override
	public boolean isOn(Point p) {
		for(Shape s : shapes){
			if(s.isOn(p)){
				return true;
			}
		}
		return false;
	}
		
}
