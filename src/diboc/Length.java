package diboc;

public enum Length {

    WHOLE(4), DOTTED_HALF(3), HALF(2), DOTTED_QUARTER(1.5), QUARTER(1), EIGTH(.5), SIXTEENTH(.25), THIRTYSECOND(.125);

    private double length;

    Length(double length) {

        this.length = length;

    }

    public double getLength() {

        return length;

    }

}
