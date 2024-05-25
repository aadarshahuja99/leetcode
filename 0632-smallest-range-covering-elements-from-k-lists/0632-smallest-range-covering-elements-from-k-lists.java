class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        ArrayList<int[]> data = new ArrayList<>();
        for(int i=0; i<k; i++)
        {
            var list = nums.get(i);
            for(int number : list)
            {
                data.add(new int[] { number, i });
            }
        }
        Collections.sort(data, (a,b) -> {
            return a[0] - b[0];
        });
        int start = 0;
        int totalNums = data.size();
        int[] smallestRange = new int[2];
        int rangeLength = Integer.MAX_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int end = 0; end < totalNums; end++)
        {
            int[] endElement = data.get(end);
            map.put(endElement[1], map.getOrDefault(endElement[1], 0) + 1);
            // System.out.println(map.get(endElement[1])+" "+(endElement[0])+" start: "+data.get(start)[0]+", "+map.get(data.get(start)[1]));
            if(map.size() == k)
            {
                int last = start;
                while(map.size() == k)
                {
                    int[] startElement = data.get(start);
                    map.put(startElement[1], map.getOrDefault(startElement[1], 0) - 1);
                    // System.out.println(startElement[0]+" "+startElement[1]+" val: "+map.get(startElement[1]));
                    if(map.get(startElement[1]) == 0)
                    {
                        // System.out.println("removing "+startElement[1]+" for "+data.get(start)[0]);
                        map.remove(startElement[1]);
                    }
                    last = start;
                    start++;
                }
                int currentLength = endElement[0] - data.get(last)[0];
                // System.out.println(last+" "+end+" "+rangeLength+" "+currentLength+" "+endElement[0]+" "+data.get(start)[0]);
                if(rangeLength > currentLength)
                {
                    rangeLength = currentLength;
                    smallestRange = new int[] { data.get(last)[0], endElement[0] };
                }
            }
        }
        if(map.size() == k)
        {
            int last = start;
            int[] endElement = data.get(totalNums-1);
            int end = totalNums-1;
            while(map.size() == k)
            {
                int[] startElement = data.get(start);
                map.put(startElement[1], map.getOrDefault(startElement[1], 0) - 1);
                // System.out.println("2: "+startElement[0]+" "+startElement[1]+" val: "+map.get(startElement[1]));
                if(map.get(startElement[1]) == 0)
                {
                    // System.out.println("2: removing "+startElement[1]+" for "+data.get(start)[0]);
                    map.remove(startElement[1]);
                }
                last = start;
                start++;
            }
            int currentLength = endElement[0] - data.get(last)[0];
            // System.out.println(last+" "+end+" "+rangeLength+" "+currentLength+" "+endElement[0]+" "+data.get(start)[0]);
            if(rangeLength > currentLength)
            {
                rangeLength = currentLength;
                smallestRange = new int[] { data.get(last)[0], endElement[0] };
            }
        }
        return smallestRange;
    }
}