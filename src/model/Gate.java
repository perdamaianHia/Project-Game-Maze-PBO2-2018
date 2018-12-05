package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Gate extends Sel {

    boolean getPosisiX;
    boolean getPosisiY;

    public Gate(int x, int y) {
        super(x, y);
        URL loc = this.getClass().getResource("Create_Blue.png");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
