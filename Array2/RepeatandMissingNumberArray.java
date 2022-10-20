 /* You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4 */



public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] repeatedNumber(final int[] A) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=1;i<=A.length;i++){
            map.put(i,1);
        }
        for(int i=0;i<A.length;i++){
            int k = map.get(A[i]);
            map.put(A[i],k+1);
        }
        int arr[] = new int[2];
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue()>2){
                arr[0] = entry.getKey();
            }
            if(entry.getValue() == 1){
                arr[1] = entry.getKey();
            }
        }
    return arr;
}
}
