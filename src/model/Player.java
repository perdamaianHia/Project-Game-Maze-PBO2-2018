/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author icode9
 */
public class Player extends Pixel{

    public Player(int x, int y) {
        super(x, y);
        URL loc = this.getClass().getResource("Character4.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }

    public void Gerak(int x, int y) {
        int nx = this.getPosisiX() + x;
        int ny = this.getPosisiY() + y;
        this.setPosisiX(nx);
        this.setPosisiY(ny);

    }
}
