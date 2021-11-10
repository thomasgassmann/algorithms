package com.thomasgassmann.datastructures;

public class CuckooHashTable implements HashTable {
    private int[] _t1;
    private int[] _t2;

    private HashProvider _h1;
    private HashProvider _h2;

    public CuckooHashTable(int initialSize) {
        initTables(initialSize);
    }

    @Override
    public void insert(int key) {
        int[] currentTable = _t1;
        HashProvider currentHash = _h1;
        int originalKey = key;
        while (true) {
            if (currentTable[currentHash.hash(key)] == 0) {
                currentTable[currentHash.hash(key)] = key;
                return;
            }

            if (originalKey == key && _t2 == currentTable) {
                break;
            }

            var replaced = currentTable[currentHash.hash(key)];
            currentTable[currentHash.hash(key)] = key;
            key = replaced;
            currentTable = currentTable == _t1 ? _t2 : _t1;
            currentHash = currentHash == _h1 ? _h2 : _h1;
        }

        int[] old1 = _t1;
        int[] old2 = _t2;
        initTables(_t1.length + 1);
        for (int i = 0; i < old1.length; i++)
            insert(old1[i]);
        for (int i = 0; i < old2.length; i++)
            insert(old2[i]);
        insert(originalKey);
    }

    @Override
    public void delete(int key) {
        int t1k = _h1.hash(key);
        if (_t1[t1k] == key) {
            _t1[t1k] = 0;
            return;
        }

        int t2k = _h2.hash(key);
        if (_t2[t2k] == key) {
            _t2[t2k] = 0;
        }
    }

    @Override
    public boolean search(int key) {
        int h1h = _h1.hash(key);
        int h2h = _h2.hash(key);
        return _t1[h1h] == key || _t2[h2h] == key;
    }

    private void initTables(int m) {
        _t1 = new int[m];
        _t2 = new int[m];

        _h1 = new BasicHashProvider();
        _h2 = new MultiplicativeHashing();
        _h1.init(m);
        _h2.init(m);
    }
}
