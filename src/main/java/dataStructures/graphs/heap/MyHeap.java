package dataStructures.graphs.heap;

import java.util.Arrays;

public class MyHeap {

    private int capacity;
    private int takenSlots;
    private int[] items;

    public MyHeap(int size){
        if (size < 0) throw new IllegalArgumentException("Cannot accept negative size");
        this.capacity = size;
        this.items = new int[capacity];
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2*parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2*parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return  (childIndex - 1)/2;
    }

    private int getLeftChild(int index){
        return items[getLeftChildIndex(index)];
    }

    private int getRightChild(int index){
        return items[getRightChildIndex(index)];
    }

    private int getParent(int index){
        return items[getParentIndex(index)];
    }

    private void swap(int index1, int index2) {
        int temp = items[index1];
        items[index1] = items[index2];
        items[index2] = temp;
    }

    public int peek() {
        if (takenSlots==0) throw new IndexOutOfBoundsException("There is nothing to peek at.");
        return items[0];
    }

    public int poll() {
        if (takenSlots==0) throw new IndexOutOfBoundsException("There is nothing to poll.");
        int item = items[0];
        items[0] = items[takenSlots - 1];
        decreaseCapacity();
        takenSlots--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        if(takenSlots==capacity){
            increaseCapacity();
        }
        items[takenSlots] = item;
        takenSlots++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = takenSlots - 1;
        while (getParentIndex(index) >= 0 && getParent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while (getLeftChildIndex(index) < takenSlots) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (getRightChildIndex(index) < takenSlots && getRightChild(index) < getLeftChild(index)){
                smallerChildIndex = getRightChildIndex(index);
            }
            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int item: items) {
            sb.append(" " + item);
        }
        return sb.toString();
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTakenSlots() {
        return takenSlots;
    }

    public int[] getItems() {
        return items;
    }

    private void increaseCapacity() {
        items = Arrays.copyOf(items, items.length+1);
        capacity++;
    }

    private void decreaseCapacity() {
        items = Arrays.copyOf(items, items.length-1);
    }
}
