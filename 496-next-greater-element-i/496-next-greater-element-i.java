class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> next_greatest = new HashMap();
        Stack<Integer> stack = new Stack();
        
        for(Integer num: nums2) {
            while(!stack.isEmpty() && stack.peek() < num) {
                next_greatest.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        for(int i = 0; i < nums1.length; i++) {
            if(next_greatest.get(nums1[i]) == null) {
                nums1[i] = -1; 
            }
            else {
                nums1[i] = next_greatest.get(nums1[i]);
            }
        }
        
        return nums1;
    }
}