package com.thomasgassmann.datastructures;

public class MultiplicativeHashing implements HashProvider {
    private int _m;

    @Override
    public void init(int size) {
        _m = size;
    }

    @Override
    public int hash(int key) {
        double psi = (Math.sqrt(5) - 1) / 2; // inverse golden ratio
        double res = _m * (key * psi - Math.floor(key * psi));
        return (int)Math.floor(res);
    }
}
