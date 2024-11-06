package entity;

import jailbreak.AssetSetter;
import jailbreak.GamePanel;
import jailbreak.KeyHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.SwingUtilities;
import object.OBJ_Coderkey;
import object.OBJ_KEY;
import object.OBJ_Note;
import object.OBJ_notebed;
import java.awt.Graphics2D;
public class Player extends Entity {
    GamePanel gp;
    KeyHandler keyh;
    public boolean isImageDisplayed0 = false;
    public boolean isImageDisplayed1 = false;
    public boolean isPanel = false;
    int keydoor1 = 0;
    int keyChest = 0;
    int coderkey = 0;
    int knowbed = 0;
    int knowbed2 = 0;
    public int red = 0;
    public int green = 0;
    public int blue = 0;
    public int black = 0;
            
    AssetSetter keyset ;
    
    public Player(GamePanel gp, KeyHandler keyh) {
    this.gp = gp;
    this.keyh = keyh; // Pass the inputPanel instance
        setDefaultValues();
        getPlayerImage();
        solidArea = new Rectangle();
        solidArea.x = 8;
        solidArea.y = 20;
        solidArea.width = 28;
        solidArea.height = 40;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
}
    public void setDefaultValues(){
        x = 100;            //set player default position
        y = 600;
        speed = 4;
        direction = "down1";
    }
    public void getPlayerImage(){
        try{
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk2.png"));
            down3 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk3.png"));
            down4 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk4.png"));
            down5 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk5.png"));
            down6 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk6.png"));
            down7 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk7.png"));
            down8 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk8.png"));
            down9 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk9.png"));
            down10 = ImageIO.read(getClass().getResourceAsStream("/player/downwalk10.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk2.png"));
            up3 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk3.png"));
            up4 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk4.png"));
            up5 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk5.png"));
            up6 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk6.png"));
            up7 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk7.png"));
            up8 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk8.png"));
            up9 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk9.png"));
            up10 = ImageIO.read(getClass().getResourceAsStream("/player/upwalk10.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk2.png"));
            left3 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk3.png"));
            left4 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk4.png"));
            left5 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk5.png"));
            left6 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk6.png"));
            left7 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk7.png"));
            left8 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk8.png"));
            left9 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk9.png"));
            left10 = ImageIO.read(getClass().getResourceAsStream("/player/leftwalk10.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk2.png"));
            right3 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk3.png"));
            right4 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk4.png"));
            right5 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk5.png"));
            right6 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk6.png"));
            right7 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk7.png"));
            right8 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk8.png"));
            right9 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk9.png"));
            right10 = ImageIO.read(getClass().getResourceAsStream("/player/rightwalk10.png"));
            idle = ImageIO.read(getClass().getResourceAsStream("/player/downwalk1.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void pickUpObject(int i){
        if(i!= 999){
            gp.obj[i] = null;
        }
    }
    public void update(){
        
        if (keyh.ePressed) {
        direction = "e";
        int objIndex = gp.cChecker.checkObject(this, true);//IMPORTANT1
        
        if(objIndex == 0){
            pickUpObject(objIndex);
            keydoor1++;
            gp.playSE(1);
        }
        if(objIndex == 1 && keydoor1 == 1){
            keydoor1--;
            gp.playSE(2);
            pickUpObject(objIndex);
        }else if(objIndex == 1){
            gp.TriggerText();
        }
        if(objIndex == 2 ){
            pickUpObject(objIndex);
            gp.playSE(1);
        }
        if(objIndex == 3 ){
            gp.playSE(1);
            gp.obj[6] = new OBJ_KEY();
            gp.obj[6].x = 10*gp.tileSize;
            gp.obj[6].y = 13*gp.tileSize;
            pickUpObject(objIndex);
        }
        if(objIndex == 4 && coderkey == 1){
            pickUpObject(objIndex);
            gp.playSE(1);
            gp.obj[8] = new OBJ_Note();
            gp.obj[8].x = 16*gp.tileSize;
            gp.obj[8].y = 11*gp.tileSize;
        }else if(objIndex == 4){
            gp.TriggerText();
        }
        
        if (objIndex == 5 && keyChest == 1){
            gp.playSE(6);
            gp.obj[7] = new OBJ_Coderkey();
            gp.obj[7].x = 2*gp.tileSize;
            gp.obj[7].y = 2*gp.tileSize;
            pickUpObject(objIndex);
        }else if(objIndex == 5){
            gp.TriggerText();
        }
        
        if (objIndex == 6){
            gp.playSE(1);
            keyChest=1;
            pickUpObject(objIndex);
        }
        if (objIndex == 7){
            gp.playSE(1);
            coderkey=1;
            pickUpObject(objIndex);
        }
        if (objIndex == 8){ //paper
            gp.playSE(0);
            interactcoder();
        }
        if (objIndex == 10 ){
            gp.playSE(2);
            pickUpObject(objIndex);
            gp.obj[16] = new OBJ_notebed();
            gp.obj[16].x = 16*gp.tileSize;
            gp.obj[16].y = 4*gp.tileSize;
        }
        if (objIndex == 11 ){
            gp.playSE(1);
            pickUpObject(objIndex);
        }
        if (objIndex == 25 ){
            gp.playSE(1);
            pickUpObject(objIndex);
        }
        if (objIndex == 26 ){
            gp.playSE(1);
            pickUpObject(objIndex);
        }
        /*if (objIndex == 27 ){
            gp.playSE(1);
            pickUpObject(objIndex);
        }*/
        
        if (objIndex == 12 ){
            gp.playSE(2);
            pickUpObject(objIndex);
        }
        if (objIndex == 13 ){
            gp.playSE(2);
            pickUpObject(objIndex);
        }
        if (objIndex == 14 ){
            gp.playSE(2);
            pickUpObject(objIndex);
        }
        if (objIndex == 15 && knowbed == 1 ){
            pickUpObject(objIndex);
            knowbed2 = 1;
            gp.playSE(1);
        }else if(objIndex == 15){
            gp.TriggerText();
        }
        if (objIndex == 16 ){ //paper
            gp.playSE(0);
            knowbed = 1;
            interact();
        }
        if (objIndex == 9 /*&& red == 6 && green==5 && blue==4 && black==7 && knowbed2==1 && coderkey==1*/){ //paper
            gp.triggerWinner();
            gp.playSE(4);
        }else if (objIndex == 9){
            gp.playSE(5);
        }
        if (objIndex == 17 ){
            gp.playSE(7);
            red++;
        }
        if (objIndex == 18 ){
            gp.playSE(7);
            red--;
        }
        if (objIndex == 19 ){
            gp.playSE(7);
            green++;
        }
        if (objIndex == 20 ){
            gp.playSE(7);
            green--;
        }
        if (objIndex == 21 ){
            gp.playSE(7);
            blue++;
        }
        if (objIndex == 22 ){
            gp.playSE(7);
            blue--;
        }
        if (objIndex == 23 ){
            gp.playSE(7);
            black++;
        }
        if (objIndex == 24 ){
            gp.playSE(7);
            black--;
        }

        if (objIndex != 999) { // Object detected
            System.out.println("Interacting with object at index: " + objIndex);
        } else {
            System.out.println("No object to interact with.");
        }

        keyh.ePressed = false; // Reset the 'E' key press
    }
        
        if(keyh.upPressed == true || keyh.downPressed == true || keyh.leftPressed == true || keyh.rightPressed == true){
            if(keyh.upPressed == true){
            direction = "up";
            
        }
        else if(keyh.downPressed == true){
            direction = "down";
            
        }
        else if(keyh.leftPressed == true){
            direction = "left";
            
        }
        else if(keyh.rightPressed == true){
            direction = "right";
            
        }else{
            setIdle();  
        }

        //CHECK TILE COLLISION
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //CHECK OBJECT COLLISION
        int objIndex = gp.cChecker.checkObject(this, true); //IMPORTANT2
        
        if(collisionOn == false){ //IF TILE COLLISION IS FALSE, PLAYER CAN MOVE!
            switch(direction){
                case "up": y -= speed;
                    break;
                case "down": y += speed;
                    break;
                case "left": x -= speed;
                    break;
                case "right": x += speed;
                    break;
            }
        }
        spriteCounter++;
        if (spriteCounter > 4) { // change picture every 10 frames
            spriteNum++;
        if (spriteNum > 10) { // assuming 10 frames per animation cycle
            spriteNum = 1; // reset to first frame
            }
        spriteCounter = 0;
        } 
     }
}


// Example method to check if the entered code is valid
private boolean isValidCode(String value) {
    // Replace with your actual validation logic
    return "1234".equals(value);  // Assuming "1234" is the correct code
}
 public void draw(Graphics g) {
        // Example player draw logic (use images if available)
        g.setColor(java.awt.Color.BLUE);
        g.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
    public void interact() {
    isImageDisplayed0 = !isImageDisplayed0;
    System.out.println("Interacting...");
    }
    public void interactcoder() {
    isImageDisplayed1 = !isImageDisplayed1;
    System.out.println("Interacting...");
    }
    public void setIdle() {
    switch(direction) {
        case "up":
            spriteNum = 1;  // up1 for idle
            break;
        case "down":
            spriteNum = 1;  // down1 for idle
            break;
        case "left":
            spriteNum = 1;  // left1 for idle
            break;
        case "right":
            spriteNum = 1;  // right1 for idle
            break;
    }
}
    public void draw(Graphics2D g2){
        
        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        BufferedImage image = null;
        switch(direction){
            case "up":
                if(spriteNum == 1){
                    image = up1;
                }
                if(spriteNum == 2){
                    image = up2;
                }
                if(spriteNum == 3){
                    image = up3;
                }
                if(spriteNum == 4){
                    image = up4;
                }
                if(spriteNum == 5){
                    image = up5;
                }
                if(spriteNum == 6){
                    image = up6;
                }
                if(spriteNum == 7){
                    image = up7;
                }
                if(spriteNum == 8){
                    image = up8;
                }
                if(spriteNum == 9){
                    image = up9;
                }
                if(spriteNum == 10){
                    image = up10;
                } 
                break;   
            case "down":
                if(spriteNum == 1){
                    image = down1;
                }
                if(spriteNum == 2){
                    image = down2;
                }
                if(spriteNum == 3){
                    image = down3;
                }
                if(spriteNum == 4){
                    image = down4;
                }
                if(spriteNum == 5){
                    image = down5;
                }
                if(spriteNum == 6){
                    image = down6;
                }
                if(spriteNum == 7){
                    image = down7;
                }
                if(spriteNum == 8){
                    image = down8;
                }
                if(spriteNum == 9){
                    image = down9;
                }
                if(spriteNum == 10){
                    image = down10;
                }
                break;
            case "left":
                if(spriteNum == 1){
                    image = left1;
                }
                if(spriteNum == 2){
                    image = left2;
                }
                if(spriteNum == 3){
                    image = left3;
                }
                if(spriteNum == 4){
                    image = left4;
                }
                if(spriteNum == 5){
                    image = left5;
                }
                if(spriteNum == 6){
                    image = left6;
                }
                if(spriteNum == 7){
                    image = left7;
                }
                if(spriteNum == 8){
                    image = left8;
                }
                if(spriteNum == 9){
                    image = left9;
                }
                if(spriteNum == 10){
                    image = left10;
                }
                break;
            case "right":
                if(spriteNum == 1){
                    image = right1;
                }
                if(spriteNum == 2){
                    image = right2;
                }
                if(spriteNum == 3){
                    image = right3;
                }
                if(spriteNum == 4){
                    image = right4;
                }
                if(spriteNum == 5){
                    image = right5;
                }
                if(spriteNum == 6){
                    image = right6;
                }
                if(spriteNum == 7){
                    image = right7;
                }
                if(spriteNum == 8){
                    image = right8;
                }
                if(spriteNum == 9){
                    image = right9;
                }
                if(spriteNum == 10){
                    image = right10;
                }
                
                break;
            default :
                image = down1;
        }
        g2.drawImage(image, x, y,gp.tileSize-4,gp.tileSize+26,null);
        
    }
}
