package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_keybox extends SuperObject{
    public OBJ_keybox(){
        name = "box";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/keybox.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
    }
}