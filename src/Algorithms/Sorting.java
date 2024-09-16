/*
 * Selection Sort
 * Bubble Sort
 * Insertion Sort
 * Merge Sort
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


    //* Merge Sort */
    void mergeSort(int[] ar) {
        mergeDivide(ar, 0, ar.length-1);
        System.out.print("Merge Sort: ");
        ob.printArray(ar);

    }

    void mergeDivide(int[] ar, int first, int last) {
        if(first < last) {
           int mid = (first + last) / 2;
           
           mergeDivide(ar, first, mid);
           mergeDivide(ar, mid+1, last);
           ob.mergeConquer(ar, first, mid, last);
        }
    }

    void mergeConquer(int[] ar, int first, int mid, int last) {
        //* 1. Create 2 Arrays : first to mid & mid+1 to last
        int m = mid - first + 1, n = last - mid;
        int[] firstArr = new int[m], secondArr = new int[n];

        //* 2. Copy Data in the 2 different arrays.
        for(int i=0, j=0; i<m || j<n; i++, j++) {
            if(i<m) {
                firstArr[i] = ar[first + i];    // first to mid
            }
            if(j<n) {
                secondArr[j] = ar[mid + 1 + j]; // mid+1 to last
            }
        }

        //* 2. Compare and Sort array.
        int i=0, j=0, k=first; 
        while(i<m && j<n) {
            if(firstArr[i] < secondArr[j]) {
                ar[k] = firstArr[i];
                i++; 
                k++;
            } else {
                ar[k] = secondArr[j];
                j++;
                k++;
            }
        }

        //* If any elements in the arrays left
        while(i<m) {
            ar[k]=firstArr[i];
            i++;
            k++;
        }
        while(j<n) {
            ar[k]=firstArr[j];
            j++;
            k++;
        }
    }

    //* Quick Sort */
    void quickSort(int[] ar) {
        quickDivide(ar, 0, ar.length-1);
        System.out.println("Quick Sort: ");
        ob.printArray(ar);
    }
    void quickDivide(int[] ar, int first, int last) {
        if (first < last) {
            int pivotIndex = ob.partition(ar, first, last);
            quickDivide(ar, first, pivotIndex - 1);
            quickDivide(ar, pivotIndex + 1, last);
        }
    }

    int partition(int arr[], int first, int last) {
        int pivot = arr[last], pIndex = first, temp; // pIndex = pivotIndex
        //pivot = always smallest or largest then it is worst case. array is in descending and ascending order. 
		for (int i = first; i<last; i++) { // last is pivot itself 
            if (arr[i] < pivot) { // motive = pivot se chhote sb aage ar bade sb last me. (Exact order ni chahiye).
                // swap arr[pIndex, arr[i]) 
                temp = arr[pIndex]; 
                arr[pIndex] = arr[i]; 
                arr[i] = temp;
				pIndex++;
            } 
        }
		
		//set pivot position = smaller < pivot < larger
		temp = arr[pIndex];
        arr[pIndex] = arr[last]; 
        arr[last] = temp; 
  
        return pIndex;	// returning appropriate position of pivot. 
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

        int[] arr = {4, 1, 3, 2, 0};
        
        System.out.print("Given Array: ");
        for(int item: arr) {
            System.out.print(item + ", ");
        }
        System.out.println();
        
        // ob.selectionSort(arr);
        // ob.bubbleSort(arr);
        // ob.insertionSort(arr);
        
        // ob.mergeSort(arr);
        ob.quickSort(arr);
    }
}