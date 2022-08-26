class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //ToReturn List
        List<List<Integer>> toReturn = new ArrayList<List<Integer>>();
        //HashMap for efficient checking
        HashMap<Integer, Integer> hashy = new HashMap<Integer, Integer>();
        //HashSet of Lists to check for dupes
        HashSet<List<Integer>> dupes = new HashSet<List<Integer>>();
        
        for(int i = 0; i < nums.length-2; i++) {
            //Loop through all values except the last two because there's not going to
            //be any triplets left
            
            //Now it's just like two-sum with valueToGet 
            int valueToGet = 0-nums[i];
            hashy = new HashMap<Integer, Integer>();
            
           //Iterate through the rest of the list like normal twos-um
           for(int j = i+1; j < nums.length; j++) {
               if(hashy.get(valueToGet-nums[j]) != null) {
                   //If you find a match create a triplet of it and sore
                   List<Integer> array = new ArrayList<Integer>();
                   array.add(nums[i]);
                   array.add(nums[j]);
                   array.add(valueToGet-nums[j]);
                   Collections.sort(array);
                   //If adding it to the set is false, we know its a dupe
                    if(dupes.add(array) != false) {
                          toReturn.add(array);  
                    }
               }
               else {
                   //Add in the number and the index
                   hashy.put(nums[j], j);
               }
           }
        }
        return toReturn;
    }
}