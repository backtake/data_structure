package dataStructures.graphs.heap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHeapTest {

    @Test
    void addTest() {
        MyHeap myHeap = createHeap();
        addNodesToHeap(myHeap);
        String result = " 1 4 2 25 17 10 9";
        assertEquals(result, myHeap.toString());
    }

    @Test
    void peekFromEmptyHeapTest() {
        MyHeap myHeap = createHeap();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myHeap.peek();
        });
    }

    @Test
    void peekTest() {
        MyHeap myHeap = createHeap();
        addNodesToHeap(myHeap);
        String result = "1";

        assertEquals(result, String.valueOf(myHeap.peek()));
    }

    @Test
    void pollFromEmptyHeapTest() {
        MyHeap myHeap = createHeap();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myHeap.poll();
        });
    }

    @Test
    void pollReturnTest() {
        MyHeap myHeap = createHeap();
        addNodesToHeap(myHeap);
        int result = 1;
        assertEquals(result, myHeap.poll());
    }

    @Test
    void pollTest() {
        MyHeap myHeap = createHeap();
        addNodesToHeap(myHeap);
        myHeap.poll();
        String result = " 2 4 9 25 17 10";

        assertEquals(result, myHeap.toString());
    }

    private MyHeap createHeap() {
        MyHeap myHeap = new MyHeap(5);
        return myHeap;
    }

    private void addNodesToHeap(MyHeap myHeap) {
        myHeap.add(1);
        myHeap.add(4);
        myHeap.add(9);
        myHeap.add(25);
        myHeap.add(17);
        myHeap.add(10);
        myHeap.add(2);
    }
}