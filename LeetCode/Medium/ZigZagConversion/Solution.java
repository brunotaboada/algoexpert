package LeetCode.Medium.ZigZagConversion;

/*
  6. ZigZag Conversion

  The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

  P   A   H   N
  A P L S I I G
  Y   I   R
  And then read line by line: "PAHNAPLSIIGYIR"

  Write the code that will take a string and make this conversion given a number of rows:

  string convert(string s, int numRows);

  Example 1:
  Input: s = "PAYPALISHIRING", numRows = 3
  Output: "PAHNAPLSIIGYIR"

  Example 2:
  Input: s = "PAYPALISHIRING", numRows = 4
  Output: "PINALSIGYAHRPI"
  Explanation:
  P     I    N
  A   L S  I G
  Y A   H R
  P     I

  Example 3:
  Input: s = "A", numRows = 1
  Output: "A"


  Constraints:
  1 <= s.length <= 1000
  s consists of English letters (lower-case and upper-case), ',' and '.'.
  1 <= numRows <= 1000
*/

import java.util.ArrayList;
import java.util.List;


public class Solution {

    enum Direction {
        UP, DOWN
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> list = new ArrayList<>();
        int rows = array.size();
        int cols = array.get(0).size();
        int i = 0;
        int j = 0;
        Direction direction = Direction.DOWN;
        while (i < rows && j < cols) {
            list.add(array.get(i).get(j));
            if (j == 0 && direction == Direction.DOWN && i != rows - 1) {
                i++;
                direction = Direction.UP;
            } else if (i == 0 && direction == Direction.UP && j != cols - 1) {
                j++;
                direction = Direction.DOWN;
            } else if (j == cols - 1 && direction == Direction.UP) {
                i++;
                direction = Direction.DOWN;
            } else if (i == rows - 1 && direction == Direction.DOWN) {
                j++;
                direction = Direction.UP;
            } else if (direction == Direction.UP) {
                i--;
                j++;
            } else {
                i++;
                j--;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        zigzagTraverse(List.of(
            List.of(1, 3, 4, 10),
            List.of(2, 5, 9, 11),
            List.of(6, 8, 12, 15),
            List.of(7, 13, 14, 16)
        ));
    }
}