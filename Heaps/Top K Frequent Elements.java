/* Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
Example 2:

Input: nums = [1], k = 1
Output: [1]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.
 

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size. */

class Pair implements Comparable<Pair>{
    int a;
    int b;
    public Pair(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Pair m){
        return m.b - this.b;
    }
}
class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length==1) return nums;
        int res[] = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair>  q = new PriorityQueue<>();
        for(int i = 0;i<nums.length;i++){
          map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            q.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int i = 0;
        while(i<k){
          res[i] = q.poll().a;
          i++;
        }
        return res;
    }
}
