class Solution {
    public String getPermutation(int n, int k) {
        String ans = "";
        int fact = 1;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i < n; i++) { // finding (n-1) factorial and creating numbers list
            fact = fact * i;
            numbers.add(i);
        }
        numbers.add(n);
        k = k - 1; // we are taking 0 based indexing

        while (true) {
            ans += numbers.get(k / fact);
            numbers.remove(k / fact); // remove from our list

            if (numbers.size() == 0)
                break;

            k = k % fact;
            fact = fact / numbers.size();
        }

        return ans;

    }
}