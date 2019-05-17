package diboc;

public class TimeSignature {

    private int beatsPerMinute;
    private int beatsPerMeasure;
    private Length beat;

    /*
     * Constructor
     */

    public TimeSignature(int beatsPerMinute, int beatsPerMeasure, Length beat) {

        this.beatsPerMinute = beatsPerMinute;
        this.beatsPerMeasure = beatsPerMeasure;
        this.beat = beat;

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

    public Length getBeat() {

        return beat;

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

    public void setBeat(Length beat) {

        this.beat = beat;

    }

}
