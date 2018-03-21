package dataStructures.linkedList.DoubleLinkedList;

public class MyLinkedList {

    private Node head;
    private Node last;
    private int listLength;

    public Node getHead() {
        return head;
    }

    public Node getLast() {
        return last;
    }

    public int getListLength() {
        return listLength;
    }

    public void add(int value) {
        Node newNode = new Node(value, null, null);
        listLength++;

        if (head==null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNextLink(newNode);
            newNode.setPreviousLink(last);
            last = newNode;
        }
    }

    public void add(int index, int value) {
        if (index<0 || index > listLength) throw new IndexOutOfBoundsException();

        Node temp;
        Node newNode = new Node(value, null, null);

        if (index == 0) {
            temp = head;
            head = newNode;
            newNode.setNextLink(temp);
            temp.setPreviousLink(newNode);

        } else if (index == listLength) {
            last.setNextLink(newNode);
            newNode.setPreviousLink(last);
            last = newNode;

        } else {
            int pos = index-1;
            Node currentNode = head;

            for (int i=0;i<listLength;i++) {
                if (i==pos) {
                    temp = currentNode.getNextLink();
                    currentNode.setNextLink(newNode);
                    newNode.setNextLink(temp);
                    newNode.setPreviousLink(currentNode);
                    temp.setPreviousLink(newNode);
                    break;
                }
                currentNode = currentNode.getNextLink();
            }
        }
        listLength++;
    }

    public void remove(int index) {
        if (index<0 || index >= listLength) throw new IndexOutOfBoundsException();

        Node temp;

        if (index == 0) {
            temp = head.getNextLink();
            head = temp;
        } else if (index == listLength-1) {
            temp = last.getPreviousLink();
            temp.setNextLink(null);
            last = temp;
        } else {
            Node currentNode = head;
            int pos = index - 1;
            Node nextTemp;

            for (int i=0;i<listLength;i++) {
                if (i==pos) {
                    temp = currentNode.getNextLink();
                    nextTemp = temp.getNextLink();
                    currentNode.setNextLink(nextTemp);
                    nextTemp.setPreviousLink(currentNode);
                    break;
                }
                currentNode = currentNode.getNextLink();
            }
        }
        listLength--;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();

        if (listLength == 0) {
            sb.append("MyLinkedList is empty");
        } else if (listLength == 1){
            sb.append(" " + head.getInfo());
        } else if (listLength > 1){
            sb.append(" " + head.getInfo());
            Node currentNode = head.getNextLink();

            while(currentNode.getNextLink()!=null){
                sb.append(" " + currentNode.getInfo());
                currentNode = currentNode.getNextLink();
            }
            sb.append(" " + currentNode.getInfo());
        }
        return sb.toString();
    }
}
