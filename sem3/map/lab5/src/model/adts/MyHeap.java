// java
package model.adts;

import model.value.Value;
import java.util.HashMap;
import java.util.Map;

public class MyHeap implements MyIHeap {
    private Map<Integer, Value> content;
    private int freeAddr;

    public MyHeap() {
        content = new HashMap<>();
        freeAddr = 1; // addresses start at 1
    }

    @Override
    public int allocate(Value value) {
        int addr = freeAddr++;
        content.put(addr, value);
        return addr;
    }

    @Override
    public void put(int addr, Value value) {
        if (!content.containsKey(addr)) throw new RuntimeException("Invalid heap address: " + addr);
        content.put(addr, value);
    }

    @Override
    public Value get(int addr) {
        if (!content.containsKey(addr)) throw new RuntimeException("Invalid heap address: " + addr);
        return content.get(addr);
    }

    @Override
    public boolean contains(int addr) { return content.containsKey(addr); }

    @Override
    public void remove(int addr) { content.remove(addr); }

    @Override
    public Map<Integer, Value> getContent() { return new HashMap<>(content); }

    @Override
    public void setContent(Map<Integer, Value> newContent) {
        content = new HashMap<>(newContent);
    }
}
