class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> toReturn = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap();
        
        for(int i = 0; i < strs.length; i++) {
            char[] value = strs[i].toCharArray();
            Arrays.sort(value);
            String compare = new String(value);
            if(map.get(compare) == null) {
                List<String> toAdd = new ArrayList();
                toAdd.add(strs[i]);
                map.put(compare, toAdd);
            }
            else {
                List<String> toAdd = map.get(compare);
                toAdd.add(strs[i]);
                map.put(compare, toAdd);
            }
        }
        
        for(List<String> values: map.values()) {
            toReturn.add(values);
        }
        
        return toReturn;
    }
}