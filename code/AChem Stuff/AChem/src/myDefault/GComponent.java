package myDefault;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class GComponent extends JPanel{

	private ArrayList<Squares> dotDotDot = new ArrayList<>();
	private ArrayList<Line2D> lines = new ArrayList<>();

	double scale = 1;
	Graphics2D g2;
	Graphics g;
	private static final long serialVersionUID = 1L;

	public void newSquares(ArrayList<Particle> particles) {
		dotDotDot.clear();
		Color shade = Color.GREEN;
		for (Particle part : particles) {
			if(part.bonded.size() > part.maxBonds) {
				System.out.println(part.bonded.size()  + " "+ part.maxBonds );
			}
			
			if (part.bonded.size() == part.maxBonds) {
				if(part.unbreakableBond == true) {
					shade = Color.BLUE;
				} else {
					shade = Color.GREEN;
				}
			} else {
				if(part.unbreakableBond == true) {
					shade = Color.ORANGE;
				} else {
					shade = Color.RED;
				}
			}
			
			 	double cosPitch = Math.cos(AL.leftRight);
		        double sinPitch = Math.sin(AL.leftRight);
		        double cosYaw = Math.cos(AL.upDown);
		        double sinYaw = Math.sin(AL.upDown);
		        //
		        double x = part.position[0];
		        double y = part.position[1];
		        double z = part.position[2];
		     // Apply pitch rotation (around the X-axis)
		        double y1 = cosPitch * y - sinPitch * z;
		        double z1 = sinPitch * y + cosPitch * z;

		        // Apply yaw rotation (around the Y-axis)
		        double x1 = cosYaw * x + sinYaw * z1;
		        double y2 = y1;
		        double z2 = -sinYaw * x + cosYaw * z1;

		        // Orthographic projection (ignoring depth)
		        double x2D = x1;
		        double y2D = y2;
		        
				//double XCord = part.position[0]*Math.cos(AL.leftRight)+part.position[1]*Math.sin(AL.leftRight);//XCordXpart + XCordYpart + XCordZpart;
				//double YCord = part.position[2]*Math.cos(AL.upDown)-(Math.cos(AL.leftRight)*part.position[1] -Math.sin(part.position[0]))* Math.sin(AL.upDown);
		        double XCord = x2D;
		        double YCord = y2D;
			
			dotDotDot.add(new Squares(XCord+700000000, YCord+500000000, scale, part.position[2], shade));
			//dotDotDot.add(new Squares(part.position[0], part.position[1], scale, part.position[2], shade));
		}

	}

	public void newLines(ArrayList<Particle> particles) {
		lines.clear();
		Color shade = Color.GREEN;
		for (Particle part : particles) {
			for (Particle otherPart : part.bonded) {
				if (part.position[2] >= otherPart.position[2]) {
					shade = Color.YELLOW;
				} else {
					shade = Color.RED;
				}
				
				 // Calculate rotation matrix components
		        double cosPitch = Math.cos(AL.leftRight);
		        double sinPitch = Math.sin(AL.leftRight);
		        double cosYaw = Math.cos(AL.upDown);
		        double sinYaw = Math.sin(AL.upDown);
		        //
		        double x = part.position[0];
		        double y = part.position[1];
		        double z = part.position[2];
		     // Apply pitch rotation (around the X-axis)
		        double y1 = cosPitch * y - sinPitch * z;
		        double z1 = sinPitch * y + cosPitch * z;

		        // Apply yaw rotation (around the Y-axis)
		        double x1 = cosYaw * x + sinYaw * z1;
		        double y2 = y1;
		        double z2 = -sinYaw * x + cosYaw * z1;

		        // Orthographic projection (ignoring depth)
		        double x2D = x1;
		        double y2D = y2;
		        
				//double XCord = part.position[0]*Math.cos(AL.leftRight)+part.position[1]*Math.sin(AL.leftRight);//XCordXpart + XCordYpart + XCordZpart;
				//double YCord = part.position[2]*Math.cos(AL.upDown)-(Math.cos(AL.leftRight)*part.position[1] -Math.sin(part.position[0]))* Math.sin(AL.upDown);
		        double XCord = x2D;
		        double YCord = y2D;
				//double OtherXCord = otherPart.position[0]*Math.cos(AL.leftRight)+otherPart.position[1]*Math.sin(AL.leftRight);//XCordXpart + XCordYpart + XCordZpart;
				//double OtherYCord = otherPart.position[2]*Math.cos(AL.upDown)-(Math.cos(AL.leftRight)*otherPart.position[1] -Math.sin(otherPart.position[0]))* Math.sin(AL.upDown);
				
		        x = otherPart.position[0];
		        y = otherPart.position[1];
		        z = otherPart.position[2];
		     // Apply pitch rotation (around the X-axis)
		        y1 = cosPitch * y - sinPitch * z;
		        z1 = sinPitch * y + cosPitch * z;

		        // Apply yaw rotation (around the Y-axis)
		        x1 = cosYaw * x + sinYaw * z1;
		        y2 = y1;
		        z2 = -sinYaw * x + cosYaw * z1;

		        // Orthographic projection (ignoring depth)
		        x2D = x1;
		        y2D = y2;
		        
				//double XCord = part.position[0]*Math.cos(AL.leftRight)+part.position[1]*Math.sin(AL.leftRight);//XCordXpart + XCordYpart + XCordZpart;
				//double YCord = part.position[2]*Math.cos(AL.upDown)-(Math.cos(AL.leftRight)*part.position[1] -Math.sin(part.position[0]))* Math.sin(AL.upDown);
		        double OtherXCord = x2D;
		        double OtherYCord = y2D;
		        
		        //lines.add(new Line2D.Double(500,500,OtherXCord,OtherYCord));
		        //lines.add(new Line2D.Double(8 +XCord+ (700000000)/Runner.hardScale, 778-YCord-(500000000)/Runner.hardScale, 8 + OtherXCord+(700000000)/Runner.hardScale, 778-OtherYCord-(500000000)/Runner.hardScale));

				lines.add(new Line2D.Double(8 + (XCord+700000000)/Runner.hardScale, 778-(YCord+500000000)/Runner.hardScale, 8 + (OtherXCord+700000000)/Runner.hardScale, 778-(OtherYCord+500000000)/Runner.hardScale));
			}
		}

	}

	public void newSquares(double[][] theBois) {
		dotDotDot.clear();
		for (int i = 0; i < theBois.length; i++) {
			for (int k = 0; k < theBois[0].length; k++) {
				if (theBois[i][k] == 0) {
					// dotDotDot.add(new Squares(k,i,scale,Color.black));
				} else if (theBois[i][k] < 0) {
					dotDotDot.add(new Squares(k, i, scale, Color.PINK));
				} else if (theBois[i][k] < 0.25) {
					dotDotDot.add(new Squares(k, i, scale, Color.BLUE));
				} else if (theBois[i][k] < 0.3) {
					dotDotDot.add(new Squares(k, i, scale, Color.RED));
				} else if (theBois[i][k] < 0.35) {
					dotDotDot.add(new Squares(k, i, scale, Color.GREEN));
				} else if (theBois[i][k] < 0.4) {
					dotDotDot.add(new Squares(k, i, scale, Color.MAGENTA));
				} else if (theBois[i][k] < 0.5) {
					dotDotDot.add(new Squares(k, i, scale, Color.ORANGE));
				} else if (theBois[i][k] < 1.5) {
					dotDotDot.add(new Squares(k, i, scale, Color.GREEN));
				} else if (theBois[i][k] < 2.0) {
					dotDotDot.add(new Squares(k, i, scale, Color.ORANGE));
				} else if (theBois[i][k] < 2.5) {
					dotDotDot.add(new Squares(k, i, scale, Color.RED));
				} else if (theBois[i][k] < 3.0) {
					dotDotDot.add(new Squares(k, i, scale, Color.PINK));
				} else if (theBois[i][k] >= 3.0) {
					dotDotDot.add(new Squares(k, i, scale, Color.MAGENTA));
				}
			}
		}
	}

	// paints the visual
	@Override
	protected void paintComponent(Graphics g) {
		this.g = g;
		super.paintComponent(g);
		g2 = (Graphics2D) g;
		g2.setColor(Color.blue);
		Rectangle2D backGround1 = new Rectangle2D.Double(0, 0, 1650, 1000);
		g2.fill(backGround1);
		g2.draw(backGround1);
		g2.setColor(Color.black);
		Rectangle2D backGround = new Rectangle2D.Double(5, 5, 1525, 775);
		g2.fill(backGround);
		g2.draw(backGround);
		//System.out.println("here");
		for (Squares sqr : dotDotDot) {
			// g2.setColor(sqr.dotMaker);
			sqr.drawOn(g2);
		}
		//System.out.println("There");
		g2.setColor(Color.YELLOW);
		for(Line2D lies:lines) {
			//System.out.println("check");
			g2.draw(lies);
		}

	}

}
