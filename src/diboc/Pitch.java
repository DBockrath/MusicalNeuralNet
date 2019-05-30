package diboc;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Pitch extends Vector<Double> {

    private Pitches pitches;
    private Clip clip;
    private AudioInputStream audioInputStream;

    public Pitch(Pitches pitches) {

        super(88);
        this.pitches = pitches;
        buildSuper();

        try {

            File file = new File("src/PianoPitches/Piano.ff." + pitches.name() + ".aiff");
            clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, AudioSystem.getAudioInputStream(file).getFormat()));
            audioInputStream = AudioSystem.getAudioInputStream(file);

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

    private void buildSuper() {

        int index = 0;
        switch (pitches) {

            case Bb0:
                index = 1;
                break;

            case B0:
                index = 2;
                break;

            /*
             * First Octave
             */

            case C1:
                index = 3;
                break;

            case Db1:
                index = 4;
                break;

            case D1:
                index = 5;
                break;

            case Eb1:
                index = 6;
                break;

            case E1:
                index = 7;
                break;

            case F1:
                index = 8;
                break;

            case Gb1:
                index = 9;
                break;

            case G1:
                index = 10;
                break;

            case Ab1:
                index = 11;
                break;

            case A1:
                index = 12;
                break;

            case Bb1:
                index = 13;
                break;

            case B1:
                index = 14;
                break;

            /*
             * Second Octave
             */

            case C2:
                index = 15;
                break;

            case Db2:
                index = 16;
                break;

            case D2:
                index = 17;
                break;

            case Eb2:
                index = 18;
                break;

            case E2:
                index = 19;
                break;

            case F2:
                index = 20;
                break;

            case Gb2:
                index = 21;
                break;

            case G2:
                index = 22;
                break;

            case Ab2:
                index = 23;
                break;

            case A2:
                index = 24;
                break;

            case Bb2:
                index = 25;
                break;

            case B2:
                index = 26;
                break;

            /*
             * Third Octave
             */

            case C3:
                index = 27;
                break;

            case Db3:
                index = 28;
                break;

            case D3:
                index = 29;
                break;

            case Eb3:
                index = 30;
                break;

            case E3:
                index = 31;
                break;

            case F3:
                index = 32;
                break;

            case Gb3:
                index = 33;
                break;

            case G3:
                index = 34;
                break;

            case Ab3:
                index = 35;
                break;

            case A3:
                index = 36;
                break;

            case Bb3:
                index = 37;
                break;

            case B3:
                index = 38;
                break;

            /*
             * Fourth Octave
             */

            case C4:
                index = 39;
                break;

            case Db4:
                index = 40;
                break;

            case D4:
                index = 41;
                break;

            case Eb4:
                index = 42;
                break;

            case E4:
                index = 43;
                break;

            case F4:
                index = 44;
                break;

            case Gb4:
                index = 45;
                break;

            case G4:
                index = 46;
                break;

            case Ab4:
                index = 47;
                break;

            case A4:
                index = 48;
                break;

            case Bb4:
                index = 49;
                break;

            case B4:
                index = 50;
                break;

            /*
             * Fifth Octave
             */

            case C5:
                index = 51;
                break;

            case Db5:
                index = 52;
                break;

            case D5:
                index = 53;
                break;

            case Eb5:
                index = 54;
                break;

            case E5:
                index = 55;
                break;

            case F5:
                index = 56;
                break;

            case Gb5:
                index = 57;
                break;

            case G5:
                index = 58;
                break;

            case Ab5:
                index = 59;
                break;

            case A5:
                index = 60;
                break;

            case Bb5:
                index = 61;
                break;

            case B5:
                index = 62;
                break;

            /*
             * Sixth Octave
             */

            case C6:
                index = 63;
                break;

            case Db6:
                index = 64;
                break;

            case D6:
                index = 65;
                break;

            case Eb6:
                index = 66;
                break;

            case E6:
                index = 67;
                break;

            case F6:
                index = 68;
                break;

            case Gb6:
                index = 69;
                break;

            case G6:
                index = 70;
                break;

            case Ab6:
                index = 71;
                break;

            case A6:
                index = 72;
                break;

            case Bb6:
                index = 73;
                break;

            case B6:
                index = 74;
                break;

            /*
             * Seventh Octave
             */

            case C7:
                index = 75;
                break;

            case Db7:
                index = 76;
                break;

            case D7:
                index = 77;
                break;

            case Eb7:
                index = 78;
                break;

            case E7:
                index = 79;
                break;

            case F7:
                index = 80;
                break;

            case Gb7:
                index = 81;
                break;

            case G7:
                index = 82;
                break;

            case Ab7:
                index = 83;
                break;

            case A7:
                index = 84;
                break;

            case Bb7:
                index = 85;
                break;

            case B7:
                index = 86;
                break;

            case C8:
                index = 87;
                break;

        }

        for (int i = 0; i < 88; i++)
            super.add(0.0);

        for (int i = 0; i < super.size(); i++) {

            if (i == index)
                super.set(i, 1.0);

        }

    }

}
