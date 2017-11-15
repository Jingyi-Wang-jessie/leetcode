/*
Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?
*/

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        int n = nums.length;
        
        for(int i=0;i< n; i++){
            int index = Math.abs(nums[i]) -1;
            if(nums[index] <0){
                list.add(index +1);
            }else{
                nums[index] = -nums[index];
            }
        }
        
        return list;
    }
}

/*
用0 - n-1 的索引对应 1 - n 的数值， 每次改变对应索引处数值的正负， 如果发现index =i处数值为负， 意味着 i+1 这个数出现了两次。
*/