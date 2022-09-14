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
            //If the start of the next interval is less than the end of the
            //current one
            if(intervals[i][0] < curr[1]) {
                //We're going to have to remove an interval
                intervalsRemoved++;
                
                //If the current interval spans a longer distance than the shorter one,
                //we'd have to remove one
                if(curr[1] > intervals[i][1]) {
                    curr = intervals[i];
                }
            }
            else {
                //Otherwise, if not overlapping move on
                curr = intervals[i];
            }
        }
        
        //Returning the intervalsRemoved amount
        return intervalsRemoved;
    }
}