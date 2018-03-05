/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package testing.lib.sort_search;

import java.lang.*;
import java.util.*;

import static testing.lib.common.CommonUtils.printArray;

/**
 *
 * @author yunl
 */
//public class Search<T extends Number> {
public class Search {

    // Opposite to linearSearch()
    static public <T extends Number> T findKthLargest(T[] nums, int k) {
        int len = nums.length;
        if (len < k) return null;

        return helper(nums, 0, len - 1, k);
    }

    static private <T extends Number> T helper(T[] a, int b, int e, int k) {
        if (a == null || b < 0 || e < 0 || k < 0 || b > e || (e - b + 1) < k) return null;
        int q = Utility.partition(a, b, e, (n1, n2) -> -Double.compare(n1.doubleValue(), n2.doubleValue()));

        int qth = q - b + 1;
        if (qth == k) return a[q];
        if (qth > k) {
            return helper(a, b, q - 1, k);
        } else {
            return helper(a, q + 1, e, k - qth);
        }
    }
//    static private int partition(int[] a, int b, int e) {
//        if (a == null || b < 0 || e < 0 || b > e)
//            return -1;
//
//        int q = b + (int)(Math.random() * (e - b + 1));
//        if (q != e) swap(a, q, e);
//
//        int low = b, high = e;
//        boolean lToH = true;
//
//        while(low < high) {
//            if (a[low] < a[high]) {
//                swap(a, low, high);
//                lToH = !lToH;
//            } else {
//                if (lToH) low++;
//                else high--;
//            }
//        }
//        return low;
//    }

    public static <T extends Number> int linearSearch(T[] a, int size, int kth) {
        return linearSearch(a, 0, size - 1, kth);
    }

    public static <T extends Number> int linearSearch(T[] a, int b, int e, int kth) {
        if (a == null || b < 0 || e < 0 || kth < 0 || b > e || (e - b + 1) < kth) {
            System.out.println("b: " + b + "; e: " + e + "; kth: " + kth);
            if (a == null) System.out.println("a == null");
            return -1;
        }
        int q = Utility.partition(a, b, e, (n1, n2) -> Double.compare(n1.doubleValue(), n2.doubleValue()));
        int ith = q - b + 1;
        if (ith == kth) {
            return q;
        } else if (ith > kth) {
            return linearSearch(a, b, q - 1, kth);
        } else {
            return linearSearch(a, q + 1, e, kth - ith);
        }
    }

    public static <T extends Number> int binarySearchRecursive(T[] a, int size, T val) {
        return binarySearchRecursive(a, 0, size - 1, val);
    }

    public static <T extends Number> int binarySearchRecursive(T[] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;
        int m = (b + e) / 2;
        if (Utility.compareItem(a[m], val) == 0) {
            return m;
        } else if (Utility.compareItem(a[m], val) > 0) {
            return binarySearchRecursive(a, b, m - 1, val);
        } else {
            return binarySearchRecursive(a, m + 1, e, val);
        }
    }

    public static <T extends Number> int binarySearchIterative(T[] a, int size, T val) {
        if (size < 1) return -1;
        int b = 0, e = size - 1;

        while (b <= e) {
            int m = (b + e) / 2;
            if (Utility.compareItem(a[m], val) == 0) {
                return m;
            } else if (Utility.compareItem(a[m], val) > 0) {
                e = m - 1;
            } else {
                b = m + 1;
            }
        }
        return -1;
    }
    public static <T extends Number> int binarySearchIterative2(T[] a, int size, T val) {
        if (size < 1) return -1;
        int b = 0, e = size - 1;

        while (b + 1 < e) {
            int m = b + (e - b)/2;
            if (Utility.compareItem(a[m], val) == 0) {
                return m;
            } else if (Utility.compareItem(a[m], val) > 0) {
                e = m;
            } else {
                b = m;
            }
        }
        if (Utility.compareItem(a[b], val) == 0) {
            return b;
        }
        if (Utility.compareItem(a[e], val) == 0) {
            return e;
        }
        return -1;
    }

    public static <T extends Number> int binarySearchForRotationWithDuplication(T[] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;

        while (b <= e) {
            int m = (b + e) / 2;
            if (Utility.compareItem(a[m], val) == 0) {
                return m;
            } else if (Utility.compareItem(a[m], val) > 0) {
                if (Utility.compareItem(a[m], a[b]) > 0 && Utility.compareItem(a[b], val) > 0) {
                    b = m + 1;
                } else {
                    e = m - 1;
                }
            } else {
                if (Utility.compareItem(a[m], a[e]) < 0 && Utility.compareItem(a[e], val) < 0) {
                    e = m - 1;
                } else {
                    b = m + 1;
                }
            }
        }

        return -1;
    }

    /**
     * Find Minimum in Rotated Sorted Array
     *
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     *         (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * There could be duplicated elements
     * You may assume no duplicate exists in the array.
     */
    public int findMin(int[] num) {
        assert num != null;
        int len = num.length;
        if (len < 1) return -1;

        int begin = 0;
        int end = len - 1;
        int mid;
        while (begin <= end) {
            mid = (begin + end)/2;
            if (mid == begin)
                return Math.min(num[begin], num[end]);

            while (begin < mid && num[begin] == num[mid])
                begin++;
            while (end > mid && num[end] == num[mid])
                end--;

            if (num[mid] > num[begin] && num[mid] < num[end]) {
                return num[begin];
            } else if (num[mid] > num[begin] && num[mid] > num[end]) {
                begin = mid + 1;
            } else if (num[mid] < num[begin] && num[mid] < num[end]) {
                if (num[mid-1] > num[mid])
                    return num[mid];
                end = mid - 1;
            }
        }
        return -1;
    }
    public int findMin2(int[] num) {
        if (num == null || num.length == 0) return Integer.MIN_VALUE;

        int lb = 0, ub = num.length - 1;
        // case1: num[0] < num[num.length - 1]
        if (num[lb] < num[ub]) return num[lb];

        // case2: num[0] > num[num.length - 1] or num[0] < num[num.length - 1]
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (num[mid] < num[ub]) {
                ub = mid;
            } else if (num[mid] > num[ub]){
                lb = mid;
            } else {
                ub--;
            }
        }

        return Math.min(num[lb], num[ub]);
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int R = matrix.length;
        if (R < 1) return false;
        int C = matrix[0].length;
        if (C < 1) return false;

        int r = R - 1;
        int c = 0;
        while (r >= 0 && c < C) {
            if (matrix[r][c] == target) {
                return true;
            } else if (matrix[r][c] < target) {
                c++;
            } else {
                r--;
            }
        }
        return false;
    }

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int R = matrix.length;
        if (R < 1) return false;
        int C = matrix[0].length;
        if (C < 1) return false;

        int begin = 0, end = R * C - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (matrix[mid / C][mid % C] == target) {
                return true;
            } else if (matrix[mid / C][mid % C] > target) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        return false;
    }

    /**
     * Lower Bound & Upper Bound
     *
     * 定义：
     * lower bound：为在给定升序数组中大于等于目标值的最小索引
     * upper bound：为在给定升序数组中小于等于目标值的最大索引
     */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] < target) {
                lb = mid;
            } else {
                ub = mid;
            }
        }

        return lb + 1;
    }
    public static int lowerBound2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return nums[low] == target ? low : low + 1;
    }

    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lb = -1, ub = nums.length;
        while (lb + 1 < ub) {
            int mid = lb + (ub - lb) / 2;
            if (nums[mid] > target) {
                ub = mid;
            } else {
                lb = mid;
            }
        }

        return ub - 1;
    }
    public static int upperBound2(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int low = 0;
        int high = nums.length - 1;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return nums[high] == target ? high : high - 1;
    }

    /**
     * Search for a Range
     *
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     *         return [3, 4].
     */
    // Passed test
    public static int[] searchRange(int[] A, int target) {
        System.out.println("\nStart function searchRange(). Target = " + target);
        printArray(A, "\tNums:");
        int[] res = new int[]{-1, -1};
        if (A == null) return res;
        int len = A.length;
        if (len < 1) return res;

        int low = 0, high = len - 1;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (A[low] == target) {
            res[0] = low;
        } else if (low + 1 < len && A[low+1] == target) {
            res[0] = low + 1;
        } else {
            System.out.println("\tNot found. low = " + low);
            return res;
        }

        high = len - 1;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            if (A[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (A[high] == target) {
            res[1] = high;
        } else {
            res[1] = high - 1;
        }

        printArray(res, "\tRes:");
        return res;
    }
    // Passed test
    public static int[] searchRange2(int[] A, int target) {
        System.out.println("\nStart function searchRange2(). Target = " + target);
        printArray(A, "\tNums:");

        int[] res = new int[]{-1, -1};
        if (A == null) return res;
        int len = A.length;
        if (len < 1) return res;

        int low = -1, high = len;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            if (A[mid] < target) {
                low = mid;
            } else {
                high = mid;
            }
        }
        if (low + 1 < len && A[low + 1] == target) {
            res[0] = low + 1;
        } else {
            System.out.println("\tNot found. low = " + low);
            return res;
        }

        high = len;
        while (low + 1 < high) {
            int mid = low + (high - low)/2;
            if (A[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        res[1] = high - 1;

        printArray(res, "\tRes:");
        return res;
    }

    public static void searchForClosestDemo(int[] A, int target) {
        System.out.println("\nStart function searchForClosestDemo(). Target = " + target);
        printArray(A, "\tNums:");
        System.out.println("\tRes1: " + searchForClosest(A, target));
    }
    public static int searchForClosest(int[] A, int target) {
        if (A == null) return -1;
        int len = A.length;
        if (len < 1) return -1;

        int low = 0, high = len - 1;
        while (low + 1 < high) {
            int mid = (low + high)/2;
            if (A[mid] == target) {
                return A[mid];
            } else if (A[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (Math.abs(A[low] - target) > Math.abs(A[high] - target)) {
            return A[high];
        } else {
            return A[low];
        }
    }

    public static int sqrt(int x) {
        long start = 1, end = x;
        while (start + 1 < end) {
            long mid = start + (end - start) / 2;
            if (mid * mid == x) {
                return (int)mid;
            } else if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return (int) end;
        }
        return (int) start;
    }
    public static Double sqrt (Double n) {
        System.out.println("\nStart function sqrt()");
        System.out.println("\tn = " + n);
        Double precision_unit = 0.000001;

        if (n < 0.0) {
            System.out.println("\tres = " + -1.0);
            return -1.0;
        } else if (n <= precision_unit) {
            System.out.println("\tres = " + precision_unit);
            return 0.001;
        } else if (n == 1.0) {
            System.out.println("\tres = " + 1.0);
            return 1.0;
        }

        boolean lowerThanOne = false;
        if (n <= 1.0) {
            lowerThanOne = true;
            n *= (1.0/precision_unit);
        }

        Double low = 1.0;
        Double high = n;
        Double mid = 0.0;

        while (low < high) {
            mid = (low + high)/2.0;
            if (Math.abs((mid * mid) - n) <= precision_unit) {
                break;
            } else if ((mid * mid) > n) {
                high = mid;
            } else {
                low = mid;
            }
        }
        if (lowerThanOne) {
            mid /= 1000;
        }
        System.out.println("\tres = " + mid);
        return mid;
    }

    /**
     * Find Peak Element - Accepted
     *
     * A peak element is an element that is greater than its neighbors.
     * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * You may imagine that num[-1] = num[n] = -∞.
     * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
     */
    public static int findPeakElement(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int begin = 0;
        int end = nums.length - 1;

        while (begin + 1 < end) {  // 这个形式保证: left < mid < right
            int mid = begin + (end - begin)/2;
            if (nums[mid] < nums[mid + 1]) {
                begin = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        return nums[begin] > nums[end] ? begin : end;
    }
    // Wrong version
    public static int findPeakElement2(int[] nums) {
        if (nums == null || nums.length < 1) return -1;
        if (nums.length == 1) return 0;
        int begin = 0;
        int end = nums.length - 1;

        while (begin < end) {
            int mid = begin + (end - begin)/2;
            if (nums[mid] < nums[mid + 1]) {
                begin = mid + 1;
            } else if (nums[mid] < nums[mid - 1]) { // mid - 1有可能越界
                end = mid;
            } else {
                return mid;
            }
        }
        return begin;
    }

    /**
     * Split Array Largest Sum
     *
     * Given an array which consists of non-negative integers and an integer m,
     * you can split the array into m non-empty continuous subarrays.
     * Write an algorithm to minimize the largest sum among these m subarrays.
     *
     * Note:
     * Given m satisfies the following constraint: 1 ≤ m ≤ length(nums) ≤ 14,000.
     *
     * Examples:
     *
     * Input:
     * nums = [7,2,5,10,8];   m = 2
     *
     * Output: 18
     *
     * Explanation:
     * There are four ways to split nums into two subarrays.
     * The best way is to split it into [7,2,5] and [10,8],
     * where the largest sum among the two subarrays is only 18.
     */
    // Optimal solution: http://www.cnblogs.com/grandyang/p/5933787.html
    public static void splitArrayDemo(int[] nums, int m) {
        System.out.println("\nStart function splitArray()");
        printArray(nums, "Nums:");
        System.out.println("\tm = " + m);

        int maxSum1 = splitArray(nums, m);
        System.out.println("\tMaxSum = " + maxSum1);
        int maxSum2 = splitArray2(nums, m);
        System.out.println("\tMaxSum = " + maxSum2);
    }
    public static int splitArray(int[] nums, int m) {
        long left = 0, right = 0;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        while (left <= right) {
            long mid = left + (right - left)/2;
            if (canSplit(nums, mid, m)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }
    public static int splitArray2(int[] nums, int m) {
        long left = 0, right = 0;
        for (int n : nums) {
            left = Math.max(left, n);
            right += n;
        }
        while (left < right) {
            long mid = left + (right - left)/2;
            if (canSplit(nums, mid, m)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (int)left;
    }
    private static boolean canSplit(int[] nums, long mid, int m) {
        int cnt = 1;
        long curSum = 0;
        for (int n : nums) {
            curSum += n;
            if (curSum > mid) {
                curSum = n;
                cnt++;
                if (cnt > m) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Find the Duplicate Number
     *
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
     *
     * Note:
     * You must not modify the array (assume the array is read only).
     * You must use only constant, O(1) extra space.
     * Your runtime complexity should be less than O(n2).
     * There is only one duplicate number in the array, but it could be repeated more than once.
     */
    public static int findDuplicate(int[] nums) {
        System.out.println("\nStart function findDuplicate()");
        printArray(nums, "\tNums:");

        int len = nums.length;
        int left = 1, right = len - 1;
        while (left < right) {
            int mid = (left + right)/2;
            int cnt = 0;
            for (int n : nums) {
                if (n <= mid) cnt++;
            }
            if (cnt <= mid) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println("\tRes = " + left);
        return left;
    }

}