import java.util.*;
import java.io.*;

class Solution {
    public static int modularExponentiation(int x, int n, int m) {
        long ans = 1;
        long X = x;

        while (n > 0) {
            if (n % 2 == 0) { // even power
                X = (X % m * X % m) % m;
                n = n / 2;
            } else { // odd power
                ans = (ans * X % m) % m;
                n = n - 1;
            }
        }
        return (int) (ans % m);
    }
}