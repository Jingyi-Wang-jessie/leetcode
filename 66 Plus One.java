/*
Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
*/

class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> res = new ArrayList<Integer>();
        int valueToAdd = 1;
        
        for (int i =digits.length-1;i>=0;i--){
            int temp = digits[i] + valueToAdd;
            if (temp >= 10){
                res.add(0, temp-10);
                valueToAdd = 1;
            }else{
                res.add(0, temp);
                valueToAdd = 0;
            }
        }
        
        if (valueToAdd == 1){
            res.add(0, 1);
        }
        
        int[] result = new int[res.size()];
        for(int i =0; i< res.size(); i++){
            result[i] = res.get(i);
        }
        
        return result;
    }
}