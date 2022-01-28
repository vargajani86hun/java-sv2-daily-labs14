package day04;

import java.util.HashMap;
import java.util.Map;

public class PairFinder {
    public int findPairs(int[] arr) {
        Map<Integer, Integer> numbersInArray = new HashMap<>();
        for (int i : arr) {
            if (numbersInArray.containsKey(i)) {
                numbersInArray.put(i, numbersInArray.get(i) + 1);
            } else {
                numbersInArray.put(i, 1);
            }
        }
        return numbersInArray.values().stream()
                .mapToInt(i -> i / 2)
                .sum();
    }
}
