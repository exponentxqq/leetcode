package com.learn.leetcode.valid_palindrome;

/**
 * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
 *
 * <p>示例 1: 输入: "aba" 输出: True
 *
 * <p>示例 2: 输入: "abca" 输出: True 解释: 你可以删除c字符。
 *
 * <p>注意: 字符串只包含从 a-z 的小写字母。字符串的最大长度是50000。
 */
public class Main {
  public static void main(String[] args) {
    System.out.println(validPalindrome("aydmda")); // true
    System.out.println(validPalindrome("gmlcupuuffuupuculmg")); // true
    System.out.println(validPalindrome("eeccccbebaeeabebccceea")); // false
    System.out.println(validPalindrome("yd")); // true
    System.out.println(validPalindrome("eccer")); // true
    System.out.println(validPalindrome("abc")); // false
    System.out.println(validPalindrome("abca")); // true
    System.out.println(validPalindrome("abcda")); // false
    System.out.println(validPalindrome("aba")); // true
    System.out.println(validPalindrome("tebbem")); // false
    System.out.println(validPalindrome("tebbe")); // true
  }

  private static boolean validPalindrome(String s) {
    String[] characters = s.split("");
    int startIdx = 0;
    int endIdx = characters.length - 1;
    while (startIdx < endIdx) {
      if (characters[startIdx].equals(characters[endIdx])) {
        startIdx++;
        endIdx--;
      } else {
        boolean leftOffsetFlag = true, rightOffsetFlag = true;
        for (int i = startIdx, j = endIdx - 1; i < j; i++, j--) {
          if (!characters[i].equals(characters[j])) {
            rightOffsetFlag = false;
            break;
          }
        }

        for (int i = startIdx + 1, j = endIdx; i < j; i++, j--) {
          if (!characters[i].equals(characters[j])) {
            leftOffsetFlag = false;
            break;
          }
        }
        return leftOffsetFlag || rightOffsetFlag;
      }
    }
    return true;
  }
}
