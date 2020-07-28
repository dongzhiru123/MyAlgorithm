package guanglianda;

import sun.reflect.generics.tree.Tree;

import java.util.Map;
import java.util.TreeMap;

public class Main2 {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(1, 2);
        treeMap.put(2, 3);
        treeMap.put(0, 2);
        Map.Entry<Integer, Integer> integerIntegerEntry = treeMap.pollFirstEntry();
        System.out.println(integerIntegerEntry.getKey());
    }
}
