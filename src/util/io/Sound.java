package util.io;

import window.Window;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.sound.sampled.*;

public class Sound {

    public static final Sound MENU_BGM = new Sound("/assets/audio/Player-Select.wav");
    public static final Sound STAGE_BGM = new Sound("/assets/audio/Akuma-Stage.wav");
    public static final Sound GAMEOVER_BGM = new Sound("/assets/audio/Game-Over.wav");
    public final Set<Clip> clips = Collections.synchronizedSet(new HashSet<>());

    private final AudioFormat format;
    private final byte[] bytes;
    private static float currVolume = 0;
    private float volumeF;

    public Sound(String path) {
        volumeF =  1f;
        try {
            AudioInputStream stream = AudioSystem.getAudioInputStream(new BufferedInputStream(Window.class.getResourceAsStream(path)));
            this.format = stream.getFormat();
            this.bytes = stream.readAllBytes();

            for (int i = 0; i < 4; i++) {
                this.createNewClip();
            }
        } catch (IOException | UnsupportedAudioFileException e) {
            throw new Error(e);
        }
    }

    private Clip createNewClip() {
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(this.format, this.bytes, 0, this.bytes.length);
            clips.add(clip);
            return clip;
        } catch (LineUnavailableException e) {
            throw new Error(e);
        }
    }

    public static final Clip[] musicClip = new Clip[1];

    public static void playMusic(Clip s){

        if(musicClip[0] != null ){
            musicClip[0].stop();
        }
        musicClip[0] = s;
        musicClip[0].setFramePosition(0);
        musicClip[0].loop(Clip.LOOP_CONTINUOUSLY);
    }

    public Clip getClip(){
        return clips.stream()
                .filter(c ->c.getFramePosition() == 0 || c.getFramePosition() == c.getFrameLength())
                .findFirst()
                .orElseGet(this::createNewClip);

    }

}