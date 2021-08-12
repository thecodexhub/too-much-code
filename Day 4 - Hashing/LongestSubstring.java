// Longest substring without repeating characters
// Given a string s, find the length of the longest substring with no-repeating characters.

// [https://www.youtube.com/watch?v=qtVh-XEpsJo&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=26]

// Input: s = "abcabcbb"
// Output: 3
// Explanation: the answer is "abc", with the length of 3

// Time complexity: O(N), Space complexity: O(N)

import java.util.HashMap;

public class LongestSubstring {

  public int longestSubstring(String s) {
    HashMap<Character, Integer> mpp = new HashMap<Character, Integer>();
    int left = 0, right = 0;
    int len = 0;
    int n = s.length();

    while (right < n) {
      if (mpp.containsKey(s.charAt(right))) {
        left = Math.max(left, mpp.get(s.charAt(right)) + 1);
      }
      mpp.put(s.charAt(right), right);
      len = Math.max(len, right - left + 1);
      right++;
    }

    return len;
  }
}
