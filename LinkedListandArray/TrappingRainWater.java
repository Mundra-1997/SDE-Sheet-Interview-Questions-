/*  Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

 

Example 1:


Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
Example 2:

Input: height = [4,2,0,3,2,5]
Output: 9
 

Constraints:

n == height.length
1 <= n <= 2 * 104
0 <= height[i] <= 105 */   


class Solution {
    public int trap(int[] arr) {
        int sum =0;
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<arr.length;i++){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
              int popheight = arr[st.peek()];
               st.pop();
                 if(st.isEmpty()){
                  break;
              }
              int distance = i-st.peek()-1;
              int height = Math.min(arr[i],arr[st.peek()]) - popheight;
             
              sum += distance*height;  
            }
            st.push(i);
        }
        return sum;
    }
}
