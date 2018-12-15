package test;

import java.io.IOException;
import javax.swing.JFileChooser;
import model.Tempat;
import view.gameFrame;
import view.TempatPanel;

public class TestGame2 {

    public static void main(String[] args) throws IOException {
        JFileChooser jf = new JFileChooser();
        int returnVal = jf.showOpenDialog(null);
        Tempat tempat = new Tempat();
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            tempat.bacaKonfigurasi(jf.getSelectedFile());
            // menampilkan atribut 'isi' dari kelas Tempat
            System.out.println("Isi peta = ");
            System.out.println(tempat.getIsi());
            if (tempat.getDaftarSel() != null) {
                for (int i = 0; i < tempat.getDaftarSel().size(); i++) {
                    // menampilkan nilai posisi Baris,posisi Kolom dan nilai
                    System.out.println(
                            tempat.getDaftarSel().get(i).getBaris() + ","
                            + tempat.getDaftarSel().get(i).getKolom() + ","
                            + tempat.getDaftarSel().get(i).getNilai());

                }
            }
        }
        // Set ukuran tempat
        Tempat.batasKanan = 430;
        Tempat.batasBawah = 350;
        // buat tempatPanel dan tambahkan tempat ke tempatPanel
        TempatPanel tempatPanel = new TempatPanel();
        tempatPanel.setTempat(tempat);
        // buat gameFrame dan tambahkan tempatPanel ke gameFrame
        gameFrame game = new gameFrame("My Game", tempatPanel);
    }

}
