package dataStructures.hashmap;

public class KeyValue {

    private String key;
    private Integer value;

    public KeyValue(String key, Integer value) {
        if (key==null) throw new IllegalArgumentException("Key in MyHashMap cannot be a null!");
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
