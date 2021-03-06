//Leetcode 034 - Search for a Range - 数组内连续相等的while循环.java

//Lintcode 061 - Search for a Range.java
//http://www.lintcode.com/en/problem/search-for-a-range/
//Leetcode 034
//https://leetcode.com/problems/search-for-a-range/

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] result = {-1, -1};
        if (A == null || A.length == 0) {
            return result;
        }
        
        int start = 0, end = A.length - 1;
        if(A[start] > target || A[end] < target) {
            return result;
        }
        int pos = -1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] == target) {
                pos = mid;
                break;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(pos == -1) {
            if (A[start] != target && A[end] != target) {
                return result;
            } else {
                pos = (A[start] == target ? start : end);
            }
        }

        //find first target in the range A[start] ~ A[pos]
        //find  last target in the range A[pos] ~ A[end]
        int i = start, j = pos;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (A[mid] == target) {
                j = mid;
            } else {
                i = mid;
            }
        }
        result[0] = A[i] == target ? i : j;
        
        i = pos; j = end;
        while (i + 1 < j) {
            int mid = i + (j - i) / 2;
            if (A[mid] == target) {
                i = mid;
            } else {
                j = mid;
            }
        }
        result[1] = A[j] == target ? j : i;
        
        return result;
    }
}

//以前的做法
public class Solution {
    public static void main(String[] agrs){
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;
        int[] result = searchRange(nums, target);
        System.out.println(result[0] + " "+ result[1]);
    }
    
    public static int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if(nums.length==0||nums==null) return res;
        
        int index1 = BiSearch(nums, 0, nums.length-1, target);
        if(index1 == -1) return res;
        else res[0] = res[1] = index1;

        int index2=index1;
        //判断连续相等的while循环！记住！
while(index2<nums.length-1){
    if(nums[index2+1] != target) break; //注意这里的+1
    else index2++;
}
        res[1] = index2;
        return res;
    }
    
    public static int BiSearch(int[] A, int start, int end, int key){
        int L = start, R =end;
        while(L<R){
            int M = (L+R)/2;
            if(A[M] < key){
                L = M+1;
            } else {
                R = M;
            }
        }
        return (L==R && A[L] == key) ? L : -1;
    }
}