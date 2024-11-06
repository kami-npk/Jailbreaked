package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_keyboxreal extends SuperObject{
    public OBJ_keyboxreal(){
        name = "keybox";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/keybox.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
    }
}