package model.adts;

import model.exception.ADTException;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K, V> implements MyIDictionary<K, V> {
    private final Map<K, V> map;

    public MyDictionary() {
        this.map = new HashMap<>();
    }

    @Override
    public void update(K key, V value) throws ADTException {
        if (!map.containsKey(key))
            throw new ADTException("Key not defined: " + key);
        map.put(key, value);
    }

    @Override
    public V lookup(K key) throws ADTException {
        if (!map.containsKey(key))
            throw new ADTException("Key not defined: " + key);
        return map.get(key);
    }

    @Override
    public boolean isDefined(K key) {
        return map.containsKey(key);
    }

    @Override
    public void put(K key, V value) {
        map.put(key, value);
    }

    @Override
    public Map<K, V> getContent() {
        return map;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}
