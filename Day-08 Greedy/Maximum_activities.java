import java.util.*;

class Pair {
    int start;
    int end;

    Pair(int s, int e) {
        start = s;
        end = e;
    }
}

public class Solution {
    public static int maximumActivities(List<Integer> start, List<Integer> end) {
        ArrayList<Pair> list = new ArrayList<>();
        for (int i = 0; i < start.size(); i++) {
            list.add(new Pair(start.get(i), end.get(i)));
        }

        Collections.sort(list, (a, b) -> (a.end - b.end));
        int count = 1;
        int limit = list.get(0).end;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).start >= limit) {
                limit = list.get(i).end;
                count++;
            }
        }
        return count;
    }
}