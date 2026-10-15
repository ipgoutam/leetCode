class Solution {
    static class Point{
        int index;
        int distance;

        Point(int index, int distance){
            this.index = index;
            this.distance = distance;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<Point> pq = new PriorityQueue<>((a,b) -> a.distance - b.distance);
        boolean[] isMST = new boolean[n];

        pq.offer(new Point(0,0));

        int minCost = 0;
        int pointsConnected = 0;

        while(pointsConnected < n){
            Point current = pq.poll();
            if(isMST[current.index]){
                continue;
            }
            isMST[current.index] = true;
            minCost+= current.distance;
            pointsConnected++;

            // add distance
            for(int i=0; i<n; i++){
                if(!isMST[i]){
                    int distance = Math.abs(points[current.index][0] - points[i][0]) + Math.abs(points[current.index][1] - points[i][1]);
                    pq.offer(new Point(i, distance));
                }
            }
        }
        return minCost;
    }
}