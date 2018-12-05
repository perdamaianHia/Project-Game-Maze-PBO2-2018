package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import model.Ball;
import model.Gate;
import model.Player;
import model.Sel;
import model.Tempat;
import model.Wall;

public class TempatPanel extends JPanel {

    private Tempat tempat;

    private ArrayList allPerintah = new ArrayList();
    public ArrayList arrWall = new ArrayList(); // penampung data dinding
    public ArrayList arrBall = new ArrayList(); // penampung data bola
    public ArrayList arrGate = new ArrayList(); // penampung data gol
    private ArrayList arrTempat = new ArrayList(); // penampung data peta
    public Player maze;
    private int posisiX;
    private int posisiY;
    private Image image;

    private int tinggi = 0; // tinggi tempat Game
    private int lebar = 0;  // lebar tempat Game
    private int jarak = 20;

    public TempatPanel() {
    }

    public TempatPanel(Tempat tempat) {
        this.tempat = tempat;
    }

    public void PerintahGerak(String input) {
        String in[] = input.split(" ");
        if (in.length > 2) {
            JOptionPane.showMessageDialog(null, "Jumlah Kata Dari 2");
        } else if (in.length == 2) {
            if (in[0].matches("{udriz}")) {
                allPerintah.add(input);
                if (in[0].equalsIgnoreCase("u")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekNabrakTembok(maze, "u")) {
                            return;
                        } else if (cekBolaPemainTembok("u")) {
                            return;
                        } else {
                            maze.Gerak(0, -jarak);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("d")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekNabrakTembok(maze, "d")) {
                            return;
                        } else if (cekBolaPemainTembok("d")) {
                            return;
                        } else {
                            maze.Gerak(0, jarak);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("r")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekNabrakTembok(maze, "r")) {
                            return;
                        } else if (cekBolaPemainTembok("r")) {
                            return;
                        } else {
                            maze.Gerak(jarak, 0);
                            repaint();
                        }
                    }
                } else if (in[0].equalsIgnoreCase("l")) {
                    for (int i = 0; i < Integer.parseInt(String.valueOf(in[i])); i++) {
                        if (cekObjekNabrakTembok(maze, "l")) {
                            return;
                        } else if (cekBolaPemainTembok("l")) {
                            return;
                        } else {
                            maze.Gerak(-jarak, 0);
                            repaint();
                        }

                    }

                } else if (in[0].equalsIgnoreCase("z")) {

                }
            } else {
                JOptionPane.showMessageDialog(null, "Kata Tidak Dikenal");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Jumlah Kata Hanya Satu");
        }
    }

    private boolean cekObjekNabrakTembok(Sel pemain, String input) {
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

    private boolean cekBolaNabrakBola(Sel objek, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball bol = (Ball) arrBall.get(i);
                if (objek.PosisiKiriObjek(bol)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball bol = (Ball) arrBall.get(i);
                if (objek.PosisiKananObjek(bol)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball bol = (Ball) arrBall.get(i);
                if (objek.PosisiAtasObjek(bol)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball bol = (Ball) arrBall.get(i);
                if (objek.PosisiBawahObjek(bol)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;
    }

    private boolean cekBolaPemainTembok(String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball ball = (Ball) arrBall.get(i);
                if (maze.PosisiKiriObjek(ball)) {
                    if (cekBolaNabrakBola(ball, "l")) {
                        bantu = true;
                        break;
                    } else if (cekObjekNabrakTembok(ball, "l")) {
                        bantu = true;
                        break;
                    } else {
                        ball.Gerak(-jarak, 0);
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball ball = (Ball) arrBall.get(i);
                if (maze.PosisiKananObjek(ball)) {
                    if (cekBolaNabrakBola(ball, "r")) {
                        bantu = true;
                        break;
                    } else if (cekObjekNabrakTembok(ball, "r")) {
                        bantu = true;
                        break;
                    } else {
                        ball.Gerak(jarak, 0);
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball ball = (Ball) arrBall.get(i);
                if (maze.PosisiAtasObjek(ball)) {
                    if (cekBolaNabrakBola(ball, "u")) {
                        bantu = true;
                        break;
                    } else if (cekObjekNabrakTembok(ball, "u")) {
                        bantu = true;
                        break;
                    } else {
                        ball.Gerak(0, -jarak);
                        isCompleted();
                    }
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < arrBall.size(); i++) {
                Ball ball = (Ball) arrBall.get(i);
                if (maze.PosisiBawahObjek(ball)) {
                    if (cekBolaNabrakBola(ball, "d")) {
                        bantu = true;
                        break;
                    } else if (cekObjekNabrakTembok(ball, "d")) {
                        bantu = true;
                        break;
                    } else {
                        ball.Gerak(0, jarak);
                        isCompleted();
                    }
                }
            }
        }
        return bantu;
    }

    public void isCompleted() {
        int jumBola = arrBall.size();
        int goal = 0;
        for (int i = 0; i < arrBall.size(); i++) {
            Ball bol = (Ball) arrBall.get(i);
            for (int j = 0; j < arrGate.size(); j++) {
                Gate gaw = (Gate) arrGate.get(j);
                if (bol.getPosisiX() == gaw.getPosisiX() && bol.getPosisiX() == gaw.getPosisiY()) {
                    goal += 1;

                }
            }
        }
        if (goal == jumBola) {
            JOptionPane.showMessageDialog(null, "Selamat Anda Berhasil Menyelesaikan Game Ini.");
        }
    }

    /**
     * Fungsi untuk menggambar di panel
     *
     * @param g
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        arrTempat.addAll(arrWall);
        arrTempat.addAll(arrGate);
        arrTempat.addAll(arrBall);
        arrTempat.add(maze);
        for (int i = 0; i < arrTempat.size(); i++) {
            if (arrTempat.get(i) != null) {
                Tempat item = (Tempat) arrTempat.get(i);
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);
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

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
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

}
