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
        String[] arr = new String[13];
        arr[0] = "M";
        arr[1] = "CM";
        arr[2] = "D";
        arr[3] = "CD";
        arr[4] = "C";
        arr[5] = "XC";
        arr[6] = "L";
        arr[7] = "XL";
        arr[8] = "X";
        arr[9] = "IX";
        arr[10] = "V";
        arr[11] = "IV";
        arr[12] = "I";
        int idx = 0;
        StringBuilder sb = new StringBuilder("");
        while(num > 0)
        {
            for(int i=0; i<(num/vals[idx]); i++)
            {
                sb.append(arr[idx]);
            }
            num = (num%vals[idx]);
            idx++;
        }
        return sb.toString();
    }
}