public class MyHashTable<K, V> {
    private HashNode<K, V>[] ChainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {

    }

    public MyHashTable(int M) {
        this.M = M;
    }

    private void initArray() {
        this.ChainArray = new HashNode[M];
    }

    private int hash(K key) {
        int hash = 0;
        int p = 31;
        int m = 1_000_000_009;
        String strKey = (String)key;
        for (int i = 0; i < strKey.length(); i++) {
            hash = (int)((hash + strKey.charAt(i)) % m);
        }

        return Math.abs(hash % m);
    }

    public void put(K key, V value) {

    }

    public V get(K key) {
        return null;
    }

    public V remove(K key) {
        return null;
    }

    public boolean contains(V value) {
        return false;
    }

    public K getKey(V value) {
        return null;
    }
}
