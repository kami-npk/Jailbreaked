package object;

import java.io.IOException;
import javax.imageio.ImageIO;


public class OBJ_GREEN extends SuperObject{
    public OBJ_GREEN(){
        name = "green";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objects/GREEN.png"));
        }catch(IOException e){
            e.printStackTrace();    
        }
        
    }
}
