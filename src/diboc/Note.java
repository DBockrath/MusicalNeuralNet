package diboc;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* A Note is a vector of pitch and length vectors. The order goes as follows:
 * Index 0 = Pitch
 * Index 1 = Length
 */

public class Note extends Vector<Vector<Double>> {

    /*
     * Constructors
     */

    public Note(Vector<Vector<Double>> note) throws Exception {

        if (note.size() != 2)
            throw new Exception("The parameter must have a size of 2.");

        for (Vector<Double> v : note)
            super.add(v);

    }

    public Note(Vector<Double> pitch, Vector<Double> length) {

        super.add(pitch);;
        super.add(length);

    }

    public Note(Pitch pitch, Length length) {

        super.add(pitchToVector(pitch));
        super.add(lengthToVector(length));

    }

    public Note(Pitches pitch, Length length) {

        super.add(pitchToVector(pitch));
        super.add(lengthToVector(length));

    }

    /*
     * Getters
     */

    public Pitch getPitch() {

        return vectorToPitch(super.get(0));

    }

    public Pitches getPitchEnum() {

        return vectorToPitchEnum(super.get(0));

    }

    public Vector<Double> getPitchVector() {

        return super.get(0);

    }

    public Length getLength() {

        return vectorToLength(super.get(1));

    }

    public Vector<Double> getLengthVector() {

        return super.get(1);

    }

    /*
     * Setters
     */

    public void setPitch(Pitch pitch) {

        super.set(0, pitchToVector(pitch));

    }

    public void setPitch(Pitches pitch) {

        super.set(0, pitchToVector(pitch));

    }

    public void setPitch(Vector<Double> pitch) {

        super.set(0, pitch);

    }

    public void setLength(Length length) {

        super.set(1, lengthToVector(length));

    }
    
    public void setLength(Vector<Double> length) {
        
        super.set(1, length);
        
    }

    /*
     * Playback of the Note
     */

    public void play(TimeSignature timeSignature) {

        Pitch pitch = vectorToPitch(super.get(0));

        /*
         * Use this link for help making conversions:
         *
         * https://music.stackexchange.com/questions/24140/how-can-i-find-the-length-in-seconds-of-a-quarter-note-crotchet-if-i-have-a-te
         */

        // TODO: Check this for accuracy. May not be giving the number desired.
        double numOfSeconds = ((timeSignature.getBeat().getLength() / 4) * vectorToLength(super.get(1)).getLength()) * (60 / timeSignature.getBeatsPerMinute());
        double numOfMillis = 1000 * numOfSeconds;

        pitch.play();
        double currentTime = new Date().getTime();
        double desiredTime = currentTime + numOfMillis;
        while (currentTime < desiredTime)
            currentTime = new Date().getTime();
        pitch.stop();

    }

    /*
     * For converting with vectors
     */

    private Vector<Double> pitchToVector(Pitch pitch) {

        return pitchToVector(pitch.getPitchEnum());

    }

    private Vector<Double> pitchToVector(Pitches pitch) {

        Vector<Double> resultant = new Vector<>(88);

        int index = 0;
        switch (pitch) {

            case A0:
                index = 0;
                break;

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

        for (int i = 0; i < resultant.size(); i++) {

            if (i == index)
                resultant.set(i, 1.0);

            else
                resultant.set(i, 0.0);

        }

        return resultant;

    }

    private Pitch vectorToPitch(Vector<Double> pitch) {

        int highest = 0;
        for (int i = 1; i < pitch.size(); i++) {

            if (pitch.get(highest) < pitch.get(i))
                highest = i;

        }

        switch (highest) {

            case 0:
                return new Pitch(Pitches.A0);

            case 1:
                return new Pitch(Pitches.Bb0);

            case 2:
                return new Pitch(Pitches.B0);

                /*
                 * First Octave
                 */

            case 3:
                return new Pitch(Pitches.C1);

            case 4:
                return new Pitch(Pitches.Db1);

            case 5:
                return new Pitch(Pitches.D1);

            case 6:
                return new Pitch(Pitches.Eb1);

            case 7:
                return new Pitch(Pitches.E1);

            case 8:
                return new Pitch(Pitches.F1);

            case 9:
                return new Pitch(Pitches.Gb1);

            case 10:
                return new Pitch(Pitches.G1);

            case 11:
                return new Pitch(Pitches.Ab1);

            case 12:
                return new Pitch(Pitches.A1);

            case 13:
                return new Pitch(Pitches.Bb1);

            case 14:
                return new Pitch(Pitches.B1);

                /*
                 * Second Octave
                 */

            case 15:
                return new Pitch(Pitches.C2);

            case 16:
                return new Pitch(Pitches.Db2);

            case 17:
                return new Pitch(Pitches.D2);

            case 18:
                return new Pitch(Pitches.Eb2);

            case 19:
                return new Pitch(Pitches.E2);

            case 20:
                return new Pitch(Pitches.F2);

            case 21:
                return new Pitch(Pitches.Gb2);

            case 22:
                return new Pitch(Pitches.G2);

            case 23:
                return new Pitch(Pitches.Ab2);

            case 24:
                return new Pitch(Pitches.A2);

            case 25:
                return new Pitch(Pitches.Bb2);

            case 26:
                return new Pitch(Pitches.B2);

                /*
                 * Third Octave
                 */

            case 27:
                return new Pitch(Pitches.C3);

            case 28:
                return new Pitch(Pitches.Db3);

            case 29:
                return new Pitch(Pitches.D3);

            case 30:
                return new Pitch(Pitches.Eb3);

            case 31:
                return new Pitch(Pitches.E3);

            case 32:
                return new Pitch(Pitches.F3);

            case 33:
                return new Pitch(Pitches.Gb3);

            case 34:
                return new Pitch(Pitches.G3);

            case 35:
                return new Pitch(Pitches.Ab3);

            case 36:
                return new Pitch(Pitches.A3);

            case 37:
                return new Pitch(Pitches.Bb3);

            case 38:
                return new Pitch(Pitches.B3);

                /*
                 * Fourth Octave
                 */

            case 40:
                return new Pitch(Pitches.Db4);

            case 41:
                return new Pitch(Pitches.D4);

            case 42:
                return new Pitch(Pitches.Eb4);

            case 43:
                return new Pitch(Pitches.E4);

            case 44:
                return new Pitch(Pitches.F4);

            case 45:
                return new Pitch(Pitches.Gb4);

            case 46:
                return new Pitch(Pitches.G4);

            case 47:
                return new Pitch(Pitches.Ab4);

            case 48:
                return new Pitch(Pitches.A4);

            case 49:
                return new Pitch(Pitches.Bb4);

            case 50:
                return new Pitch(Pitches.B4);

                /*
                 * Fifth Octave
                 */

            case 51:
                return new Pitch(Pitches.C5);

            case 52:
                return new Pitch(Pitches.Db5);

            case 53:
                return new Pitch(Pitches.D5);

            case 54:
                return new Pitch(Pitches.Eb5);

            case 55:
                return new Pitch(Pitches.E5);

            case 56:
                return new Pitch(Pitches.F5);

            case 57:
                return new Pitch(Pitches.Gb5);

            case 58:
                return new Pitch(Pitches.G5);

            case 59:
                return new Pitch(Pitches.Ab5);

            case 60:
                return new Pitch(Pitches.A5);

            case 61:
                return new Pitch(Pitches.Bb5);

            case 62:
                return new Pitch(Pitches.B5);

                /*
                 * Sixth Octave
                 */

            case 63:
                return new Pitch(Pitches.C6);

            case 64:
                return new Pitch(Pitches.Db6);

            case 65:
                return new Pitch(Pitches.D6);

            case 66:
                return new Pitch(Pitches.Eb6);

            case 67:
                return new Pitch(Pitches.E6);

            case 68:
                return new Pitch(Pitches.F6);

            case 69:
                return new Pitch(Pitches.Gb6);

            case 70:
                return new Pitch(Pitches.G6);

            case 71:
                return new Pitch(Pitches.Ab6);

            case 72:
                return new Pitch(Pitches.A6);

            case 73:
                return new Pitch(Pitches.Bb6);

            case 74:
                return new Pitch(Pitches.B6);

                /*
                 * Seventh Octave
                 */

            case 75:
                return new Pitch(Pitches.C7);

            case 76:
                return new Pitch(Pitches.Db7);

            case 77:
                return new Pitch(Pitches.D7);

            case 78:
                return new Pitch(Pitches.Eb7);

            case 79:
                return new Pitch(Pitches.E7);

            case 80:
                return new Pitch(Pitches.F7);

            case 81:
                return new Pitch(Pitches.Gb7);

            case 82:
                return new Pitch(Pitches.G7);

            case 83:
                return new Pitch(Pitches.Ab7);

            case 84:
                return new Pitch(Pitches.A7);

            case 85:
                return new Pitch(Pitches.Bb7);

            case 86:
                return new Pitch(Pitches.B7);

            case 87:
                return new Pitch(Pitches.C8);

            default:
                return new Pitch(Pitches.C4);

        }

    }

    private Pitches vectorToPitchEnum(Vector<Double> pitch) {

        return vectorToPitch(pitch).getPitchEnum();

    }
    
    private Vector<Double> lengthToVector(Length length) {
        
        Vector<Double> resultant = new Vector<>(6);
        
        int index = 0;
        switch (length) {

        case DOTTED_HALF:
            index = 1;
            break;

        case HALF:
            index = 2;
            break;

        case DOTTED_QUARTER:
            index = 3;
            break;

        case QUARTER:
            index = 4;
            break;
            
        case EIGTH:
            index = 5;
            break;
            
        case SIXTEENTH:
            index = 6;
            break;
            
        case THIRTYSECOND:
            index = 7;
            break;
        
        }
        
        for (int i = 0; i < resultant.size(); i++) {
            
            if (i == index)
                resultant.set(i, 1.0);
            
            else
                resultant.set(i, 0.0);
            
        }
        
        return resultant;
        
    }

    private Length vectorToLength(Vector<Double> length) {

        int highest = 0;
        for (int i = 1; i < length.size(); i++) {

            if (length.get(highest) < length.get(i))
                highest = i;

        }

        switch (highest) {

            case 0:
                return Length.WHOLE;

            case 1:
                return Length.DOTTED_HALF;

            case 2:
                return Length.HALF;

            case 3:
                return Length.DOTTED_QUARTER;

            case 5:
                return Length.EIGTH;

            case 6:
                return Length.SIXTEENTH;

            case 7:
                return Length.THIRTYSECOND;

            default:
                return Length.QUARTER;

        }

    }

}
