package diboc;

public class Node {

    private Node previous;
    private Node next;

    public Node(Node previous, Node next) {

        this.previous = previous;
        this.next = next;

    }

    public double outputState() {

        return previous.outputState() * sigmoid(previous.output());

    }

    public double output() {

        return previous.output();

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