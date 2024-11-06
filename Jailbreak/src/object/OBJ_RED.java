package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_RED extends SuperObject{
    public OBJ_RED(){
        name = "red";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/red.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
