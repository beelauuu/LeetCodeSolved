class Solution {
    public int[][] merge(int[][] intervals) {
        
        //If the interval length is <= 1 we know there's nothing to merge
        //just return
        if(intervals.length <= 1) {
            return intervals;
        }
        
        //Otherwise, sort the array intervals by start
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0]-arr2[0];
            }
        });
        
        //Create a new ArrayList to be returned and gather the first interval
        List<int[]> outputArray = new ArrayList();
        int[] currentinterval = intervals[0];
        outputArray.add(currentinterval);
        
        for(int[] interval: intervals) {
            //Gather the beginning and end of your current working interval and
            //potential merge interval
            int begin = currentinterval[0];
            int end = currentinterval[1];
            int nextbegin = interval[0];
            int nextend = interval[1];
            
            //If the end of your current interval is >= to the beginning of your next
            //interval, you may have a potential merge
            if(end >= nextbegin) {
                currentinterval[1] = Math.max(end, nextend);
            }
            else {
                //Otherwise, we know we're in a different interval, so set a different
                //current interval and add it to the ArrayList
                currentinterval = interval;
                outputArray.add(currentinterval);
            }
        }
        
        //Return everything
        int[][] toReturn = new int[outputArray.size()][];
        for(int i = 0; i < outputArray.size(); i++) {
            toReturn[i] = outputArray.get(i);
        }
        
        return toReturn;
        
        
    }
}