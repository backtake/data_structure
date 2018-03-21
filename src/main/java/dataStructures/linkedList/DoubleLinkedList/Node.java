package dataStructures.linkedList.DoubleLinkedList;

public class Node {

    private Node previousLink;
    private Node nextLink;
    private int info;

    public Node(){
    }

    public Node(int data, Node previousLink, Node nextLink) {
        this.info = data;
        this.previousLink = previousLink;
        this.nextLink = nextLink;
    }

    public Node getPreviousLink() {
        return previousLink;
    }

    public void setPreviousLink(Node previousLink) {
        this.previousLink = previousLink;
    }

    public Node getNextLink() {
        return nextLink;
    }

    public void setNextLink(Node nextLink) {
        this.nextLink = nextLink;
    }

    public int getInfo() {
        return info;
    }

    public void setInfo(int info) {
        this.info = info;
    }

    public String toString(){
        return " " + String.valueOf(info);
    }
}
