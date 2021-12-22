package com.example.aproj.SoundThreads;

import java.io.File;
import javax.sound.sampled.*;

public class TaskSuccessSound implements Runnable{

    public void playTrack(){
        try {
            File file = new File("src/main/resources/com/example/aproj/Sounds/successSound.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            DataLine.Info info = new DataLine.Info(Clip.class, audioInputStream.getFormat());
            Clip clip = (Clip)AudioSystem.getLine(info);
            clip.open(audioInputStream);
            clip.start();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
        playTrack();
    }
}

