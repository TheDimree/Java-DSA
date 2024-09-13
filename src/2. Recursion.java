/*
 * Natural No
 * Factorial
 * Fibonacci
 * x^n (Stack Height = n, Stack Height = logn)
 * Tower of Hanoi
 * Print string in reverse
 * Find first & last occurrence of element
 * Check if the array is sorted (strictly increasing)
 * Move all 'x' to the end
 * Remove all duplicates in String
 * Print all subsequences
 * Print all unique subsequences
 * Print Keypad Combinations
 */

class Recursion {
    void naturalno(int count, int n) {
        if(count<=n) {
            System.out.print(count+", ");
            naturalno(++count, n);
        }
    }

    int factorial(int n) {
        //* 2 parameters => task then recursive call
        // if(n == 1) {
        //     System.out.print("Factorial: "+result);
        //     return;
        // }
        // result *=n;
        // factorial(n-1, result);
        
        //* Single Parameter => call then task
        if(n ==1 || n == 0) {   // base case
            return 1;
        }

        int factNext = factorial(n-1);
        return n*factNext;
    }

    void fibonacci(int a, int b, int n) {
        if(n == 0){
            return;
        }
        int sum=a+b;
        System.out.print(sum+", ");
        fibonacci(b, sum, n-1);
    }

    int powerN(int base, int power) {
        if(power == 0) {
            return 1;
        }
        if(base == 0) {
            return 0;
        }
        int powerNext = powerN(base, power-1);   // 5, 4, 3...
        return base*powerNext;
    }

    int powerLogn(int base, int power) {
        if(power == 0) {
            return 1;
        }
        if(base == 0) {
            return 0;
        }

        int halfPower = powerLogn(base, power/2);

        // check if n is even or odd
        if(power%2 == 0) {
            return halfPower * halfPower; // 4 = 4/2 + 4/2 (power add when base same)
        }
        
        if(power%2 != 0) {
            return halfPower * halfPower * base;    // 5 = 5/2 + 5/2 + 1
        }
        return 1;
    }

    //* Intermediate Level Starts
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
        Recursion ob = new Recursion();
        
        // ob.naturalno(0,7);
        // System.out.println(ob.factorial(4));
        
        // int a=0, b=1, n=7;
        // ob.fibonacci(a, b, n);
        
        // System.out.println(ob.powerLogn(3,4));
        
        // ob.towerOfHanoi(2, "S", "H", "D");
        
        // String name = "MAR";
        // ob.stringReverse(name, name.length()-1);

        // findOccurance("abhajhaahiaihaiaa,iah", 0, 'b');
        
        // int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        // System.out.println(ob.isArraySorted(arr, 0));
        
        // String str="";
        // ob.moveX("axxbxcxxd", 0, 0, str);      
    }
}