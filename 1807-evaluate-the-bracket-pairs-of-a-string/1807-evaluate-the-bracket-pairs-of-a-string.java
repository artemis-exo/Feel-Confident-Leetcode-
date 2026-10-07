// // Method 1--- > Using temp SB
class Solution {
    public String evaluate(String s, List<List<String>> K) {
        Map<String,String>map=new HashMap<>();
        for(List<String> st:K){
            map.put(st.get(0),st.get(1));
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        while(i<s.length()){
            if(Character.isAlphabetic(s.charAt(i))){
                sb.append(s.charAt(i));
            }
            else if(s.charAt(i)=='('){
                i++;
                StringBuilder temp=new StringBuilder();
                while(i<s.length() && s.charAt(i)!=')'){
                    temp.append(s.charAt(i));
                    i++;
                }
                sb.append(map.getOrDefault(temp.toString(),"?"));
            }
            i++;
        }
        return sb.toString();
    }
}

// Using Substring Fetch
class Solution {
    public String evaluate(String s, List<List<String>> K) {
        Map<String, String> d = new HashMap<>();
        for (var k : K)
            d.put(k.get(0), k.get(1));
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                int j = s.indexOf(")", i + 1);
                sb.append(d.getOrDefault(s.substring(i + 1, j), "?"));
                i = j;
            } else
                sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
