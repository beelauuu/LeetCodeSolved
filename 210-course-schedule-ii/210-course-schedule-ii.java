class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] numofpres = new int[numCourses];
        
        for(int[] prereq: prerequisites) {
            numofpres[prereq[0]]++;
        }
        
        Set<Integer> zeroPres = new HashSet();
        
        for(int i = 0; i < numofpres.length; i++) {
            if(numofpres[i] == 0) {
                zeroPres.add(i);
            }
        }
        
        if(zeroPres.isEmpty()) {
            return new int[]{};
        }
        int i = 0;
        int[] toReturn = new int[numCourses];
        while(!zeroPres.isEmpty()) {
            Iterator<Integer> it = zeroPres.iterator();
            int course = it.next();
            zeroPres.remove(course);
            toReturn[i++] = course;
            
            for(int[] prereq: prerequisites) {
                if(course == prereq[1]) {
                    numofpres[prereq[0]]--;
                    if(numofpres[prereq[0]] == 0) {
                        zeroPres.add(prereq[0]);
                    }
                }
            } 
        }
        
        for(int j = 0; j < numofpres.length; j++) {
            if(numofpres[j] > 0) {
                return new int[]{};
            }
        }
        
        return toReturn;
    }
}