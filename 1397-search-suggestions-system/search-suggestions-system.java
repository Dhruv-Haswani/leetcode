import java.util.*;

class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd;
    }

    TrieNode root = new TrieNode();

    void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }

    void dfs(TrieNode node, String prefix, List<String> list) {
        if (list.size() == 3) return; // only need top 3
        if (node.isEnd) {
            list.add(prefix);
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                char c = (char) ('a' + i);
                dfs(node.children[i], prefix + c, list);
            }
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Insert all products into Trie
        for (String product : products) {
            insert(product);
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            prefix += c;
            int index = c - 'a';
            if (curr != null) {
                curr = curr.children[index];
            }
            List<String> suggestions = new ArrayList<>();
            if (curr != null) {
                dfs(curr, prefix, suggestions);
            }
            result.add(suggestions);
        }

        return result;
    }
}
