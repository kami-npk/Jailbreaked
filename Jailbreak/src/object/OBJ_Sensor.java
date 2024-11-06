package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_Sensor extends SuperObject{
    public OBJ_Sensor(){
        name = "sensor";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/Sensor.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
