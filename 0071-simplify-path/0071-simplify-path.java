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
                if(pathList.size() > 0)
                {
                    pathList.removeLast();
                }
            }
            else
            {
                pathList.addLast(String.format("/%s", component));
            }
        }
        if(pathList.isEmpty())
        {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for(String component : pathList)
        {
            sb.append(component);
        }
        return sb.toString();
    }
}