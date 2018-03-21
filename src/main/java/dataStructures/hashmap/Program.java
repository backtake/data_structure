package dataStructures.hashmap;

public class Program {

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.add("Zaaad", 10);
        myHashMap.add("Zd", 20);
        myHashMap.add("Z", 30);
        System.out.println(myHashMap.toString());
        myHashMap.clearAll();
        System.out.println(myHashMap.toString());
    }
}
