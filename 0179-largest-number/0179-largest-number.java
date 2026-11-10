class Solution {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int idx = 0;
        for(int num : nums)
        {
            strs[idx] = String.valueOf(num);
            idx++;
        }
        Arrays.sort(strs, new Comparator<String>() {
            public int compare(String a, String b)
            {
                String c1 = a + b;
                String c2 = b + a;
                return c2.compareTo(c1);
            }
        });
        StringBuilder sb = new StringBuilder();
        if(strs[0].equals("0"))
        {
            return "0";
        }
        for(String current : strs)
        {
            sb.append(current);
        }
        return sb.toString();
    }
}