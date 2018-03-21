package dataStructures.Queue;

public class Program {

    public static void main(String[] args) {

        CustomQueue customQueue = new CustomQueue();
        customQueue.enqueue("A",1);
//        customQueue.enqueue("B",1);
//        customQueue.enqueue("C",3);
        System.out.println(customQueue.toString());
        customQueue.enqueue("X",0);
        System.out.println(customQueue.toString());
        customQueue.enqueue("Z",2);
        System.out.println(customQueue.toString());
        System.out.println(customQueue.dequeue());
        System.out.println(customQueue.toString());
    }
}
