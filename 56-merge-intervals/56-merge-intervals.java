class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) {
            return intervals;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] arr1, int[] arr2) {
                return arr1[0]-arr2[0];
            }
        });
        
        List<int[]> outputArray = new ArrayList();
        int[] currentinterval = intervals[0];
        outputArray.add(currentinterval);
        
        for(int[] interval: intervals) {
            int begin = currentinterval[0];
            int end = currentinterval[1];
            int nextbegin = interval[0];
            int nextend = interval[1];
            
            if(end >= nextbegin) {
                currentinterval[1] = Math.max(end, nextend);
            }
            else {
                currentinterval = interval;
                outputArray.add(currentinterval);
            }
        }
        
        int[][] toReturn = new int[outputArray.size()][];
        
        for(int i = 0; i < outputArray.size(); i++) {
            toReturn[i] = outputArray.get(i);
        }
        
        return toReturn;
        
        
    }
}