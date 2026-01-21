public class lavaFloor {
    public int longestJump(int[] distances, int maxJumpDistance) {
        
        if (distances.length == 1)
            return 0;
        
        int maxJump = 0, currentJump = 0;

        for (int distance = 1; distance <= distances.length -1; distance++){
            if (Math.abs(distances[distance] - distances[distance-1]) <= maxJumpDistance) currentJump++;
            else{
                if (currentJump > maxJump) {
                    maxJump = currentJump;
                }
                currentJump = 0;
            }
        }

        return maxJump;

    }
}