/*
 ! Intermediate Level
 * Tower of Hanoi
 * Print string in reverse
 * Find first & last occurrence of element
 * Check if the array is sorted (strictly increasing)
 * Move all 'x' to the end
 * Remove all duplicates in String
 */

 package Recursion;

class Recursion2 {
    
     void towerOfHanoi(int n, String src, String helper, String dest) {
         if(n == 1) {    // last disk is always moved to destination only.
             System.out.println("Move disk "+ n +" from "+ src +" to "+ dest);
             return;
         }
         towerOfHanoi(n-1, src, dest, helper);
         System.out.println("Move disk "+ n +" from "+ src +" to "+ dest);
         towerOfHanoi(n-1, helper, src, dest);
 
     }
 
     void stringReverse(String s, int index) {
         if(index < 0) {
             return;
         }
         stringReverse(s, index-1);
         System.out.print(s.charAt(index));
     }
 
     static int first = -1, last = -1;    // static variables are always class var.
     static void findOccurance(String s, int index, char element) {
         if(index == s.length()) {
             if(last == -1) {
                 last = first;
             }
             System.out.println("(First, Last) = "+ first +", "+ last);
             return;
         }
 
         if(s.charAt(index) == element) {
             if(first == -1) {   // first and last time update.
                 first = index;
             }
             else {
                 last = index;
             }
         }
 
         findOccurance(s, index+1, element); //checking one by one like we do in the loops.
     }

    static boolean[] map = new boolean[26];
    
    static void removeDuplicates(String str, int idx, String newString) {

        if(idx == str.length()) {
            System.out.println("Removed Duplicates from '"+ str +"' : "+ newString);
            return;
        }
        char currChar = str.charAt(idx);
        // System.out.print(currChar);
        if(map[currChar - 'a']) {   //  if(map[currChar - 'a'] == true)
            removeDuplicates(str, ++idx, newString);
        } else {
            newString += currChar;
            map[currChar - 'a'] = true;
            removeDuplicates(str, idx+1, newString);
        }
    }
 
     boolean isArraySorted(int[] ar, int index) {
         if(index == ar.length-1) {
             return true;  // sorted array
         }
         if(ar[index]>ar[index+1]) {   // unsorted array
             return false;
         }
         return isArraySorted(ar, index+1);
     }
 
     void moveX(String s, int index, int count, String newString) {
         if(index == s.length()) {   // stop recursion because the String has been traversed.   
             for(int i=1; i<=count; i++) {
                 newString += 'x';
             }
             System.out.println("Updated String: "+newString);
             return;
         }
 
         if(s.charAt(index) == 'x') {
             newString = s.substring(0, index) + s.substring(index+1);
             moveX(newString, index, ++count, newString);    // check another shifted character.
         }
         else {
             moveX(s, index+1, count, newString);    // check next index
         }       
     }
     public static void main(String[] args) {
         Recursion2 ob = new Recursion2();

         // ob.towerOfHanoi(2, "S", "H", "D");
         
         // String name = "MAR";
         // ob.stringReverse(name, name.length()-1);
 
         // findOccurance("abhajhaahiaihaiaa,iah", 0, 'b');
         
         // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
         // System.out.println(ob.isArraySorted(arr, 0));
         
         // String str="";
         // ob.moveX("axxbxcxxd", 0, 0, str);   
         
         String str = "aabcbbcdeefdf", newString="";
         removeDuplicates(str, 0, newString);
     }
 }