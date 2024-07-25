/*
K-Pangrams |GFG
Given a string str and an integer k, return true if the string can be changed into a pangram after at most k operations, else return false.

A single operation consists of swapping an existing alphabetic character with any other alphabetic character.

Note - A pangram is a sentence containing every letter in the english alphabet.

Examples :

Input: str = "the quick brown fox jumps over the lazy dog", k = 0
Output: true
Explanation: the sentence contains all 26 characters and is already a pangram.

Input: str = "aaaaaaaaaaaaaaaaaaaaaaaaaa", k = 25 
Output: true
Explanation: The word contains 26 instances of 'a'. Since only 25 operations are allowed. We can keep 1 instance and change all others to make str a pangram.

Input: str = "a b c d e f g h i j k l m", k = 20
Output: false

Expected Time Complexity: O(n)
Expected Auxiliary Space: O(1)  

Constraints:
1<= str.size() <= 105
0<= k <= 50
str may contain duplicate characters.
str contains only lowercase alphabets or spaces.
*/

class Solution {
    boolean kPangram(String str, int k) {
        // approach o(n), space arr[26]
        //edge case: count chars in str, 
        // if charCount < 26 ->  you cannot replace with all aplhabets 
           // => false
          //else, continue
         int alphaCount =0;
         String str1 = str.toLowerCase();
        //create an aplhabetic array of size [26]
        int[] charArr = new int[26];
        //traverse through the str and inc the arr size based on the alphabet
         for(int i=0;i<str1.length();i++){
             if(Character.isLetter(str1.charAt(i))){
             alphaCount++;
             charArr[str1.charAt(i)-'a']++;
             }
         }
         //System.out.println("alphacount is "+alphaCount);
         if(alphaCount<26){
             return false;
         }
   
        //traverse through the str and inc the arr size based on the alphabet
        // for(int i=0;i<str1.length();i++){
        //     Character character = str1.charAt(i);
        //     charArr['a'-character]++;
        // }
         //count all zeros
        int replaceCount =0;
        for(int i=0;i<charArr.length;i++){
            if(charArr[i]==0){
                replaceCount++;
            }
        }
        //System.out.println("replaceCount is "+replaceCount);
         //if count >= k - true
        if(replaceCount > k ){
            return false;
        }
        // else false
        return true;
        
    }
}
