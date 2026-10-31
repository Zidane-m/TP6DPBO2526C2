import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;

public class Logic implements ActionListener, KeyListener {
    int frameWidth = 360;
    int frameHeight = 640;

    int playerStartPosX = frameWidth / 2;
    int playerStartPosY = frameHeight / 2;
    int playerWidth = 34;
    int playerHeight = 24;

    int pipeStartPosX = frameWidth;
    int pipeStartPosY = 0;
    int pipeWidth = 64;
    int pipeHeight = 512;

    Timer gameLoop;
    Timer pipesCooldown;
    int gravity = 1;

    int pipeVelocityX = -2;

    View view;
    Image birdImage;
    Image lowerPipeImage;
    Image upperPipeImage;
    Image backgroundImage;

    Player player;
    ArrayList<Pipe> pipes;
    SoundManager soundManager;

    // Status Game (Spesifikasi Wajib 1, 2, 4)
    private boolean gameOver = false;
    private boolean gameStarted = false;
    private int score = 0;

    public Logic() {
        soundManager = new SoundManager();

        birdImage = loadImage("assets/bird.png");
        lowerPipeImage = loadImage("assets/lowerPipe.png");
        upperPipeImage = loadImage("assets/upperPipe.png");
        backgroundImage = loadImage("assets/background.png");

        player = new Player(playerStartPosX, playerStartPosY, playerWidth, playerHeight, birdImage);
        pipes = new ArrayList<Pipe>();

        pipesCooldown = new Timer(1500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (gameStarted && !gameOver) {
                    placePipes();
                }
            }
        });

        gameLoop = new Timer(1000 / 60, this);
    }

    private Image loadImage(String path) {
        try {
            URL url = getClass().getResource(path);
            if (url == null) {
                url = getClass().getResource("/" + path);
            }
            if (url != null) {
                return new ImageIcon(url).getImage();
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat gambar: " + path);
        }
        return null;
    }

    public void setView(View view) {
        this.view = view;
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Pipe> getPipes() {
        return pipes;
    }

    public Image getBackgroundImage() {
        return backgroundImage;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public int getScore() {
        return score;
    }

    public SoundManager getSoundManager() {
        return soundManager;
    }

    // Memulai permainan saat masuk dari Main Menu (Spesifikasi 5)
    public void startGame() {
        restartGame();
    }

    // Restart permainan (Spesifikasi Wajib 2)
    public void restartGame() {
        player.reset(playerStartPosX, playerStartPosY);
        pipes.clear();
        score = 0;
        gameOver = false;
        gameStarted = true;

        if (view != null) {
            view.updateScore(score);
            view.repaint();
        }

        if (soundManager != null) {
            soundManager.playBGM();
        }

        pipesCooldown.restart();
        gameLoop.restart();
    }

    // Trigger Game Over (Spesifikasi Wajib 1)
    public void triggerGameOver() {
        gameOver = true;
        gameLoop.stop();
        pipesCooldown.stop();

        if (soundManager != null) {
            soundManager.stopBGM();
            soundManager.playGameOver();
        }

        if (view != null) {
            view.repaint();
        }
    }

    // Deteksi Tabrakan AABB (Spesifikasi Wajib 1)
    public boolean checkCollision(Player p, Pipe pipe) {
        // Toleransi margin 2px agar gameplay adil dan nyaman
        int pX = p.getPosX() + 2;
        int pY = p.getPosY() + 2;
        int pW = p.getWidth() - 4;
        int pH = p.getHeight() - 4;

        return pX < pipe.getPosX() + pipe.getWidth() &&
               pX + pW > pipe.getPosX() &&
               pY < pipe.getPosY() + pipe.getHeight() &&
               pY + pH > pipe.getPosY();
    }

    public void placePipes() {
        int randomPosY = (int) (pipeStartPosY - (pipeHeight / 4) - Math.random() * (pipeHeight / 2));
        int openingSpace = frameHeight / 4;

        Pipe upperPipe = new Pipe(pipeStartPosX, randomPosY, pipeWidth, pipeHeight, upperPipeImage);
        pipes.add(upperPipe);

        Pipe lowerPipe = new Pipe(pipeStartPosX, randomPosY + openingSpace + pipeHeight, pipeWidth, pipeHeight, lowerPipeImage);
        pipes.add(lowerPipe);
    }

    public void move() {
        if (!gameStarted || gameOver) {
            return;
        }

        // Pergerakan vertikal player dipengaruhi gravitasi
        player.setVelocityY(player.getVelocityY() + gravity);
        player.setPosY(player.getPosY() + player.getVelocityY());
        player.setPosY(Math.max(player.getPosY(), 0));

        // 1. Cek batas bawah layar (Spesifikasi Wajib 1)
        if (player.getPosY() + player.getHeight() >= frameHeight) {
            player.setPosY(frameHeight - player.getHeight()); // Tahan posisi agar burung tetap terlihat di dasar
            triggerGameOver();
            return;
        }

        // 2. Gerakkan pipa dan cek tabrakan / skor (Spesifikasi Wajib 1 & 4)
        for (int i = 0; i < pipes.size(); i++) {
            Pipe pipe = pipes.get(i);
            pipe.setPosX(pipe.getPosX() + pipeVelocityX);

            // Tabrakan dengan pipa -> Game Over
            if (checkCollision(player, pipe)) {
                triggerGameOver();
                return;
            }

            // Skor bertambah +1 saat burung melewati pipa (Spesifikasi 4)
            if (!pipe.isPassed() && player.getPosX() > pipe.getPosX() + pipe.getWidth()) {
                pipe.setPassed(true);
                // Hanya tambah skor 1x per pasangan pipa (melalui upperPipe)
                if (pipe.getImage() == upperPipeImage) {
                    score++;
                    if (view != null) {
                        view.updateScore(score);
                    }
                    if (soundManager != null) {
                        soundManager.playScore();
                    }
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
        if (view != null) {
            view.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        // Kontrol melompat saat bermain
        if (gameStarted && !gameOver) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                player.setVelocityY(-9);
                if (soundManager != null) {
                    soundManager.playJump();
                }
            }
        } else if (gameOver) {
            // Kontrol restart saat Game Over dengan tombol 'R' (Spesifikasi Wajib 2)
            if (e.getKeyCode() == KeyEvent.VK_R) {
                restartGame();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}
}
