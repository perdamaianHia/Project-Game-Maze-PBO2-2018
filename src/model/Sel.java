package model;

import java.awt.Color;
import java.awt.Image;

public class Sel {

    private int baris = 0;
    private int kolom = 0;
    private int lebar = 25;
    private int tinggi = 25;
    private int posisiX;
    private int posisiY;
    private int jarak = 20;
    private Image image;

    private char nilai;

    private Color warna;

    public Sel() {
    }

    public Sel(int baris, int kolom, char nilai) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
    }

    public Sel(int baris, int kolom, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int baris, int kolom, int lebar, int tinggi, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int posisiX, int posisiY) {
        this.posisiX = posisiX;
        this.posisiY = posisiY;
    }

    /**
     * Fungsi mengecek sel ada di batas kiri
     *
     * @return
     */
    public boolean isBatasKiri() {
        if (kolom * lebar <= 0) {
            return true;
        } else {
            return false;
        }

    }

    /**
     * Fungsi ceking sel ada di batas kanan
     *
     * @return
     */
    public boolean isBatasKanan() {
        if (kolom * lebar + lebar < Tempat.batasKanan) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Fungsi untuk menggeser sel ke kanan
     */
    public void geserKanan() {
        if (isBatasKanan() == false) {
            kolom++;
        }
    }

    /**
     * Fungsi untuk menggeser sel ke kanan
     */
    public void geserKiri() {
        if (isBatasKiri() == false) {
            kolom--;
        }
    }

    /**
     * Fungsi untuk mengecek sel ada di batas atas
     */
    public boolean isBatasAtas() {
        if (baris * lebar <= 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Fungsi untuk mengecek sel ada di batas bawah
     */
    public boolean isBatasBawah() {
        if (baris * lebar + lebar < Tempat.batasBawah) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Fungsi untuk geser atas
     */
    /**
     * @return the baris
     */
    public int getBaris() {
        return baris;
    }

    /**
     * @param baris the baris to set
     */
    public void setBaris(int baris) {
        this.baris = baris;
    }

    /**
     * @return the kolom
     */
    public int getKolom() {
        return kolom;
    }

    /**
     * @param kolom the kolom to set
     */
    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    /**
     * @return the nilai
     */
    public char getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    /**
     * @return the warna
     */
    public Color getWarna() {
        return warna;
    }

    /**
     * @param warna the warna to set
     */
    public void setWarna(Color warna) {
        this.warna = warna;
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

    public int getPosisiX() {
        return posisiX;
    }

    public void setPosisiX(int posisiX) {
        this.posisiX = posisiX;
    }

    public int getPosisiY() {
        return posisiY;
    }

    public void setPosisiY(int posisiY) {
        this.posisiY = posisiY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public boolean PosisiKiriObjek(Sel Objek) {
        if (((this.getPosisiX() - jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiKananObjek(Sel Objek) {
        if (((this.getPosisiX() + jarak) == Objek.getPosisiX()) && (this.getPosisiY() == Objek.getPosisiY())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean PosisiAtasObjek(Sel Objek) {
        if (((this.getPosisiY() - jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }

    }

    public boolean PosisiBawahObjek(Sel Objek) {
        if (((this.getPosisiY() + jarak) == Objek.getPosisiY()) && (this.getPosisiX() == Objek.getPosisiX())) {
            return true;
        } else {
            return false;
        }
    }
}
