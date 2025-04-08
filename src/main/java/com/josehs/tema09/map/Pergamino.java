package com.josehs.tema09.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/*
public class Pergamino<K, V> implements Map<K, V> {

    private static final int ;
    private static final int DEFAULT_SIZE = 10;
    private final List<Pair>[] data;
    private int count;

    public Pergamino() {
        this(DEFAULT_SIZE);
    }

    public Pergamino(int capacity) {
        data = new List[capacity];
        count = 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean containsValue(Object value) {
        return null;
    }

    @Override
    public V get(Object key) {
        Pair<K, V> pair = getPair((K)key);
        if (pair == null) {
            return null;
        }
        return null;
    }

    @Override
    public V put(K key,V value) {
        int position = key.hashCode() % data.length;
        if (data[position] == null) {
            data[position] = new ArrayList<>();
        }
        Pair<K, V> pair = getPair(key);
        if (pair == null) {
            data[position].add(new Pair(key, value));
            count++;
            if ((double)count / data.length > DEFAULT_LOAD_FACTOR) {
                resize();
            }
            return null;
        }
        V oldValue = pair.getValue();
        pair
        return oldValue;
    }

    private void resize() {
        List<Pair>[] aux = new List[data.length * DEFAULT_GROW_FACTOR];
        for (List<Pair> arrayList : data) {
            if (arrayList != null) {
                for (Pair<K,V> pair : arrayList){

                }
            }
        }
    }

    public Pair<K,V> getPair(K key, int hash) {
        int position = key.hashCode() % data.length;
        List<Pair> pairs = data[position];
        for (Pair pair : pairs) {
            if (pair.getKey().equals(key)) {
                return pair;
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }
}

 */