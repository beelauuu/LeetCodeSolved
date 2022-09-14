class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> next_greatest = new HashMap();
        Stack<Integer> stack = new Stack();
        
        //Loop through the larger int array
        for(Integer num: nums2) {
            //If there is a next_greatest number, pop the current stack and then
            //map it in the hashmap
            while(!stack.isEmpty() && stack.peek() < num) {
                next_greatest.put(stack.pop(), num);
            }
            //This is a while-loop because assuming the case of [6,5,4,3,2,1,7]
            //Stack is going to contain each of the first 6 numbers and then when 7 is
            //reached all the numbers will be popped()
            
            //Push every number onto the stack
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