package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Locker1 extends SuperObject{
    public OBJ_Locker1(){
        name = "Locker1";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/locker.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
