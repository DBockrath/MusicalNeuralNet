package diboc;

import java.util.ArrayList;
import java.util.Vector;

public class Network {

    private Vector<Double> input;
    private LSTMNode firstNode;
    ArrayList<LSTMNode> hiddenLayer;

    // TODO: Make the constructor not take a parameter.

    public Network(Vector<Double> input) {

        this.input = input;
        hiddenLayer = new ArrayList<>();

        firstNode = new LSTMNode(null, input.get(0), null);
        hiddenLayer.add(firstNode);

        int i = 1;
        LSTMNode current = firstNode;
        while (i < input.size()) {

            current.setNext(new LSTMNode(firstNode, input.get(i), null));
            i++;
            hiddenLayer.add(current);
            current = current.getNext();

        }

        firstNode.setPrevious(current);

    }

    public Vector<Double> getOutput(Vector<Double> input) {

        return null;

    }

}