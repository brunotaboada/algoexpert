package AlgoExSolutions.Medium.SuffixTrieConstruction;

import java.util.HashMap;
import java.util.Map;

/**
 * * Suffix Trie Construction
 */
class Program {
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {
            for (int i = 0; i < str.length(); i++) {
                String word = str.substring(i);
                TrieNode cur = root;
                for (Character c : word.toCharArray()) {
                    if (!cur.children.containsKey(c)) {
                        TrieNode tn = new TrieNode();
                        cur.children.put(c, tn);
                    }
                    cur = cur.children.get(c);
                }
                cur.children.put(endSymbol, null);
            }
        }

        public boolean contains(String str) {
            TrieNode cur = root;
            for (Character c : str.toCharArray()) {
                if (!cur.children.containsKey(c)) {
                    return false;
                }
                cur = cur.children.get(c);
            }
            if (cur.children.containsKey(endSymbol)) return true;
            return false;
        }
    }
}
