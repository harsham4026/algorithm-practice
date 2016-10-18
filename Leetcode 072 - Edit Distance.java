Leetcode 072 - Edit Distance.java

public class Solution {
    /**
     * @param word1 & word2: Two string.
     * @return: The minimum number of steps.
     */
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        int m = word1.length();
        int n = word2.length();
        
        if(m == 0 || n == 0) {
            return Math.abs(m - n);
        }
        
        int[][] f = new int[m+1][n+1];
        
        //initilize
        for(int i = 0; i <= m; i++) {
            f[i][0] = i;
        }
        for(int j = 0; j <= n; j++){
            f[0][j] = j;
        }
        
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    f[i][j] = f[i-1][j-1];
                } else {
                    //f[i][j] = Math.min(f[i-1][j], f[i][j-1], f[i-1][j-1]) + 1;
                    //Math.min 不接受三个参数，只要分两步写
                    f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + 1;
                    f[i][j] = Math.min(f[i][j], f[i-1][j-1] + 1);
                }
            }
        }
        
        return f[m][n];
    }
}