class Solution {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> count = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        int i = 0, length = S.length();
        //puts last occurence of each char in the hahsmap mapped with its index
        for (int j = 0; j < length; j++) {
            char c = S.charAt(j);
            count.put(c, j);
        }

        int curLen = 0;
        int goal = 0;
        while (i < length) {
            char c = S.charAt(i);
            goal = Math.max(goal, count.get(c));
            curLen++;
            if (goal == i) {
                res.add(curLen);
                curLen = 0;
            }
            i++;
        }
        return res;
    }
}


