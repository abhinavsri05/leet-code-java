package n02_divide_and_conquer;

public class LC0820ShortEncodingOfWords
{
    /*
    private class TrieNode
    {
        private boolean isWord;
        TrieNode[] node = new TrieNode[26];
    }

    private TrieNode createTrie(String[] words)
    {
        TrieNode trie = new TrieNode();

        for (String word: words)
            insertIntoTrie(trie, word);

        return trie;
    }

    private void insertIntoTrie(TrieNode trie, String word)
    {
        // Reverse the word and then insert

        char[] wordArray = word.toCharArray();
        int l = wordArray.length;
        int i;

        for (i = l - 1; i >= 0; i--)
        {
            if (trie.node[wordArray[i] - 'a'] == null)
                trie.node[wordArray[i] - 'a'] = new TrieNode();
            trie.node[wordArray[i] - 'a'].isWord |= (i == l - 1);
            trie = trie.node[wordArray[i] - 'a'];
        }
    }

    private int dfsTrie(TrieNode trie, int depth)
    {
        int i;
        boolean hasChild = false;
        int sumLength = 0;
        for (i = 0; i < 26; i++)
        {
            if (trie.node[i] == null)
                continue;
            hasChild = true;
            sumLength += dfsTrie(trie.node[i], depth + 1);
        }

        return !hasChild ? depth + 1 : sumLength; // Every leaf is a word
    }

    public int minimumLengthEncoding(String[] words)
    {
        TrieNode trie = createTrie(words);
        return dfsTrie(trie, 0);
    }
    */

    // Keeping count of children

    private class TrieNode
    {
        // isWord is not needed for this problem
        private boolean isWord;
        private int countChildren;
        TrieNode[] node = new TrieNode[26];
    }

    private TrieNode createTrie(String[] words)
    {
        TrieNode trie = new TrieNode();
        trie.countChildren = 0;

        for (String word: words)
            insertIntoTrie(trie, word);

        return trie;
    }

    private void insertIntoTrie(TrieNode trie, String word)
    {
        // Reverse the word and then insert

        char[] wordArray = word.toCharArray();
        int l = wordArray.length;
        int i;

        for (i = l - 1; i >= 0; i--)
        {
            if (trie.node[wordArray[i] - 'a'] == null)
            {
                trie.node[wordArray[i] - 'a'] = new TrieNode();
                trie.node[wordArray[i] - 'a'].countChildren = 0;
                trie.countChildren++;
            }
            trie.node[wordArray[i] - 'a'].isWord |= (i == l - 1);
            trie = trie.node[wordArray[i] - 'a'];
        }
    }

    private int dfsTrie(TrieNode trie, int depth)
    {
        int i;
        int sumLength = 0;
        if (trie.countChildren == 0) return depth + 1;
        for (i = 0; i < 26; i++)
        {
            if (trie.node[i] == null)
                continue;
            sumLength += dfsTrie(trie.node[i], depth + 1);
        }

        return sumLength; // Every leaf is a word
    }

    public int minimumLengthEncoding(String[] words)
    {
        TrieNode trie = createTrie(words);
        return dfsTrie(trie, 0);
    }
}
