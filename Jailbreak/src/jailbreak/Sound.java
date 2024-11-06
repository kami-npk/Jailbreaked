
package jailbreak;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;


public class Sound {
    Clip clip;
    URL soundURL[] = new URL[10];
    private FloatControl volumeControl;
    
    public Sound(){
        soundURL[0] = getClass().getResource("/sound/Paper Sound Effect.wav");
        soundURL[1] = getClass().getResource("/sound/Whoosh sound effect.wav");
        soundURL[2] = getClass().getResource("/sound/metaldoor.wav");
        soundURL[3] = getClass().getResource("/sound/Kevin MacLeod_ 8bit Dungeon Level.wav");
        soundURL[4] = getClass().getResource("/sound/Correct .wav");
        soundURL[5] = getClass().getResource("/sound/Wrong .wav");
        soundURL[6] = getClass().getResource("/sound/Openchest.wav");
        soundURL[7] = getClass().getResource("/sound/button.wav");
        
    }
    public void setFile(int i){
        try{
            AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(ais);
            
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.VOLUME);
        }catch(Exception e){
            
        }
    }
    public void play(){
        clip.start();
    }
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){ 
        clip.stop();
        
    }
    public void setVolume(float volume){
        if (volumeControl != null) {
            // Convert volume to decibels
            float min = volumeControl.getMinimum();
            float max = volumeControl.getMaximum();
            float dB = min + (max - min) * volume;
            volumeControl.setValue(dB);
            
        }
    }
    

}
