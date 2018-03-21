package dataStructures.dynamicArray;

import java.util.Arrays;

public class DynamicIntArray {

    private Object[] array;
    private int takenSlots = 0;

    public DynamicIntArray(int size){
        if (size < 0) throw new IllegalArgumentException("Cannot accept negative size");
        this.array = new Object[size];
    }

    public DynamicIntArray(){
        this.array = new Object[0];
    }

    public void add(int i) {
        int availableSlots = array.length;

        if (availableSlots - takenSlots == 0) {
            increaseList();
        }
        this.array[takenSlots++] = i;
    }

    public void remove(int index) {

        if ((index > this.array.length-1) || (index < 0)) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            if (index < this.array.length-1) {
                for (int i = index; i < this.array.length - 1; i++) {
                    this.array[i] = this.array[i + 1];
                }
            }
            decreaseList();
        }
    }

    public void insert(int index, int element) {
        Object temp;

        if (index > this.array.length || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            increaseList();
            for (int i = this.array.length-1; i > index; i--){
                temp = this.array[i];
                this.array[i] = this.array[i-1];
                this.array[i-1] = temp;
            }
            this.array[index] = element;
        }
    }

    public Object[] getArray() {
        return array;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Object elem: array) {
            sb.append(" " + elem);
        }
        return sb.toString();
    }

    private void increaseList() {
        array = Arrays.copyOf(this.array, array.length+1);
    }

    private void decreaseList() {
        array = Arrays.copyOf(this.array, array.length-1);
    }
}
