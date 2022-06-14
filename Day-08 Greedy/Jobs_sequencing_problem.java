
/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}
*/

class Solution {
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> (b.profit - a.profit)); // sort the array on maximum profit first
        int max = 0;
        for (Job job : arr) {
            max = Math.max(max, job.deadline);
        }

        int[] result = new int[max + 1];
        Arrays.fill(result, -1);

        int numberOfJobs = 0, profit = 0;

        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) { // found free slot
                    result[j] = i;
                    numberOfJobs++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }

        return new int[] { numberOfJobs, profit };

    }
}
