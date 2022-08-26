class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
        HashMap<Integer, Integer> hashy = new HashMap<Integer, Integer>();
        HashSet<List<Integer>> dupes = new HashSet<List<Integer>>();
        
        for(int i = 0; i < nums.length-2; i++) {
            int valueToGet = 0-nums[i];
            hashy = new HashMap<Integer, Integer>();
           for(int j = i+1; j < nums.length; j++) {
               if(hashy.get(valueToGet-nums[j]) != null) {
                   List<Integer> array = new ArrayList<Integer>();
                   array.add(nums[i]);
                   array.add(nums[j]);
                   array.add(valueToGet-nums[j]);
                   Collections.sort(array);
                    if(dupes.add(array) != false) {
                          toReturn.add(array);  
                    }
               }
               else {
                   hashy.put(nums[j], j);
               }
           }
        }
        return toReturn;
    }
}