package diboc;

import java.util.Vector;

public class Note extends Vector<Vector<Double>> {

    private double octave;

    public Note(Vector<Vector<Double>> note) throws Exception {

        if (note.size() != 3)
            throw new Exception("The parameter must have a size of 3.");

        for (Vector<Double> v : note)
            super.add(v);

    }

    public Note(Vector<Double> octave, Vector<Double> pitch, Vector<Double> length) {

        super.add(octave);
        super.add(pitch);
        super.add(length);

    }

    public Length getLength() {

        return binaryToLength(super.get(2));

    }

    public void setLength(Length length) {

        super.set(2, lengthToBinary(length));

    }
    
    public void setLength(Vector<Double> length) {
        
        super.set(2, length);
        
    }
    
    private Pitch binaryToPitch(Vector<Double> pitch) {

        int highest = 0;
        for (int i = 1; i < pitch.size(); i++) {

            if (pitch.get(highest) < pitch.get(i))
                highest = i;

        }

        switch (highest) {

            case 0:
                return Pitch.C;

            case 1:
                return Pitch.Db;

            case 2:
                return Pitch.D;

            case 3:
                return Pitch.Eb;

            case 4:
                return Pitch.E;

            case 5:
                return Pitch.F;

            case 6:
                return Pitch.Gb;

            case 7:
                return Pitch.G;

            case 8:
                return Pitch.Ab;

            case 9:
                return Pitch.A;

            case 10:
                return Pitch.Bb;

            case 11:
                return Pitch.B;

            default:
                return Pitch.C;

        }

    }
    
    private Vector<Double> lengthToBinary(Length length) {
        
        Vector<Double> resultant = new Vector<>(6);
        
        int index = 0;
        switch (length) {
        
        case WHOLE:
            index = 0;
            break;
            
        case HALF:
            index = 1;
            break;
            
        case QUARTER:
            index = 2;
            break;
            
        case EIGTH:
            index = 3;
            break;
            
        case SIXTEENTH:
            index = 4;
            break;
            
        case THIRTYSECOND:
            index = 5;
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

    private Length binaryToLength(Vector<Double> length) {

        int highest = 0;
        for (int i = 1; i < length.size(); i++) {

            if (length.get(highest) < length.get(i))
                highest = i;

        }

        switch (highest) {

            case 0:
                return Length.WHOLE;

            case 1:
                return Length.HALF;

            case 2:
                return Length.QUARTER;

            case 3:
                return Length.EIGTH;

            case 4:
                return Length.SIXTEENTH;

            case 5:
                return Length.THIRTYSECOND;

            default:
                return Length.QUARTER;

        }

    }

}
