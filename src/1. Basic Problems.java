import java.util.*;



/* 
 * Average of 3 no.
 * Sum of first n odd no.
 * Find Greater no.
 * Circumference
 * Voting Right
 * Count 0, Positives and Negatives
 * a raise to power b
 * GCD
 * Fibonacci
*/
class BasicProblems {
    Scanner sc = new Scanner(System.in);
    
    void average() {
        System.out.println("Enter three no. to find their average: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        System.out.println("1. Average of three no: "+ (a+b+c)/3);
    }

    void oddSum() {
        int i = 1, sum = 0;
        System.out.println("Find sum of n no. odds, Enter n: ");        
        int n = sc.nextInt();
        while(i<n) {
            if(i%2!=0){
                sum+=i++;
            }
        }
        
        System.out.println("2. Sum of " + n + " no. is : " + sum);        
    }

    void greatest() {
        System.out.println("Enter 2 no. to find the greater among them: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("Greatest no. is: "+((a>b)?a:b));
    }

    void circumference() {
        System.out.println("Enter radius: ");        
        int r = sc.nextInt();
        System.out.println("Circumference of the circle: " + 2*3.14*r);        
    }

    void vote() {
        System.out.println("Enter your age: ");
        int age = sc.nextInt();
        System.out.println((age>18)?"Eligible to vote.":"Can't vote.");
    }

    void checkZerosPositivesNegatives() {
        int[] ar = new int[100];
        int i = 0, zero = 0, pos = 0, neg = 0;
        System.out.println("Enter (non-numeric to exit) no. to check no. of zeros, positives and negatives:");
        while(true) {
            try{
                ar[i] = sc.nextInt();    
            } catch (InputMismatchException e) {
                System.out.println("Exiting...");
                break; // Exit the loop
            }
            if(i==99) {
                System.out.println("Array is full.");
            }
            i++;
        }
        for(int j = 0; j<i; j++) {
            if(ar[j] == 0) {
                zero++;
            }
            if(ar[j] > 0) {
                pos++;
            }
            if(ar[j] == 0) {
                neg++;
            }
        }
        System.out.println("Negative count: "+neg+" Zero count: "+zero+" Positive count: "+pos);
    }
    
    void power(){
        System.out.println("Enter base and exponent: ");
        int base = sc.nextInt();
        int exponent = sc.nextInt();
        System.out.println("Result: " + Math.pow(base, exponent));
    }

    void GCD(){
        //Using Euclidean Algorithm
        System.out.println("Enter two no to find GCD: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        // int gcd = (b == 0)? a : GCD(b, a % b);   // recursion method
        while(b!=0){    // jb tak 0 shesh ni bachtaa
            int rem = a%b;
            a=b;
            b=rem;
        }
        System.out.println("GCD: " + a);

    }

    void fibonacci(){
        System.out.println("Enter n:");
        int n = sc.nextInt();
        int a=0, b=1, sum=a+b;
        System.out.print("Fibonacci series: "+a+", "+b);
        int i=2;
        while(i<n){
            sum=a+b;
            System.out.print(", "+sum);
            a=b;
            b=sum;
            i++;
        }
    }

    public static void main(String[] args) {
        BasicProblems ob = new BasicProblems();
        
        // ob.average();
        // ob.oddSum();
        // ob.greatest();
        // ob.circumference();
        // ob.vote();
        ob.checkZerosPositivesNegatives();
        // ob.power();
        // ob.GCD();
        // ob.fibonacci();



        

        

        

    }
}