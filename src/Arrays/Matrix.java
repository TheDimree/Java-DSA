package Arrays;
import java.util.*;

/*
 * Searching in 2D Array
 * Spiral Output
 * Transpose of a Matrix
 */

class Matrix {

    void traverse(int[][] ar) {
        System.out.println("Given Matrix:");
        for(int i=0; i<ar.length;i++){
            for(int j=0; j<ar[i].length;j++){
                System.out.print(ar[i][j]+" ");
            }
            System.out.println();
        }
    }

    void search(int[][] ar, int item) {
        boolean found = false;
        System.out.println(found);
        System.out.println("Searching "+item);
        for(int i=0; i<ar.length;i++){
            for(int j=0; j<ar[i].length;j++){
                if(ar[i][j]==item) {
                    System.out.println("Item found at the location: ("+i+", "+j+")");
                    found = true;
                }
            }
        }
        if(!found) {
            System.out.println("Item not found");
        }
    }

    void spiralOutput(int[][] ar) {
        System.out.println("Spiral Output:");
        int rows=ar.length, cols=ar[0].length;

        //Boundaries of the matrix
        int top = 0, bottom = rows - 1, left = 0, right = cols-1;

        while(top<=bottom && left<=right) {

            for(int i=left; i<=right;i++) {
                System.out.print(ar[top][i] + " "); // row is constant
            }
            top++;  // Move the top boundary down

            for(int i=top; i<=bottom;i++) {
                System.out.print(ar[i][right] + " "); // column is constant
            }
            right--;    // Move the right boundary left

            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    System.out.print(ar[bottom][i] + " ");
                }
                bottom--; // Move the bottom boundary up
            }

            if (left <= right) {
                // Traverse from bottom to top along the left column
                for (int i = bottom; i >= top; i--) {
                    System.out.print(ar[i][left] + " ");
                }
                left++;  // Move the left boundary right
            }
        }
    }

    void transpose(int[][] ar) {
        for(int i=0; i<ar.length;i++){
            System.out.println("Transpose of a Matrix: ");
            for(int j=0; j<ar[i].length;j++){
                System.out.print(ar[j][i]+" ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 3 }, { 4,5,6}, {7,8,9} };
        Matrix ob = new Matrix();

        ob.traverse(arr);
        // ob.search(arr, 6);
        // ob.transpose(arr);
        ob.spiralOutput(arr);
        
    }
}