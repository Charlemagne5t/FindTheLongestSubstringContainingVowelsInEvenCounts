import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 0);
        map.put('e', 1);
        map.put('i', 2);
        map.put('o', 3);
        map.put('u', 4);
        int mask = 0;
        Map<Integer, Integer> prefixMask = new HashMap<>();
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int charAsNum = map.get(ch);
                mask ^= 1 << charAsNum;
            }
            if (mask == 0) {
                maxLength = i + 1;
                continue;
            }
            if (prefixMask.containsKey(mask)) {
                maxLength = Math.max(maxLength, i - prefixMask.get(mask));
            }
            prefixMask.putIfAbsent(mask, i);
        }
        return maxLength;
    }
}