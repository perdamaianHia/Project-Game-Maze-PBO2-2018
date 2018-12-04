
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Sel;

public class GameFrame extends JFrame {

    private TempatPanel tempatPanel;

    private JLabel perintahlabel;
    private JTextField perintahText;
    private JButton pindahKananButton;
    private JButton pindahKiriButton;
    private JButton pindahAtasButton;
    private JButton pindahBawahButton;
    private JButton serongAtasKanan;
    private JButton serongAtasKiri;
    private JButton serongBawahKanan;
    private JButton serongBawahKiri;
    private JButton tambahButton;
    private JButton hapusButton;

    private JMenuBar menuBar;
    private JMenu gameMenu;
    private JMenuItem exitMenuItem;
    private JMenuItem bacaKonfigurasiMenuItem;

    public GameFrame(String title) {
        this.setTitle(title);
        this.init();
    }

    public GameFrame(String title, TempatPanel tempatPanel) {
        setTitle(title);
        this.tempatPanel = tempatPanel;
        this.init();
    }

    public void init() {
        // set ukuran dan layout
        this.setSize(800, 500);
        this.setLayout(new BorderLayout());

        // set menu Bar
        menuBar = new JMenuBar();
        gameMenu = new JMenu("Game");
        exitMenuItem = new JMenuItem("Keluar");
        bacaKonfigurasiMenuItem = new JMenuItem("Baca");
        gameMenu.add(bacaKonfigurasiMenuItem);
        gameMenu.add(exitMenuItem);
        menuBar.add(gameMenu);
        setJMenuBar(menuBar);

        //action perform for exitMenuItem
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        }
        );

        // panel selatan
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        this.perintahlabel = new JLabel("Perintah");
        southPanel.add(perintahlabel);

        this.perintahText = new JTextField(20);
        southPanel.add(perintahText);

        this.pindahKananButton = new JButton("Kanan");
        southPanel.add(pindahKananButton);

        pindahKananButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKanan();
            }
        });

        this.pindahKiriButton = new JButton("Kiri");
        southPanel.add(pindahKiriButton);

        pindahKiriButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahKiri();
            }
        });

        this.pindahAtasButton = new JButton("Atas");
        southPanel.add(pindahAtasButton);

        pindahAtasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahAtas();
            }
        });

        southPanel.setPreferredSize(new Dimension(700, 100));

        this.pindahBawahButton = new JButton("Bawah");
        southPanel.add(pindahBawahButton);

        pindahBawahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pindahBawah();
            }
        });

        this.serongAtasKanan = new JButton("Serong Atas Kanan");
        southPanel.add(serongAtasKanan);

        serongAtasKanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongAtasKanan();
            }
        });

        this.serongAtasKiri = new JButton("Serong Atas Kiri");
        southPanel.add(serongAtasKiri);

        serongAtasKiri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongAtasKiri();
            }
        });

        this.serongBawahKanan = new JButton("Serong Bawah Kanan");
        southPanel.add(serongBawahKanan);

        serongBawahKanan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongBawahKanan();
            }
        });

        this.serongBawahKiri = new JButton("Serong Bawah Kiri");
        southPanel.add(serongBawahKiri);

        serongBawahKiri.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                serongBawahKiri();
            }
        });

        this.tambahButton = new JButton("tambahBola");
        southPanel.add(tambahButton);
        tambahButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tambahBola();
            }
        });

        this.hapusButton = new JButton("hapusBola");
        southPanel.add(hapusButton);

        hapusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hapusBola();
            }
        });

        // set contentPane
        Container cp = this.getContentPane();
        if (tempatPanel != null) {
            cp.add(getTempatPanel(), BorderLayout.CENTER);
        }
        cp.add(southPanel, BorderLayout.SOUTH);

        // set visible= true
        this.setVisible(true);
    }

    /**
     * Fungsi untuk tambahBola
     */
    public void tambahBola() {
        tempatPanel.getTempat().tambahSel(new Sel(0, 0, 25, 25, '#', Color.BLUE));
        repaint();
    }

    /**
     * Fungsi hapus bola
     */
    public void hapusBola() {

        tempatPanel.getTempat().hapusSel();
        repaint();
    }

    /**
     * Fungsi untuk memindahkan sel dan menggambar ulang
     */
    public void pindahKanan() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserKanan();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahKiri() {
        // posisiX seluruh sel ditambah 20
        // sehingga sel akan terlihat bergerak ke kanan
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserKiri();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();
    }

    public void pindahAtas() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserAtas();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();

    }

    public void pindahBawah() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).geserBawah();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();

    }

    public void serongAtasKanan() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).serongAtasKanan();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();

    }

    public void serongAtasKiri() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).serongAtasKiri();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();

    }

    public void serongBawahKanan() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).serongBawahKanan();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();

    }

    public void serongBawahKiri() {
        for (int i = 0; i < getTempatPanel().getTempat().getDaftarSel().size(); i++) {
            // set posisiX yang baru
            getTempatPanel().getTempat().getDaftarSel().get(i).serongBawahKiri();
        }
        // gambar ulang tempat Panel
        getTempatPanel().repaint();

    }

    /**
     * @return the tempatPanel
     */
    public TempatPanel getTempatPanel() {
        return tempatPanel;
    }

    /**
     * @param tempatPanel the tempatPanel to set
     */
    public void setTempatPanel(TempatPanel tempatPanel) {
        this.tempatPanel = tempatPanel;
    }
}
