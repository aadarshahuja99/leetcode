class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(tx < sx || ty < sy)
        {
            return false;
        }
        while(tx >= sx && ty >= sy)
        {
            if(ty > tx)
            {
                if(tx > sx)
                {
                    ty = ty%tx;
                }
                else
                {
                    if((ty - sy)%tx == 0)
                    {
                        return true;
                    }
                    return false;
                }
            }
            else
            {
                if(ty > sy)
                {
                    tx = tx%ty;
                }
                else
                {
                    if((tx - sx)%ty == 0)
                    {
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }
}