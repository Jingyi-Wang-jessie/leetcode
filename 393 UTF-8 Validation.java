/*
A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:

For 1-byte character, the first bit is a 0, followed by its unicode code.
For n-bytes character, the first n-bits are all one's, the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
This is how the UTF-8 encoding would work:

   Char. number range  |        UTF-8 octet sequence
      (hexadecimal)    |              (binary)
   --------------------+---------------------------------------------
   0000 0000-0000 007F | 0xxxxxxx
   0000 0080-0000 07FF | 110xxxxx 10xxxxxx
   0000 0800-0000 FFFF | 1110xxxx 10xxxxxx 10xxxxxx
   0001 0000-0010 FFFF | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx
Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
*/

class Solution {
    public boolean validUtf8(int[] data) {
        if(data==null || data.length==0) return false;
        boolean isValid = true;
        for(int i=0;i<data.length;i++) {
            if(data[i]>255) return false; // 1 after 8th digit, 100000000
            int numberOfBytes = 0;
            if(data[i] <128) { // 0xxxxxxx, 1 byte, 128(10000000)
                numberOfBytes = 1;
            } else if(data[i] >=192 && data[i] <224) { // 110xxxxx, 2 bytes, 224(11100000), 192(11000000)
                numberOfBytes = 2;
            } else if(data[i] >=224 && data[i] <240) { // 1110xxxx, 3 bytes, 240(11110000), 224(11100000)
                numberOfBytes = 3;
            } else if(data[i] >=240 && data[i] <248) { // 11110xxx, 4 bytes, 248(11111000), 240(11110000)
                numberOfBytes = 4;
            } else {
                return false;
            }
            for(int j=1;j<numberOfBytes;j++) { // check that the next n bytes start with 10xxxxxx
                if(i+j>=data.length) return false;
                if(data[i+j]<128 | data[i+j] >=192) return false; // 192(11000000), 128(10000000)
            }
            i=i+numberOfBytes-1;
        }
        return isValid;
    }
}

/*
the goal is to define if the sequence is formed by all valid characters.
*/