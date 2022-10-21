/* Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

 

Example 1:

Input: nums = [3,2,3]
Output: [3]
Example 2:

Input: nums = [1]
Output: [1]
Example 3:

Input: nums = [1,2]
Output: [1,2]
 

Constraints:

1 <= nums.length <= 5 * 104
-109 <= nums[i] <= 109
 

Follow up: Could you solve the problem in linear time and in O(1) space?  */ 



class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int num1 = -1;
        int num2 = -1;
        int count1 = 0;
        int count2 = 0;
        for(int i = 0;i<nums.length;i++){
            if(num1 == nums[i]) count1++;
            else if(num2 == nums[i]) count2++;
            else if(count1 == 0){
                num1 = nums[i];
                count1 = 1;
            }
            else if(count2 == 0){
              num2 = nums[i];
              count2 = 1;
            }
            else{
                count1--;
                count2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        count1 = 0;
        count2 = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == num1) count1++;
            else if(nums[i] == num2) count2++;
        }
        if(count1> nums.length/3) ans.add(num1);
        if(count2> nums.length/3) ans.add(num2);
        return ans;
    }
}
