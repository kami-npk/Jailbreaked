package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_BED extends SuperObject{
    public OBJ_BED(){
        name = "BED";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Bed1.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
