package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_BLACKdown extends SuperObject{
    public OBJ_BLACKdown(){
        name = "black";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/BLACK.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
