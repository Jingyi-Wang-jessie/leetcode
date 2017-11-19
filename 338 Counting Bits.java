/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

Example:
For num = 5 you should return [0,1,1,2,1,2]
*/

class Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        if(num == 0){
            return res;
        }
        
        res[1] = 1;
        
        int exp = 1;
        int i = 2;
        
        while(i<=num){
            int base = (int)Math.pow(2,exp);
            while(i<Math.pow(2,exp+1)){
                res[i] = 1 + res[i-base];
                if(i == num){
                    return res;
                }
                i++;
            }
            exp ++;
        }
        
        return res;
    }
}
