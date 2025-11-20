package model.adt;

import exception.ADTException;

public interface MyIDictionary<K, V> {
    V lookup(K key) throws ADTException;
    void update(K key, V value) throws ADTException;
    void put(K key, V value);
    boolean isDefined(K key);
    String toString();
}
