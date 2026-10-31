import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class View extends JPanel {
    int width = 360;
    int height = 640;

    private Logic logic;
    private JLabel scoreLabel;

    public View(Logic logic) {
        this.logic = logic;
        setPreferredSize(new Dimension(width, height));
        setLayout(new BorderLayout());
        setBackground(Color.cyan);

        // Inisialisasi JLabel untuk penampil skor (Spesifikasi Wajib 3)
        scoreLabel = new JLabel("Score: 0", SwingConstants.CENTER);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 28));
        scoreLabel.setForeground(Color.WHITE);
        scoreLabel.setOpaque(false);
        scoreLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        add(scoreLabel, BorderLayout.NORTH);

        // Tambahkan fokus dan Key Listener untuk menerima input
        setFocusable(true);
        addKeyListener(logic);
    }

    public void updateScore(int score) {
        scoreLabel.setText("Score: " + score);
    }

    public JLabel getScoreLabel() {
        return scoreLabel;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        // 1. Gambar background image
        Image bgImage = logic.getBackgroundImage();
        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, width, height, null);
        }

        // 2. Gambar pipa
        ArrayList<Pipe> pipes = logic.getPipes();
        if (pipes != null) {
            for (int i = 0; i < pipes.size(); i++) {
                Pipe pipe = pipes.get(i);
                g.drawImage(pipe.getImage(), pipe.getPosX(), pipe.getPosY(),
                        pipe.getWidth(), pipe.getHeight(), null);
            }
        }

        // 3. Gambar player burung
        Player player = logic.getPlayer();
        if (player != null && player.getImage() != null) {
            g.drawImage(player.getImage(), player.getPosX(), player.getPosY(),
                    player.getWidth(), player.getHeight(), null);
        }

        // 4. Gambar Game Over Overlay jika permainan selesai (Spesifikasi Wajib 1 & 2)
        if (logic.isGameOver()) {
            // Semi-transparent overlay gelap
            g.setColor(new Color(0, 0, 0, 160));
            g.fillRect(0, 0, width, height);

            // Teks "GAME OVER"
            g.setFont(new Font("Arial", Font.BOLD, 36));
            g.setColor(new Color(231, 76, 60)); // Coral Red
            FontMetrics fm = g.getFontMetrics();
            String goText = "GAME OVER";
            int goX = (width - fm.stringWidth(goText)) / 2;
            g.drawString(goText, goX, 260);

            // Teks Skor Akhir
            g.setFont(new Font("Arial", Font.BOLD, 22));
            g.setColor(Color.WHITE);
            FontMetrics fmScore = g.getFontMetrics();
            String finalScoreText = "Skor Akhir: " + logic.getScore();
            int scoreX = (width - fmScore.stringWidth(finalScoreText)) / 2;
            g.drawString(finalScoreText, scoreX, 305);

            // Teks Petunjuk Restart
            g.setFont(new Font("Arial", Font.BOLD, 17));
            g.setColor(new Color(241, 196, 15)); // Bright Yellow
            FontMetrics fmRestart = g.getFontMetrics();
            String restartText = "Tekan 'R' untuk Main Lagi";
            int restartX = (width - fmRestart.stringWidth(restartText)) / 2;
            g.drawString(restartText, restartX, 355);
        }
    }
}
