package dataStructures.linkedList.DoubleLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    @Test
    void addTest(){
        MyLinkedList myLinkedList = createList();
        String result = " 11 13 16";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void addAtPosTest(){
        MyLinkedList myLinkedList = createList();
        myLinkedList.add(3,1000);
        myLinkedList.add(0,1000);
        myLinkedList.add(2,1000);

        String result = " 1000 11 1000 13 16 1000";
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

        String result = " 13 16";
        assertEquals(result, myLinkedList.toString());
    }

    @Test
    void removeElementTest(){
        MyLinkedList myLinkedList = createList();
        myLinkedList.remove(2);

        String result = " 11 13";
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
        myLinkedList.add(11);
        myLinkedList.add(13);
        myLinkedList.add(16);

        return myLinkedList;
    }
}