public static String encode(List<String> strs) {
		        String toEncode = "";
		        for(int i = 0; i < strs.size(); i++) {
		            int sizer = strs.get(i).length();
		            toEncode += sizer + "#" + strs.get(i);
		        }
		        return toEncode;
		    }

public static List<String> decode(String str) {
		        List<String> toReturn = new ArrayList();
		        int i = 0;

		        while(i < str.length()) {
		            int j = i;
		            while(str.charAt(j) != '#') {
		            	j++;
		            }
                //Parse the length between the two pointrs
		            int len = Integer.parseInt(str, i, j, 10);
		            toReturn.add(str.substring(j + 1, j + len + 1));
		            i = j + 1 + len;
		        }

		        return toReturn;
		    }
