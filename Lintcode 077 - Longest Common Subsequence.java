Lintcode 077 - Longest Common Subsequence.java
http://www.lintcode.com/en/problem/longest-common-subsequence/

i
 A B C D
^ ^ ^ ^ ^
0 1 2 3 4

j
 E A C B
^ ^ ^ ^ ^
0 1 2 3 4

f[i][j]
    j     <=n 
    0 1 2 3 4 
i 0 0 0 0 0 0
  1 0 0 1 1 1
  2 0 0 1 1 2
  3 0 0 1 2 2
  4 0 0 1 2 2
<=
m  

关键语句：
    f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
    if(A.charAt(i - 1) == B.charAt(j - 1)) {
        f[i][j] = f[i - 1][j - 1] + 1;
    }

public class Solution {
    public int longestCommonSubsequence(String A, String B) {
        if(A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }
        
        int m = A.length();
        int n = B.length();
        
        int[][] f = new int[m + 1][n + 1];
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                if(A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + 1;
                }
            }
        }
        
        return f[m][n];
    }
}
