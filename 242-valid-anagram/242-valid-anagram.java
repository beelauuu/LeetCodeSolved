class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> stringmap = new HashMap<Character, Integer>();
        
        //Check if their lengths are the same first
        if(s.length() != t.length()) {
            return false;
        }
        //Map one string characters to a hashmap
        for(int i = 0; i < s.length(); i++) {
            if(stringmap.get(s.charAt(i)) == null) {
                stringmap.put(s.charAt(i), 1);
            }
            else {
                stringmap.put(s.charAt(i), stringmap.get(s.charAt(i))+1);
            }
        }
        
        //Loop through the other string, checking to see if they have same amount/type
        //of characters
        for(int i = 0; i < t.length(); i++) {
            if(stringmap.get(t.charAt(i)) == null || stringmap.get(t.charAt(i)) == 0 ) {
                return false;
            }
            else {
                stringmap.put(t.charAt(i), stringmap.get(t.charAt(i))-1);
            }
        }
                
        return true;
    }
}