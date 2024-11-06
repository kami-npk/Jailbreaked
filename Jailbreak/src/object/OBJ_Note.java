package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Note extends SuperObject{
    public OBJ_Note(){
        name = "note";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Note.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
