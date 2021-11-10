package com.thomasgassmann.datastructures;

import java.util.ArrayList;

public class HashTableWithList implements HashTable {
    private ArrayList<Integer>[] _buckets;
    private HashProvider _hashing;

    public HashTableWithList(int size, HashProvider hashing) {
        _buckets = new ArrayList[size];
        _hashing = hashing;

        _hashing.init(size);
    }

    @Override
    public void insert(int key) {
        ArrayList<Integer> bucket = getBucket(key);
        if (bucket.contains(key)) {
            return;
        }

        bucket.add(key);
    }

    @Override
    public void delete(int key) {
        ArrayList<Integer> bucket = getBucket(key);
        if (bucket.contains(key)) {
            bucket.remove((Object)key);
        }
    }

    @Override
    public boolean search(int key) {
        return getBucket(key).contains(key);
    }

    private ArrayList<Integer> getBucket(int key) {
        int hash = _hashing.hash(key);
        if (_buckets[hash] == null) {
            _buckets[hash] = new ArrayList<>();
        }

        return _buckets[hash];
    }
}
