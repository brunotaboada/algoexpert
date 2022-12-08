package AlgoExSolutions.Medium.ReverseWordsInAString;

import java.util.ArrayList;
import java.util.List;

/**
 * * Reverse Words In A String
 */
class Program {
    public String reverseWordsInString(String s) {
        int n = s.length();
        if (n < 2) return s;
        StringBuilder sb = new StringBuilder();
        List<String> words = new ArrayList<>();
        int i, start = 0;
        for (i = 1; i < n; i++) {
            Character prevChar = s.charAt(i - 1), currChar = s.charAt(i);
            if ((prevChar == ' ' || currChar == ' ') && (prevChar != currChar)) {
                words.add(s.substring(start, i));
                start = i;
            }
        }
        words.add(s.substring(start, i));
        for (i = words.size() - 1; i >= 0; i--) sb.append(words.get(i));
        return sb.toString();
    }
}
