package com.thomasgassmann.datastructures;

import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;

public class HashTableWithProbing implements HashTable {
    private ProbeItem[] _values;
    private HashProvider _hashing;
    private ProbingProvider _probing;
    private int _m;

    public HashTableWithProbing(int size, HashProvider hash, ProbingProvider probing) {
        _hashing = hash;
        _probing = probing;
        _values = new ProbeItem[size];

        _hashing.init(size);
        _probing.init(_hashing);

        _m = size;
    }

    @Override
    public void insert(int key) {
        probeKey(key, current -> {
            if (_values[current] == null || _values[current].deleted) {
                _values[current] = new ProbeItem();
                _values[current].key = key;
                return true;
            }

            return false;
        });
    }

    @Override
    public void delete(int key) {
        probeKey(key, current -> {
            if (_values[current] != null && _values[current].key == key) {
                _values[current].deleted = true;
                return true;
            }

            return false;
        });
    }

    @Override
    public boolean search(int key) {
        AtomicReference<Boolean> res = new AtomicReference<>(false);
        probeKey(key, current -> {
            if (_values[current] == null) {
                res.set(false);
                return true;
            }

            if (_values[current].key == key && !_values[current].deleted) {
                res.set(true);
                return true;
            }

            return false;
        });

        return res.get();
    }

    private void probeKey(int key, Function<Integer, Boolean> func) {
        int j = 0;
        do {
            int current = mod((_hashing.hash(key) - _probing.probe(j++, key)), _m);
            if (func.apply(current)) {
                return;
            }
        } while (j < _m);
    }

    private int mod(int x, int y) {
        int result = x % y;
        return result < 0 ? result + y : result;
    }
}
