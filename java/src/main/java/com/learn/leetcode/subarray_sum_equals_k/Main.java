package com.learn.leetcode.subarray_sum_equals_k;

import java.util.Random;

public class Main {
  public static void main(String[] args) {
    int length = new Random().nextInt(20000) + 1;
    int[] array = new int[length];
    for (int i = 0; i < length; i++) {
      array[i] = new Random().nextInt(2001) - 1000;
    }
    long k = (long)(-(long)1e7 + (Math.random() * ((long)1e7 + (long)1e7)));

    System.out.println("array length: " + length);
    System.out.println("k: " + k);

    int result = subArraySumEqualsK(array, k);
    System.out.println(result);

    int[] arr = {1, 2, 3, 4, 5, 6, 1, 4, 1};
    long key = 5;
    System.out.println(subArraySumEqualsK(arr, key));
  }

  //  解法一
  private static int subArraySumEqualsK(int[] nums, long k) {
    int result = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == k) {
        result++;
      }
      int current = nums[i];
      for (int j = i + 1; j < nums.length; j++) {
        current += nums[j];
        if (current == k) {
          result++;
        }
      }
    }
    return result;
  }

  // 解法二:map
  private static int subArraySumEqualsK1(int[] nums, long k) {
    return 1;
  }
}
