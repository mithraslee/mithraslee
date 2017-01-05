package testing.lib.fenwick_tree;

/**
 * Created by yun.li on 12/23/16.
 */
public class BIT {
    private int[] BIT;
    private int[] arr;

    private int lowBit(int x) {
        return x & -x;
    }

    public BIT(int[] nums) {
        int len = nums.length;
        if (len < 1) return;

        BIT = new int[len+1];
        arr = new int[len];
        for (int i = 0; i < len; i++) {
            update(i, nums[i]);
        }
    }

    void update(int i, int val) {
        int diff = val - arr[i];
        arr[i] = val;
        int index = i + 1;
        while (index <= arr.length) {
            BIT[index] += diff;
            index += lowBit(index);
        }
    }

    public int sumRange(int i) {
        int sum = 0;
        int index = i+1;
        while (index > 0) {
            sum += BIT[index];
            index -= lowBit(index);
        }
        return sum;
    }

    public int sumRange(int i, int j) {
        if (i == 0) return sumRange(j);
        else return sumRange(j) - sumRange(i-1);
    }
}
