package com.thomasgassmann.datastructures;

import java.util.Random;

public class UniversalHashingProvider implements HashProvider {
    private int _m;
    private int _p;
    private int _a;
    private int _b;

    public UniversalHashingProvider(int p) {
        _p = p;
    }

    @Override
    public void init(int size) {
        _m = size;
        var random = new Random();
        _a = random.nextInt(1, _p); // a in [1, p - 1]
        _b = random.nextInt(0, _p); // b in [0, p - 1]
    }

    @Override
    public int hash(int key) {
        return ((_a * key + _b) % _p) % _m;
    }
}
