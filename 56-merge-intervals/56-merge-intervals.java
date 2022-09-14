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
        
        List<int[]> toReturn = new ArrayList<int[]>();
        int[] current = intervals[0];
        toReturn.add(current);
        
        for(int i = 1; i < intervals.length; i++) {
            if(current[1] >= intervals[i][0]) {
                if(current[1] <= intervals[i][1]) {
                    current[1] = intervals[i][1];
                }
            }
            else {
                current = intervals[i];
                toReturn.add(current);
            }
        }
        
        //Return everything
        int[][] toReturnn = new int[toReturn.size()][];
        for(int i = 0; i < toReturn.size(); i++) {
            toReturnn[i] = toReturn.get(i);
        }
        
        return toReturnn;
    }
}