class Solution {
    private Map<Character, Set<Character>> adj;
    private Map<Character, Boolean> visited;
    private List<Character> result;

    public String foreignDictionary(String[] words) {
        //build the adj list
        adj = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                //create an empty array for each character
                adj.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String w1 = words[i], w2 = words[i + 1];
            int minLen = Math.min(w1.length(), w2.length());
            if (w1.length() > w2.length() && w1.substring(0, minLen).equals(w2.substring(0, minLen))) {
                return "";
            }
            for (int j = 0; j < minLen; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    //When it finds two different characters, it establishes a directed edge from the first differing character in w1 to the corresponding character in w2 in the adjacency list. This indicates that the character in w1 should appear before the character in w2 in the alien dictionary.
                    adj.get(w1.charAt(j)).add(w2.charAt(j));
                    break;
                }
            }
        }

        visited = new HashMap<>();
        result = new ArrayList<>();
        for (char c : adj.keySet()) {
            if (dfs(c)) {
                return "";
            }
        }
        //the result was built using post order dfs so reverse the array
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for (char c : result) {
            sb.append(c);
        }
        return sb.toString();
    }
    // (DFS) on the graph to determine the order of characters and detect cycles.
    private boolean dfs(char ch) {
        //detect cyle if one occurs
        if (visited.containsKey(ch)) {
            return visited.get(ch);
        }
        //Mark the character ch as being visited in the current path.
        visited.put(ch, true);
        for (char next : adj.get(ch)) {
            if (dfs(next)) {
                return true;
            }
        }
        visited.put(ch, false);
        result.add(ch);
        return false;
    }
}


