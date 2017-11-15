/*
Write a program that outputs the string representation of numbers from 1 to n.

But for multiples of three it should output “Fizz” instead of the number and for the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
*/

class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        
        for(int i =1;i<n+1; i++){
            int mod3 = i % 3;
            int mod5 = i % 5;
            if(mod3 == 0 && mod5 == 0){
                list.add("FizzBuzz");
            }else if (mod3 == 0 && mod5 != 0){
                list.add("Fizz");
            }else if (mod3 != 0 && mod5 == 0){
                list.add("Buzz");
            }else{
                list.add(String.valueOf(i));
            }
        }
        
        return list;
    }
}