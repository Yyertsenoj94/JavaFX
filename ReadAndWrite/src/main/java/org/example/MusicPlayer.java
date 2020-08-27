package org.example;



import javax.sound.sampled.*;
import java.io.IOException;
import java.net.URL;

public class MusicPlayer {

    private boolean play = true;
    private Clip clip;

    public MusicPlayer(){

    }

    public synchronized void playSong(){
        while(!play){
            try{
                System.out.println(Thread.currentThread() + ": I am going into a waiting state because I cannot play");
                wait();
            }catch (InterruptedException e){

            }
        }
        System.out.println(Thread.currentThread() + ": I am now allowed to play, and I will continue playing my song");
        play = false;
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        System.out.println(Thread.currentThread() + ": I AM RELEASING CONTROL");
        notify();
    }

    public synchronized void pause(){
        System.out.println(Thread.currentThread() + ":  I have control now and I am pausing the player");
        clip.stop();
    }

    public synchronized void resume(){
        System.out.println(Thread.currentThread() + ": I still have control, and I am now notifying the player to resume playing");
        play = true;
        notify();
    }

    public synchronized void setSong(String name){
        System.out.println(Thread.currentThread() + ": I am changing the song");
        URL file = getClass().getResource("/" + name + ".wav");
        try (AudioInputStream as = AudioSystem.getAudioInputStream(file)) {
            clip = AudioSystem.getClip();
            clip.open(as);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
