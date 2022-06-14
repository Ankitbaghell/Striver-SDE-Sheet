
/****************************************************************

    Following is the class structure of the Pair class:

        class Pair
        {
        	int weight;
	        int value;
	        Pair(int weight, int value)
	        {
		        this.weight = weight;
		        this.value = value;
	        }
	        
        }
        
*****************************************************************/
import java.util.*;

class pairComparator implements Comparator<Pair> {
    public int compare(Pair o1, Pair o2) {
        double a = ((double) o1.value / o1.weight);
        double b = ((double) o2.value / o2.weight);
        if (a > b)
            return -1;
        else
            return 1;
    }
}

public class Solution {
    public static double maximumValue(Pair[] items, int n, int w) {
        Arrays.sort(items, new pairComparator());

        double finalValue = 0.0;
        int currWeight = 0;

        for (int i = 0; i < n; i++) {
            if (currWeight + items[i].weight <= w) {
                currWeight += items[i].weight;
                finalValue += items[i].value;
            } else {
                int remainingWeight = w - currWeight;
                finalValue += (((double) items[i].value / items[i].weight)) * remainingWeight;
                break;
            }
        }
        return finalValue;
    }
}
