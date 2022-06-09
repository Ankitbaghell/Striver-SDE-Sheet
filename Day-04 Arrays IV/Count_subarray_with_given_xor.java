import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static int subarraysXor(ArrayList<Integer> arr, int x) {
        HashMap<Integer, Integer> map = new HashMap<>(); // <xor , how many time this xor appears>
        int count = 0;
        int xor = 0;
        for (int i = 0; i < arr.size(); i++) {
            xor ^= arr.get(i); // prefix xor
            if (xor == x)
                count++;
            if (map.get(xor ^ x) != null) {
                count += map.get(xor ^ x);
            }
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}