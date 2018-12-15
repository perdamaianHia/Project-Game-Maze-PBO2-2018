package view;

import model.Sel;
import model.Tempat;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class TempatPanel extends JPanel{
     private Tempat tempat;

    public TempatPanel() {
    }

    public TempatPanel(Tempat tempat) {
        this.tempat = tempat;
    }

    /**
     * Fungsi untuk menggambar di panel
     *
     * @param g
     */
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(0, 0, Tempat.batasKanan, Tempat.batasBawah);
        // proses gambar daftar sel
        // asumsi sel berbentuk lingkaran
        // gambar lingkaran dengan fillOval dengan diameter 20
        if (tempat != null) {
            for (int i = 0; i < tempat.getDaftarSel().size(); i++) {
                Sel sel = tempat.getDaftarSel().get(i);
                g.setColor(sel.getWarna());
                g.fillOval(sel.getKolom() * sel.getLebar(),
                        sel.getBaris() * sel.getTinggi(),
                        sel.getLebar(),
                        sel.getTinggi());
            }
        }
    }

    /**
     * @return the tempat
     */
    public Tempat getTempat() {
        return tempat;
    }

    /**
     * @param tempat the tempat to set
     */
    public void setTempat(Tempat tempat) {
        this.tempat = tempat;
    }
}