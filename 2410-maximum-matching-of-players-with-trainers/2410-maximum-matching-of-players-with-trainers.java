class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int trainer : trainers)
        {
            set.add(trainer);
        }
        int count =0;
        for(int player : players)
        {
            var trainer = set.ceiling(player);
            if(trainer == null)
            {
                continue;
            }
            count++;
            set.remove(trainer);
        }
        return count;
    }
}