class Solution {
    public boolean isPalindrome(String s) {
        
        //Java Regex In This Case, Any character except A-Z, a-z, or 0-9.
        String copy = s.replaceAll("[^A-Za-z0-9]","");
        copy = copy.toLowerCase();
        
        //Copying it over and adding it
        char[] array = copy.toCharArray();
        List<Character> og = new ArrayList<>();
        List<Character> rev = new ArrayList<>();
        
        for(char c: array) {
            og.add(c);
            rev.add(c);
        }
        
        Collections.reverse(rev);
        
        //Comparing each value
        for(int i = 0; i < og.size(); i++) {
            if(og.get(i) != rev.get(i)) {
                return false;
            }
        }
        
        //If asked for inplace 
        // for(int i = 0 ; i < copy.length()/2; i++) {
        //     if(copy.charAt(i) != copy.charAt(copy.length()-i-1)) {
        //         return false;
        //     }
        // }
        
        return true;
    }
}