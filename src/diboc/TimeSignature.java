package diboc;

public class TimeSignature {

    private int beatsPerMinute;
    private int beatsPerMeasure;
    private Length getsTheBeat;

    /*
     * Constructor
     */

    public TimeSignature(int beatsPerMinute, int beatsPerMeasure, Length getsTheBeat) {

        this.beatsPerMinute = beatsPerMinute;
        this.beatsPerMeasure = beatsPerMeasure;
        this.getsTheBeat = getsTheBeat;

    }

    /*
     * Getters
     */

    public int getBeatsPerMinute() {

        return beatsPerMinute;

    }

    public int getBeatsPerMeasure() {

        return beatsPerMeasure;

    }

    public Length getGetsTheBeat() {

        return getsTheBeat;

    }

    /*
     * Setters
     */

    public void setBeatsPerMinute(int beatsPerMinute) {

        this.beatsPerMinute = beatsPerMinute;

    }

    public void setBeatsPerMeasure(int beatsPerMeasure) {

        this.beatsPerMeasure = beatsPerMeasure;

    }

    public void setGetsTheBeat(Length getsTheBeat) {

        this.getsTheBeat = getsTheBeat;

    }

}
