package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Locker extends SuperObject{
    public OBJ_Locker(){
        name = "Locker";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/locker.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
