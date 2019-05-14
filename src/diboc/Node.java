package diboc;

import java.util.Vector;

public class Node<T> {

    // TODO: Use vectors instead of doubles

    private Vector<T> input;
    private Vector<T> previousCellOutput;

    private double concatInput;
    private double inputWeight;
    private double previousCellOutputWeight;
    private double inputBias;

    public Node(Vector<T> previousCellOutput, Vector<T> input) {

        this.input = input;
        this.previousCellOutput = previousCellOutput;
//        concatInput = previousCellOutput + input;

    }

    private Vector<T> inputGate() {

//        return Math.tanh(inputBias + (input * inputWeight) + (previousCellOutput * previousCellOutputWeight));
        return null;

    }

    private Vector<T> forgetGate() {

        return null;

    }

    private Vector<T> outputGate() {

        return null;

    }

    public Vector<T> outputState() {

        return input;

    }

    public Vector<T> output() {

        return input;

    }

    private double sigmoid(double input) {

        return (Math.pow(Math.E, input)) /
                (1 + Math.pow(Math.E, input));

    }

    private double tanh(double input) {

        return (Math.pow(Math.E, input) - Math.pow(Math.E, (-1 * input))) /
                (Math.pow(Math.E, input) + Math.pow(Math.E, (-1 * input)));

    }

}