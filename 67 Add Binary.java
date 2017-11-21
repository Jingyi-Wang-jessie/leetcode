/*
Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".
*/

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder("");
        while(a.length() > b.length()){
            b = "0" + b;
        }
        while(a.length() < b.length()){
            a = "0" + a;
        }
        
        int length = a.length();
        int left = 0;
        for(int i = length-1; i>=0; i--){
            int temp = a.charAt(i) - '0' + b.charAt(i) - '0' +left;
            if (temp >1){
                res.insert(0,temp-2);
                left = 1;
            }else{
                res.insert(0,temp);
                left = 0;
            }
        }
        
        if(left == 1){
            res.insert(0,1);
        }
        
        return res.toString();
    }
}