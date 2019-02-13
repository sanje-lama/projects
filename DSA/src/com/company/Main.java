package com.company;

import com.sun.deploy.util.ArrayUtil;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here

       // System.out.println(recursiveFib(5));

        int[] arr = {1,5,3,4,2,6};
        mergeSort(arr, 0,arr.length-1);
    }
    // diving the process.
    private static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (right + left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            System.out.println("left: " + left);
            System.out.println("Middle: " + mid);
            System.out.println("Right: " + right);

            merge(left, mid, right, arr);
        }
    }
// merging the process
            private static void merge(int left, int mid, int right, int[] arr) {
                //determine the size of our left and right sub arrays. Added 1 because at the moment because the middle
                // and left is zero.
                int leftArrSize = mid - left + 1;
                int rightArrSize = right - mid;

                //left and right array are initialized adding one more space for a Sentinel value
                int[] leftArr = new int[leftArrSize + 1];
                int[] rightArr = new int[rightArrSize + 1];

                //Copy the elements into the left sub array starting from the left index. This is the left half of the array.
                for (int i = 0; i < leftArrSize; i++) {
                    leftArr[i] = arr[left + i];
                }

                //copy elements into the right sub array starting from the middle index. This is the right half of the array.
                for (int j = 0; j < rightArrSize; j++) {
                    rightArr[j] = arr[mid + 1 + j];
                }

                //add sentinel values to signal when a subarray has been completely merged first
                leftArr[leftArrSize] = Integer.MAX_VALUE;
                rightArr[rightArrSize] = Integer.MAX_VALUE;

                System.out.println(Arrays.toString(leftArr));
                System.out.println(Arrays.toString(rightArr));

                // leftarray index and rightarray index
                int i = 0;
                int j = 0;

                /*merge subarrays into larger array sentinel values allow use to skip checks after one array has been exhausted*/
                for (int k = left; k <= right; k++) {
                    //if the index on the left is inorder
                    if (leftArr[i] <= rightArr[j]) {
                        System.out.println("Comparing "  + " Left " + leftArr[i] + " Right " + rightArr[j]);
                        //combine and increment left index
                        arr[k] = leftArr[i];
                        System.out.println("Current Array " + Arrays.toString(arr));
                        i++;
                    } else {
                        System.out.println("Appending right");
                        //combiner and increment right index
                        arr[k] = rightArr[j];
                        System.out.println("Current Array " + Arrays.toString(arr));
                        j++;
                    }
                }
                System.out.println("Merged Result " + Arrays.toString(arr));
            }





    private static int recursiveFib(int n){

        if (n==0) {
            return 1;
        }

        if (n==1) {
            return 1;
        }
        System.out.println(n);
        return recursiveFib(n-1) + recursiveFib(n-2);
    }

}
