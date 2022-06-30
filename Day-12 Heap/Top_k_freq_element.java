class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();  // number , frequency
        for(int x : nums){
            map.put(x , map.getOrDefault(x,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> map.get(a) - map.get(b));
        for(int x : map.keySet()){
            pq.add(x);
            if(pq.size() > k)
                pq.remove();
        }    
        
        int[] ans = new int[k];
        int i=0;
        while(!pq.isEmpty()){
            ans[i++] = pq.remove();
        }
       return ans; 
    }
}