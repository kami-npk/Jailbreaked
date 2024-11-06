package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_BLUEdown extends SuperObject{
    public OBJ_BLUEdown(){
        name = "blue";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/BLUE.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
