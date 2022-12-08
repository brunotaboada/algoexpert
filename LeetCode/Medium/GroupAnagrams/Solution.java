package LeetCode.Medium.GroupAnagrams;

import java.util.*;
import java.util.stream.Collectors;

/*
  49. Group Anagrams

  Given an array of strings strs, group the anagrams together. You can return the answer in any order.

  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.


  Example 1:
  Input: strs = ["eat","tea","tan","ate","nat","bat"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

  Example 2:
  Input: strs = [""]
  Output: [[""]]

  Example 3:
  Input: strs = ["a"]
  Output: [["a"]]


  Constraints:
  1 <= strs.length <= 104
  0 <= strs[i].length <= 100
  strs[i] consists of lower-case English letters.
*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<String>> dMap = new HashMap<>();
        for (String word : strs) {
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), map.getOrDefault(word.charAt(i), 0) + 1);
            }
            if (!dMap.containsKey(map)) {
                List<String> strings = new ArrayList<>();
                strings.add(word);
                dMap.put(map, strings);
            }else{
                List<String> strings = dMap.get(map); strings.add(word);
                dMap.put(map, strings);
            }
        }
        return new ArrayList<>(dMap.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(
            solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}).toString());

        System.out.println(solution.groupAnagrams(new String[]{""}).toString());

        System.out.println(solution.groupAnagrams(new String[]{"a"}).toString());
    }
}
