class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";

        String pref = strs[0];
        int prefLen = pref.length();

        //already have the first word so start from the second word
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            //while the prefix length is greater than the word,
            while (prefLen > s.length() || !pref.equals(s.substring(0, prefLen))) {
                prefLen--;
                if (prefLen == 0) {
                    return "";
                }
                pref = pref.substring(0, prefLen);
            }
        }

        return pref;        
    }
}
