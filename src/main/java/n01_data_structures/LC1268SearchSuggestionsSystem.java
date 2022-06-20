package n01_data_structures;

import java.util.LinkedList;
import java.util.List;

public class LC1268SearchSuggestionsSystem
{
    private class TrieNode
    {
        boolean isWord;
        TrieNode[] node = new TrieNode[26];
    }

    private TrieNode createTrie(String[] words)
    {
        TrieNode root = new TrieNode();
        for (String word: words)
            insertWord(root, word);
        return root;
    }

    private void insertWord(TrieNode root, String word)
    {
        int l = word.length();
        int i = 0;
        for (char c: word.toCharArray())
        {
            if (root.node[c - 'a'] == null)
                root.node[c - 'a'] = new TrieNode();
            root.node[c - 'a'].isWord |= (i == l - 1);
            root = root.node[c - 'a'];
            i++;
        }
    }

    private int dfs(List<String> l, TrieNode trie, StringBuilder temp, int found)
    {
        if (trie == null || found == 3) return found;

        if (trie.isWord && found == 0)
        {
            l.add(temp.toString());
            found++;
        }

        for (int ch = 0; ch < 26; ch++)
        {
            if (found == 3) return found;
            if (trie.node[ch] == null) continue;
            temp.append((char)(ch + 'a'));
            if (trie.node[ch].isWord && found < 3)
            {
                l.add(temp.toString());
                found++;
            }
            found = dfs(l, trie.node[ch], temp, found);
            temp.deleteCharAt(temp.length() - 1);
        }
        return found;
    }

    private List<String> searchPrefix(TrieNode trie, String prefix)
    {
        List<String> ret = new LinkedList<>();
        int len = prefix.length();
        if (len == 0) return ret;

        for (char c: prefix.toCharArray())
        {
            if (trie.node[c - 'a'] != null)
                trie = trie.node[c - 'a'];
            else
                return ret;
        }
        dfs(ret, trie, new StringBuilder(prefix), 0);
        return ret;

    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord)
    {
        TrieNode trie = createTrie(products);
        List<List<String>> result = new LinkedList<>();

        for (int i = 1; i <= searchWord.length(); i++)
            result.add(searchPrefix(trie, searchWord.substring(0, i)));

        return result;
    }
}
