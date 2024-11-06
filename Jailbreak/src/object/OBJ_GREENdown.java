package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_GREENdown extends SuperObject{
    public OBJ_GREENdown(){
        name = "green";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/GREEN.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
