class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //Establishing an array of integers which will keep track of the number of
        //pre-reqs for each course (1,0) means that 0 is a pre-req for 1
        int[] numOfPres = new int[numCourses];
        
        //Using a for-each loop to loop through the 2D array. Since (1,0) means that
        //1 has a pre-req of 0, increment each course to the appropriate number of pre-reqs
        for(int[] prereq: prerequisites) {
            numOfPres[prereq[0]]++;
        }
        
        //Use a Set to keep track of which course has no pre-reqs (free course)
        Set<Integer> zeroDegrees = new HashSet();
        
        //Add the courses with 0 pre-reqs into the set
        for(int i = 0; i < numCourses; i++) {
            if(numOfPres[i] == 0) {
                zeroDegrees.add(i);
            }
        }
        
        //If its empty, we know that each course has a pre-req meaning a loop, we can return
        //false
        if(zeroDegrees.isEmpty()) {
            return false;
        }
        
        //Otherwise iterate through each course in zeroDegrees
        while(!zeroDegrees.isEmpty()) {
            //Getting the next value with an iterator because you can't modify a Set in a
            //for-each loop while it's iterating
            Iterator<Integer> it = zeroDegrees.iterator();
            int course = it.next();
            
            //After getting the course, remove it from the set
            zeroDegrees.remove(course);
            
            //For every path course like (1,0), if it has this course as its pre-req, we know
            //that it is possible to be reached, so we can subtract a prereq
            for(int[] prereq: prerequisites) {
                if(course == prereq[1]) {
                    numOfPres[prereq[0]]--;
                //If it's zero, add it back into the set
                    if(numOfPres[prereq[0]] == 0) {
                        zeroDegrees.add(prereq[0]);
                    }
                }
            }
        }
        
        //At the very end, if the number of pre-reqs for each thing isn't 0, we know something couldn't have been reached, therefore false
        for(int i = 0; i < numOfPres.length; i++) {
            if(numOfPres[i] > 0) {
                return false;
            }
        }
        return true;
    }
}