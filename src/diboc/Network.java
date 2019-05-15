package diboc;

import java.util.ArrayList;
import java.util.Vector;

public class Network {

    private LSTMNode firstNode;
    ArrayList<LSTMNode> hiddenLayer;

    public Network(int size) {

        hiddenLayer = new ArrayList<>();

        firstNode = new LSTMNode(null, null);
        hiddenLayer.add(firstNode);

        int i = 1;
        LSTMNode current = firstNode;
        while (i < size) {

            current.setNext(new LSTMNode(firstNode, null));
            i++;
            hiddenLayer.add(current);
            current = current.getNext();

        }

        firstNode.setPrevious(current);

    }

    public Song getOutput(Genre input) throws Exception {
        
        /* TODO: Needs to turn Vector<Double> into Vector<Vector<Double>>
         * The input will be a Vector<Double representing the key of the song or the genre of the song
         * The output will be a Vector<Vector<Double>> that is essentially a song (Vector of notes)
         */
        
//        if (input.size() != hiddenLayer.size())
//            throw new Exception("Input length must match the number of hidden cells.");
//        
//        int i = 0;
//        for (LSTMNode node : hiddenLayer)
//            node.setInput(input.get(i++));
//        
//        Vector<Vector<Double>> resultant = new Vector<>(hiddenLayer.size());
//        for (int j = 0; j < hiddenLayer.size(); j++)
//            resultant.set(j, hiddenLayer.get(j).output());
//
//        return resultant;
        
        return null;

    }
    
    public Song getOutput(Key input) throws Exception {
        
        /* TODO: Needs to turn Vector<Double> into Vector<Vector<Double>>
         * The input will be a Vector<Double representing the key of the song or the genre of the song
         * The output will be a Vector<Vector<Double>> that is essentially a song (Vector of notes)
         */
        
//        if (input.size() != hiddenLayer.size())
//            throw new Exception("Input length must match the number of hidden cells.");
//        
//        int i = 0;
//        for (LSTMNode node : hiddenLayer)
//            node.setInput(input.get(i++));
//        
//        Vector<Vector<Double>> resultant = new Vector<>(hiddenLayer.size());
//        for (int j = 0; j < hiddenLayer.size(); j++)
//            resultant.set(j, hiddenLayer.get(j).output());
//
//        return resultant;
        
        return null;

    }

}
