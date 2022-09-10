class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> check = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                check.push(s.charAt(i));
            }
            else {
                    if(check.isEmpty()) {
                        return false;
                    }   
                    char c = check.pop();
                    if(s.charAt(i) == ')' && c == '(') {
                    }
                    else if(s.charAt(i) == '}' && c == '{') {
                    }
                    else if(s.charAt(i) == ']' && c == '[') {
                    }
                    else {
                        return false;
                    }
                }
            }
        
        if(check.isEmpty()) {
            return true;
        }
        return false;
    }
}