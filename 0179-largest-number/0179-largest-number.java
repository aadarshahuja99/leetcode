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
        String ans = "";
        for(String current : strs)
        {
            ans += current;
        }
        if(ans.charAt(0) == '0')
        {
            return "0";
        }
        return ans;
        // int[][] digits = new int[nums.length][10];
        // for(int[] digit : digits)
        // {
        //     Arrays.fill(digit, -1);
        // }
        // int idx = 0;
        // for(int n : nums)
        // {
        //     if(n == 0)
        //     {
        //         digits[idx][0] = 0;
        //         continue;
        //     }
        //     int pow = (int)(Math.log(n)/Math.log(10)) + 1;
        //     int multiplier = 10;
        //     int i=0;
        //     // System.out.println(pow + " "+ multiplier+" for n = "+n);
        //     while(n > 0)
        //     {
        //         digits[idx][i] = n%multiplier;
        //         n = n/10;
        //         i++;
        //     }
        //     idx++;
        // }
        // Arrays.sort(digits, new Comparator<int[]>() {
        //     public int compare(int[] a, int[] b)
        //     {
        //         int i=9;
        //         while(i >= 0 && (a[i] == -1 && b[i] == -1))
        //         {
        //             i--;
        //         }
        //         int j=i;
        //         if(a[i] == -1)
        //         {
        //             while(i >= 0 && a[i] == -1)
        //             {
        //                 i--;
        //             }
        //             while(j >= 0 && i >= 0 && a[i] == b[j])
        //             {
        //                 j--;
        //                 i--;
        //             }
        //             if(i==-1 && j==-1)
        //             {
        //                 return 0;
        //             }
        //             else if(i==-1)
        //             {
        //                 return b[j];
        //             }
        //             else if(j==-1)
        //             {
        //                 return -a[i];
        //             }
        //             return b[j] - a[i];
        //         }
        //         else if(b[i] == -1)
        //         {
        //             while(i >= 0 && b[i] == -1)
        //             {
        //                 i--;
        //             }
        //             while(j >= 0 && i >= 0 && a[j] == b[i])
        //             {
        //                 j--;
        //                 i--;
        //             }
        //             if(i==-1 && j==-1)
        //             {
        //                 return 0;
        //             }
        //             else if(i==-1)
        //             {
        //                 return -a[j];
        //             }
        //             else if(j==-1)
        //             {
        //                 return b[i];
        //             }
        //             return b[i] - a[j];
        //         }
        //         while(i >= 0 && a[i] == b[i])
        //         {
        //             i--;
        //         }
        //         if(i==-1)
        //         {
        //             return 0;
        //         }
        //         return b[i] - a[i];
        //     }
        // });
        // String ans = "";
        // for(int[] element : digits)
        // {
        //     for(int i=9; i>=0; i--)
        //     {
        //         // System.out.print(element[i]+" ");
        //         if(element[i] == -1)
        //         {
        //             continue;
        //         }
        //         ans += String.valueOf(element[i]);
        //     }
        //     // System.out.println();
        // }
        // return ans;
    }
}