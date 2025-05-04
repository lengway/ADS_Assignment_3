public class MyHashTable<K, V> {
    private HashNode<K, V>[] ChainArray;
    private int M = 11;
    private int size;

    public MyHashTable() {
        initArray();
    }

    public MyHashTable(int M) {
        initArray();
        this.M = M;
    }

    private void initArray() {
        this.ChainArray = new HashNode[M];
    }

    private int hash(K key) {
        if (!(key instanceof String strKey)) {
            throw new IllegalArgumentException("Key must be a String");
        }

        int hash = 0;
        int p = 31;
        int m = 1_000_000_009;
        for (int i = 0; i < strKey.length(); i++) {
            hash = (int)((hash * p + strKey.charAt(i)) % m);
        }

        return Math.abs(hash % M);
    }

    public void put(K key, V value) {
        int index = hash(key);

        HashNode<K, V> head = ChainArray[index];

        if (head == null) {
            ChainArray[index] = new HashNode<>(key, value);
            size++;
        }
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
