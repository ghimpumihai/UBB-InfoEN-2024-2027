// java
package model.adts;

import model.value.Value;
import java.util.Map;

public interface MyIHeap {
    int allocate(Value value);              // returns allocated address
    void put(int addr, Value value);        // update existing or insert
    Value get(int addr);
    boolean contains(int addr);
    void remove(int addr);
    Map<Integer, Value> getContent();
    void setContent(Map<Integer, Value> newContent);
}
