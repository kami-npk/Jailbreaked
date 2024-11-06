package jailbreak;
import entity.Entity;
import entity.Player;
import java.awt.Rectangle;
import object.SuperObject;

public class CollisionChecker {
    GamePanel gp;
            
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    public void checkTile(Entity entity){
        int entityLeftWorldx = (entity.x + entity.solidArea.x)-2;
        int entityRightWorldx = (entity.x + entity.solidArea.x + entity.solidArea.width)-2;
        int entityTopWorldy = (entity.y + entity.solidArea.y)-2;
        int entityDownWorldy = (entity.y + entity.solidArea.y + entity.solidArea.height)-2;
        
        int entityLeftCol = entityLeftWorldx/gp.tileSize;
        int entityRightCol = entityRightWorldx/gp.tileSize;
        int entityTopRow = entityTopWorldy/gp.tileSize;
        int entityDownRow = entityDownWorldy/gp.tileSize;
        
        int tileNum1,tileNum2;
        
        switch(entity.direction){
            case"up":
                entityTopRow = (entityTopWorldy - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
                
            case"down":
                entityDownRow = (entityDownWorldy + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityDownRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityDownRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
                
            case"left":
                entityLeftCol = (entityLeftWorldx - entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityLeftCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityLeftCol][entityDownRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
                
            case"right":
                entityRightCol = (entityRightWorldx + entity.speed)/gp.tileSize;
                tileNum1 = gp.tileM.mapTileNum[entityRightCol][entityTopRow];
                tileNum2 = gp.tileM.mapTileNum[entityRightCol][entityDownRow];
                if(gp.tileM.tile[tileNum1].collision == true || gp.tileM.tile[tileNum2].collision == true){
                    entity.collisionOn = true;
                }
                break;
        }
    }
    class GameObject {
    public Rectangle solidArea; // The current hitbox
    public int solidAreaDefaultX; // Default x position of the solid area
    public int solidAreaDefaultY; // Default y position of the solid area
    public boolean collision; // Collision property
    // Other properties...
}
    
    public int checkObject(Entity entity,boolean player){
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            if(gp.obj[i] != null){
                
                //get entity solid area position
                entity.solidArea.x = entity.x + entity.solidArea.x;
                entity.solidArea.y = entity.y + entity.solidArea.y;
                
                //get the object solid area position
                gp.obj[i].solidArea.x = gp.obj[i].x + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].y + gp.obj[i].solidArea.y;
                
                Rectangle enlargedHitbox = new Rectangle(
                gp.obj[i].x - 30,
                gp.obj[i].y - 30,
                gp.tileSize + 40,
                gp.tileSize + 40
                );
                
                switch(entity.direction){
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            if(gp.obj[i].collision == true){
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                    case "e":
                        if(entity.solidArea.intersects(enlargedHitbox)){ 
                        if(entity.solidArea.intersects(gp.obj[i].solidArea)){
                            
                                entity.collisionOn = true;
                            }
                            if(player == true){
                                index = i;
                            }
                        }
                        break;
                }
            }
            if (gp.obj[i] != null) {
            gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
            gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;
        }
        entity.solidArea.x = entity.solidAreaDefaultX;
        entity.solidArea.y = entity.solidAreaDefaultY;
    }
        return index;
    }
}
 