/*
Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.
*/

//non-recursive
class Solution {
    public List<String> letterCombinations(String digits) {
        String[] KEYS = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"} ;
        LinkedList<String> res = new LinkedList<String>();
        if (digits.length() ==0){
            return res;
        }
        res.add("");
        
        for (int i=0;i <digits.length();i++){
            int input = digits.charAt(i) - '0';
            String value = KEYS[input];
            while (res.peek().length() ==i){
                String prefix = res.remove();
                for (int j =0;j<value.length();j++){
                    char chara = value.charAt(j);
                    res.add(prefix+chara);
                }
            }
                
        }
        
        return res;
    }
}

//recursive
class Solution {
    private static final String[] KEYS = {"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"} ;
    private void combine(int offset, String prefix, List<String> res, String digits){
        if(offset >= digits.length()){
            res.add(prefix);
            return;
        }
        String value = KEYS[digits.charAt(offset)-'0'];
        for (int i=0;i<value.length();i++){
            combine(offset+1, prefix+ value.charAt(i), res , digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        List<String> res = new LinkedList();
        if (digits.length()==0) {
            return res;
        }
        int offset = 0;
        String prefix = "";
        combine(offset, prefix, res, digits);
        return res;
    }
}

//非递归：FIFO队列，LinkedList,peek()
//递归： 分解，深度
