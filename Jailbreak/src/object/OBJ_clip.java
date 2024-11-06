package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_clip extends SuperObject{
    public OBJ_clip(){
        name = "clipkey";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/clip.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
