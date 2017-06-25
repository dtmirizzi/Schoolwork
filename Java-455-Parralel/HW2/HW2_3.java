/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HW;

import java.util.Random;

/**
 * @author dtmirizzi
 */
public class HW2_3 {

    public static void main(String[] args) {
	int[] a= new int[1000];
	for (int i=0; i<a.length;i++){
	    a[i]= i; 
	}
	System.out.println(findKthSmallest(a,100));
    }
    public static int findKthSmallest(int[] nums, int k) {
        int start = 0, end = nums.length - 1, index = k;
        while (start < end) {
            int pivot = partion(nums, start, end);
            if (pivot < index) start = pivot + 1; 
            else if (pivot > index) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];
    }
    
    private static int partion(int[] nums, int start, int end) {
        int pivot = start, temp;
        while (start <= end) {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            if (start > end) break;
            temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
        temp = nums[end];
        nums[end] = nums[pivot];
        nums[pivot] = temp;
        return end;
    }
}
