class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] par = new int[edges.length + 1];
        int[] rank = new int[edges.length + 1];
        for (int i = 0; i < par.length; i++) {
            //initialize parent to itself and rank to 1
            par[i] = i;
            rank[i] = 1;
        }

        for (int[] edge : edges) {
            //if the union method is false return that edge since it creates a cycle
            if (!union(par, rank, edge[0], edge[1]))
                return new int[]{edge[0], edge[1]};
        }
        return new int[0];
    }

    private int find(int[] par, int n) {
        int p = par[n];
        while (p != par[p]) {
            par[p] = par[par[p]];
            p = par[p];
        }
        return p;
    }

    private boolean union(int[] par, int[] rank, int n1, int n2) {
        //find each parent from each pair of nodes to see if they already form a path
        int p1 = find(par, n1);
        int p2 = find(par, n2);

        //if boh nodes have the same parent connecting them will create a loop so false
        if (p1 == p2)
            return false;
        //if p1 is a bigger tree than add the smaller one to it
        if (rank[p1] > rank[p2]) {
            par[p2] = p1;
            //add it to the tree
            rank[p1] += rank[p2];
        } else {
            par[p1] = p2;
            rank[p2] += rank[p1];
        }
        return true;
    }
}

