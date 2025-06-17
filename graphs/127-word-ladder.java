i

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Map<String, List<String>> nei = new HashMap<>();
        
        wordList.add(beginWord);
        
        for (String word : wordList) {
            //find every pattern in the current word and translate it into all combos of string with wildcard
            for (int j = 0; j < word.length(); j++) {
                String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                //all strings with this pattern witht he wildcard map it to the designated pattern
                nei.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        //set to not revist same position twice
        Set<String> visit = new HashSet<>();
        //start at beginning word
        visit.add(beginWord);
        Queue<String> q = new LinkedList<>();
        //start at beginning word
        q.add(beginWord);
        int res = 1;

        while (!q.isEmpty()) {
            //iterate over each layer in the queue
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                //When you "pop" a word from the front of the queue, you're effectively exploring all possible transformations of that word before moving on to the next word in the queue
                String word = q.poll();
                if (word.equals(endWord)) {
                    return res;
                }
                //iterate over each word to find all patterns that word can have and find all other words that have that pattern
                for (int j = 0; j < word.length(); j++) {
                    //create the wildcard pattern for each index of the word
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    //get all the neighbours of the current word
                    for (String neiWord : nei.getOrDefault(pattern, new ArrayList<>())) {
                        if (!visit.contains(neiWord)) {
                            visit.add(neiWord);
                            q.add(neiWord);
                        }
                    }
                }
            }
            res++;
        }

        return 0; 
    }
}


