package dataStructures.stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    @Test
    void pushTest(){
        MyStack<String> myStack = createStack();
        myStack.push("F");
        myStack.push("G");
        String result = " G F E D C B A";

        assertEquals(result, myStack.toString());
    }

    @Test
    void pushNoSpaceLeftTest(){
        MyStack<String> myStack = createStack();
        myStack.push("F");
        myStack.push("G");
        assertThrows(StackOverflowError.class, ()-> {
            myStack.push("H");
        });
    }

    @Test
    void popTest(){
        MyStack<String> myStack = createStack();
        myStack.pop();
        String result = " D C B A";

        assertEquals(result, myStack.toString());
    }

    @Test
    void popFromEmptyStackTest() {
        MyStack<String> myStack = createEmptyStack();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myStack.pop();
        });
    }

    @Test
    void peekTest(){
        MyStack<String> myStack = createStack();
        assertEquals("E", myStack.peek());
    }

    @Test
    void peekFromEmptyStackTest() {
        MyStack<String> myStack = createEmptyStack();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myStack.peek();
        });
    }

    @Test
    void getFreeSlotsAmountTest(){
        MyStack<String> myStack = createStack();
        assertEquals(2, myStack.getFreeSlotsAmount());
    }

    private MyStack<String> createEmptyStack() {
        MyStack<String> myStack = new MyStack<String>(7);
        return myStack;
    }

    private MyStack<String> createStack() {
        MyStack<String> myStack = new MyStack<String>(7);
        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        myStack.push("D");
        myStack.push("E");

        return myStack;
    }
}