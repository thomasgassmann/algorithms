package com.thomasgassmann.exercises;

public class Coins {
    private static int n;
    private static int[] E1;
    private static int[] E2;

    private static ArrayList<Integer>[] tree;
    private static int[] dp;

    public static void main(String[] args) {
        // Uncomment this line if you want to read from a file
        //In.open("public/large.in");
        //Out.compareTo("public/large.out");

        n = In.readInt(); // number of nodes
        E1 = new int[n - 1];
        E2 = new int[n - 1];

        // edges
        for(int i = 0; i < n - 1; i++) {
            // edge between E1[i] and E2[i], such that E1[i] is the parent of E2[i]
            E1[i] = In.readInt();
            E2[i] = In.readInt();
        }

        Out.println(getMinCoins());

        // Uncomment this line if you want to read from a file
        // In.close();
    }

    public static int getMinCoins() {
        // n = number of nodes
        // for 0 <= i < n - 1, there is an edge between E1[i] and E2[i], such that E1[i] is the parent of E2[i]
        tree = new ArrayList[n];
        for (int i = 0; i < E1.length; i++) {
            if (tree[E1[i]] == null) {
                tree[E1[i]] = new ArrayList<Integer>();
            }

            tree[E1[i]].add(E2[i]);
        }


        dp = new int[n];
        for (int i = 0; i < dp.length; i++)
            dp[i] = 1;

        DFS(0);

        return dp[0];
    }

    private static void DFS(int v) {
        var children = tree[v];
        if (children == null || children.size() == 0)
            return;

        for (var child : children)
            DFS(child);
        var dpc = new int[children.size()];
        for (int i = 0; i < dpc.length; i++)
            dpc[i] = dp[children.get(i)];

        Arrays.sort(dpc);
        int coins = dpc[dpc.length - 1];
        int available = coins;
        for (int i = dpc.length - 2; i >= 0; i--) {
            available--;
            if (dpc[i] > available) {
                int borrow = dpc[i] - available;
                available += borrow;
                coins += borrow;
            }
        }

        dp[v] = coins;
    }
}
