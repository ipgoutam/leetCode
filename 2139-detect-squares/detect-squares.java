class DetectSquares {

    private Map<String, Integer> pointCount;
    private List<int[]> points;
    public DetectSquares() {
        pointCount = new HashMap<>();
        points = new ArrayList<>();
    }
    private String key(int x, int y){
        return x + "," + y;
    }
    public void add(int[] point) {
        int x = point[0], y = point[1];
        String k = key(x, y);
        pointCount.put(k, pointCount.getOrDefault(k,0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        int qx = point[0], qy = point[1];
        int ways=0;

        for(int[] p : points){
            int px = p[0], py = p[1];

            if(Math.abs(qx - px) == Math.abs(qy -py) && qx != px){
                String corner1 = key(qx, py);
                String corner2 = key(px, qy);

                if(pointCount.containsKey(corner1) && pointCount.containsKey(corner2)){
                    ways += pointCount.get(corner1) * pointCount.get(corner2);
                }
            }
        }
        return ways;
    }
}

// class DetectSquares {
//     // Map to store counts of points
//     private Map<String, Integer> pointCount;
//     // List to store all points (to iterate during queries)
//     private List<int[]> points;

//     public DetectSquares() {
//         pointCount = new HashMap<>();
//         points = new ArrayList<>();
//     }

//     // Helper to create a key string for coordinates
//     private String key(int x, int y) {
//         return x + "," + y;
//     }

//     // Add a new point
//     public void add(int[] point) {
//         int x = point[0], y = point[1];
//         String k = key(x, y);
//         pointCount.put(k, pointCount.getOrDefault(k, 0) + 1);
//         points.add(point); // keep duplicates separately
//     }

//     // Count number of squares with query point
//     public int count(int[] point) {
//         int qx = point[0], qy = point[1];
//         int ways = 0;

//         for (int[] p : points) {
//             int px = p[0], py = p[1];

//             // Check if (qx,qy) and (px,py) can be diagonal corners
//             if (Math.abs(qx - px) == Math.abs(qy - py) && qx != px) {
//                 // Other two corners
//                 String corner1 = key(qx, py);
//                 String corner2 = key(px, qy);

//                 if (pointCount.containsKey(corner1) && pointCount.containsKey(corner2)) {
//                     ways += pointCount.get(corner1) * pointCount.get(corner2);
//                 }
//             }
//         }

//         return ways;
//     }
// }
/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */