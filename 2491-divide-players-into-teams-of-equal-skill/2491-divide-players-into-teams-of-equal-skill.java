class Solution {
    public long dividePlayers(int[] skill) {
        int i=0;
        int n = skill.length;
        int j= n-1;
        long ans = 0l;
        Arrays.sort(skill);
        int desiredSum = skill[i] + skill[j];
        while(i < j)
        {
            int current = skill[i] + skill[j];
            // System.out.println(skill[i]+" "+skill[j]+" "+desiredSum);
            if(current != desiredSum)
            {
                return -1;
            }
            ans += skill[i]*skill[j];
            i++;
            j--;
        }
        return ans;
    }
}