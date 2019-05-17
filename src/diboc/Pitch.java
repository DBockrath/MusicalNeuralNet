package diboc;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Pitch {

    private Pitches pitches;
    private Clip clip;
    private AudioInputStream audioInputStream;

    public Pitch(Pitches pitches) {

        this.pitches = pitches;

        try {

            clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, AudioSystem.getAudioInputStream(new File("\\src\\diboc\\PianoPitches\\Piano.ff." + pitches.name() + ".aiff")).getFormat()));
            audioInputStream = AudioSystem.getAudioInputStream(new File("\\src\\diboc\\PianoPitches\\Piano.ff." + pitches.name() + ".aiff"));

        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException e) {

            e.printStackTrace();

        }

    }

    public void play() {

        try {

            clip.open(audioInputStream);

        } catch (LineUnavailableException | IOException e) {

            e.printStackTrace();

        }

        clip.setFramePosition(0);
        clip.start();

    }

    public void stop() {

        clip.stop();
        clip.close();

    }

    public Pitches getPitchEnum() {

        return pitches;

    }

}
