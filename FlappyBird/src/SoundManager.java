import javax.sound.sampled.*;
import java.net.URL;

public class SoundManager {
    private Clip bgmClip;
    private Clip jumpClip;
    private Clip pointClip;
    private Clip deadClip;

    public SoundManager() {
        bgmClip = loadClip("assets/sounds/bgm.wav");
        jumpClip = loadClip("assets/sounds/jump.wav");
        pointClip = loadClip("assets/sounds/point.wav");
        deadClip = loadClip("assets/sounds/dead.wav");
    }

    private Clip loadClip(String resourcePath) {
        try {
            URL url = getClass().getResource(resourcePath);
            if (url == null) {
                url = getClass().getResource("/" + resourcePath);
            }
            if (url != null) {
                AudioInputStream ais = AudioSystem.getAudioInputStream(url);
                Clip clip = AudioSystem.getClip();
                clip.open(ais);
                return clip;
            }
        } catch (Exception e) {
            System.err.println("Gagal memuat audio: " + resourcePath + " (" + e.getMessage() + ")");
        }
        return null;
    }

    public void playBGM() {
        if (bgmClip != null) {
            try {
                bgmClip.stop();
                bgmClip.setFramePosition(0);
                bgmClip.loop(Clip.LOOP_CONTINUOUSLY);
            } catch (Exception ignored) {}
        }
    }

    public void stopBGM() {
        if (bgmClip != null) {
            try {
                bgmClip.stop();
            } catch (Exception ignored) {}
        }
    }

    public void playJump() {
        playEffect(jumpClip);
    }

    public void playScore() {
        playEffect(pointClip);
    }

    public void playGameOver() {
        playEffect(deadClip);
    }

    private void playEffect(Clip clip) {
        if (clip != null) {
            try {
                if (clip.isRunning()) {
                    clip.stop();
                }
                clip.setFramePosition(0);
                clip.start();
            } catch (Exception ignored) {}
        }
    }
}
