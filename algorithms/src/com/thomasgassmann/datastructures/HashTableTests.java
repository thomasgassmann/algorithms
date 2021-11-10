package com.thomasgassmann.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HashTableTests {
    @Test
    public void CheckHashTableWithListWithBasicHashing() {
        var table = new HashTableWithList(13, new BasicHashProvider());
        CheckHashTableOps(table, 100);
    }

    @Test
    public void CheckHashTableWithListWithMultiplicativeHashing() {
        var table = new HashTableWithList(13, new MultiplicativeHashing());
        CheckHashTableOps(table, 100);
    }

    @Test
    public void CheckHashTableWithListWithUniversalHashing() {
        var table = new HashTableWithList(173, new UniversalHashingProvider(7919));
        CheckHashTableOps(table, 8000);
    }

    @Test
    public void CheckHashTableWIthProbingWithLinearProbing() {
        var table = new HashTableWithProbing(173, new MultiplicativeHashing(), new LinearProbing());
        CheckHashTableOps(table, 160);
    }

    @Test
    public void CheckHashTableWIthProbingWithQuadraticProbing() {
        var table = new HashTableWithProbing(173, new BasicHashProvider(), new QuadraticProbing());
        CheckHashTableOps(table, 160);
    }

    @Test
    public void CheckHashTableWIthProbingWithDoubleHashing() {
        var table = new HashTableWithProbing(173, new UniversalHashingProvider(173), new DoubleHashing(new MultiplicativeHashing()));
        CheckHashTableOps(table, 160);
    }

    private void CheckHashTableOps(HashTable table, int bound) {
        for (int i = 0; i < bound; i++) {
            table.insert(i);
        }

        for (int i = 1; i < bound; i += 2) {
            table.delete(i);
        }

        for (int i = 0; i < bound; i++) {
            Assertions.assertEquals(table.search(i), i % 2 == 0);
        }
    }
}
