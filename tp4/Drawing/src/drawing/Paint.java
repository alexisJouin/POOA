package drawing;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Classe Interface graphique pour l'application de dessin
 */
public class Paint {

	private JFrame frame;
	private JButton clearButton;
	private JButton circleButton;
	private JButton rectangleButton;
	private JButton testButton;
	private JButton grouperButton;
	private JButton dissocierButton;
	private JPanel buttonPanel;
	private JPanel mainPanel;
	private JPanel menuPanel;
	private Drawing drawing;
	private StatusBar statusBar;
	
	public void run(){
		frame = new JFrame("Paint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new JPanel(new BorderLayout());
		menuPanel = new JPanel(new BorderLayout());
		
		drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		clearButton = new JButton("Effacer");
		circleButton = new JButton("Cercle");
		rectangleButton = new JButton("Rectangle");
		
		//Boutons pour grouper/dissocier
		grouperButton = new JButton("Grouper");
		dissocierButton = new JButton("Dissocier");
		
		testButton = new JButton("Test");
		
		//Pour la zone de statut
		statusBar = new StatusBar(drawing);
		
		
		//System.out.println(statusBar);
		
		
		//Pour les Boutons
		buttonPanel = new JPanel();
		buttonPanel.add(clearButton);
		buttonPanel.add(circleButton);
		buttonPanel.add(rectangleButton);
		buttonPanel.add(grouperButton);
		buttonPanel.add(dissocierButton);
		
		//test
		//menuPanel.add(testButton);
		
		
		//Menu en bas de l'appli
		menuPanel.add(buttonPanel, BorderLayout.NORTH);
		menuPanel.add(statusBar, BorderLayout.SOUTH);
		
		
		//Vue principale
		mainPanel.add(drawing, BorderLayout.CENTER);
		mainPanel.add(menuPanel, BorderLayout.SOUTH);
		
		
		
		
		//listeners pour les boutons
		clearButton.addActionListener(new ClearButtonListener(drawing));
		circleButton.addActionListener(new CircleButtonListener(drawing));
		rectangleButton.addActionListener(new RectangleButtonListener(drawing));
		grouperButton.addActionListener(new GrouperButtonListener(drawing));
		
		//listeners pour la zone de dessin
		DrawingMouseListener l = new DrawingMouseListener(drawing);
		drawing.addMouseListener(l);
		drawing.addMouseMotionListener(l);

		frame.getContentPane().add(mainPanel);
		frame.setSize(640,480);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args){
		Paint app = new Paint();
		app.run();
	}
}
