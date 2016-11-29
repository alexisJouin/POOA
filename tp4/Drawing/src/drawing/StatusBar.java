package drawing;

import java.util.ArrayList;

import javax.swing.*;

public class StatusBar extends JLabel implements Observer {

	private double nbFigure = 0;
	private int nbCircle = 0;
	private int nbRectangle = 0;
	private String output = "";
	//private ArrayList<Shape> shapes;
	
	private Drawing drawing;
	
	public StatusBar(Drawing drawing){
		super();
		this.drawing = drawing;	
	}

	
	@Override
	public void update(Observable o) {
		/*
		if(o instanceof Drawing){
			
		}
		int nbFigure = 0;
		int nbCircle = 0;
		int nbRectangle = 0;
		
		for(Shape shape : shapes){	

		}
		*/
		this.nbFigure = this.drawing.getSize().getHeight() * this.drawing.getSize().getWidth();
		this.output = "<html><h4>Nombre de figure : </h4> " + this.nbFigure + " </html>";
		
		this.setText(output);			
		
	}
	
	
	
	/*
	public void addCircle(){
		this.nbCircle ++;
		this.nbFigure ++;
	}
	
	public void addRectangle(){
		this.nbRectangle ++;
		this.nbFigure ++;
	}
	*/
}
