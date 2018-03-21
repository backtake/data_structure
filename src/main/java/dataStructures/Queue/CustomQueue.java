package dataStructures.Queue;

public class CustomQueue {

    private Node firstNode;
    private Node lastNode;
    private int size;

    public Node getFirstNode() {
        return firstNode;
    }

    public Node getLastNode() {
        return lastNode;
    }

    public int getSize() {
        return size;
    }

    public void setFirstNode(Node firstNode) {
        this.firstNode = firstNode;
    }

    public void setLastNode(Node lastNode) {
        this.lastNode = lastNode;
    }

    public void enqueue(String value, int priority){
        Node newNode = new Node(value, priority);
        Node temp = lastNode;
        Node currentNode = null;
        size++;

        if (firstNode == null) {
            firstNode = newNode;
            lastNode = newNode;

        } else if (firstNode != null && firstNode.getPriority()>newNode.getPriority()) {
            firstNode.setPreviousNode(newNode);
            newNode.setNextNode(firstNode);
            firstNode = newNode;

        } else if (lastNode.getPriority()<=newNode.getPriority()) {
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
            lastNode = newNode;

        } else {
            while (newNode.getPriority()<temp.getPriority() && temp.getPreviousNode() != null) {
                currentNode = temp;
                temp = temp.getPreviousNode();
            }
            temp.setNextNode(newNode);
            newNode.setPreviousNode(temp);
            newNode.setNextNode(currentNode);
            currentNode.setPreviousNode(newNode);
        }
    }

    public String peek(){
        if (firstNode==null) {
            throw new IndexOutOfBoundsException("There is nothing to peek at!");
        }
        return firstNode.getValue();
    }

    public String dequeue(){
        if (firstNode==null) {
            throw new IndexOutOfBoundsException("There is nothing to remove!");
        }
        Node temp = firstNode.getNextNode();
        Node nodeToRemove = firstNode;
        firstNode = temp;
        size--;
        return nodeToRemove.getValue();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node temp = firstNode;
        for (int i=0; i<size;i++){
            sb.append(" " + temp.getValue());
            temp = temp.getNextNode();
        }
        return sb.toString();
    }
}
