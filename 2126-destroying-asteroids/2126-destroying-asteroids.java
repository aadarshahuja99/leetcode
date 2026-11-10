class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long total = mass;
        for(int ast : asteroids)
        {
            if(ast > total)
            {
                return false;
            }
            total += ast;
        }
        return true;
    }
}