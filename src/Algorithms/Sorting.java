/*
 * Selection Sort
 * Bubble Sort
 * Insertion Sort
*/

package Algorithms;
// import java.util.*;

public class Sorting {
    static Sorting ob = new Sorting();
    
    void printArray(int arr[]) 
    { 
        for (int item : arr) 
            System.out.print(item + ", "); 
        System.out.println(); 
    }

    void selectionSort(int[] ar) {
        for(int i = 0; i<ar.length; i++) {
            int min_index = i;
            for(int j = i+1; j<ar.length; j++) {
                if(ar[j] < ar[min_index]) {
                    min_index = j;
                }
            }               
            int temp = ar[min_index];
            ar[min_index] = ar[i];
            ar[i] = temp;
        }
        System.out.print("Selection Sort: ");
        ob.printArray(ar);
    }

    void bubbleSort(int[] ar) {
        boolean swapped = false;
        for(int i=0; i<ar.length; i++) {
            for(int j=0; j<ar.length-i-1;j++){
                if(ar[j]>ar[j+1]){
                    int temp = ar[j];
                    ar[j] = ar[j+1];
                    ar[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped==false) {
                break;
            }
        }
        System.out.print("Bubble Sort: ");
        ob.printArray(ar);
    }
    
    void insertionSort(int[] ar) {
        
        for(int i=1; i<ar.length; i++) {
            int item = ar[i];
            int j=i-1;
            while(j>=0 && ar[j]>item) {
                ar[j+1] = ar[j];
                j--;
            }
            ar[j+1] = item;
        }

        System.out.print("Insertion Sort: ");
        ob.printArray(ar);
    }

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        
        // System.out.println("How many elements:");
        // int n= sc.nextInt();
        // int[] arr = new int[n];
        
        // System.out.println("Enter elements of an array: ");
        // for(int i = 0; i<arr.length; i++) {
        //     arr[i] = sc.nextInt();
        // }

        int[] arr = {4, 1, 2, 3, 0};
        
        System.out.print("Given Array: ");
        for(int item: arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        // ob.selectionSort(arr);
        // ob.bubbleSort(arr);
        // ob.insertionSort(arr);
    }
}
