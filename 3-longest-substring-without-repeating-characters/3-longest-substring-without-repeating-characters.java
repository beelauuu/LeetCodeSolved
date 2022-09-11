class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int max = 0;
        HashSet<Character> set = new HashSet();
        
        //Two pointers (sliding window)
        while(j < s.length()) {
            //If the set doesn't contain the character, increment and add j.
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(set.size(), max);
            }
            else {
                //Otherwise slide up your beginning for the duplicate.
                set.remove(s.charAt(i++));
            }
        }
        
        return max;
    }
}