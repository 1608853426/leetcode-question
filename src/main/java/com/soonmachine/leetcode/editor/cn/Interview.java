package com.soonmachine.leetcode.editor.cn;

import java.util.Scanner;

public class Interview {







    public void heap_sort(int[] arr, int n){
        for(int i = n / 2 - 1; i >= 0; i --){
            heapify(arr, n, i);
        }
        for (int i = n - 1; i >= 0; i --){
            swap(arr, 0, i);
            heapify(arr, i, 0);
        }
        for (int x : arr){
            System.out.print(x + " ");
        }
    }

    void heapify(int[] arr, int n, int i){

        int largest = i;
        int lSon = i * 2 + 1;
        int rSon = i * 2 + 2;

        if(lSon < n && arr[lSon] > arr[largest]){
            largest = lSon;
        }
        if(rSon < n && arr[rSon] > arr[largest]){
            largest = rSon;
        }
        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }


    }
    void swap(int[] arr, int i, int j){
        int tmp  = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}


