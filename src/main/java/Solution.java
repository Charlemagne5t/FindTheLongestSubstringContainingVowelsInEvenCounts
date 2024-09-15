import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        int n = s.length();
        char[] arr = s.toCharArray();

        int mask = 0;
        Map<Integer, int[]> map = new HashMap<>();
        map.put(0, new int[]{-1, -1});
        for (int i = 0; i < n; i++) {
            int ch = -1;
            if(arr[i] == 'a') {
                ch = 0;
            }else if(arr[i]== 'e') {
                ch = 1;
            }else if(arr[i] == 'i') {
                ch = 2;
            }else if(arr[i] == 'o') {
                ch = 3;
            }else if(arr[i] == 'u') {
                ch = 4;
            }
            if(ch != -1) {
                mask ^= 1 << ch;
            }
            int[] ind = map.getOrDefault(mask, new int[]{-2, -1});
            if(ind[0] == -2) {
                ind[0] = i;
                if(mask == 0) {
                    res = Math.max(res, 1);
                }
            }else {
                ind[1] = i;
                res = Math.max(res, ind[1] - ind[0]);
            }
            map.put(mask, ind);
        }



        return res;
    }
}