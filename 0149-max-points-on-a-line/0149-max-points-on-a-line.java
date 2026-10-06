class Solution {
    public int maxPoints(int[][] points) {

        if(points.length<=2)
            return points.length; 

        int max = 0; 

        for(int i = 0; i<points.length; i++){
            HashMap<Double, Integer> mp = new HashMap<>(); 
            for(int j = i+1; j<points.length; j++){
                int x1 = points[i][0]; 
                int x2 = points[j][0]; 
                int y1 = points[i][1]; 
                int y2 = points[j][1]; 

                double slope; 
                if(x1 == x2)
                    slope = Double.POSITIVE_INFINITY;
                else{
                    slope = (double)(y1-y2)/(x2-x1);
                    if(slope == -0.0)
                        slope = 0.0; 
                } 

                mp.put(slope, mp.getOrDefault(slope, 0) + 1); 
            }
            for(int value: mp.values())
                max = Math.max(max, value+1); 
        }

        return max; 
    }
}