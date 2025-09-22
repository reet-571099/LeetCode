class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] res = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        int [] inDegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites)
        {
            adjList.get(pre[1]).add(pre[0]);
            inDegree[pre[0]]++;
        }
        for(int i = 0;i<inDegree.length;i++)
        {
            if(inDegree[i]==0){
                q.offer(i);
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            int top = q.peek();
            res[idx++] = q.poll();
            for(int num : adjList.get(top)){
                inDegree[num]--;
                if(inDegree[num]==0)
                {
                    q.offer(num);
                }
            }
            
        }
        return idx==numCourses ? res : new int[0];
    }
}