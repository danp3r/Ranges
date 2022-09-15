package ranges;

import map.Entry;
import tree.BinaryTree;
import tree.Range;

public class RangeMap<Key extends Comparable<Key>, Value> {
    private final BinaryTree<Entry<Range<Key>, Value>> tree = new BinaryTree<>();

    public Value get(Range<Key> key) {
        Entry<Range<Key>, Value> entry = tree.get(new Entry<>(key, null));
        return entry == null ? null : entry.getValue();
    }

    public Value put(Range<Key> key, Value value) {
        Entry<Range<Key>, Value> entry = tree.add(new Entry<>(key, value));
        return entry == null ? null : entry.getValue();
    }
    
    public void update(Range<Key> key, Value value) {
        Entry<Range<Key>, Value> entry = tree.get(new Entry<>(key, null));
        if (entry != null) {
            entry.setValue(value);
        }
    }
    
    public Value remove(Range<Key> key) {
        Entry<Range<Key>, Value> entry = tree.deleteNode(new Entry<>(key, null));
        return entry == null ? null : entry.getValue();
    }
    
    public boolean isContainsKey(Range<Key> key) {
        return tree.isContainsNode(new Entry<>(key, null));
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}
