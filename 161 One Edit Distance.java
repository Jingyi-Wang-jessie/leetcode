//Given two strings S and T, determine if they are both one edit distance apart.

class Solution {
    public boolean isOneEditDistance(String s, String t) {
        for (int i=0;i < Math.min(s.length(),t.length()); i++){
            if (s.charAt(i) != t.charAt(i)){
                if(s.length() == t.length()){
                    return s.substring(i+1).equals(t.substring(i+1));
                }
                else if (s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i+1));
                }
                else{
                    return s.substring(i+1).equals(t.substring(i));
                }
            }
        }
        
        return Math.abs(s.length() - t.length()) == 1;
    }
}

//edit distance是指多少步需要从一个字符串转变成另一个字符串，包括replace，insert, delete. 当发现存在不同时，应该判断是否只有这个一个不同，- -》b, a-》-， a-》b.
//计算edit distance时就是从最后一个元素考虑，recursion. Dij = Di-1,j-1   if bi = aj/    Di-1,j-1 +Wrep(bi,aj); Di-1,j+Wdel(bi) ; Di,j-1+Wins(aj) if bi <> aj