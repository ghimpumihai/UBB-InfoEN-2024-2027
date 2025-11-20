package model.adts;

import model.exception.ADTException;
import model.value.StringValue;

import java.io.BufferedReader;

public interface MyIFileTable {
    void put(StringValue key, BufferedReader value);
    BufferedReader lookup(StringValue key) throws ADTException;
    boolean isDefined(StringValue key);
    void remove(StringValue key) throws ADTException;
    java.util.Map<StringValue, BufferedReader> getContent();
}

