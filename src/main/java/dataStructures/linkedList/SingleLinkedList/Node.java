package dataStructures.linkedList.SingleLinkedList;

public class Node {

    private int info;
    private Node linkToNextNode;

    public Node(){
    }

    public Node(int data, Node link) {
        this.info = data;
        this.linkToNextNode = link;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int data) {
        this.info = data;
    }

    public Node getLink() {
        return linkToNextNode;
    }

    public void setLink(Node link) {
        this.linkToNextNode = link;
    }
}
