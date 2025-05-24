package myDefault;

import java.awt.BorderLayout;
import java.awt.Button;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Viewer {

	// import javax.swing.JLabel;

	public static JFrame frame = new JFrame();
	final static int frameWidth = 1650;
	final static int frameHeight = 1000;
	static GComponent myComponent = new GComponent();
	public static JPanel pan = new JPanel();

	public static void main(String[] args) {
		frame.setSize(frameWidth, frameHeight);
		//final String frameTitle = "Graph Of Map";
		//myComponent.add(new AL("soup"));
		Button up = new Button(" A ");
		up.addActionListener(new AL("up"));
		Button down = new Button(" V ");
		down.addActionListener(new AL("down"));
		Button left = new Button(" > ");
		left.addActionListener(new AL("right"));
		Button right = new Button(" < ");
		right.addActionListener(new AL("left"));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(myComponent);
		pan.add(up);
		pan.add(down);
		pan.add(left);
		pan.add(right);
		frame.add(pan,BorderLayout.NORTH);
		frame.setVisible(true);
		
	}

	public void update() {
		frame.add(myComponent);
		frame.repaint();
	}

	public void changeComp(int[][] change) {
		//myComponent.newSquares(change);
	}
}
