class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int count = 0;
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        
        for(int[] edge:prerequisites){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            indegree[v]++;
        }
        
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        
        while(!q.isEmpty()){
            int node = q.poll();
            count++;
            
            for(int nbr : graph.get(node)){
                indegree[nbr]--;
                
                if(indegree[nbr]==0){
                    q.offer(nbr);
                }
            }
        }
        return numCourses==count;
    }
}