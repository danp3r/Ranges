package tree;

public abstract class Range<T extends Comparable<T>> implements Comparable<Range<T>> {
    T start;
    T end;

    public Range(T start, T end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "(" + start + ", " + end + ")";
    }
}
