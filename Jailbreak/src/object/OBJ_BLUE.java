package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_BLUE extends SuperObject{
    public OBJ_BLUE(){
        name = "blue";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/BLUE.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
