// java
package model.utils;

import model.value.RefValue;
import model.value.Value;
import java.util.*;
import java.util.stream.Collectors;

public class GarbageCollector {
    // Collects all reachable heap entries (transitively) starting from values in symTableValues.
    public static Map<Integer, Value> safeGarbageCollector(Collection<Value> symTableValues, Map<Integer, Value> heap) {
        Set<Integer> reachable = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // initial addresses from symbol table
        for (Value v : symTableValues) {
            if (v instanceof RefValue) {
                int addr = ((RefValue) v).getAddr();
                if (heap.containsKey(addr)) stack.push(addr);
            }
        }

        // traverse heap following RefValue links
        while (!stack.isEmpty()) {
            int addr = stack.pop();
            if (!reachable.contains(addr)) {
                reachable.add(addr);
                Value hv = heap.get(addr);
                if (hv instanceof RefValue) {
                    int innerAddr = ((RefValue) hv).getAddr();
                    if (heap.containsKey(innerAddr) && !reachable.contains(innerAddr)) stack.push(innerAddr);
                }
            }
        }

        return heap.entrySet().stream()
                .filter(e -> reachable.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
