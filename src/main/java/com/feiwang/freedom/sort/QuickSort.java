package com.feiwang.freedom.sort;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] nums = {5, 4, 7, 9, 1, 2, 3};
        partition(nums,0,nums.length-1);

        int[] result = sort(nums, 0, nums.length - 1);
        for(int i:result){
            System.out.printf(i+"");
        }

    }

    static int[] sort(int[] num, int low, int high) {
        if (low >= high) return num;
        int p = partition(num, low, high);
        sort(num, low, p -1);
        sort(num, p+1, high);
        return num;
    }

    static int partition(int[] num, int low, int high) {
        if (low > high) return low;
        int pivotI = low;
        int pivot = num[pivotI];
        while (low < high) {
            while (low < high && num[high] >= pivot) {
                high--;
            }
            num[low] = num[high];
            while (low<high && num[low]<=pivot){
                low++;
            }
            num[high] = num[low];
        }
        num[low] = pivot;
        return low;
    }


}
