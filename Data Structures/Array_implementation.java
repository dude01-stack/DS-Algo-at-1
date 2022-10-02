
// This is file to show how array data structure is implemented using JAVA

/*  An array in Java is a group of like-typed variables referred to by a common name. Arrays in Java work differently than they do in C/C++.
 * In Java, all arrays are dynamically allocated.
*/


import java.util.*;

public class Array_implementation {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Array declaration
        int[] arr = new int[10];

        // Array input
        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }

        // Array printing
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        /* 2-d Arrays in jAVA */

        // 2d array input
        int[][] arr1 = new int[3][2];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr1[i][j] = input.nextInt();
            }
        }
        // 2d array printing
        for (int[] innerarray : arr1) {
            for (int data : innerarray) {
                System.out.print(data + "  ");
            }
            System.out.println();
        }
    }
}
