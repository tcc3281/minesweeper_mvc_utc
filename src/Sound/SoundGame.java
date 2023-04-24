package Sound;

import javax.sound.sampled.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SoundGame {
    private final String lose=".\\sound\\lose.wav";
    private final String win=".\\sound\\win.wav";
    private Map<String,Clip> mp;
    public SoundGame() {
        mp=new HashMap<>();
        try {
            this.addSound(lose,"Lose");
            this.addSound(win,"Win");
        }catch (Exception e){
            System.out.println("Er");
        }

    }
    public void addSound(String s, String name){
        Clip clip;
        try {
            File file=new File(s);
            AudioInputStream sound=AudioSystem.getAudioInputStream(file);
            clip=AudioSystem.getClip();
            clip.open(sound);
            mp.put(name,clip);
        }catch (Exception e){

        }
    }
    public void soundWin(){
        String s="Win";
        mp.get(s).setFramePosition(0);
        mp.get(s).start();
    }
    public void soundLose(){
        String s="Lose";
        mp.get(s).setFramePosition(0);
        mp.get(s).start();
    }
    public void close(){

    }
}
