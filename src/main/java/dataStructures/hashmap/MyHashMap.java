package dataStructures.hashmap;

import java.util.LinkedList;

public class MyHashMap {

    private int bucketSize = 16;
    private LinkedList<KeyValue>[] elements = new LinkedList[bucketSize];

    public void add(String key, Integer value) {
        int position = getHash(key);
        if (elements[position] == null) {
            elements[position] = new LinkedList<>();
        } else {
            for (KeyValue kv: elements[position]) {
                if (kv.getKey() == key) throw new IllegalArgumentException("Key already exists!");
            }
        }
        elements[position].add(new KeyValue(key, value));
    }

    public Integer getValue(String key) {
        int position = getHash(key);
        if (elements[position] != null) {
            for (KeyValue kv: elements[position]) {
                if (kv.getKey() == key) {
                    return kv.getValue();
                }
            }
        }
        throw new IllegalArgumentException("No record has been found.");
    }

    public void remove(String key) {
        int position = getHash(key);
        if (elements[position] != null) {
            for (KeyValue kv: elements[position]) {
                if (kv.getKey() == key) {
                    elements[position].remove(kv);
                    return;
                }
            }
        }
        throw new IllegalArgumentException("No record has been found.");
    }

    public void clearAll(){
        elements = new LinkedList[bucketSize];
    }

    private int getHash(String key){
        return key.hashCode() % bucketSize;
    }

    public LinkedList<KeyValue>[] getElements() {
        return elements;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" || ");
        for (LinkedList<KeyValue> list: elements) {
            if (list == null) {
                continue;
            }
            for (KeyValue keyValue : list) {
                sb.append("key: " + keyValue.getKey() + " | value: " + keyValue.getValue() + " || ");
            }
        }
        return sb.toString();
    }
}
