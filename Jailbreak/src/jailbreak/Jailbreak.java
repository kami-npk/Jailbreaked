package jailbreak;
import javax.swing.JFrame;
public class Jailbreak {

    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Jail Break");
        
        GamePanel gamepanel = new GamePanel();
        window.add(gamepanel);
        
        //960px 768px
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamepanel.setupGame();
        gamepanel.startGameThread();
    }
    
}
