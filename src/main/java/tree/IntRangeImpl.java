package tree;

public class IntRangeImpl extends Range<Integer> {
    public IntRangeImpl(Integer start, Integer end) {
        super(start, end);
    }

    @Override
    public int compareTo(Range<Integer> o) {
        return Math.abs(end - start) - Math.abs(o.end - o.start);
    }
}
