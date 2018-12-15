package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Maps extends JPanel {
    private ArrayList arrWall = new ArrayList(); 
//    private ArrayList arrBall = new ArrayList();
    private ArrayList arrGate = new ArrayList();
    private ArrayList arrMaps = new ArrayList();
    private Player maze;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 20;

    private File Alamatpeta;
    private ArrayList Allperintah = new ArrayList();

    public Maps(File file) {
        setPeta(file);
    }

    public void setPeta(File file) {

        try {
            if (file != null) {

                FileInputStream input = new FileInputStream(file);
                Alamatpeta = file;
                int posisiX = 0;
                int posisiY = 0;
                Wall wall;
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
//                    } else if (item == 'x') {
//                        b = new Ball(posisiX, posisiY);
//                        arrBall.add(b);
//                        posisiX += jarak;
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
            Logger.getLogger(Maps.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        arrMaps.addAll(arrWall);
        arrMaps.addAll(arrGate);
//        arrMaps.addAll(arrBall);
        arrMaps.add(maze);
        for (int i = 0; i < arrMaps.size(); i++) {
            if (arrMaps.get(i) != null) {
                Pixel item = (Pixel) arrMaps.get(i);
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);
            }
        }
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
    }

    public void PerintahGerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah kata dari 2");
        } else if (in.length == 2) {
            if (in[0].matches("[udrlz]")) {
                Allperintah.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "u")) {
                            return;
                        } else {
                            maze.Gerak(0, -jarak);
                            repaint();
                        }

                    }

                } else if (in[0].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "d")) {
                            return;
                        } else {
                            maze.Gerak(0, jarak);
                            repaint();
                        }

                    }
                } else if (in[0].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "r")) {
                            return;
                        } else {
                            maze.Gerak(jarak, 0);
                            repaint();
                        }

                    }

                } else if (in[0].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                        if (cekObjekNabrakTembok(maze, "l")) {
                            return;
                        } else {
                            maze.Gerak(-jarak, 0);
                            repaint();
                        }

                    }
                } else if (in[0].equalsIgnoreCase("z")) {

                }
            } else {
                JOptionPane.showMessageDialog(null, "Kata tidak Dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah kata hanya Satu");
        }
    }

    private boolean cekObjekNabrakTembok(Pixel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < arrWall.size(); i++) {
                Wall wall = (Wall) arrWall.get(i);
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < arrWall.size(); i++) {
                Wall wall = (Wall) arrWall.get(i);
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;

                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < arrWall.size(); i++) {
                Wall wall = (Wall) arrWall.get(i);
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < arrWall.size(); i++) {
                Wall wall = (Wall) arrWall.get(i);
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }

//    private boolean cekBolaNabrakBola(Pixel objek, String input) {
//        boolean bantu = false;
//        if (input.equalsIgnoreCase("l")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol = (Ball) arrBall.get(i);
//                if (objek.PosisiKiriObjek(bol)) {
//                    bantu = true;
//                    break;
//                }
//            }
//        } else if (input.equalsIgnoreCase("r")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol = (Ball) arrBall.get(i);
//                if (objek.PosisiKananObjek(bol)) {
//                    bantu = true;
//                    break;
//                }
//            }
//
//        } else if (input.equalsIgnoreCase("u")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol = (Ball) arrBall.get(i);
//                if (objek.PosisiAtasObjek(bol)) {
//                    bantu = true;
//                    break;
//                }
//            }
//
//        } else if (input.equalsIgnoreCase("d")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol = (Ball) arrBall.get(i);
//                if (objek.PosisiBawahObjek(bol)) {
//                    bantu = true;
//                    break;
//                }
//            }
//        }
//        return bantu;
//    }
//
//    private boolean cekBolaPemainTembok(String input) {
//        boolean bantu = false;
//        if (input.equalsIgnoreCase("l")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol1 = (Ball) arrBall.get(i);
//                if (soko.PosisiKiriObjek(bol1)) {
//                    if (cekBolaNabrakBola(bol1, "l")) {
//                        bantu = true;
//                        break;
//                    } else if (cekObjekNabrakTembok(bol1, "l")) {
//                        bantu = true;
//                        break;
//                    } else {
//                        bol1.Gerak(-jarak, 0);
//                        isCompleted();
//                    }
//                }
//            }
//        } else if (input.equalsIgnoreCase("r")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol1 = (Ball) arrBall.get(i);
//                if (soko.PosisiKananObjek(bol1)) {
//                    if (cekBolaNabrakBola(bol1, "r")) {
//                        bantu = true;
//                        break;
//                    } else if (cekObjekNabrakTembok(bol1, "r")) {
//                        bantu = true;
//                        break;
//                    } else {
//                        bol1.Gerak(jarak, 0);
//                        isCompleted();
//                    }
//                }
//            }
//        } else if (input.equalsIgnoreCase("u")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol1 = (Ball) arrBall.get(i);
//                if (soko.PosisiAtasObjek(bol1)) {
//                    if (cekBolaNabrakBola(bol1, "u")) {
//                        bantu = true;
//                        break;
//                    } else if (cekObjekNabrakTembok(bol1, "u")) {
//                        bantu = true;
//                        break;
//                    } else {
//                        bol1.Gerak(0, -jarak);;
//                        isCompleted();
//                    }
//                }
//            }
//        } else if (input.equalsIgnoreCase("d")) {
//            for (int i = 0; i < arrBall.size(); i++) {
//                Ball bol1 = (Ball) arrBall.get(i);
//                if (soko.PosisiBawahObjek(bol1)) {
//                    if (cekBolaNabrakBola(bol1, "d")) {
//                        bantu = true;
//                        break;
//                    } else if (cekObjekNabrakTembok(bol1, "d")) {
//                        bantu = true;
//                        break;
//                    } else {
//
//                        bol1.Gerak(0, jarak);;
//                        isCompleted();
//                    }
//                }
//            }
//        }
//        return bantu;
//    }

//    public void isCompleted() {
//        int jumBola = arrBall.size();
//        int goal = 0;
//        for (int i = 0; i < arrBall.size(); i++) {
//            Ball bol = (Ball) arrBall.get(i);
//            for (int j = 0; j < arrGate.size(); j++) {
//                Gate gaw = (Gate) arrGate.get(j);
//                if (bol.getPosisiX() == gaw.getPosisiX() && bol.getPosisiY() == gaw.getPosisiY()) {//cek posisi bola sama dengan bola.
//                    goal += 1;
//                }
//            }
//        }
//        if (goal == jumBola) {
//            JOptionPane.showMessageDialog(null, "Selamat anda berhasil menyelesaikan game ini.");
//        }
//    }

    public void restartLevel() {
        Allperintah.clear();
        arrGate.clear();
//        arrBall.clear();
        arrWall.clear();
        arrMaps.clear();
        setPeta(Alamatpeta);
        repaint();
    }

    public String getTeksPerintah() {
        String bantu = "";
        for (int i = 0; i < Allperintah.size(); i++) {
            bantu = bantu + Allperintah.get(i) + " ";
        }
        return bantu;
    }

}
