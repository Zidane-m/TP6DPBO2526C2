import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("FlappyBird");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setResizable(false);

                CardLayout cardLayout = new CardLayout();
                JPanel mainContainer = new JPanel(cardLayout);

                Logic logika = new Logic();
                View tampilan = new View(logika);
                logika.setView(tampilan);

                // Buat Main Menu (Spesifikasi Wajib 5)
                MainMenu mainMenu = new MainMenu(
                        new Runnable() {
                            @Override
                            public void run() {
                                // Aksi saat tombol "Mulai Permainan" diklik
                                cardLayout.show(mainContainer, "GAME");
                                tampilan.requestFocusInWindow();
                                logika.startGame();
                            }
                        },
                        new Runnable() {
                            @Override
                            public void run() {
                                // Aksi saat tombol "Keluar" diklik
                                System.exit(0);
                            }
                        }
                );

                mainContainer.add(mainMenu, "MENU");
                mainContainer.add(tampilan, "GAME");

                frame.add(mainContainer);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
