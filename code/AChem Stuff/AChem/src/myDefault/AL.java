package myDefault;

import java.awt.*;
import java.awt.event.*;

public class AL extends Frame implements WindowListener,ActionListener {
        TextField text = new TextField(20);
        Button b;
        public String rotate = "";
        public static double upDown = 0;
        public static double leftRight = 0;

        public AL(String title) {
                addWindowListener(this);
                rotate= title;
        }

        public void actionPerformed(ActionEvent e) {
        	System.out.println(rotate);
            if(rotate.equals("up")) {
            	upDown+=0.26179938779;
            } else if(rotate.equals("down")) {
            	upDown-=0.26179938779;
            } else if(rotate.equals("left")) {
            	leftRight+=0.26179938779;
            } else if(rotate.equals("right")) {
            	leftRight-=0.26179938779;
            }
        }

        public void windowClosing(WindowEvent e) {
                dispose();
                System.exit(0);
        }

        public void windowOpened(WindowEvent e) {}
        public void windowActivated(WindowEvent e) {}
        public void windowIconified(WindowEvent e) {}
        public void windowDeiconified(WindowEvent e) {}
        public void windowDeactivated(WindowEvent e) {}
        public void windowClosed(WindowEvent e) {}

}