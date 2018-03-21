package dataStructures.Queue;

public class Node {

    private String value;
    private Node nextNode;
    private Node previousNode;
    private int priority;

    public Node(String value, int priority){
        this.value=value;
        this.priority=priority;
    }

    public String getValue() {
        return value;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node node) {
        this.nextNode = node;
    }

    public Node getPreviousNode() {
        return previousNode;
    }

    public void setPreviousNode(Node previousNode) {
        this.previousNode = previousNode;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
