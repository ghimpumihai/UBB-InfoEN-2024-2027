package model.adts;

import model.exception.ADTException;
import model.value.StringValue;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.Map;

public class MyFileTable implements MyIFileTable {
    private final Map<StringValue, BufferedReader> map;

    public MyFileTable() {
        this.map = new HashMap<>();
    }

    @Override
    public void put(StringValue key, BufferedReader value) {
        map.put(key, value);
    }

    @Override
    public BufferedReader lookup(StringValue key) throws ADTException {
        if (!map.containsKey(key))
            throw new ADTException("File not found in FileTable: " + key);
        return map.get(key);
    }

    @Override
    public boolean isDefined(StringValue key) {
        return map.containsKey(key);
    }

    @Override
    public void remove(StringValue key) throws ADTException {
        if (!map.containsKey(key))
            throw new ADTException("File not found in FileTable: " + key);
        map.remove(key);
    }

    @Override
    public Map<StringValue, BufferedReader> getContent() {
        return map;
    }

    @Override
    public String toString() {
        return map.toString();
    }
}

