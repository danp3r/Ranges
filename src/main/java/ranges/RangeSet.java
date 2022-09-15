package ranges;

import tree.BinaryTree;
import tree.Range;

public class RangeSet<T extends Comparable<T>> {
    final BinaryTree<Range<T>> tree = new BinaryTree<>();

    public Range<T> add(Range<T> value) {
        return tree.add(value);
    }

    public Range<T> delete(Range<T> value) {
        return tree.deleteNode(value);
    }

    public boolean isContains(Range<T> value) {
        return tree.isContainsNode(value);
    }

    public int size() {
        return tree.getSize();
    }

    public String toString() {
        return tree.toString();
    }
}
