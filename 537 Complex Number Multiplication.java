/*
Given two strings representing two complex numbers.

You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
*/

class Solution {
    public String complexNumberMultiply(String a, String b) {
        String[] aArr = a.split("\\+|i");
        int real_a = Integer.parseInt(aArr[0]);
        int i_a = Integer.parseInt(aArr[1]);
        
        String[] bArr = b.split("\\+|i");
        int real_b = Integer.parseInt(bArr[0]);
        int i_b = Integer.parseInt(bArr[1]);
        
        int real_res = real_a*real_b - i_a*i_b;
        int i_res = i_a*real_b + i_b*real_a;
        
        return String.valueOf(real_res) + "+" + String.valueOf(i_res) + "i";
    }
}

/*
\\+
*/