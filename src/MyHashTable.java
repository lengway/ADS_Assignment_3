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
        // я решил реализовать хештейбл только для стрингов поэтому в начале идет проверка
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

        // прост добавляем узел сразу если ну ничо нет
        if (head == null) {
            ChainArray[index] = new HashNode<>(key, value);
            size++;
            return;
        }

        // если чето да есть проходимся по цепочке
        HashNode<K, V> current = head;
        while (current != null) {
            // и если ключ уже имеется то мы обновляем значение
            if (current.getKey().equals(key)) {
                current.setValue(value);
                return;
            }

            // если некст нулл значит мы в конце цепочки
            if (current.getNext() == null) {
                break;
            }

            current = current.getNext();
        }

        // и если мы оказались в конце то добавляем узел в конец
        current.setNext(new HashNode<>(key, value));
        size++;
    }


    public V get(K key) {
        return ChainArray[hash(key)].getValue();
    }

    public V remove(K key) {
        ChainArray[hash(key)] = null;
        size--;
        return ChainArray[hash(key)].getValue();
    }

    public boolean contains(V value) {
        for (HashNode<K, V> kvHashNode : ChainArray) {
            if (kvHashNode.getValue().equals(value)) {
                return true;
            }
        }

        return false;
    }

    public K getKey(V value) {
        for (HashNode<K, V> kvHashNode : ChainArray) {
            if (kvHashNode.getValue().equals(value)) {
                return kvHashNode.getKey();
            }
        }

        return null;
    }
}
