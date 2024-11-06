package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Locker3 extends SuperObject{
    public OBJ_Locker3(){
        name = "Locker3";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/locker.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
