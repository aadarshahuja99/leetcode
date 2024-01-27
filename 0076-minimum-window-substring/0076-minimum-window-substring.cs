public class Solution {
    public string MinWindow(string s, string t) {
        if(t.Length > s.Length)
        {
            return string.Empty;
        }
        if(s.Length == 1 && string.Equals(s,t))
        {
            return s;
        }
        int i = 0;
        int j = 0;
        Dictionary<char, int> map = new();
        int uniqueCharCount = 0;
        foreach(char c in t)
        {
            if(map.ContainsKey(c))
            {
                map[c]++;
            }
            else
            {
                map.Add(c, 1);
                uniqueCharCount++;
            }
        }
        int count = t.Length;
        int answerStartIndex = -1;
        int minLength = s.Length + 1;
        bool firstIndex = false;
        // Console.WriteLine($"unique count: {uniqueCharCount}");
        while(j < s.Length && i < s.Length)
        {
            // Console.WriteLine($"start: j: {j}, i: {i}");
            if(uniqueCharCount > 0)
            {
                if(map.ContainsKey(s[j]))
                {
                    // Console.WriteLine($"jth index: {s[j]}, map value: {map[s[j]]}");
                    map[s[j]]--;
                    if(map[s[j]] == 0)
                    {
                        uniqueCharCount--;
                    }
                    // Console.WriteLine($"After decrement: jth index: {s[j]}, map value: {map[s[j]]}, unique count: {uniqueCharCount}");
                }
                j++;
            }
            else if(uniqueCharCount == 0)
            {
                j--;
                while(i <= j && uniqueCharCount == 0)
                {
                    if(map.ContainsKey(s[i]))
                    {
                        map[s[i]]++;
                        if(map[s[i]] == 1)
                        {
                            uniqueCharCount++;
                            i++;
                            break;
                        }
                    }
                    i++;
                }
                if(minLength > j-i+2)
                {
                    answerStartIndex = i-1;
                    minLength = j-i+2;
                }
                // Console.WriteLine($"minLength: {minLength}, answerstartindex: {answerStartIndex}");
                j++;
            }
        }
        if(uniqueCharCount == 0)
        {
            j--;
            while(i <= j && uniqueCharCount == 0)
            {
                if(map.ContainsKey(s[i]))
                {
                    map[s[i]]++;
                    if(map[s[i]] == 1)
                    {
                        uniqueCharCount++;
                        i++;
                        break;
                    }
                }
                i++;
            }
            if(minLength > j-i+2)
            {
                answerStartIndex = i-1;
                minLength = j-i+2;
            }
        }
        // Console.WriteLine($"{answerStartIndex}, {minLength}");
        if(answerStartIndex == -1)
        {
            return string.Empty;
        }
        return s.Substring(answerStartIndex, minLength);
    }
}