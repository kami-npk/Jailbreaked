package jailbreak;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    public boolean upPressed,downPressed,leftPressed,rightPressed;
    GamePanel gp;
    
    public KeyHandler(GamePanel gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {   
    }
    @Override
    public void keyPressed(KeyEvent e) { //press button
        int code = e.getKeyCode();
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum = 0;
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum = 1;
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = 0;
                    gp.playMusic(3);
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
            }
        }
        if(gp.gameState == gp.isGameOver){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum = 0;
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum = 1;
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = 0;
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
            }
        }
        if(gp.gameState == gp.isWinner){
            if(code == KeyEvent.VK_W){
                gp.ui.commandNum = 0;
            }
            if(code == KeyEvent.VK_S){
                gp.ui.commandNum = 1;
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.ui.commandNum == 0){
                    gp.gameState = 0;
                }
                if(gp.ui.commandNum == 1){
                    System.exit(0);
                }
            }
        }
        
        //Play STATE
        if(gp.gameState == gp.gameState){ 
            if(code == KeyEvent.VK_W){
            upPressed = true;
        }
            if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
            if(code == KeyEvent.VK_S){
            downPressed = true;
        }
            if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
            if(code == KeyEvent.VK_E) {
            ePressed = true;  // E key released
        }
    }
}
    
    
    public boolean ePressed = false;
    @Override
    public void keyReleased(KeyEvent e) { //release button
        int code = e.getKeyCode();
        
        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        else if(code == KeyEvent.VK_E) {
        ePressed = false;  // E key released
    }
    }
    
}
