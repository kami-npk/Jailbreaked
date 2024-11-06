package entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entity {
    public int x,y;
    public int speed;
    public BufferedImage up1,up2,up3,up4,up5,up6,up7,up8,up9,up10,down1,down2,down3,down4,down5,down6,down7,down8,down9,down10,left1,left2,left3,left4,left5,left6,left7,left8,left9,left10,right1,right2,right3,right4,right5,right6,right7,right8,right9,right10,idle;
    public String direction;
    
    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public boolean collisionOn = false;
    
    public int solidAreaDefaultX, solidAreaDefaultY;
}
