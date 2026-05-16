package form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MenuUser {

    private JPanel panelUserMenu;
    private JTextField usuariTextField;
    private JButton jugarButton;

    public MenuUser() {
        panelUserMenu = new JPanel();
        panelUserMenu.setLayout(new BoxLayout(panelUserMenu, BoxLayout.Y_AXIS));
        panelUserMenu.setBackground(new Color(245, 245, 245)); // gris claro elegante
        panelUserMenu.setBorder(new EmptyBorder(50, 50, 50, 50));
        panelUserMenu.setPreferredSize(new Dimension(600, 650));

        // Título
        JLabel title = new JLabel("Snake Game");
        title.setFont(new Font("Segoe UI", Font.BOLD, 30));
        title.setForeground(new Color(40, 40, 40));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Texto
        JLabel subtitle = new JLabel("Introdueix el teu nom d'usuari");
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        subtitle.setForeground(new Color(80, 80, 80));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        usuariTextField = new JTextField();
        usuariTextField.setMaximumSize(new Dimension(300, 40));
        usuariTextField.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        usuariTextField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(200, 200, 200)),
                BorderFactory.createEmptyBorder(8, 10, 8, 10)
        ));

        jugarButton = new JButton("Jugar");
        jugarButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jugarButton.setBackground(new Color(60, 130, 200));
        jugarButton.setForeground(Color.WHITE);
        jugarButton.setFont(new Font("Segoe UI", Font.BOLD, 15));
        jugarButton.setFocusPainted(false);
        jugarButton.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 25));

        jugarButton.addActionListener(e -> {
            String usuari = usuariTextField.getText().trim();

            if (usuari.isEmpty()) {
                JOptionPane.showMessageDialog(panelUserMenu,
                        "No pots deixar el camp introduir usuari buit");
            } else {
                int idUsuari = GuardarPartides.obtenerOCrearUsuario(usuari);

                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(panelUserMenu);
                frame.setContentPane(new SnakeGame(usuari, idUsuari));
                frame.revalidate();
                frame.repaint();
            }
        });


        panelUserMenu.add(title);
        panelUserMenu.add(Box.createRigidArea(new Dimension(0, 25)));
        panelUserMenu.add(subtitle);
        panelUserMenu.add(Box.createRigidArea(new Dimension(0, 35)));
        panelUserMenu.add(usuariTextField);
        panelUserMenu.add(Box.createRigidArea(new Dimension(0, 30)));
        panelUserMenu.add(jugarButton);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("SnakeGame");
        Toolkit pantalla =Toolkit.getDefaultToolkit();
        Image icono = pantalla.getImage("src/imatges/LogoSnaKeGame.png");
        frame.setIconImage(icono);

        frame.setContentPane(new MenuUser().panelUserMenu);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}