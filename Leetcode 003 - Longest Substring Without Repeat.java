//Leetcode 003 - Longest Substring Without Repeating Characters

//两个指针，一个 pioneer 走在前面，一个 checker 在后面，检查是否出现了两次。
//pioneer 先把出现过一次的字母都变成 true， checker 再把第二次出现的变成 false


//特别说明 ‘abba’ 这个例子
//set[a - true, b - true], i->2(b), j->0(a);
// while条件 set[b - true],       此时 j 指在 a 上，a->false，j++, maxLen 计算一次  = 2-1+1 = 2
// while条件 set[b - true]依旧成立，此时 j 指在 b 上，b->false，j++, maxLen 计算一次  = 2-2+1 = 1 < 2 不更新
// while条件 set[b - false] break
public class Solution {
    public int lengthOfLongestSubstring(String s ) {
        boolean[] set = new boolean[128]; //默认false
        int checker = 0, maxLen = 0;
        for(int pioneer = 0 ; pioneer <s .length(); pioneer++){
            while(set [s.charAt(pioneer)]){ //试一个"abba", 就可以知道为什么用while而不是if了
                set[s.charAt(checker)] = false;
                checker++;
            }
            set[s.charAt(pioneer)] = true; // 和 2Sum hashmap 一样，刚开始时先进这一句
            maxLen = Math.max(pioneer - checker+1, maxLen);
        }
        return maxLen;
    }
}