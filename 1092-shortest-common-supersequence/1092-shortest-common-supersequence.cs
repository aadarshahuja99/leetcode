public class Solution {
    public string ShortestCommonSupersequence(string str1, string str2) {
        int n = str1.Length;
        int m = str2.Length;
        int[,] td = new int[n+1,m+1];
        for(int a=1; a<=n; a++)
        {
            td[a,0] = a;
        }
        for(int b=1; b<=m; b++)
        {
            td[0,b] = b;
        }
        for(int k=1; k<=n; k++)
        {
            for(int l=1; l<=m; l++)
            {
                if(str1[k-1]==str2[l-1])
                {
                    td[k,l]=td[k-1,l-1]+1;
                }
                else
                {
                    td[k,l]=1 + Math.Min(td[k-1,l], td[k,l-1]);
                }
            }
        }
        int length = td[n,m];
        if(length == 0)
        {
            return str1+str2;
        }
        int i=n;
        int j=m;
        string lcs="";
        while(i > 0 && j > 0)
        {
            if(str1[i-1] == str2[j-1])
            {
                lcs = str1[i-1] + lcs;
                i--;
                j--;
            }
            else
            {
                if(td[i-1,j]>td[i,j-1])
                {
                    lcs = str2[j-1] + lcs;
                    j--;
                }
                else
                {
                    lcs = str1[i-1] + lcs;
                    i--;
                }
            }
        }
        if (i > 0)
        {
            lcs = str1.Substring(0, i) + lcs;
        }
        else if (j > 0)
        {
            lcs = str2.Substring(0, j) + lcs;
        }
        return lcs;
    }
}