package object;

import java.io.IOException;
import javax.imageio.ImageIO;

public class OBJ_coder extends SuperObject{
    public OBJ_coder(){
        name = "coder";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/coderLock_1.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
    }
}