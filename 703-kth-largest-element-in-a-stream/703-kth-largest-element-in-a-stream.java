class KthLargest {
    
    PriorityQueue<Integer> pq = new PriorityQueue();
    int k;
    
    public KthLargest(int k, int[] nums) {
        this.k = k;
        
        //Adding in the initial numbers into the stream
        for(int i = 0; i < nums.length; i++) {
        add(nums[i]);
        }

    }
    
    public int add(int val) {
        //Add in the value to add
        pq.add(val);
        
        //If the size is greater than the kth value to return, just remove the smallest one
        if(pq.size() > k) {
            pq.poll();
        }
        
        //The head of the pq is going to be the kth element everytime
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */