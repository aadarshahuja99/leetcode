class Solution {
    public String intToRoman(int num) {
        int[] vals = new int[13];
        vals[0] = 1000;
        vals[1] = 900;
        vals[2] = 500;
        vals[3] = 400;
        vals[4] = 100;
        vals[5] = 90;
        vals[6] = 50;
        vals[7] = 40;
        vals[8] = 10;
        vals[9] = 9;
        vals[10] = 5;
        vals[11] = 4;
        vals[12] = 1;

        HashMap<Integer,String> map = new HashMap<>();
        map.put(0, "M");
        map.put(1, "CM");
        map.put(2, "D");
        map.put(3, "CD");
        map.put(4, "C");
        map.put(5, "XC");
        map.put(6, "L");
        map.put(7, "XL");
        map.put(8, "X");
        map.put(9, "IX");
        map.put(10, "V");
        map.put(11, "IV");
        map.put(12, "I");
        
        int idx = 0;
        StringBuilder sb = new StringBuilder("");
        while(num > 0)
        {
            for(int i=0; i<(num/vals[idx]); i++)
            {
                sb.append(map.get(idx));
            }
            num = (num%vals[idx]);
            idx++;
        }
        return sb.toString();
    }
}