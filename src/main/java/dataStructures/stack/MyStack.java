package dataStructures.stack;

public class MyStack<T> {

    private T[] array;
    private int firstAvailableSlot;

    public MyStack(int size){
        array = (T[])new Object[size];
        firstAvailableSlot = 0;
    }

    public void push(T obj) {
        if (firstAvailableSlot>=array.length) {
            throw new StackOverflowError("Cant push nothing more in, no space left.");
        } else {
            array[firstAvailableSlot] = obj;
            firstAvailableSlot++;
        }
    }

    public T pop() {
        if (firstAvailableSlot<=0) {
            throw new IndexOutOfBoundsException("Cant pop when theres nothing left to poop.");
        } else {
            T popElement = array[firstAvailableSlot-1];
            firstAvailableSlot--;
            return popElement;
        }
    }

    public T peek() {
        if (firstAvailableSlot<=0) {
            throw new IndexOutOfBoundsException("Theres nothing to peek at yet.");
        }
        return array[firstAvailableSlot-1];
    }

    public int getFreeSlotsAmount(){
        return array.length - firstAvailableSlot;
    }

    public int getActualStackSize() {
        return firstAvailableSlot;
    }

    public int getMaxStackSize(){
        return array.length;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i=firstAvailableSlot-1;i>=0;i--) {
            sb.append(" " + array[i]);
        }
        return sb.toString();
    }
}
