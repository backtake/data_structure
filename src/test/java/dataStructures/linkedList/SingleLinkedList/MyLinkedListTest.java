package dataStructures.linkedList.SingleLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void addTest(){
        MyLinkedList myLinkedList = createList();
        String result = " 10 12 15";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void addAtPosTest(){
        MyLinkedList myLinkedList = createList();
        myLinkedList.add(3,1000);
        myLinkedList.add(0,1000);
        myLinkedList.add(2,1000);

        String result = " 1000 10 1000 12 15 1000";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void addAtWrongPosTest(){
        MyLinkedList myLinkedList = createList();
        assertThrows(IndexOutOfBoundsException.class, ()-> {
            myLinkedList.add(100,10);
        });
    }

    @Test
    void removeFirstElementTest(){
        MyLinkedList myLinkedList = createList();
        myLinkedList.remove(0);

        String result = " 12 15";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void removeElementTest(){
        MyLinkedList myLinkedList = createList();
        myLinkedList.remove(2);

        String result = " 10 12";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void removeWrongIndexTest(){
        MyLinkedList myLinkedList = createList();
        assertThrows(IndexOutOfBoundsException.class, ()->{
            myLinkedList.remove(10);
        });
    }

    private MyLinkedList createList(){
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.add(10);
        myLinkedList.add(12);
        myLinkedList.add(15);

        return myLinkedList;
    }

}