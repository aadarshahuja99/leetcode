class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        Element[] elements = new Element[indices.length];
        int idx = 0;
        for(int index : indices)
        {
            elements[idx] = new Element(sources[idx], targets[idx], index);
            idx++;
        }
        Arrays.sort(elements, (a,b) -> {
            return a.index - b.index;
        });
        HashMap<Integer,Pair<String,Integer>> indexes = new HashMap<>();
        for(Element e : elements)
        {
            int current = e.index;
            int stringIndex = 0;
            if(e.source.length() > s.length() - e.index)
            {
                continue;
            }
            boolean currentStatus = true;
            while(stringIndex < e.source.length())
            {
                if(s.charAt(current) != e.source.charAt(stringIndex))
                {
                    currentStatus = false;
                    break;
                }
                current++;
                stringIndex++;
            }
            if(currentStatus)
            {
                indexes.put(e.index, new Pair<String,Integer>(e.target, e.source.length()));
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length();)
        {
            if(!indexes.containsKey(i))
            {
                sb.append(s.charAt(i));
                i++;
            }
            else
            {
                var pair = indexes.get(i);
                for(char c : pair.getKey().toCharArray())
                {
                    sb.append(c);
                }
                i += pair.getValue();
            }
        }
        return sb.toString();
    }
    class Element
    {
        String source;
        String target;
        int index;
        public Element(String s, String t, int i)
        {
            source = s;
            target = t;
            index = i;
        }
    }
}