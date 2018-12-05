package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.TempatPanel;

public class Tempat extends TempatPanel {

    private int tinggi = 0; // tinggi tempat Game
    private int lebar = 0;  // lebar tempat Game
    private int jarak = 20;
    private ArrayList<Sel> daftarSel; // daftar sel

    private String isi; // isi file konfigurasi
    private File AlamatKonfigurasi;

    public static int batasKanan;

    public static int batasBawah;

    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }

    /**
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi' dan juga di atribut daftarSel
     *
     * @param file
     */
    public void bacaKonfigurasi(File file) {
        try {
            if (file != null) {

                FileInputStream input = new FileInputStream(file);
                AlamatKonfigurasi = file;
                int posisiX = 0;
                int posisiY = 0;
                Wall wall;
                Ball b;
                Gate a;
                int data;
                while ((data = input.read()) != -1) {
                    char item = (char) data;
                    if (item == '\n') {
                        posisiY += jarak;
                        if (this.lebar < posisiX) {
                            this.lebar = posisiX;
                        }
                        posisiX = 0;
                    } else if (item == '#') {
                        wall = new Wall(posisiX, posisiY);
                        arrWall.add(wall);
                        posisiX += jarak;
                    } else if (item == 'x') {
                        b = new Ball(posisiX, posisiY);
                        arrBall.add(b);
                        posisiX += jarak;
                    } else if (item == 'o') {
                        a = new Gate(posisiX, posisiY);
                        arrGate.add(a);
                        posisiX += jarak;
                    } else if (item == '@') {
                        maze = new Player(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '.') {
                        posisiX += jarak;
                    }
                    tinggi = posisiY;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fungsi penambah daftar sel.
     *
     * @param sel
     */
    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
    }

    /**
     * Fungsi hapus sel. Sel yang paling akhir diremove dari daftar sel.
     */
    public void hapusSel() {
        if (!daftarSel.isEmpty()) {
            daftarSel.remove(0);
        }
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public String getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(String isi) {
        this.isi = isi;
    }
}
