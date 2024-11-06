package jailbreak;

import object.OBJ_BED;
import object.OBJ_BLACK;
import object.OBJ_BLACKdown;
import object.OBJ_BLUE;
import object.OBJ_BLUEdown;
import object.OBJ_GREEN;
import object.OBJ_GREENdown;
import object.OBJ_KEY;
import object.OBJ_Locker;
import object.OBJ_Locker1;
import object.OBJ_Locker2;
import object.OBJ_Locker3;
import object.OBJ_Locker4;
import object.OBJ_RED;
import object.OBJ_REDdown;
import object.OBJ_Sensor;
import object.OBJ_chest;
import object.OBJ_clip;
import object.OBJ_coder;
import object.OBJ_door;
import object.OBJ_keybox;
import object.OBJ_keyboxreal;

public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp = gp;
    }
    
    public void setObject(){
        gp.obj[0] = new OBJ_clip();
        gp.obj[0].x = 1*gp.tileSize;
        gp.obj[0].y = 8*gp.tileSize;
        
        gp.obj[1] = new OBJ_door();
        gp.obj[1].x = 5*gp.tileSize;
        gp.obj[1].y = 7*gp.tileSize;
        
        gp.obj[2] = new OBJ_keybox();
        gp.obj[2].x = 1*gp.tileSize;
        gp.obj[2].y = 6*gp.tileSize;
        
        gp.obj[25] = new OBJ_keybox();
        gp.obj[25].x = 8*gp.tileSize;
        gp.obj[25].y = 9*gp.tileSize;
        
        gp.obj[26] = new OBJ_keybox();
        gp.obj[26].x = 12*gp.tileSize;
        gp.obj[26].y = 14*gp.tileSize;
        
        /*gp.obj[27] = new OBJ_keybox();
        gp.obj[27].x = 18*gp.tileSize;
        gp.obj[27].y = 8*gp.tileSize;*/
            
        gp.obj[3] = new OBJ_keyboxreal();
        gp.obj[3].x = 8*gp.tileSize;
        gp.obj[3].y = 14*gp.tileSize;
        
        gp.obj[4] = new OBJ_coder();
        gp.obj[4].x = 19*gp.tileSize;
        gp.obj[4].y = 12*gp.tileSize;
        
        gp.obj[5] = new OBJ_chest();
        gp.obj[5].x = 1*gp.tileSize;    
        gp.obj[5].y = 1*gp.tileSize;
        
        gp.obj[9] = new OBJ_Sensor();
        gp.obj[9].x = 13*gp.tileSize;    
        gp.obj[9].y = 0*gp.tileSize;
        
        gp.obj[10] = new OBJ_Locker();
        gp.obj[10].x = 19*gp.tileSize;    
        gp.obj[10].y = 1*gp.tileSize;
        
        gp.obj[11] = new OBJ_Locker1();
        gp.obj[11].x = 19*gp.tileSize;    
        gp.obj[11].y = 2*gp.tileSize;
        
        gp.obj[12] = new OBJ_Locker2();
        gp.obj[12].x = 19*gp.tileSize;    
        gp.obj[12].y = 3*gp.tileSize;
        
        gp.obj[13] = new OBJ_Locker3();
        gp.obj[13].x = 19*gp.tileSize;    
        gp.obj[13].y = 4*gp.tileSize;
        
        gp.obj[14] = new OBJ_Locker4();
        gp.obj[14].x = 19*gp.tileSize;    
        gp.obj[14].y = 5*gp.tileSize;
        
        gp.obj[15] = new OBJ_BED();
        gp.obj[15].x = 1*gp.tileSize;    
        gp.obj[15].y = 14*gp.tileSize;
        
        gp.obj[17] = new OBJ_RED();////////////////////////////////////////////////////////////////////////////
        gp.obj[17].x = 8*gp.tileSize;    
        gp.obj[17].y = 3*gp.tileSize;
        
        gp.obj[18] = new OBJ_REDdown();
        gp.obj[18].x = 8*gp.tileSize;    
        gp.obj[18].y = 5*gp.tileSize;
        
        gp.obj[19] = new OBJ_GREEN();
        gp.obj[19].x = 10*gp.tileSize;    
        gp.obj[19].y = 3*gp.tileSize;
        
        gp.obj[20] = new OBJ_GREENdown();
        gp.obj[20].x = 10*gp.tileSize;    
        gp.obj[20].y = 5*gp.tileSize;
        
        gp.obj[21] = new OBJ_BLUE();
        gp.obj[21].x = 12*gp.tileSize;    
        gp.obj[21].y = 3*gp.tileSize;
        
        gp.obj[22] = new OBJ_BLUEdown();
        gp.obj[22].x = 12*gp.tileSize;    
        gp.obj[22].y = 5*gp.tileSize;
       

        
        gp.obj[23] = new OBJ_BLACK();
        gp.obj[23].x = 14*gp.tileSize;    
        gp.obj[23].y = 3*gp.tileSize;
        
        gp.obj[24] = new OBJ_BLACKdown();
        gp.obj[24].x = 14*gp.tileSize;    
        gp.obj[24].y = 5*gp.tileSize;
    }
}
