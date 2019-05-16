package diboc;

import java.util.Vector;

public class LSTMNode {

    private LSTMNode previous;
    private LSTMNode next;

    private Vector<Double> input;
    private Vector<Double> state;
    private double weight;
    private double bias;

    public LSTMNode(LSTMNode previous, Vector<Double> input, LSTMNode next) {

        this.previous = previous;
        this.next = next;
        state = previous.outputState();
        
//        try {
//
//            this.input = add(previous.output(), input);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//        }

    }
    
    public LSTMNode(LSTMNode previous, LSTMNode next) {
        
        this.previous = previous;
        this.next = next;
        
    }
    
    public Vector<Double> getInput() {
        
        return input;
        
    }

    public LSTMNode getPrevious() {

        return previous;

    }

    public LSTMNode getNext() {

        return next;

    }
    
    public void setInput(Vector<Double> input) {
        
        this.input = input;
        
    }

    public void setPrevious(LSTMNode previous) {

        this.previous = previous;

    }

    public void setNext(LSTMNode next) {

        this.next = next;

    }
    
    public Note output() {

        return null;

    }

    private Vector<Double> outputState() {

        return state;

    }

    private Vector<Double> inputGate() {

        return null;

    }

    private Vector<Double> forgetGate() {

        return null;

    }

    private Vector<Double> outputGate() {

        return null;

    }
    
    private Vector<Double> add(Vector<Double> x, Vector<Double> y) throws Exception {
        
        if (x.size() != y.size())
            throw new Exception("Vectors must be the same size to add.");
        
        Vector<Double> resultant = new Vector<>(x.size());
        for (int i = 0; i < x.size(); i++)
            resultant.set(i, (x.get(i) + y.get(i)));
        
        return resultant;
        
    }
    
    private Vector<Double> multiply(Vector<Double> x, Vector<Double> y) throws Exception {
        
        if (x.size() != y.size())
            throw new Exception("Vectors must be the same size to multiply.");
        
        Vector<Double> resultant = new Vector<>(x.size());
        for (int i = 0; i < x.size(); i++)
            resultant.set(i, (x.get(i) * y.get(i)));
        
        return resultant;
        
    }

    private Vector<Double> sigmoid(Vector<Double> x) {

        Vector<Double> resultant = new Vector<>(x.size());
        for (int i = 0; i < x.size(); i++)
            resultant.set(i, (Math.pow(Math.E, x.get(i)) / (Math.pow(Math.E, x.get(i)) + 1)));
        
        return resultant;

    }

    private Vector<Double> tanh(Vector<Double> x) {
        
        Vector<Double> resultant = new Vector<>(x.size());
        for (int i = 0; i < x.size(); i++)
            resultant.set(i, ((Math.pow(Math.E, x.get(i)) - Math.pow(Math.E, (-1 * x.get(i)))) / (Math.pow(Math.E, x.get(i)) + Math.pow(Math.E, (-1 * x.get(i))))));
        
        return resultant;

    }

}
