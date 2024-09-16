/*
 ! Basic Level
 * Natural No
 * Factorial
 * Fibonacci
 * x^n (Stack Height = n, Stack Height = logn)
 */

package Recursion;

class Recursion1 {
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

    public static void main(String[] args) {
        Recursion1 ob = new Recursion1();
        
        // ob.naturalno(0,7);
        // System.out.println(ob.factorial(4));
        
        // int a=0, b=1, n=7;
        // ob.fibonacci(a, b, n);
        
        // System.out.println(ob.powerLogn(3,4)); 
    }
}