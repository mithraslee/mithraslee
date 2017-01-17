package testing.lib.library;

/**
 * Created by Yun on 1/14/2017.
 */
public class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }

    @Override
    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}