package com.learn.leetcode.max_product;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
 *
 * <p>
 *
 * <p>示例 1:
 *
 * <p>输入: [2,3,-2,4] 输出: 6 解释: 子数组 [2,3] 有最大乘积 6。 示例 2:
 *
 * <p>输入: [-2,0,-1] 输出: 0 解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
 *
 * <p>输入: [0, 2] 输出: 2
 */
public class Main {
  public static void main(String[] args) {
    int[] arr1 = {2, 3, -2, 4};
    System.out.println(maxProduct(arr1));
    int[] arr2 = {-2, 3, -4};
    System.out.println(maxProduct(arr2));
    int[] arr3 = {0, 2};
    System.out.println(maxProduct(arr3));

    int[] arr4 = {2, 3, -2, 4};
    System.out.println(maxProduct1(arr4));
    int[] arr5 = {-2, 3, -4};
    System.out.println(maxProduct1(arr5));
    int[] arr6 = {0, 2};
    System.out.println(maxProduct1(arr6));
  }

  public static int maxProduct(int[] nums) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length; i++) {
      int subLength = i + 1;
      int j = 0;
      do {
        int subProduct = 1;
        for (int k = 0; k < subLength; k++) {
          subProduct *= nums[k + j];
        }
        if (subProduct > max) {
          max = subProduct;
        }
        j++;
      } while ((j + subLength) <= nums.length);
    }
    return max;
  }

  // 动态规划
  public static int maxProduct1(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    int[] maxes = new int[nums.length];
    int[] mines = new int[nums.length];

    maxes[0] = nums[0];
    mines[0] = nums[0];

    for (int i = 1; i < nums.length; i++) {
      if (nums[i] >= 0) {
        mines[i] = Math.min(nums[i], nums[i] * mines[i - 1]);
        maxes[i] = Math.max(nums[i], nums[i] * maxes[i - 1]);
      } else {
        mines[i] = Math.min(nums[i], nums[i] * maxes[i - 1]);
        maxes[i] = Math.max(nums[i], nums[i] * mines[i - 1]);
      }
    }

    int max = maxes[0];
    for (int i = 1; i < nums.length; i++) {
      max = Math.max(max, maxes[i]);
    }
    return max;
  }
}
