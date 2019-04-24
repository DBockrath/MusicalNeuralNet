package diboc;

public class Node {

    private Node previous;
    private Node next;

    public Node(Node previous, Node next) {

        this.previous = previous;
        this.next = next;

    }

    public Object outputState() {

        return previous.outputState();

    }

    public Object output(Object input) {

        return input;

    }

}