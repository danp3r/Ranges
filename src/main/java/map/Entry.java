package map;

public class Entry<Key extends Comparable<Key>, Value> implements Comparable<Entry<Key, Value>>{
    Key key;
    Value value;

    public Entry(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int compareTo(Entry<Key, Value> o) {
        return key.compareTo(o.key);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Entry)) {
            return false;
        }
        return ((Entry<Key, Value>)o).key.equals(this.key);
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public String toString() {
        return "[key = " + key.toString() + ", value = " + value.toString() + "]";
    }
}
