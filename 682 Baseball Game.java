/*
You're now a baseball game point recorder.

Given a list of strings, each string can be one of the 4 following types:

Integer (one round's score): Directly represents the number of points you get in this round.
"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
Each round's operation is permanent and could have an impact on the round before and the round after.

You need to return the sum of the points you could get in all the rounds.
*/

class Solution {
    public int calPoints(String[] ops) {
        
        int[] scores = new int[ops.length];
        for (int i =0; i<scores.length; i++){
            scores[i] = 0;
        }
        
        int idx = 0;
        
        for (int i =0; i<ops.length ;i++){
            if (ops[i].equals("+")){
                scores[idx] = scores[idx-1] + scores[idx-2];
                idx += 1;
            }else if(ops[i].equals("D")){
                scores[idx] = scores[idx-1]*2;
                idx += 1;
            }else if(ops[i].equals("C")){
                scores[idx-1] = 0;
                idx -= 1;
            }else{
                scores[idx] = Integer.parseInt(ops[i]);
                idx += 1;
            }
        }
        
        int sum = 0;
        for (int i=0; i<scores.length; i++){
            sum += scores[i];
        }
        
        return sum;
    }
}