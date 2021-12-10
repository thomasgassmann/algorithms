package com.thomasgassmann.graphs;

import java.util.ArrayList;
import java.util.HashMap;

public class UnionFind<T> {
    private HashMap<T, T> _rep;
    private HashMap<T, ArrayList<T>> _members;

    public UnionFind(int size) {
        _rep = new HashMap<>(size);
        _members = new HashMap<>(size);
    }

    public static <T> UnionFind<T> make(GraphWithWeights<T> graph) {
        var u = new UnionFind<T>(graph.getVertices().size());
        for (var v : graph.getVertices()) {
            u._rep.put(v, v);
            var members = new ArrayList<T>();
            members.add(v);
            u._members.put(v, members);
        }

        return u;
    }

    public T repr(T u) {
        return _rep.get(u);
    }

    public boolean same(T u, T v) {
        return _rep.get(u) == _rep.get(v);
    }

    public void union(T u, T v) {
        if (_members.get(v).size() < _members.get(u).size()) {
            T tmp = u;
            u = v;
            v = tmp;
        }

        for (var x : _members.get(_rep.get(u))) {
            _rep.put(x, _rep.get(v));
            var m = _members.get(_rep.get(v));
            m.add(x);
        }
    }
}
