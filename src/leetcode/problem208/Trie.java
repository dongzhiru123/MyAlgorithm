package leetcode.problem208;

import sun.reflect.generics.tree.Tree;

/**
 *实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * 示例:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 *
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 */
public class Trie {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("abcd");
        trie.insert("acde");
        trie.insert("bcde");
        System.out.println(trie.search("abcd"));
        System.out.println(trie.startsWith("abc"));
    }
    private class Node {
        Node[] nodes = new Node[26];
        boolean isLeaf;
    }

    Node root = new Node();
    /** Initialize your data structure here. */
    public Trie() {

    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (word == null || word.length() == 0) throw new RuntimeException("插入空字符串！");
        insert(word, root);
    }

    public void insert(String word, Node root) {
        if (word.length() == 0) {
            root.isLeaf = true;
            return;
        }
        int subscript = charAt(word.charAt(0));
        if (root.nodes[subscript] == null) {
            root.nodes[subscript] = new Node();
        }
        insert(word.substring(1), root.nodes[subscript]);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if (word == null || word.length() == 0) return false;
        Node temporary = root;
        for (int i = 0; i < word.length(); i++) {
            int subscript = charAt(word.charAt(i));
            Node temp = temporary.nodes[subscript];
            if (temp == null) return false;
            temporary = temp;
        }
        return temporary.isLeaf;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if (prefix == null || prefix.length() == 0) return false;
        Node temporary = root;
        for (int i = 0; i < prefix.length(); i++) {
            int subscript = charAt(prefix.charAt(i));
            Node temp = temporary.nodes[subscript];
            if (temp == null) return false;
            temporary = temp;
        }
        return true;
    }

    /** 返回字符对应的下标 */
    public int charAt(char c) {
        return c - 'a';
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}