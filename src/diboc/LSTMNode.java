package diboc;

public class LSTMNode {

    private LSTMNode previous;
    private LSTMNode next;

    private double input;
    private double state;
    private double weight;
    private double bias;

    public LSTMNode(LSTMNode previous, double input, LSTMNode next) {

        this.previous = previous;
        this.next = next;
        this.input = previous.output() + input;
        state = previous.outputState();

    }

    public double output() {

        return input;

    }

    public LSTMNode getPrevious() {

        return previous;

    }

    public LSTMNode getNext() {

        return next;

    }

    public void setPrevious(LSTMNode previous) {

        this.previous = previous;

    }

    public void setNext(LSTMNode next) {

        this.next = next;

    }

    private double outputState() {

        return state;

    }

    private double inputGate() {

        return 0;

    }

    private double forgetGate() {

        return 0;

    }

    private double outputGate() {

        return 0;

    }

    private double sigmoid(double x) {

        return Math.pow(Math.E, x) / (Math.pow(Math.E, x) + 1);

    }

    private double tanh(double x) {

        return (Math.pow(Math.E, x) - Math.pow(Math.E, (-1 * x))) / (Math.pow(Math.E, x) + Math.pow(Math.E, (-1 * x)));

    }

}