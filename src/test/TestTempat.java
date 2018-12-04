
package test;

import javax.swing.JFileChooser;
import model.Tempat;



public class TestTempat {

    public static void main(String[] args) {
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
    }

}
