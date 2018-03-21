package dataStructures.linkedList.SingleLinkedList;

public class MyLinkedList {

    private Node head;
    private Node last;
    private int listLength;

    public int getLength() {
        return listLength;
    }

    public Node getHead() {
        return head;
    }

    public Node getLast() {
        return last;
    }

    public void add(int value) {
        Node newNode = new Node(value, null);
        listLength++;

        if (head==null) {
            head = newNode;
            last = newNode;
        } else {
            last.setLink(newNode);
            last = newNode;
        }
    }

    public void add(int index, int value) {

        if (index<0 || index > listLength) throw new IndexOutOfBoundsException();

        Node temp;
        Node newNode = new Node(value, null);

        if (index == 0) {
            temp = head;
            head = newNode;
            newNode.setLink(temp);
        } else {
            int pos = index - 1;
            Node currentNode = head;

            for (int i = 0; i < listLength; i++) {
                if (i == pos) {
                    temp = currentNode.getLink();
                    currentNode.setLink(newNode);
                    newNode.setLink(temp);
                    break;
                }
                currentNode = currentNode.getLink();
            }
        }
        listLength++;
    }

    public void remove(int index) {
        if (index<0 || index >= listLength) throw new IndexOutOfBoundsException();

        Node temp;
        Node nextTemp;

        if (index==0) {
            temp = head.getLink();
            head = temp;
        } else {
            temp = head;
            int pos = index-1;
            for(int i=0;i<listLength;i++){
                if (i==pos){
                    nextTemp = temp.getLink();
                    temp.setLink(nextTemp.getLink());
                    break;
                }
                temp = temp.getLink();
            }
        }
        listLength--;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (listLength == 0) {
            sb.append("MyLinkedList is empty");
        } else if (listLength == 1){
            sb.append(" " + head.getInfo());
        } else if (listLength > 1){
            sb.append(" " + head.getInfo());
            Node currentNode = head.getLink();

            while(currentNode.getLink()!=null){
                sb.append(" " + currentNode.getInfo());
                currentNode = currentNode.getLink();
            }
            sb.append(" " + currentNode.getInfo());
        }
        return sb.toString();
    }
}
