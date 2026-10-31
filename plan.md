# Rencana Tugas Praktikum 6 (TP6) DPBO 2526 C2
**Java Swing GUI: Game Development - Flappy Bird (Modul 6 & Modul 7)**

---

## 1. Ringkasan & Analisis Penugasan

Rencana pengerjaan ini disusun berdasarkan panduan dari **Modul 6 (Intro to Gamedev)** dan **Modul 7 (Gamedev Part 2)**. 

### Prinsip Utama Pengerjaan:
1. **Fase Baseline (Tahap Pertama):** Mengikuti seluruh kode program asli dari **Modul 6** dan **Modul 7** secara presisi **tanpa modifikasi apapun terlebih dahulu**, guna memastikan pondasi dasar Flappy Bird (gerakan burung, gravitasi, game loop, kemunculan dan pergerakan pipa) berjalan stabil 100%.
2. **Fase Pengembangan TP6 (Tahap Kedua):** Mengimplementasikan seluruh spesifikasi wajib tugas praktikum, fitur bonus audio (+20 poin), serta polesan kreatif.
3. **Fase Dokumentasi & Finalisasi:** Melakukan pengujian sistematis, perekaman video pengujian, penyusunan laporan komprehensif pada `README.md`, dan penyerahan tugas sebelum tenggat waktu.

### Spesifikasi Penugasan TP6 (Modul 7 Halaman 9):
* **Spesifikasi Wajib:**
  1. **Game Over (Hentikan Permainan):** Permainan berhenti saat player menabrak/menyentuh pipa atau jatuh melewati batas bawah window `JFrame`.
  2. **Fitur Restart Game:** Setelah kondisi Game Over, pemain dapat mengulang permainan kembali dengan menekan tombol `"R"` pada keyboard.
  3. **JLabel Penampil Skor:** Menampilkan skor menggunakan komponen `JLabel` di layar permainan.
  4. **Penambahan Skor:** Skor bertambah `+1` secara tepat setiap kali player berhasil melewati pasangan pipa obstacle.
  5. **Main Menu Awal:** Menampilkan menu utama di awal program yang memiliki 2 tombol utama:
     - Tombol untuk **memulai permainan** (Play/Start Game).
     - Tombol untuk **keluar dari permainan** (Exit).
* **Fitur Bonus (+20 Poin):**
  - Menambahkan audio latar belakang (**BGM - Background Music**) dan efek suara (**SFX - Sound Effects**) seperti suara saat melompat (*jump*), mendapat skor (*point*), dan menabrak (*hit/game over*).
* **Spesifikasi Kreatif:**
  - Peningkatan visual antarmuka (tampilan Game Over overlay, font retro/game, desain tombol main menu yang selaras dengan tema game Flappy Bird).
* **Ketentuan Pengumpulan:**
  - Repositori GitHub publik: `TP6DPBO2425C...` / `TP6DPBO2526C2`.
  - Format Folder: Folder project `FlappyBird/`, folder `Dokumentasi/`, file `README.md`, dan `plan.md`.
  - Formulir Pengumpulan: [Google Form Submission](https://forms.gle/hpBcpRtUHUGJfWfX7).
  - Batas Akhir (*Deadline*): **2 November 2026, pukul 23:59 WIB**.

---

## 2. Pembagian Peran dan Tanggung Jawab

| No | Komponen / Pekerjaan | Tanggung Jawab | Deskripsi Teknis |
|---|---|---|---|
| 1 | **Inisialisasi Struktur Proyek** | **AI (Antigravity)** | Membuat struktur folder `FlappyBird/`, package `assets`, dan konfigurasi file `.iml` IntelliJ IDEA. |
| 2 | **Penyiapan Aset Gambar & Audio** | **AI & User** | - Download aset resmi dari link modul: [Google Drive Assets](https://drive.google.com/file/d/12aH9vxQQz7_0Q0lG0jWO5R2qYgp7iD5F/view).<br>- Menyiapkan file audio `.wav` untuk bonus BGM dan SFX. |
| 3 | **Fase 1: Implementasi Baseline Modul 6** | **AI (Antigravity)** | Mengimplementasikan `App.java`, `Player.java`, `View.java`, dan `Logic.java` (game loop, gravitasi, kontrol tombol Space) murni sesuai modul. |
| 4 | **Fase 1: Implementasi Baseline Modul 7** | **AI (Antigravity)** | Mengimplementasikan `Pipe.java`, modifikasi `Logic.java` (timer `pipesCooldown`, `placePipes()`, `move()`), dan render pipa di `View.java` murni sesuai modul. |
| 5 | **Uji Coba Fungsional Baseline** | **User & AI** | Memastikan burung bisa jatuh, melompat dengan Spasi, serta pipa atas dan bawah muncul dan berjalan ke kiri secara normal. |
| 6 | **Fase 2: Implementasi Game Over & Collision** | **AI (Antigravity)** | Menambahkan algoritma *AABB Intersection* (deteksi tabrakan burung dengan pipa) dan deteksi burung jatuh ke dasar layar. |
| 7 | **Fase 2: Implementasi Sistem Restart (Tombol 'R')** | **AI (Antigravity)** | Menambahkan handler tombol `'R'` pada `KeyListener` untuk me-reset posisi pemain, membersihkan array pipa, me-reset skor, dan menghidupkan kembali timer. |
| 8 | **Fase 2: Implementasi UI Skor (JLabel)** | **AI (Antigravity)** | Mengintegrasikan komponen `JLabel` pada layer `View`/`JFrame` dan memperbarui nilai skor setiap kali pipa berhasil dilewati. |
| 9 | **Fase 2: Implementasi Main Menu** | **AI (Antigravity)** | Membangun panel Main Menu dengan tombol Play dan Exit menggunakan transisi tampilan (`CardLayout` atau state management). |
| 10 | **Fase 3: Implementasi Bonus Audio (BGM & SFX)** | **AI (Antigravity)** | Membuat class `SoundManager.java` menggunakan `javax.sound.sampled` untuk memutar BGM secara *looping* dan memicu SFX saat aksi tertentu terjadi. |
| 11 | **Pengujian Menyeluruh (Testing Matrix)** | **User & AI** | Menguji semua skenario alur permainan dari menu awal hingga restart dan exit. |
| 12 | **Perekaman Media Dokumentasi** | **User (Manual)** | Merekam video (disarankan) atau GIF/tangkapan layar gameplay lengkap dan menyimpannya di folder `Dokumentasi/`. |
| 13 | **Penyusunan `README.md`** | **AI (Antigravity)** | Menulis dokumentasi lengkap berisi arsitektur OOP, diagram alur, penjelasan fitur, dan menyematkan link dokumentasi. |
| 14 | **Commit & Push GitHub** | **User (Manual)** | Melakukan git add, commit, dan push ke branch utama repositori GitHub sebelum batas deadline. |

---

## 3. Struktur Direktori Proyek

```
TP6DPBO2526C2/
├── .git/
├── FlappyBird/
│   ├── .idea/
│   ├── src/
│   │   ├── assets/
│   │   │   ├── background.png      (Latar belakang canvas 360x640)
│   │   │   ├── bird.png            (Sprite burung 34x24)
│   │   │   ├── lowerPipe.png       (Sprite pipa bawah 64x512)
│   │   │   ├── upperPipe.png       (Sprite pipa atas 64x512)
│   │   │   └── sounds/             (File audio untuk bonus)
│   │   │       ├── bgm.wav         (Musik latar belakang)
│   │   │       ├── jump.wav        (Efek suara melompat)
│   │   │       ├── point.wav       (Efek suara skor bertambah)
│   │   │       └── dead.wav        (Efek suara tabrakan/game over)
│   │   ├── App.java                (Entry point aplikasi & window manager)
│   │   ├── Logic.java              (Game logic, state, timer, dan event handler)
│   │   ├── Pipe.java               (Model entitas pipa rintangan)
│   │   ├── Player.java             (Model entitas burung/karakter pemain)
│   │   ├── View.java               (Panel kanvas rendering grafis game)
│   │   ├── MainMenu.java           (Panel UI Menu Utama: tombol Play & Exit)
│   │   └── SoundManager.java       (Helper pengelolaan pemutaran audio BGM & SFX)
│   ├── .gitignore
│   └── FlappyBird.iml
├── Dokumentasi/
│   └── (File video .mp4 / GIF / screenshot demonstrasi gameplay)
├── plan.md                         (Dokumen rencana kerja ini)
└── README.md                       (Laporan dokumentasi tugas praktikum)
```

---

## 4. Tahapan Pengerjaan Rinci (Step-by-Step)

### FASE 1: Baseline Implementation (Murni Modul 6 & Modul 7 - Tanpa Modifikasi)

Tahap ini bertujuan untuk menyelesaikan implementasi dasar tepat seperti instruksi laboratorium tanpa modifikasi apapun.

- [x] **Langkah 1.1: Setup Folder dan Project Java `FlappyBird`**
  - Membuat direktori proyek `FlappyBird/src` di dalam folder `TP6DPBO2526C2`.
  - Mengonfigurasi file `FlappyBird.iml` dan `.gitignore`.
  - Membuat package `assets` di dalam `src/`.

- [x] **Langkah 1.2: Mempersiapkan Aset Gambar Modul**
  - Mengunduh paket gambar dari tautan resmi modul: `https://drive.google.com/file/d/12aH9vxQQz7_0Q0lG0jWO5R2qYgp7iD5F/view`.
  - Menempatkan 4 file gambar ke folder `FlappyBird/src/assets/`:
    1. `background.png`
    2. `bird.png`
    3. `lowerPipe.png`
    4. `upperPipe.png`

- [x] **Langkah 1.3: Mengimplementasikan `Player.java` (Sesuai Modul 6)**
  - Atribut: `posX`, `posY`, `width`, `height`, `image`, `velocityY`.
  - Konstruktor `Player(int posX, int posY, int width, int height, Image image)`.
  - Getter & Setter lengkap untuk seluruh atribut.

- [x] **Langkah 1.4: Mengimplementasikan `Pipe.java` (Sesuai Modul 7)**
  - Atribut: `posX`, `posY`, `width`, `height`, `image`, `velocityX`, `passed`.
  - Konstruktor `Pipe(int posX, int posY, int width, int height, Image image)`.
  - Getter & Setter lengkap untuk seluruh atribut.

- [x] **Langkah 1.5: Mengimplementasikan `View.java` (Sesuai Modul 6 & 7)**
  - Mewarisi `JPanel`.
  - Inisialisasi ukuran preferensi `360 x 640` piksel dan `setBackground(Color.cyan)`.
  - Override `paintComponent(Graphics g)` yang memanggil method `draw(Graphics g)`.
  - Method `draw(Graphics g)`:
    - Menggambar sprite player: `g.drawImage(player.getImage(), player.getPosX(), player.getPosY(), player.getWidth(), player.getHeight(), null)`.
    - Menggambar list pipa: iterasi `ArrayList<Pipe>` dan menggambar setiap `pipe`.

- [x] **Langkah 1.6: Mengimplementasikan `Logic.java` (Sesuai Modul 6 & 7)**
  - Implementasi interface `ActionListener` dan `KeyListener`.
  - Inisialisasi atribut frame: `frameWidth = 360`, `frameHeight = 640`.
  - Inisialisasi atribut player: posisi awal di tengah layar (`frameWidth / 2`, `frameHeight / 2`), ukuran `34 x 24`, gravitasi `1`.
  - Inisialisasi atribut pipa: ukuran `64 x 512`, kecepatan `pipeVelocityX = -2`.
  - Memuat gambar aset `birdImage`, `lowerPipeImage`, `upperPipeImage`.
  - Inisialisasi timer:
    - `gameLoop = new Timer(1000/60, this)` (60 FPS game loop).
    - `pipesCooldown = new Timer(1500, ...)` (interval 1.5 detik memanggil `placePipes()`).
  - Method `placePipes()`:
    - Menghitung posisi Y acak pipa atas: `int randomPosY = (int) (pipeStartPosY - (pipeHeight / 4) - Math.random() * (pipeHeight / 2));`
    - Celah pipa: `int openingSpace = frameHeight / 4;`
    - Menambahkan `upperPipe` dan `lowerPipe` ke dalam `pipes`.
  - Method `move()`:
    - Mengupdate `velocityY` dengan `gravity`.
    - Mengupdate `posY` pemain dan memastikan tidak melewati batas atas (`Math.max(posY, 0)`).
    - Menggeser semua pipa ke kiri sebesar `pipeVelocityX`.
  - Method `keyPressed()`:
    - Tombol Spasi (`KeyEvent.VK_SPACE`) mengubah `velocityY = -10` (melompat).

- [x] **Langkah 1.7: Mengimplementasikan `App.java` (Sesuai Modul 6 & 7)**
  - Inisialisasi `JFrame frame = new JFrame("FlappyBird");` ukuran 360x640, non-resizable, ditengah layar.
  - Inisialisasi `Logic logika = new Logic();` dan `View tampilan = new View(logika);`.
  - Menghubungkan komunikasi dua arah: `logika.setView(tampilan)`.
  - Menambahkan `tampilan` ke `frame`, `frame.pack()`, `tampilan.requestFocus()`, dan `frame.setVisible(true)`.

- [x] **Langkah 1.8: Verifikasi & Uji Baseline (Checkpoint 1)**
  - Mengompilasi dan menjalankan program baseline.
  - Memastikan:
    1. Burung muncul dan jatuh karena gravitasi.
    2. Menekan spasi membuat burung melompat.
    3. Pipa atas dan bawah muncul secara berkala dan bergerak ke kiri.
    4. Tidak ada error/exception saat memuat aset gambar.

---

### FASE 2: Pengembangan Spesifikasi Wajib TP6

Setelah baseline terverifikasi stabil, kita mulai mengimplementasikan penugasan Modul 7 halaman 9.

- [x] **Langkah 2.1: Spesifikasi 1 - Deteksi Tabrakan & Game Over**
  - Menambahkan atribut status game: `boolean gameOver = false;` di `Logic.java`.
  - Membuat method helper pengecekan tabrakan (AABB Collision):
    ```java
    public boolean checkCollision(Player player, Pipe pipe) {
        return player.getPosX() < pipe.getPosX() + pipe.getWidth() &&
               player.getPosX() + player.getWidth() > pipe.getPosX() &&
               player.getPosY() < pipe.getPosY() + pipe.getHeight() &&
               player.getPosY() + player.getHeight() > pipe.getPosY();
    }
    ```
  - Pada method `move()`:
    - Cek tabrakan burung dengan setiap `Pipe`: jika bersentuhan, set `gameOver = true`.
    - Cek batas bawah layar: jika `player.getPosY() + player.getHeight() >= frameHeight`, set `gameOver = true`.
  - Ketika `gameOver == true`:
    - Hentikan `gameLoop.stop();` dan `pipesCooldown.stop();`.
  - Di `View.draw()`:
    - Tambahkan visual teks/banner jika `gameOver == true` (misal teks "GAME OVER" dan "Press 'R' to Restart").

- [x] **Langkah 2.2: Spesifikasi 2 - Fitur Restart Permainan (Tombol 'R')**
  - Menambahkan method `restartGame()` di `Logic.java`:
    - Mengembalikan koordinat pemain ke posisi awal (`playerStartPosX`, `playerStartPosY`).
    - Mengembalikan `velocityY = 0`.
    - Mengosongkan list pipa: `pipes.clear()`.
    - Me-reset skor ke `0`.
    - Mengembalikan status `gameOver = false`.
    - Menjalankan kembali timer: `gameLoop.start();` dan `pipesCooldown.start();`.
  - Pada method `keyPressed()` di `Logic.java`:
    - Tambahkan kondisi:
      ```java
      if (gameOver && e.getKeyCode() == KeyEvent.VK_R) {
          restartGame();
      }
      ```

- [x] **Langkah 2.3: Spesifikasi 3 & 4 - Komponen JLabel Penampil Skor & Kalkulasi Skor (+1)**
  - Menambahkan atribut skor pada `Logic.java`: `int score = 0;`.
  - Logika penambahan skor di `move()`:
    - Iterasi pipa: jika burung berhasil melewati pipa (misal: `player.getPosX() > pipe.getPosX() + pipe.getWidth()`) dan `!pipe.isPassed()`:
      - Tandai `pipe.setPassed(true);`.
      - Karena sepasang pipa (atas dan bawah) memiliki nilai X yang sama, tambahkan skor `+1` (hanya sekali per pasangan).
  - Integrasi komponen `JLabel`:
    - Membuat `JLabel scoreLabel` pada `View.java` atau tata letak overlay di atas kanvas permainan.
    - Mengatur styling: font tebal retro/sans-serif, ukuran jelas, warna kontras terhadap background.
    - Mengupdate isi teks `scoreLabel.setText("Score: " + logic.getScore());` setiap frame atau setiap skor berubah.

- [x] **Langkah 2.4: Spesifikasi 5 - Pembuatan Main Menu Awal (Tombol Play & Exit)**
  - Membuat class `MainMenu.java` yang mewarisi `JPanel`.
  - Menambahkan elemen UI:
    - Judul game: "FLAPPY BIRD".
    - Tombol "Mulai Permainan" / "Play".
    - Tombol "Keluar" / "Exit" (`System.exit(0);`).
  - Mengatur navigasi di `App.java`:
    - Menggunakan `CardLayout` atau pergantian panel pada `JFrame`.
    - Saat aplikasi dibuka pertama kali, tampilkan `MainMenu`.
    - Saat tombol "Play" ditekan, alihkan ke panel permainan `View`, beri fokus keyboard (`requestFocus()`), dan mulai game loop.

---

### FASE 3: Implementasi Fitur Bonus & Kreatif

- [x] **Langkah 3.1: Fitur Bonus (+20 Poin) - Audio BGM & Sound Effect (SFX)**
  - Menyiapkan file audio format `.wav` (PCM 16-bit) di folder `assets/sounds/`:
    - `bgm.wav`: Musik latar yang berputar terus menerus (*loop*).
    - `jump.wav`: Suara kepakan sayap/lompat saat tombol Spasi ditekan.
    - `point.wav`: Suara lonceng/ding saat skor bertambah.
    - `dead.wav`: Suara benturan saat menabrak pipa atau jatuh ke tanah.
  - Membuat class `SoundManager.java`:
    - Menggunakan library bawaan Java `javax.sound.sampled.Clip` dan `AudioSystem`.
    - Method: `playBGM()`, `stopBGM()`, `playJump()`, `playScore()`, `playGameOver()`.
  - Mengintegrasikan pemanggilan suara pada event game di `Logic.java`:
    - Saat tombol Spasi ditekan -> `soundManager.playJump()`.
    - Saat pipa dilewati -> `soundManager.playScore()`.
    - Saat tabrakan/jatuh -> `soundManager.playGameOver()`.

- [x] **Langkah 3.2: Polishing Visual & Spesifikasi Kreatif**
  - Menggambar gambar latar belakang `background.png` di `View.draw()` agar tampilan game realistis menyerupai Flappy Bird asli.
  - Memberikan visual Game Over screen yang elegan (overlay transparan gelap dengan tulisan skor akhir dan petunjuk restart).
  - Memperhalus tata letak tombol pada Main Menu dengan hover effect dan padding yang nyaman.

---

### FASE 4: Pengujian Komprehensif & Validasi Matriks

Melakukan verifikasi sistematis terhadap seluruh fungsi game:

| No | Kasus Uji | Tindakan / Input | Ekspektasi Hasil | Status |
|---|---|---|---|---|
| 1 | **Tampilan Main Menu** | Buka aplikasi pertama kali | Muncul window dengan judul, tombol Play, dan tombol Exit | [x] |
| 2 | **Tombol Exit** | Klik tombol Exit di Main Menu | Aplikasi tertutup dengan bersih (`exit code 0`) | [x] |
| 3 | **Mulai Permainan** | Klik tombol Play di Main Menu | Layar berpindah ke kanvas Flappy Bird, BGM mulai berputar | [x] |
| 4 | **Kontrol Melompat** | Tekan tombol Spasi | Burung bergerak naik (melompat), terdengar SFX jump | [x] |
| 5 | **Simulasi Gravitasi** | Tidak menekan spasi | Burung jatuh ke bawah secara wajar dan realistis | [x] |
| 6 | **Pergerakan Rintangan** | Amati layar | Pipa atas dan bawah muncul bervariasi dan bergerak ke kiri | [x] |
| 7 | **Penambahan Skor** | Burung berhasil melewati celah pipa | Skor pada `JLabel` bertambah +1, terdengar SFX score | [x] |
| 8 | **Tabrakan Pipa** | Burung menabrak pipa atas/bawah | Game Over seketika, pipa & burung berhenti, SFX hit berbunyi | [x] |
| 9 | **Jatuh ke Batas Bawah**| Burung jatuh ke dasar frame | Game Over seketika, layar memunculkan instruksi restart | [x] |
| 10 | **Restart Game** | Tekan tombol 'R' saat Game Over | Skor kembali 0, burung kembali ke tengah, pipa di-reset, game lanjut | [x] |
| 11 | **BGM Looping** | Mainkan game terus-menerus | Musik BGM terus berputar tanpa putus | [x] |

---

### FASE 5: Dokumentasi & Pembuatan Laporan (`README.md`)

- [x] **Langkah 5.1: Pengambilan Bukti Dokumentasi**
  - Merekam video demonstrasi game (durasi ~1-2 menit) yang memperlihatkan:
    1. Tampilan Main Menu & klik Start Game.
    2. Burung melompat dan gameplay normal.
    3. Skor bertambah saat melewati pipa.
    4. Audio BGM & SFX terdengar jelas.
    5. Game Over saat menabrak pipa dan saat jatuh.
    6. Fitur restart dengan tombol 'R'.
    7. Keluar game melalui tombol Exit.
  - Menyimpan file video/gif ke dalam folder `TP6DPBO2526C2/Dokumentasi/`.

- [x] **Langkah 5.2: Penyusunan Dokumen `README.md`**
  - **Identitas:** Nama, NIM, Kelas, Program Studi.
  - **Deskripsi Program:** Ringkasan proyek Flappy Bird Java Swing.
  - **Desain & Arsitektur Program:**
    - Penjelasan Class: `App`, `Logic`, `Player`, `Pipe`, `View`, `MainMenu`, `SoundManager`.
    - Diagram Class / Hubungan Antar Kelas (Mermaid Diagram).
    - Pemisahan tanggung jawab MVC/Component model.
  - **Penjelasan Alur Program:**
    - Alur state dari Main Menu -> In-Game -> Game Over -> Restart.
    - Logika Game Loop, Gravitasi, dan Collision Detection.
  - **Dokumentasi Hasil Eksekusi:**
    - Menampilkan cuplikan video / GIF / screenshot antarmuka.
  - **Panduan Menjalankan Program:**
    - Prasyarat JDK (Java 17/21/sesuai lingkungan).
    - Cara compile & run melalui IDE (IntelliJ IDEA) atau Command Line.

---

### FASE 6: Finalisasi & Penyerahan Tugas

- [ ] **Langkah 6.1: Pemeriksaan Akhir Repositori Git**
  - Pastikan tidak ada file temporary/cache yang tidak perlu (gunakan `.gitignore`).
  - Lakukan `git status` dan pastikan file `FlappyBird/`, `Dokumentasi/`, `README.md`, dan `plan.md` terlacak dengan benar.
  - Commit dengan pesan deskriptif: `git commit -m "feat: complete TP6 Flappy Bird with bonus audio and documentation"`.
  - Push ke remote GitHub branch default.

- [ ] **Langkah 6.2: Pengisian Formulir Penyerahan**
  - Periksa akses repositori GitHub agar berstatus **Public**.
  - Buka formulir pengumpulan: [https://forms.gle/hpBcpRtUHUGJfWfX7](https://forms.gle/hpBcpRtUHUGJfWfX7).
  - Submit tautan repositori sebelum **2 November 2026 pukul 23:59 WIB**.

---

## 5. Catatan Teknis Penting

1. **Pemuatan Aset Gambar:**
   - Gunakan `getClass().getResource("/assets/...")` agar aset dapat dimuat dengan andal baik saat dijalankan langsung di IDE maupun saat dibuild menjadi file `.jar`.
2. **Sinkronisasi Skor Pasangan Pipa:**
   - Karena method `placePipes()` menambahkan sepasang pipa (atas dan bawah) secara bersamaan, atribut `passed` hanya perlu dicek dan ditandai pada salah satu pipa (misal: pipa atas) agar skor bertambah tepat +1, bukan +2.
3. **Format File Audio:**
   - `javax.sound.sampled` bawaan Java Standard Edition paling andal memproses format file audio `.wav` (PCM uncompressed, 16-bit, 44.1 kHz). Hindari format `.mp3` murni tanpa library pihak ketiga.
4. **Thread Safety & RequestFocus:**
   - Komponen kanvas `View` memerlukan `setFocusable(true)` dan pemanggilan `requestFocus()` atau `requestFocusInWindow()` agar tombol keyboard (`VK_SPACE` dan `VK_R`) dapat ditangkap secara responsif setelah berpindah dari Main Menu.
