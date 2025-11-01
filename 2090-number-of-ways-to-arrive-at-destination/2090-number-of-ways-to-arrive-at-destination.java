class Pair{
    int node; 
    long dis;
    Pair(int node, long dis){
        this.node=node;
        this.dis=dis;
    }
}
class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod = (int)(1e9 + 7);
        int ne=roads.length;
        ArrayList<Pair>g[]=new ArrayList[n];
        for(int i=0;i<n;i++){
            g[i]=new ArrayList<>();
        }
        for(int i=0;i<ne;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int wt=roads[i][2];
            g[u].add(new Pair(v, wt));
            g[v].add(new Pair(u, wt));
        }
        // PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->(a.dis-b.dis));
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->{
            if(a.dis>b.dis) return 1;
            return -1;
        });
        long dis[]=new long[n];
        long ways[]=new long[n];
        Arrays.fill(dis, ((long)1e18));
        // Arrays.fill(dis, Integer.MAX_VALUE);
        // Arrays.fill(dis, (int)1e18);
        dis[0]=0;
        ways[0]=1;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty())
        {
            int u=pq.peek().node;
            long dtou=pq.peek().dis;
            pq.poll();
            for(Pair pair:g[u])
            {
                int v=pair.node;
                long dtov=pair.dis;
                if(dis[v]>dis[u]+dtov)
                {
                    dis[v]=dis[u]+dtov;
                    pq.add(new Pair(v, dis[v]));
                    ways[v]=ways[u];
                }
                else if(dis[v]==dtou+dtov){
                    ways[v] = (ways[v] + ways[u]) % mod;
                }
            }
        }
        return (int)(ways[n - 1] % mod);
    }
}