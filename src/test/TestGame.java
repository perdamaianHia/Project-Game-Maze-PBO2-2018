package test;

/**
 *
 * @author USER
 */
import java.awt.Color;
import model.Sel;
import model.Tempat;
import view.GameFrame;
import view.TempatPanel;

public class TestGame {

    public static void main(String[] args) {
        // buat 1 sel
        Sel sel = new Sel(1, 1, 20, 20, '@', Color.RED);
        // buat 1 tempat dan tambahkan sel ke tempat
        Tempat tempat = new Tempat();
        tempat.tambahSel(sel);
        // Set ukuran tempat
        Tempat.batasKanan = 783;
        Tempat.batasBawah = 300;
        // buat tempatPanel dan tambahkan tempat ke tempatPanel
        TempatPanel tempatPanel = new TempatPanel();
        tempatPanel.setTempat(tempat);
        // buat gameFrame dan tambahkan tempatPanel ke gameFrame
        GameFrame game = new GameFrame("My Game", tempatPanel);
    }
}
