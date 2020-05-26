package org.example;

public class Player implements Runnable{
    MusicPlayer player;

    public Player(MusicPlayer player){
        this.player = player;
    }

    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread());
            player.playSong();
        }


    }


}
