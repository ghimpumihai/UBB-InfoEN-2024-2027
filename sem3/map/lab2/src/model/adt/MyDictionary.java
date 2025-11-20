package model.adt;

import exception.ADTException;

import java.util.HashMap;
import java.util.Map;

public class MyDictionary<K, V> implements MyIDictionary<K, V> {
    private Map<K, V> dictionary;

    public MyDictionary() {
        dictionary = new HashMap<>();
    }

    @Override
    public V lookup(K key) throws ADTException {
        if (!dictionary.containsKey(key)) {
            throw new ADTException("Key '" + key + "' not found in dictionary");
        }
        return dictionary.get(key);
    }

    @Override
    public void update(K key, V value) throws ADTException {
        if (!dictionary.containsKey(key)) {
            throw new ADTException("Key '" + key + "' not found for update");
        }
        dictionary.put(key, value);
    }

    @Override
    public void put(K key, V value) {
        dictionary.put(key, value);
    }

    @Override
    public boolean isDefined(K key) {
        return dictionary.containsKey(key);
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }
}