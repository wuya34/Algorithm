package foundation;

/**
 * Author: amyas
 * Date: 2018/3/28/028
 * contact: geniusafteramyas@163.com
 * <p>
 * Search if a Integer within a given array.
 * If hit, return the index of this Integer, otherwise, return -1.
 */
public class BinarySearch {

    /**
     * 递归实现
     * 边界条件思考： hi = mid 以及 lo = mid的做法,将导致mid永远在 [lo,hi)之间，需要判断hi == lo + 1退出递归。
     *
     * @param a
     * @param target
     * @return
     */
    public static int execute(int[] a, int target) {
        return execute(a, 0, a.length - 1, target);
    }

    public static int execute(int[] a, int lo, int hi, int target) {
        if (hi == lo + 1) return -1;
        int mid = (lo + hi) / 2;
        if (target < a[mid]) {
            return execute(a, lo, mid, target);
        } else if (target > a[mid]) {
            return execute(a, mid, hi, target);
        } else {
            return mid;
        }
    }

    /**
     * 循环实现，非递归。
     * 边界条件思考： hi = mid-1,将mid减1的做法，导致hi<lo。如果不减1，就像上面递归的实现，需要判断hi == lo + 1;
     *
     * @param a
     * @param target
     * @return
     */
    public static int rank(int[] a, int target) {
        int hi = a.length - 1;
        int lo = 0;
        int mid;
        while (lo <= hi) {
            mid = (lo + hi) / 2;
            if (target < a[mid]) hi = mid - 1;
            else if (target > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 7, 9, 10, 123, 3412};
        int target = -1;
        System.out.println(execute(a, target));
        System.out.println(rank(a, target));
    }
}
