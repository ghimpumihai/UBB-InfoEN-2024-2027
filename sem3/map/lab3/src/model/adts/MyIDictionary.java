package model.adts;

import model.exception.ADTException;

public interface MyIDictionary<K,V> {
    void update(K key, V value) throws ADTException;
    V lookup(K key) throws ADTException;
    boolean isDefined(K key);
    void put(K key, V value);
    java.util.Map<K,V> getContent();
}
