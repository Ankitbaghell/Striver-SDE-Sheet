
class Pair {
    public int first, second, third;

    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

class PqComparator implements Comparator<Pair> {
    public int compare(Pair pair1, Pair pair2) {
        if (pair1.first < pair2.first) {
            return -1;
        }
        if (pair1.first == pair2.first) {
            return 0;
        }
        return 1;
    }
}

public class Solution {

    public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> kArrays, int k) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        PriorityQueue<Pair> minHeap = new PriorityQueue<Pair>(new PqComparator());

        for (int i = 0; i < kArrays.size(); i++) {
            minHeap.add(new Pair(kArrays.get(i).get(0), i, 0));
        }

        while (minHeap.isEmpty() == false) {
            Pair curr = minHeap.remove();

            int i = curr.second;
            int j = curr.third;

            result.add(curr.first);

            if (j + 1 < kArrays.get(i).size()) {
                minHeap.add(new Pair(kArrays.get(i).get(j + 1), i, j + 1));
            }
        }

        return result;
    }
}