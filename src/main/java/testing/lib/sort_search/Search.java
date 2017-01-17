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
        return binarySearchIterative(a, 0, size - 1, val);
    }

    public static <T extends Number> int binarySearchIterative(T[] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;

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

    public static <T extends Number> int binarySearchForRotationWithDuplication(T[] a, int b, int e, T val) {
        if (a == null || b < 0 || e < 0 || b > e)
            return -1;

        while (b < e) {
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

            if (num[mid] > num[begin] && num[mid] < num[end])
                return num[begin];
            else if (num[mid] > num[begin] && num[mid] > num[end]) {
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
     * 定义 lower bound 为在给定升序数组中大于等于目标值的最小索引，upper bound 则为小于等于目标值的最大索引，下面上代码和测试用例。
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
        System.out.println("\tRes: " + searchForClosest(A, target));

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
}