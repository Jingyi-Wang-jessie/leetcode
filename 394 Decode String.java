/*
Given an encoded string, return it's decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

Examples:

s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/

class Solution {
    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<String> leftStack = new Stack<String>();
        
        int idx = 0;
        String left = "";
        while(idx <s.length()){
            char c = s.charAt(idx);
            if(Character.isDigit(c)){
                int num = c - '0';
                idx ++;
                while (Character.isDigit(s.charAt(idx))){
                    num = 10*num + s.charAt(idx) - '0';
                    idx ++;
                }
                numStack.push(num);
                
            }else if (c == '['){
                leftStack.push(left);
                left = "";
                idx ++;
                
            }else if(c == ']'){
                StringBuilder temp = new StringBuilder(leftStack.pop());
                int repeatNum = numStack.pop();
                for (int i=0;i<repeatNum;i++){
                    temp.append(left);
                }
                left = temp.toString();
                idx ++;
                
            }else{
                left += c;
                idx ++;
            }
        }
        
        return left;
    }
}
