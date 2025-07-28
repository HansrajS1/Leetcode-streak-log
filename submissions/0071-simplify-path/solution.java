class Solution {
    public String simplifyPath(String path) {
    List<String> dirs = new ArrayList<>();
    for (String part : path.split("/")) {
        if (part.equals("..")) {
            if (!dirs.isEmpty()) 
                dirs.remove(dirs.size() - 1);
        } else if (!part.equals("") && !part.equals(".")) {
            dirs.add(part);
        }
    }
    return "/" + String.join("/", dirs);
    }
}
