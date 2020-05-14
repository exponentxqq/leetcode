package com.learn.leetcode.single_number;

public class Main {
  public static void main(String[] args) {
    int[] nums = {4,1,2,1,2};
    System.out.println(singleNumber(nums));
  }

  /**
   * 异或的特点：
   * 1. 异或运算满足交换律和结合律
   * 2. 任何数和0做异或运算，结果仍然是原来的数，即 a ^ 0 = a
   * 3. 任何数和其自身做异或运算，结果是0，即 a ^ a = 0
   *
   * 因此，在满足交换律和结合律的情况下，假设数组有2m+1个数，有m个数出现两次，一个数出现一次
   * 再令a1,a2...am为出现两次的数(a(m+2)...a(2m+1)就是他们的另一次)，那么a(m+1)就是出现一次的数
   *
   * 根据异或的三点性质可知整个数组的异或结果为：
   * (a1 ^ a1) ^ (a2 ^ a2)...(am ^ am) ^ a(m+1) = a(m+1)
   * 即出现两次的数字都可以自身异或得0，最后的异或结果只有出现一次的数字保留
   */
  public static int singleNumber(int[] nums) {
    int single = 0;
    for (int num : nums) {
      single ^= num;
    }
    return single;
  }
}
