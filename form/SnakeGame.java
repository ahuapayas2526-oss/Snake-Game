package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SnakeGame extends JPanel {

    private String nomUsuari;
    private JLabel tempsLabel;
    public JLabel puntuacioLabel;
    private JLabel usuariLabel;

    private GameStats stats;
    private Timer timer;

    public SnakeGame(String nomUsuari, int idUsuari) {

        this.nomUsuari = nomUsuari;

        this.stats = new GameStats(nomUsuari, idUsuari);

        setLayout(new BorderLayout());

        add(Header(), BorderLayout.NORTH);

        GameArea gameArea = new GameArea(stats, this);
        add(gameArea, BorderLayout.CENTER);

        iniciarTimer();
    }

    private JPanel Header() {
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1, 3));
        header.setBackground(Color.DARK_GRAY);
        header.setPreferredSize(new Dimension(650, 50));

        tempsLabel = new JLabel("0 segundos", SwingConstants.CENTER);
        puntuacioLabel = new JLabel("Manzanas: 0", SwingConstants.CENTER);
        usuariLabel = new JLabel("Jugador: " + stats.getNomUsuari(), SwingConstants.CENTER);

        tempsLabel.setForeground(Color.WHITE);
        puntuacioLabel.setForeground(Color.WHITE);
        usuariLabel.setForeground(Color.WHITE);

        header.add(tempsLabel);
        header.add(puntuacioLabel);
        header.add(usuariLabel);

        return header;
    }

    private void iniciarTimer() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stats.incrementarSegons();
                tempsLabel.setText(stats.getSegons() + " segundos");
            }
        });

        timer.start();
    }

    public void incrementarPuntuacio() {
        stats.incrementarPuntuacio();
        puntuacioLabel.setText("Manzanas: " + stats.getPuntuacio());
    }

    public GameStats getStats() {
        return stats;
    }
}