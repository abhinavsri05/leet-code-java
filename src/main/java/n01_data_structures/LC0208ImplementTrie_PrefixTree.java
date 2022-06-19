package n01_data_structures;

public class LC0208ImplementTrie_PrefixTree {
    private class TrieNode
    {
        boolean isWord;
        TrieNode[] nodes = new TrieNode[26];
    }

    private TrieNode root;

    public LC0208ImplementTrie_PrefixTree()
    {
        root = new TrieNode();
    }

    public void insert(String word)
    {
        int l = word.length();
        int i;
        TrieNode trie = root;

        for (i = 0; i < l; i++)
        {
            if (trie.nodes[word.charAt(i) - 'a'] == null)
                trie.nodes[word.charAt(i) - 'a'] = new TrieNode();
            trie.nodes[word.charAt(i) - 'a'].isWord |= (i == l - 1);
            trie = trie.nodes[word.charAt(i) - 'a'];
        }
    }

    public boolean search(String word)
    {
        int l = word.length();
        int i;
        TrieNode trie = root;

        for (i = 0; i < l - 1; i++)
        {
            if (trie.nodes[word.charAt(i) - 'a'] == null) return false;
            trie = trie.nodes[word.charAt(i) - 'a'];
        }

        return trie.nodes[word.charAt(l - 1) - 'a'] != null && trie.nodes[word.charAt(l - 1) - 'a'].isWord;
    }

    public boolean startsWith(String prefix)
    {
        int l = prefix.length();
        int i;
        TrieNode trie = root;

        for (i = 0; i < l - 1; i++)
        {
            if (trie.nodes[prefix.charAt(i) - 'a'] == null) return false;
            trie = trie.nodes[prefix.charAt(i) - 'a'];
        }
        return trie.nodes[prefix.charAt(l - 1) - 'a'] != null;
    }
}
