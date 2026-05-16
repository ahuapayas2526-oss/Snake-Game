package form;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameArea extends JPanel implements ActionListener {

    private JPanel gameOverPanel;
    private JButton restartButton;
    private JButton exitButton;

    private final int pantallaJoc = 600;
    private final int tamanyCuadradet = 25;
    private final int numCuadradetsXiY = pantallaJoc / tamanyCuadradet;
    private final int totalCosSerp = pantallaJoc * pantallaJoc / tamanyCuadradet;

    int[] serpX = new int[totalCosSerp];
    int[] serpY = new int[totalCosSerp];

    int cosSerp = 3;
    char direccio = 'd';

    int pomaX;
    int pomaY;

    Random rand = new Random();
    boolean jugant = true;

    Timer jocTimer;

    private GameStats stats;
    private SnakeGame snakeGame;

    public GameArea(GameStats stats, SnakeGame snakeGame) {

        this.stats = stats;
        this.snakeGame = snakeGame; // 🔥 IMPORTANTE (te faltaba usarlo)

        setBackground(Color.black);
        setFocusable(true);
        addKeyListener(new Controls());

        crearGameOverPanel();
        iniciarJoc();

        SwingUtilities.invokeLater(() -> requestFocusInWindow());
    }

    public void iniciarJoc() {
        agregarPoma();

        jocTimer = new Timer(100, this);
        jocTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (jugant) {
            moureSerp();
            menjarPoma();
            perdrePartida();
        }
        repaint();
    }

    public void agregarPoma() {
        pomaX = rand.nextInt(numCuadradetsXiY) * tamanyCuadradet;
        pomaY = rand.nextInt(numCuadradetsXiY) * tamanyCuadradet;
    }

    public void menjarPoma() {
        if (serpX[0] == pomaX && serpY[0] == pomaY) {
            cosSerp++;
            agregarPoma();

            snakeGame.incrementarPuntuacio();
        }
    }

    public void perdrePartida () {

        if (serpX[0] < 0 || serpY[0] < 0 ||
                serpX[0] > pantallaJoc || serpY[0] > pantallaJoc) {

            jugant = false;
            jocTimer.stop();

            GuardarPartides.guardarPartida(
                    stats.getIdUsuari(),
                    stats.getPuntuacio(),
                    stats.getSegons()
            );

            stats.reset();

            gameOverPanel.setVisible(true);
        }
    }

    public void moureSerp () {
        for (int i = cosSerp; i > 0; i--) {
            serpX[i] = serpX[i - 1];
            serpY[i] = serpY[i - 1];
        }

        switch (direccio) {
            case 'd':
                serpX[0] += tamanyCuadradet;
                break;
            case 'a':
                serpX[0] -= tamanyCuadradet;
                break;
            case 's':
                serpY[0] += tamanyCuadradet;
                break;
            case 'w':
                serpY[0] -= tamanyCuadradet;
                break;
        }
    }

    @Override
    protected void paintComponent (Graphics g){
        super.paintComponent(g);

        for (int i = 0; i < numCuadradetsXiY; i++) {
            g.drawLine(0, tamanyCuadradet * i, pantallaJoc, tamanyCuadradet * i);
            g.drawLine(tamanyCuadradet * i, 0, tamanyCuadradet * i, pantallaJoc);
        }

        g.setColor(Color.RED);
        g.fillOval(pomaX, pomaY, tamanyCuadradet, tamanyCuadradet);

        for (int i = 0; i < cosSerp; i++) {
            g.setColor(Color.GREEN);
            g.fillRect(serpX[i], serpY[i], tamanyCuadradet, tamanyCuadradet);
        }
    }

    private void crearGameOverPanel () {

        gameOverPanel = new JPanel();
        gameOverPanel.setLayout(new GridLayout(2, 1));
        gameOverPanel.setBounds(200, 200, 200, 120);
        gameOverPanel.setVisible(false);

        restartButton = new JButton("Volver a jugar");
        exitButton = new JButton("Salir");

        restartButton.addActionListener(e -> reiniciarJuego());
        exitButton.addActionListener(e -> System.exit(0));

        gameOverPanel.add(restartButton);
        gameOverPanel.add(exitButton);

        add(gameOverPanel);
    }

    public class Controls extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_A:
                    direccio = 'a';
                    break;
                case KeyEvent.VK_S:
                    direccio = 's';
                    break;
                case KeyEvent.VK_W:
                    direccio = 'w';
                    break;
                case KeyEvent.VK_D:
                    direccio = 'd';
                    break;
            }

        }
    }

    public void reiniciarJuego () {

        cosSerp = 3;
        direccio = 'd';
        jugant = true;

        for (int i = 0; i < cosSerp; i++) {
            serpX[i] = 100 - i * tamanyCuadradet;
            serpY[i] = 100;
        }

        gameOverPanel.setVisible(false);
        agregarPoma();
        jocTimer.restart();

        requestFocusInWindow();
    }
}