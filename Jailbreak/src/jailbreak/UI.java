
package jailbreak;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.TRUETYPE_FONT;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.io.IOException;
import java.io.InputStream;

public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font maruMonica,maruMonicaSF;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    public String currentDialogue =  "";
    public int commandNum = 0;
    
    
    public UI(GamePanel gp){
        this.gp = gp;
        InputStream is = getClass().getResourceAsStream("/font/MP16REG.ttf");
        try{
            maruMonica = Font.createFont(Font.TRUETYPE_FONT,is);
            is = getClass().getResourceAsStream("/font/MP16OSF.ttf");
            maruMonicaSF = Font.createFont(Font.TRUETYPE_FONT,is);
        }catch(FontFormatException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void showMessage(String text){
        message = text;
        messageOn = true;
    }
    public void draw(Graphics2D g2){
        
        this.g2 = g2;
        g2.setFont(maruMonica);
       
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(Color.white);
        
        //TITLE STATE
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        
        if(gp.gameState == gp.isGameOver){
            drawOverScreen();
        }
        if(gp.gameState == gp.isWinner){
            drawWinnerScreen();
        }
    }
    public void drawTitleScreen(){
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "JailBreak";
        int x = getXforCenteredText(text)+50;
        int y = gp.tileSize*5;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        x = gp.screenWidth/2;
        
        g2.drawImage(gp.player.down1, x-260,y-100,gp.tileSize*2,gp.tileSize*2+70,null);
        
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
        text = "START GAME";
        x = getXforCenteredText(text);
        y += gp.tileSize*5;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">>",x-gp.tileSize-20,y-4);
        }
        
        text = "EXIT";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">>",x-gp.tileSize-20,y-4);
        }
    }
    public void drawOverScreen(){
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Game Over";
        int x = getXforCenteredText(text)+50;
        int y = gp.tileSize*5;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        x = gp.screenWidth/2;
        
        g2.drawImage(gp.player.down1, x-330,y-100,gp.tileSize*2,gp.tileSize*2+70,null);
        
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
        text = "RETRY";
        x = getXforCenteredText(text);
        y += gp.tileSize*5;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">>",x-gp.tileSize-20,y-4);
        }
        
        text = "EXIT";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">>",x-gp.tileSize-20,y-4);
        }
    }
    
    public void drawWinnerScreen(){
        //TITLE NAME
        g2.setFont(g2.getFont().deriveFont(Font.BOLD,96F));
        String text = "Winner";
        int x = getXforCenteredText(text)+55;
        int y = gp.tileSize*5;
        g2.setColor(Color.white);
        g2.drawString(text, x, y);
        
        x = gp.screenWidth/2;
        
        g2.drawImage(gp.player.down1, x-240,y-100,gp.tileSize*2,gp.tileSize*2+70,null);
        
        //menu
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN,40F));
        text = "RETRY";
        x = getXforCenteredText(text);
        y += gp.tileSize*5;
        g2.drawString(text, x, y);
        if(commandNum == 0){
            g2.drawString(">>",x-gp.tileSize-20,y-4);
        }
        
        text = "EXIT";
        x = getXforCenteredText(text);
        y += gp.tileSize*2;
        g2.drawString(text, x, y);
        if(commandNum == 1){
            g2.drawString(">>",x-gp.tileSize-20,y-4);
        }
    }
    
    public int getXforCenteredText(String text){
        int length = (int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.getWidth()/2 - length/2;
        return x   ; 
    }
}
