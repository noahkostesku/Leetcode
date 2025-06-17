    
class Solution{  
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<String>> adj = new HashMap<>();
        List<String> res = new ArrayList<>();
        for (List<String> ticket : tickets) {
            String src = ticket.get(0);
            String dst = ticket.get(1);
            adj.putIfAbsent(src, new ArrayList<>());
            adj.get(src).add(dst);
        }
        //sort the destinations list for each source because we might need
        //to return a lexicographically smaller path
        for (String key : adj.keySet()) {
            Collections.sort(adj.get(key));
        }
        dfs(adj, res, "JFK");
        //result will be in reverse order so reverse it
        Collections.reverse(res);

        //n tickets = n + 1 airports due to connections
        if (res.size() != tickets.size() + 1) {
            return new ArrayList<>();
        }

        return res;
    }

    private void dfs(Map<String, List<String>> adj, List<String> result, String src) {

        if (adj.containsKey(src)) {
            //because we'll be modifying the original list and dont want to override 
            List<String> destinations = new ArrayList<>(adj.get(src));
            while (!destinations.isEmpty()) {
                String dest = destinations.get(0);
                adj.get(src).remove(0);
                dfs(adj, result, dest);
                destinations = new ArrayList<>(adj.get(src));
            }
        }
        result.add(src);
    }
}

