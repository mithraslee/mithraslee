package testing.lib.fenwick_tree;

import java.util.ArrayList;

/**
 * Created by Yun on 12/8/2015.
 */
public class FenwickTree {
    // https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/
    public ArrayList<Integer> arr;
    public int len;

    // 关键要记住BIT array的size需要比arr大1
    private int lowbit(int x) {
        return x & -x;
    }
    public FenwickTree(int l) {
        assert(l > 0);
        arr = new ArrayList<>(l+1);
        for(int i = 0; i <= l; i++)
            arr.add(0);
        len = l;
    }

    public void add(int index, int val) {
        while (index <= len) {
            arr.set(index, arr.get(index) + val);
            index += lowbit(index);
        }
    }

    public int sum(int index) {
        int res = 0;
        while (index > 0) {
            res += arr.get(index);
            index -= lowbit(index);
        }
        return res;
    }

    @Override
    public String toString() {
        return arr.toString();
    }
}
