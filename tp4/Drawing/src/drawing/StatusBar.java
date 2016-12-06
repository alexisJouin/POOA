package drawing;

import java.util.ArrayList;

import javax.swing.*;

public class StatusBar extends JLabel implements Observer {

	private double nbFigure = 0;
	private int nbCircle = 0;
	private int nbRectangle = 0;
	private String output = "<html><p><u>Barre de status :</u></p></html>";
	//private ArrayList<Shape> shapes;
	
	private Drawing drawing;
	
	public StatusBar(Drawing drawing){
		super();
		this.drawing = drawing;	

		this.setText(output);
		this.drawing.addObserver(this);
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
		
		this.nbFigure = this.drawing.shapes.size();
		System.out.println(nbFigure);
		this.setText("<html>"
				+ "<p><u>Barre de status :</u></p>"
				+ "<p>Nombre de figures : <b>" + this.nbFigure + "</b></p>"
				+ "</html>");
		
		
	}
}
