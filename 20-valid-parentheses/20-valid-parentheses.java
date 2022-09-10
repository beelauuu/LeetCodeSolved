class Solution {
    public boolean isValid(String s) {
        
        //If the length is odd, we don't even have to iterate
        if(s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> check = new Stack();
        
        for(int i = 0; i < s.length(); i++) {
            //If it starts with an open paran. we push it onto the stack
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                check.push(s.charAt(i));
            }
            else {
                //Otherwise it's a close paran. If stack is empty, no match just return
                    if(check.isEmpty()) {
                        return false;
                    }
                    
                    //Otherwise, pop a character if its valid
                    char c = check.pop();
                    if(s.charAt(i) == ')' && c != '(') {
                        return false;
                    }
                    else if(s.charAt(i) == '}' && c != '{') {
                        return false;
                    }
                    else if(s.charAt(i) == ']' && c != '[') {
                        return false;
                    }

                }
            }
        
        //If we get to the end, we know everything must have not been matched
        //ex: ((( 
        if(check.isEmpty()) {
            return true;
        }
        return false;
    }
}