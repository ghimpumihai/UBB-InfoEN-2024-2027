package model.adts;

import model.exception.ADTException;

public interface MyIStack<T> {
    void push(T v);
    T pop() throws ADTException;
    boolean isEmpty();
    java.util.List<T> toList();
}
