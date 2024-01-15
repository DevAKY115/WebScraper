package org.example;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SoundPlayer {

    public static void alarm(){

        {
            try {
                InputStream inputStream = SoundPlayer.class.getResourceAsStream("/alarm.mp3");
                Player player = new Player(inputStream);
                player.play();
            } catch (JavaLayerException e) {
                System.err.println("Error playing the MP3 file");
            }
        }
    }


}
