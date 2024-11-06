    package jailbreak;

    import entity.Player;
    import java.awt.Color;
    import java.awt.Dimension;
    import java.awt.Font;
    import java.awt.Graphics;
    import java.awt.Graphics2D;
    import java.awt.image.BufferedImage;
    import java.io.IOException;
    import javax.imageio.ImageIO;
    import javax.swing.JButton;
    import javax.swing.JPanel;
    import javax.swing.Timer;
    import object.SuperObject;
    import tile.TileManager;

    public class GamePanel extends JPanel implements Runnable {
            
        final int originalTileSize = 16; // 16x16 tile
        final int scale = 3;
        
        public final int tileSize = originalTileSize * scale;
        public final int maxScreenCol = 20;
        public final int maxScreenRow = 16;
        final int screenWidth = tileSize * maxScreenCol; // 768px
        final int screenHeight = tileSize * maxScreenRow; // 576px

        int fps = 60;
        
        private int countdown = 115; // Countdown in seconds
        private Timer countdownTimer;
        
        //STATE
        public int isGameOver = 1;
        public int isWinner = 2;
        boolean Texed = false;
        public int titleState = 3;
        public int gameState = 0;
        
        TileManager tileM = new TileManager(this);
        KeyHandler keyh = new KeyHandler(this);
        Sound sound = new Sound();
        public CollisionChecker cChecker = new CollisionChecker(this);
        public AssetSetter aSetter = new AssetSetter(this);
        Thread gameThread;
        UI ui = new UI(this);
        
        public Player player = new Player(this, keyh);
        public SuperObject obj[] = new SuperObject[35];

        private JButton exitButton;
        
        public GamePanel() {
      
            this.setPreferredSize(new Dimension(screenWidth, screenHeight));
            this.setBackground(Color.black);
            this.setDoubleBuffered(true);
            this.addKeyListener(keyh);
            this.setFocusable(true);
            setLayout(null); // If using no layout manager
            countdownTimer = new Timer(1000, e -> updateCountdown());
            countdownTimer.start();

            // Set up exit button for Game Over screen
            exitButton = new JButton("Exit");
            exitButton.setFont(new Font("Arial", Font.PLAIN, 20));
            exitButton.setOpaque(true);
            exitButton.setBackground(Color.BLACK);
            exitButton.setForeground(Color.WHITE);
            exitButton.setBorder(null);
            exitButton.setBounds(screenWidth / 2 - 60, screenHeight / 2 + 70, 120, 40);
            exitButton.addActionListener(e -> System.exit(0));
            exitButton.setVisible(false);
            this.add(exitButton);
        }

        private BufferedImage interactionImage0, interactionImage1,TitleBG;

        public void setupGame() {
            try {
                interactionImage0 = ImageIO.read(getClass().getResourceAsStream("/tiles/Bednotedd.png"));
                interactionImage1 = ImageIO.read(getClass().getResourceAsStream("/tiles/notepass_1.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }   
            aSetter.setObject();
            gameState = titleState;
        }

        public void startGameThread() {
            gameThread = new Thread(this);
            gameThread.start();
        }

        @Override
        public void run() {
            double drawInterval = 1000000000 / fps;
            double delta = 0;
            long lastTime = System.nanoTime();
            long currentTime;

            while (gameThread != null) {
                currentTime = System.nanoTime();
                delta += (currentTime - lastTime) / drawInterval;
                lastTime = currentTime;

                if (delta >= 1) {
                    if (gameState != 1) {
                        update();
                    }
                    repaint();
                    delta--;
                }
            }
        }

        private void updateCountdown() {
            if (countdown > 0 && gameState != 2) {
                countdown--;
            } else {
                triggerGameOver();
            }
        }

        private void triggerGameOver() {
            gameState = 1;
            countdownTimer.stop();
            
        }

        public void triggerWinner() {
            gameState = 2;
            countdownTimer.stop();
            
        }

        public void update() {
            player.update();
        }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //TITILE SCREEN
        if(gameState == 3 ){ //title screen
            drawDarkOverlay(g2);
            ui.draw(g2);
            countdownTimer.stop();
        }else{
            countdownTimer.start();
        if (gameState == 1) { //game over
            countdownTimer.stop();
            
            ui.draw(g2);
            
        } else if (gameState == 2) { //winner
            countdownTimer.stop();
            
            ui.draw(g2);
            displayWinnerScreen(g2);
            
        } else { //normal
            tileM.draw(g2);
            player.draw(g2);
            displayGame(g2);
            if (player.isImageDisplayed0) {
                g2.drawImage(interactionImage0, screenWidth / 2 - interactionImage0.getWidth() / 2,
                        screenHeight / 2 - interactionImage0.getHeight() / 2, null);
            }
            if (player.isImageDisplayed1) {
                g2.drawImage(interactionImage1, screenWidth / 2 - interactionImage1.getWidth() / 2,
                        screenHeight / 2 - interactionImage1.getHeight() / 2, null);
            }
            if (Texed){
                displayText(g2);
                
            }
        }
        }
        g2.dispose();
    }
    public void TriggerText() {
    Texed = true; // Set Texed to true to show the text
    repaint(); // Repaint to immediately display text

    // Create a timer to hide the text after 3.4 seconds
    new Timer(3400, e -> {
        Texed = false; // Hide the text after 3.4 seconds
        repaint(); // Repaint to clear the text
    }).start();
}
    private void displayText(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.PLAIN, 15));
        g2.drawString("I'm not Interested", player.x-35,player.y-5);
    }
    private void drawDarkOverlay(Graphics2D g2) {
        g2.setColor(new Color(0, 0, 0, 150)); // Black with alpha for transparency
        g2.fillRect(0, 0, screenWidth, screenHeight);
    }
    private void displayGame(Graphics2D g2) {
        tileM.draw(g2);
        for (SuperObject obj : obj) {
            if (obj != null) {
                obj.draw(g2, this);
            }
        }
        
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.PLAIN, 20));
        g2.drawString("Time left: " + countdown, 10, 20);
        
        
        g2.drawString(""+player.red, 402, 224);
        g2.drawString(""+player.green, 498, 224);
        g2.drawString(""+player.blue, 594, 224);
        g2.drawString(""+player.black, 690, 224);
        
        g2.setFont(new Font("Arial", Font.PLAIN, 16));
        g2.drawString("(w, a, s, d) For movement",160,550);
        g2.drawString("'e' For interact item",160,580);
        player.draw(g2);
        
        g2.setFont(new Font("Arial", Font.PLAIN, 15));
        g2.drawString("<==Exit",660,20);
        
    }
    public void display_text(Graphics2D g2){
        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 16));
        g2.drawString("I Don't interest in this item.", player.x-30, player.y+25);
    }

    private void displayGameOverScreen(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.setFont(new Font("Arial", Font.BOLD, 40));
        g2.drawString("Game Over", screenWidth / 2 - 100, screenHeight / 2 - 50);
    }

    private void displayWinnerScreen(Graphics2D g2) {
        g2.setColor(Color.WHITE);
        g2.setFont(ui.maruMonica);
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,20F));
        g2.drawString("Time Left: " + countdown + " seconds", screenWidth / 2 - 100, screenHeight / 2);
    }

    public void playMusic(int i) {
        sound.setFile(i);
        sound.setVolume((float) 0.1);
        sound.play();
        sound.loop();
    }

    public void stopMusic() {
        sound.stop();
        
    }

    public void playSE(int i) {
        sound.setFile(i);
        sound.play();
    }
}
