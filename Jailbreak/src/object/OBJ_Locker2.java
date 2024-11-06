package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Locker2 extends SuperObject{
    public OBJ_Locker2(){
        name = "Locker2";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/locker.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
