package basicclass.tree;

public interface TrieTree {

    boolean insert(String word);

    boolean search(String word);

    boolean startsWith(String prefix);
}
