//Leetcode 042 - Trapping Rain Water - tricky.java

//方法1：记录每个点左右的最高点，形成 max_left[], max_right[] 两个数组。
//然后再扫一遍，water += min(left, right) - height[i]


public int trap(int[] height) {
    if(height == null || height.length == 0) return 0;
    
    int n = height.length;
    int[] max_left = new int[n];
    int[] max_right = new int[n];
    
    max_left[0] = 0;
    max_right[0] = 0;
    
    for(int i=1; i<n; i++){
        max_left[i] = Math.max(max_left[i-1], height[i-1]);  //从左往右
        max_right[n-1-i] = Math.max(max_right[n-i], height[n-i]); //从右往左
    }
    
    int water = 0;
    for(int j=0; j<n; j++){
        int bar = Math.min(max_left[j], max_right[j]);
        if(height[j] < bar) {
            water += (bar - height[j]); 
        }
    }
    
    return water;
}

//方法2：找到最高点，然后分别从左 i = 0 扫一遍，从右 i = n-1 扫一遍
public int trap(int[] height) {
    int top = 0;
    for(int i=0; i<height.length;i++){
        if (height[i]>height[top]) top = i;
    }
    
    int water = 0;
    int left_top = 0;
    for(int i=0; i<top;i++){
        if(height[i]>left_top){
            left_top = height[i];
        } else {
            water += (left_top - height[i]);
        }
    }
    int right_top = 0;
    for(int i=height.length-1; i>top; i--){
        if(height[i] > right_top){
            right_top = height[i];
        } else {
            water += (right_top - height[i]);
        }
    }
    return water;
}

