class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> unique = new HashSet<Integer>();
        
        for(int i = 0; i < nums.length; i++) {
            if(unique.add(nums[i]) == false) {
                return true;
            }
        }
        return false;
    }
}