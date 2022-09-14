class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int intervalsRemoved = 0;
        
        if(intervals.length <= 1) {
            return 0;
        }
        
        //Sorting the intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
           public int compare(int[] one, int[] two) {
               return one[0]-two[0];
           }
        });
        
        
        int[] curr = intervals[0];
        
        for(int i = 1; i < intervals.length; i++) {
            if(curr[1] > intervals[i][0]) {
                intervalsRemoved++;
                if(curr[1] > intervals[i][1]) {
                    curr = intervals[i];
                }
            }
            else {
                curr = intervals[i];
            }
        }
        
        //Returning the intervalsRemoved amount
        return intervalsRemoved;
    }
}