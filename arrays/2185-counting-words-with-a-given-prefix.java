class Solution {
    public int prefixCount(String[] words, String pref) {
        
        int prefLength = pref.length();
        int count = 0;

        for (String word : words){
            if (word.length() < prefLength){
                continue;
            }

            if (word.substring(0, prefLength).equals(pref)){
                count++;
            }
        }
        return count;
    }
}
