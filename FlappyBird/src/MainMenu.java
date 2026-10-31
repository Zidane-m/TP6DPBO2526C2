import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class MainMenu extends JPanel {
    private Image backgroundImage;
    private Image birdImage;
    private Runnable onStartGame;
    private Runnable onExitGame;

    public MainMenu(Runnable onStartGame, Runnable onExitGame) {
        this.onStartGame = onStartGame;
        this.onExitGame = onExitGame;

        setPreferredSize(new Dimension(360, 640));
        setLayout(new GridBagLayout());

        // Load background and bird image
        try {
            URL bgUrl = getClass().getResource("assets/background.png");
            if (bgUrl == null) bgUrl = getClass().getResource("/assets/background.png");
            if (bgUrl != null) backgroundImage = new ImageIcon(bgUrl).getImage();

            URL birdUrl = getClass().getResource("assets/bird.png");
            if (birdUrl == null) birdUrl = getClass().getResource("/assets/bird.png");
            if (birdUrl != null) birdImage = new ImageIcon(birdUrl).getImage();
        } catch (Exception ignored) {}

        // Container panel for UI elements
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Title Label
        JLabel titleLabel = new JLabel("FLAPPY BIRD");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 38));
        titleLabel.setForeground(new Color(255, 235, 59)); // Bright Gold/Yellow
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Subtitle / Course Label
        JLabel subLabel = new JLabel("TP6 - DPBO 2025/2026");
        subLabel.setFont(new Font("Arial", Font.BOLD, 14));
        subLabel.setForeground(Color.WHITE);
        subLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Bird Illustration as Component
        JLabel birdLabel = new JLabel();
        if (birdImage != null) {
            Image scaledBird = birdImage.getScaledInstance(68, 48, Image.SCALE_FAST);
            birdLabel.setIcon(new ImageIcon(scaledBird));
        }
        birdLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Buttons
        JButton btnStart = createStyledButton("Mulai Permainan", new Color(46, 204, 113), new Color(39, 174, 96));
        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainMenu.this.onStartGame != null) {
                    MainMenu.this.onStartGame.run();
                }
            }
        });

        JButton btnExit = createStyledButton("Keluar", new Color(231, 76, 60), new Color(192, 57, 43));
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (MainMenu.this.onExitGame != null) {
                    MainMenu.this.onExitGame.run();
                } else {
                    System.exit(0);
                }
            }
        });

        // Add components with spacing
        contentPanel.add(Box.createVerticalStrut(10));
        contentPanel.add(titleLabel);
        contentPanel.add(Box.createVerticalStrut(6));
        contentPanel.add(subLabel);
        contentPanel.add(Box.createVerticalStrut(25));
        contentPanel.add(birdLabel);
        contentPanel.add(Box.createVerticalStrut(35));
        contentPanel.add(btnStart);
        contentPanel.add(Box.createVerticalStrut(16));
        contentPanel.add(btnExit);

        add(contentPanel);
    }

    private JButton createStyledButton(String text, Color normalColor, Color hoverColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBackground(normalColor);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.WHITE, 2, true),
                BorderFactory.createEmptyBorder(10, 30, 10, 30)
        ));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(220, 48));

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(hoverColor);
            }
            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(normalColor);
            }
        });

        return button;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        } else {
            g.setColor(new Color(78, 192, 202));
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }
}
