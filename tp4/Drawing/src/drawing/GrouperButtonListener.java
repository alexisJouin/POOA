package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class GrouperButtonListener implements ActionListener{
	private Drawing drawing;
	CommandGrouper groupe;
	private DrawingMouseListener dml = new DrawingMouseListener(drawing);
	private Shape currentGroup = null;
	
	public GrouperButtonListener(Drawing drawing){
		this.drawing = drawing;	
	}


	//Lors du clic sur grouper
	@Override
	public void actionPerformed(ActionEvent arg0) {
		System.out.println("test : " + arg0);
		
		groupe = new CommandGrouper();
		
		/*
		//Pour chaque forme selected
		for (Shape shapeSelected : this.dml.getSelectedFigure()) {
			groupe.addFigure(shapeSelected);
			this.drawing.removeShape(shapeSelected);
		}
		this.drawing.addShape(groupe);
		
		*/
		
		
		/** V2 **/
		ArrayList<Shape> shapes  = new ArrayList<Shape>();
		for (int i =0; i < drawing.shapes.size(); i++){
			Shape sh = drawing.shapes.get(i);
			if (sh.isSelected()){
				groupe.addFigure(sh);
			}
			else{
				shapes.add(sh);
			}
		}
		
		drawing.clear();
		drawing.addShape(groupe);
		for (int i =0; i < shapes.size(); i++){
			drawing.addShape(shapes.get(i));
		}
		
		
	}
	

/*
	@Override
	public void mouseDragged(MouseEvent e) {
		if(this.groupe != null){
			groupe.setOrigin(e.getPoint());
			drawing.repaint();
		}
	}

*/
	



	
	
}
