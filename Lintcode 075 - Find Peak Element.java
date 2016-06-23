Leetcode 162 - Find Peak Element
https://leetcode.com/problems/find-peak-element/
Lintcode 075 - Find Peak Element
http://www.lintcode.com/en/problem/find-peak-element/
class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        //只要一个 peak element，比较时只需向左右任一增长的区间缩小就可
        if (A == null || A.length == 0) {
            return -1;
        }
        
        int start = 0, end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1]) {
                end = mid;
            } else {
                return mid;
            }
        }
        
        return Math.max(A[start], A[end]);
    }
}
