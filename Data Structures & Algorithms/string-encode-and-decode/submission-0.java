class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs)
            {
                sb.append(s.length()).append("#").append(s);
            }
        return sb.toString();
    }

    public List<String> decode(String str) {
        System.out.print(str);
        List<String> ans = new ArrayList<String>(); 
        char[] chars = str.toCharArray();
        int i = 0; 
        while (i < str.length())
        {   int j = i; 
            while (str.charAt(j)!= '#')
                j++; 
            
            System.out.println("i " + i);
            System.out.println("j "+ j);

            int len = Integer.parseInt(str.substring(i, j));
            j++;
            String s = str.substring(j, j+len);
            ans.add(s);

            i = j+len; 

        }
        return ans; 
    }
}
