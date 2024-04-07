class Solution {
    public String simplifyPath(String path) {
        String[] components = path.split("/");
        LinkedList<String> pathList = new LinkedList<>();
        for(String component : components)
        {
            if(component.equals(".") || component.equals(""))
            {
                continue;
            }
            if(component.equals(".."))
            {
                if(pathList.size() > 1)
                {
                    pathList.removeLast();
                    pathList.removeLast();
                }
            }
            else
            {
                pathList.addLast("/");
                pathList.addLast(component);
            }
        }
        if(pathList.isEmpty())
        {
            pathList.addLast("/");
        }
        StringBuilder sb = new StringBuilder();
        for(String component : pathList)
        {
            sb.append(component);
        }
        return sb.toString();
    }
}