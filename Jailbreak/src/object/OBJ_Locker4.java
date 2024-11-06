package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Locker4 extends SuperObject{
    public OBJ_Locker4(){
        name = "Locker4";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/locker.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
