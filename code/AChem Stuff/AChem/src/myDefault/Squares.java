package myDefault;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Squares {

	public Color dotMaker=Color.GREEN;
	public double xCord;
	public double yCord;
	public double scale;
	public static double yorg=775;
	public static double xorg=5;
	Graphics g;
	
	public Squares(double position, double position2, double scale) {
		this.scale=scale;
		xCord = scale*position;
		yCord = scale*position2;
	}
	
	public Squares(double i, double k, double scale, Color c) {
		this.scale=scale;
		xCord = scale*i;
		yCord = scale*k;
		dotMaker=c;
	}
	public Squares(double i, double k, double scale, double depth, Color c) {
//		this.scale=depth/(100*scale);
//		if(scale<1) {
//			scale=1;
//		}
		xCord = scale*i;
		yCord = scale*k;
		dotMaker=c;
	}
	
	public void setOrg(double origin, double scale) {
		yorg=origin;
	}
	
	//More useful toString method 
	@Override
	public String toString() {
		return "Generator [X=" + xCord + ", Y=" + yCord + ", Origin= " + "(" + xorg + "," + yorg + ")" + "]" + dotMaker;
	}
	
	//draws a circle for the locations
	public void drawOn(Graphics g) {
		this.g=g;
		Graphics2D g2 = (Graphics2D) g;
		Rectangle2D dot = new Rectangle2D.Double(xorg + xCord/Runner.hardScale, yorg-yCord/Runner.hardScale, 7,7);
		g2.setColor(dotMaker);
		g2.fill(dot);
		//g2.draw(dot);
		//System.out.println(dotMaker);
	}

	public void redrawOn() {
		drawOn(g);
	}

	public void clear() {
		//g.clear;
	}
}
